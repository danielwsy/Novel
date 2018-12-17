package com.book.novel.readerartifact.ui.findbook.sort;

import com.book.novel.readerartifact.base.BasePresenter;
import com.book.novel.readerartifact.ui.findbook.entity.BookSortPackage;
import com.book.novel.readerartifact.ui.findbook.entity.BookSubSortPackage;

import java.util.Observable;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/17
 */

public class SortPresenter extends BasePresenter<ISortModel, ISortView> {

    public void getSortinfo() {
        io.reactivex.Observable<BookSortPackage> observable = mModel.getBookSort();
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<BookSortPackage>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BookSortPackage bookSortPackage) {
                        if (getView() != null) {
                            getView().finishBookSort(bookSortPackage);
                        }

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        io.reactivex.Observable<BookSubSortPackage> observablesub = mModel.getBookSubSort();

        observablesub.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<BookSubSortPackage>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BookSubSortPackage bookSubSortPackage) {
                        if (getView() != null) {
                            getView().finishBooSubkSort(bookSubSortPackage);
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
