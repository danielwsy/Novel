package com.book.novel.readerartifact.ui.bookshelf;

import com.book.novel.readerartifact.ui.bookshelf.entity.CollectBookBean;
import com.book.novel.readerartifact.ui.bookshelf.entity.DownloadTaskBean;
import com.book.novel.readerartifact.network.BaseHttpUtils;
import com.book.novel.readerartifact.network.UrlConfig;
import com.book.novel.readerartifact.util.BookApi;
import com.book.novel.readerartifact.util.db.BookRepository;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Retrofit;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/5
 */

public class IBookShelfModeImpl implements IBookShelfModel {

    @Override
    public List<CollectBookBean> refreshCollBooks() {
        List<CollectBookBean> collBooks = BookRepository.getInstance().getCollBooks();
        return collBooks;
    }

    @Override
    public void createDownloadTask(CollectBookBean collectBookBean) {
        // 创建下载任务
        DownloadTaskBean task = new DownloadTaskBean();


//        task.setTaskName(collectBookBean.getTitle());
//        task.setBookId(collectBookBean.get_id());
//        task.setBookChapters(collectBookBean.getBookChapters());
//        task.setLastChapter(collectBookBean.getBookChapters().size());
//
//        RxBus.getInstance().post(task);

    }

    @Override
    public void updateCollBooks(List<CollectBookBean> collectBookBeans) {

    }

    @Override
    public Single<List<CollectBookBean>> loadRecommendBooks(String gender) {
        BaseHttpUtils httpUtils = new BaseHttpUtils(UrlConfig.API_BASE_URL);
        Retrofit retrofit = httpUtils.getRetrofit();
        BookApi api = retrofit.create(BookApi.class);
        Single<List<CollectBookBean>> bookPackageObservable = api.getRecommendBookPackage(gender).map(bean -> bean.getBooks());
        return bookPackageObservable;
    }
}
