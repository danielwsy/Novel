package com.book.novel.readerartifact.ui.seach;

import android.util.Log;

import com.book.novel.readerartifact.base.BasePresenter;
import com.book.novel.readerartifact.ui.seach.entity.HotWordPackage;
import com.book.novel.readerartifact.ui.seach.entity.KeyWordPackage;
import com.book.novel.readerartifact.ui.seach.entity.SearchBookPackage;
import com.book.novel.readerartifact.util.RxUtils;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/6
 */

public class SearchPresenter extends BasePresenter<ISearchModel, ISearchView> {

    public static final String TAG = "SearchPresenter";

    /**
     * 搜索用户想要的小说
     *
     * @param keyword
     */
    public void searchBook(String keyword) {
        Observable<SearchBookPackage> observable = mModel.searchBook(keyword);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<SearchBookPackage>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SearchBookPackage searchBookPackage) {
                        if (getView() == null) return;
                        getView().finishSearchBooks(searchBookPackage.getBooks());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.v(TAG, "------searchBook---");

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * 补齐keyword
     *
     * @param complete
     */
    public void completeKeyWord(String complete) {
        Observable<KeyWordPackage> observable = mModel.completeSearchWord(complete);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<KeyWordPackage>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(KeyWordPackage keyWordPackage) {
                        if (getView() == null) return;
                        getView().finishCompleteWord(keyWordPackage.getKeywords());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.v(TAG, "------completeKeyWord---");
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    /**
     * 搜索推荐小说
     *
     * @param
     */
    public void searchHotBook() {
        Observable<HotWordPackage> observable = mModel.getHotBook();
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<HotWordPackage>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HotWordPackage hotWordPackage) {
                        if (getView() == null) return;
                        getView().finishHotBook(hotWordPackage.getHotWords());

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.v(TAG, "------searchHotBook---");
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
