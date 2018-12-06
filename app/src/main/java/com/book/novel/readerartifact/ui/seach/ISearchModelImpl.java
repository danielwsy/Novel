package com.book.novel.readerartifact.ui.seach;

import com.book.novel.readerartifact.network.BaseHttpUtils;
import com.book.novel.readerartifact.network.UrlConfig;
import com.book.novel.readerartifact.ui.seach.entity.HotWordPackage;
import com.book.novel.readerartifact.ui.seach.entity.KeyWordPackage;
import com.book.novel.readerartifact.ui.seach.entity.SearchAPi;
import com.book.novel.readerartifact.ui.seach.entity.SearchBookPackage;
import com.book.novel.readerartifact.util.BookApi;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Retrofit;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/6
 */

public class ISearchModelImpl implements ISearchModel {

    @Override
    public Observable<SearchBookPackage> searchBook(String word) {
        BaseHttpUtils httpUtils = new BaseHttpUtils();
        Retrofit retrofit = httpUtils.getRetrofit();
        SearchAPi api = retrofit.create(SearchAPi.class);
        Observable<SearchBookPackage> observable = api.getSearchBookPackage(word);
        return observable;
    }

    @Override
    public Observable<KeyWordPackage> completeSearchWord(String complete) {
        BaseHttpUtils httpUtils = new BaseHttpUtils();
        Retrofit retrofit = httpUtils.getRetrofit();
        SearchAPi api = retrofit.create(SearchAPi.class);
        Observable<KeyWordPackage> observable = api.completeWord(complete);
        return observable;
    }

    @Override
    public Observable<HotWordPackage> getHotBook() {
        BaseHttpUtils httpUtils = new BaseHttpUtils();
        Retrofit retrofit = httpUtils.getRetrofit();
        SearchAPi api = retrofit.create(SearchAPi.class);
        Observable<HotWordPackage> observable = api.getHotWordPackage();
        return observable;
    }
}
