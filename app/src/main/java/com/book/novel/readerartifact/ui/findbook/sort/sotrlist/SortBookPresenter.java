package com.book.novel.readerartifact.ui.findbook.sort.sotrlist;

import com.book.novel.readerartifact.base.BasePresenter;
import com.book.novel.readerartifact.ui.findbook.entity.BookSortListType;
import com.book.novel.readerartifact.ui.findbook.entity.SortBookPackage;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/17
 */

public class SortBookPresenter extends BasePresenter<ISortBookModel, ISoreBookView> {

    public void loadData(String gender, BookSortListType type, String major, String minor, int start, int limit) {
        Observable<SortBookPackage> observable = mModel.getSortBookPackage(gender, type, major, minor, start, limit);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<SortBookPackage>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SortBookPackage sortBookPackage) {
                        if (getView() != null) {
                            getView().loadSucceed(sortBookPackage);
                        }

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void refrashData(String gender, BookSortListType type, String major, String minor, int start, int limit) {
        Observable<SortBookPackage> observable = mModel.getSortBookPackage(gender, type, major, minor, start, limit);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<SortBookPackage>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SortBookPackage sortBookPackage) {
                        if (getView() != null) {
                            getView().RefreshSucceed(sortBookPackage);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

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
