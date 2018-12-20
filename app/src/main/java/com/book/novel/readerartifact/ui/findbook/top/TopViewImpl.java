package com.book.novel.readerartifact.ui.findbook.top;

import com.book.novel.readerartifact.network.BaseHttpUtils;
import com.book.novel.readerartifact.ui.findbook.FindApi;
import com.book.novel.readerartifact.ui.findbook.entity.BillBookPackage;
import com.book.novel.readerartifact.ui.findbook.entity.BillboardPackage;

import io.reactivex.Observable;
import retrofit2.Retrofit;

/**
 * @author daniel-wang.
 * @describe : 排行榜业务实现类
 * @date :2018/12/20
 */

public class TopViewImpl implements ITopModel {
    @Override
    public Observable<BillboardPackage> getAllTop() {
        FindApi api = getApi();
        Observable<BillboardPackage> observable = api.getBillboardPackage();

        return observable;
    }

    @Override
    public Observable<BillBookPackage> getSingleTop(String rankingId) {
        FindApi api = getApi();
        Observable<BillBookPackage> observable = api.getBillBookPackage(rankingId);
        return observable;
    }

    private FindApi getApi() {
        BaseHttpUtils httpUtils = new BaseHttpUtils();
        Retrofit retrofit = httpUtils.getRetrofit();
        FindApi api = retrofit.create(FindApi.class);
        return api;
    }
}
