package com.book.novel.readerartifact.ui.bookdetail;

import com.book.novel.readerartifact.base.BasePresenter;
import com.book.novel.readerartifact.ui.bookdetail.entity.BookDetailBean;
import com.book.novel.readerartifact.ui.bookdetail.entity.HotCommentPackage;
import com.book.novel.readerartifact.ui.bookdetail.entity.RecommendBookListPackage;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/6
 */

public class BookDetailPresenter extends BasePresenter<IBookDetailModel, IBookDetailView> {


    private String bookId;

    public void refreshBookDetail(String bookId) {
        this.bookId = bookId;
        getBookDetail(bookId);
        getHotComment(bookId);
        getRecommendedBook(bookId, 3);
    }

    /**
     * 获取数据详情
     *
     * @param bookId
     */
    public void getBookDetail(String bookId) {
        Observable<BookDetailBean> bookDetail = mModel.getBookDetail(bookId);
        bookDetail.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<BookDetailBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BookDetailBean bookDetailBean) {
                        if (getView() != null) {
                            getView().loadDetailSucceed(bookDetailBean);
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (getView() != null) {
                            getView().errorBooks(e);
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * 获取热评
     *
     * @param book
     */
    public void getHotComment(String book) {
        Observable<HotCommentPackage> hotCommnent = mModel.getHotCommnent(book);
        hotCommnent.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<HotCommentPackage>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HotCommentPackage hotCommentPackage) {
                        if (getView() != null) {
                            getView().loadHotCommnentSucceed(hotCommentPackage);
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (getView() != null) {
                            getView().errorBooks(e);
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * 获取推荐书籍
     */
    public void getRecommendedBook(String bookId, int limit) {
        Observable<RecommendBookListPackage> recommendList = mModel.getRecommendList(bookId, limit);
        recommendList.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<RecommendBookListPackage>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RecommendBookListPackage recommendBookListPackage) {
                        if (getView() != null) {
                            getView().loadRecommendListSucceed(recommendBookListPackage);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (getView() != null) {
                            getView().errorBooks(e);
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }


    @Override
    protected void onViewDestroy() {

    }
}
