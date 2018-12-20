package com.book.novel.readerartifact.ui.findbook.top;

import com.book.novel.readerartifact.base.BasePresenter;
import com.book.novel.readerartifact.ui.findbook.entity.BillBookPackage;
import com.book.novel.readerartifact.ui.findbook.entity.BillboardPackage;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author daniel-wang.
 * @describe : 排行榜交互处理
 * @date :2018/12/20
 */

public class TopPresenter extends BasePresenter<ITopModel, ITopView> {

    public void getAllTop() {
        Observable<BillboardPackage> allTop = mModel.getAllTop();
        allTop.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<BillboardPackage>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BillboardPackage billboardPackage) {
                        if (getView() != null) {
                            getView().getAllTopSucceed(billboardPackage);
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (getView() != null) {
                            getView().getError(e);
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    public void getSingleTop(String id) {
        Observable<BillBookPackage> singleTop = mModel.getSingleTop(id);
        singleTop.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<BillBookPackage>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BillBookPackage billBookPackage) {
                        if (getView() != null) {
                            getView().getSingleTopSucceed(billBookPackage);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (getView() != null) {
                            getView().getError(e);
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
