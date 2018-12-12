package com.book.novel.readerartifact.ui.readbook;

import android.util.Log;

import com.book.novel.readerartifact.base.BasePresenter;
import com.book.novel.readerartifact.ui.bookshelf.entity.BookChapterBean;
import com.book.novel.readerartifact.ui.bookshelf.entity.BookChapterPackage;
import com.book.novel.readerartifact.ui.bookshelf.entity.ChapterInfoBean;
import com.book.novel.readerartifact.ui.bookshelf.entity.ChapterInfoPackage;
import com.book.novel.readerartifact.util.MD5Utils;
import com.book.novel.readerartifact.util.db.BookRepository;
import com.book.novel.readerartifact.widget.page.TxtChapter;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/10
 */

public class ReadPresenter extends BasePresenter<IReadModel, IReadView> {


    /**
     * 获取书籍总章节
     *
     * @param bookId
     */
    public void getBookChapter(String bookId) {
        Log.v("daniel", "getBookChapter");
        Observable<BookChapterPackage> bookChapter = mModel.getBookChapter(bookId, "chapter");
        bookChapter.observeOn(AndroidSchedulers.mainThread());
        bookChapter.subscribeOn(Schedulers.io());
        bookChapter.subscribe(new Observer<BookChapterPackage>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(BookChapterPackage bookChapterPackage) {
                if (getView() != null) {
                    List<BookChapterBean> chapters = bookChapterPackage.getMixToc().getChapters();
                    for (BookChapterBean bookChapter : chapters) {
                        bookChapter.setId(MD5Utils.strToMd5By16(bookChapter.getLink()));
                        bookChapter.setBookId(bookId);
                    }
                    getView().getBookChapterSucceed(chapters);
                }

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }

    private Subscription mChapterSub;

    /**
     * 获取单章节详情
     *
     * @param bookId
     */
    public void getChapterInfos(String bookId, List<TxtChapter> bookChapters) {
        int size = bookChapters.size();
        //取消上次的任务，防止多次加载
        if (mChapterSub != null) {
            mChapterSub.cancel();
        }

        List<Single<ChapterInfoBean>> chapterInfos = new ArrayList<>(bookChapters.size());
        ArrayDeque<String> titles = new ArrayDeque<>(bookChapters.size());

        // 将要下载章节，转换成网络请求。
        for (int i = 0; i < size; ++i) {
            TxtChapter bookChapter = bookChapters.get(i);
            // 网络中获取数据
            Single<ChapterInfoBean> chapterInfoSingle = mModel.getChapterInfo(bookChapter.getLink()).map(new Function<ChapterInfoPackage, ChapterInfoBean>() {
                @Override
                public ChapterInfoBean apply(ChapterInfoPackage chapterInfoPackage) throws Exception {
                    return chapterInfoPackage.getChapter();
                }
            });

            chapterInfos.add(chapterInfoSingle);

            titles.add(bookChapter.getTitle());
        }

        Single.concat(chapterInfos)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Subscriber<ChapterInfoBean>() {
                            String title = titles.poll();

                            @Override
                            public void onSubscribe(Subscription s) {
                                s.request(Integer.MAX_VALUE);
                                mChapterSub = s;
                            }

                            @Override
                            public void onNext(ChapterInfoBean chapterInfoBean) {
                                //存储数据
                                BookRepository.getInstance().saveChapterInfo(
                                        bookId, title, chapterInfoBean.getBody()
                                );

                                getView().getChapterInfoSucceed(chapterInfoBean);
                                //将获取到的数据进行存储
                                title = titles.poll();
                            }

                            @Override
                            public void onError(Throwable t) {
                                //只有第一个加载失败才会调用errorChapter
                                if (bookChapters.get(0).getTitle().equals(title)) {

                                }

                            }

                            @Override
                            public void onComplete() {
                            }
                        }
                );
    }


    @Override
    protected void onViewDestroy() {

    }
}
