package com.book.novel.readerartifact.ui.findbook.sort;

import com.book.novel.readerartifact.network.BaseHttpUtils;
import com.book.novel.readerartifact.ui.findbook.FindApi;
import com.book.novel.readerartifact.ui.findbook.entity.BookSortPackage;
import com.book.novel.readerartifact.ui.findbook.entity.BookSubSortPackage;
import com.book.novel.readerartifact.ui.readbook.ReadBookApi;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Retrofit;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/17
 */

public class ISortModelImpl implements ISortModel {

    @Override
    public Observable<BookSortPackage> getBookSort() {
        FindApi api = getApi();
        Observable<BookSortPackage> observable = api.getBookSortPackage();
        return observable;
    }

    @Override
    public Observable<BookSubSortPackage> getBookSubSort() {
        FindApi api = getApi();
        Observable<BookSubSortPackage> observable = api.getBookSubSortPackage();
        return observable;
    }

    private FindApi getApi() {
        BaseHttpUtils httpUtils = new BaseHttpUtils();
        Retrofit retrofit = httpUtils.getRetrofit();
        FindApi api = retrofit.create(FindApi.class);
        return api;
    }
}
