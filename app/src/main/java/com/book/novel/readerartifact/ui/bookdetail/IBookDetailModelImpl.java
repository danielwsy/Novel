package com.book.novel.readerartifact.ui.bookdetail;

import com.book.novel.readerartifact.network.BaseHttpUtils;
import com.book.novel.readerartifact.ui.bookdetail.entity.BookDetailApi;
import com.book.novel.readerartifact.ui.bookdetail.entity.BookDetailBean;
import com.book.novel.readerartifact.ui.bookdetail.entity.HotCommentPackage;
import com.book.novel.readerartifact.ui.bookdetail.entity.RecommendBookListPackage;

import io.reactivex.Observable;
import retrofit2.Retrofit;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/6
 */

public class IBookDetailModelImpl implements IBookDetailModel {
    @Override
    public Observable<BookDetailBean> getBookDetail(String bookId) {
        BookDetailApi api = getApi();
        Observable<BookDetailBean> observable = api.getBookDetail(bookId);
        return observable;
    }

    @Override
    public Observable<HotCommentPackage> getHotCommnent(String book) {
        BookDetailApi api = getApi();
        Observable<HotCommentPackage> observable = api.getHotCommnentPackage(book);
        return observable;
    }

    @Override
    public Observable<RecommendBookListPackage> getRecommendList(String bookId, int limit) {
        BookDetailApi api = getApi();
        Observable<RecommendBookListPackage> observable = api.getRecommendBookListPackage(bookId, limit);
        return observable;
    }

    private BookDetailApi getApi() {
        BaseHttpUtils httpUtils = new BaseHttpUtils();
        Retrofit retrofit = httpUtils.getRetrofit();
        BookDetailApi api = retrofit.create(BookDetailApi.class);
        return api;
    }
}
