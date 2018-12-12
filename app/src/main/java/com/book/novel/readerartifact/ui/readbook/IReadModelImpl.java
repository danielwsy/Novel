package com.book.novel.readerartifact.ui.readbook;

import com.book.novel.readerartifact.network.BaseHttpUtils;
import com.book.novel.readerartifact.ui.bookshelf.entity.BookChapterPackage;
import com.book.novel.readerartifact.ui.bookshelf.entity.ChapterInfoPackage;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Retrofit;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/10
 */

public class IReadModelImpl implements IReadModel {
    @Override
    public Observable<BookChapterPackage> getBookChapter(String bookId, String view) {
        ReadBookApi api = getApi();
        Observable<BookChapterPackage> observable = api.getBookChapterPackage(bookId, view);
        return observable;
    }

    @Override
    public Single<ChapterInfoPackage> getChapterInfo(String url) {
        ReadBookApi api = getApi();
        Single<ChapterInfoPackage> observable = api.getChapterInfoPackage(url);
        return observable;
    }

    private ReadBookApi getApi() {
        BaseHttpUtils httpUtils = new BaseHttpUtils();
        Retrofit retrofit = httpUtils.getRetrofit();
        ReadBookApi api = retrofit.create(ReadBookApi.class);
        return api;
    }
}
