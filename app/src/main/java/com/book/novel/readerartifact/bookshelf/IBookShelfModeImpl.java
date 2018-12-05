package com.book.novel.readerartifact.bookshelf;

import com.book.novel.readerartifact.bookshelf.entity.CollBookBean;
import com.book.novel.readerartifact.bookshelf.entity.DownloadTaskBean;
import com.book.novel.readerartifact.bookshelf.entity.RecommendBookPackage;
import com.book.novel.readerartifact.network.BaseHttpUtils;
import com.book.novel.readerartifact.network.UrlConfig;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Retrofit;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/5
 */

public class IBookShelfModeImpl implements IBookShelfModel {

    @Override
    public List<CollBookBean> refreshCollBooks() {
        List<CollBookBean> collBooks = BookRepository
                .getInstance().getCollBooks();
        return collBooks;
    }

    @Override
    public void createDownloadTask(CollBookBean collBookBean) {
        // 创建下载任务
        DownloadTaskBean task = new DownloadTaskBean();


//        task.setTaskName(collBookBean.getTitle());
//        task.setBookId(collBookBean.get_id());
//        task.setBookChapters(collBookBean.getBookChapters());
//        task.setLastChapter(collBookBean.getBookChapters().size());
//
//        RxBus.getInstance().post(task);

    }

    @Override
    public void updateCollBooks(List<CollBookBean> collBookBeans) {

    }

    @Override
    public Single<List<CollBookBean>> loadRecommendBooks(String gender) {
        BaseHttpUtils httpUtils = new BaseHttpUtils(UrlConfig.API_BASE_URL);
        Retrofit retrofit = httpUtils.getRetrofit();
        BookApi api = retrofit.create(BookApi.class);
        Single<List<CollBookBean>> bookPackageObservable = api.getRecommendBookPackage(gender).map(bean -> bean.getBooks());
        return bookPackageObservable;
    }
}
