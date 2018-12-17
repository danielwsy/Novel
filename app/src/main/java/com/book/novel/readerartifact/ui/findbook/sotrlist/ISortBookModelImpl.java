package com.book.novel.readerartifact.ui.findbook.sotrlist;

import com.book.novel.readerartifact.network.BaseHttpUtils;
import com.book.novel.readerartifact.ui.findbook.FindApi;
import com.book.novel.readerartifact.ui.findbook.entity.BookSortListType;
import com.book.novel.readerartifact.ui.findbook.entity.SortBookPackage;

import io.reactivex.Observable;
import retrofit2.Retrofit;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/17
 */

public class ISortBookModelImpl implements ISortBookModel {
    @Override
    public Observable<SortBookPackage> getSortBookPackage(String gender, BookSortListType type, String major, String minor, int start, int limit) {
        FindApi api = getApi();
        Observable<SortBookPackage> observable = api.getSortBookPackage(gender, type.getNetName(), major, minor, start, limit);
        return observable;
    }

    @Override
    public Observable<SortBookPackage> refrashSortBookPackage(String gender, BookSortListType type, String major, String minor, int start, int limit) {
        FindApi api = getApi();
        Observable<SortBookPackage> observable = api.getSortBookPackage(gender, type.getNetName(), major, minor, start, limit);
        return observable;
    }

    private FindApi getApi() {
        BaseHttpUtils httpUtils = new BaseHttpUtils();
        Retrofit retrofit = httpUtils.getRetrofit();
        FindApi api = retrofit.create(FindApi.class);
        return api;
    }
}
