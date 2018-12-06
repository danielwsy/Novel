package com.book.novel.readerartifact.ui.bookshelf;

import com.book.novel.readerartifact.base.BasePresenter;
import com.book.novel.readerartifact.ui.bookshelf.entity.CollBookBean;
import com.book.novel.readerartifact.ui.bookshelf.entity.RecommendBookPackage;
import com.book.novel.readerartifact.util.RxUtils;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * @author daniel-wang.
 * @describe : 书架
 * @date :2018/12/5
 */

public class BookShelfPresenter extends BasePresenter<IBookShelfModel, IBookShelfView> {

    public void refreshCollBooks() {
        List<CollBookBean> collBookBeans = mModel.refreshCollBooks();
        getView().finishRefresh(collBookBeans);
    }

    public void loadRecommendBooks(String gender) {
        Single<List<CollBookBean>> bookPackage = mModel.loadRecommendBooks(gender);
        Disposable disposable = bookPackage.doOnSuccess(new Consumer<List<CollBookBean>>() {

            @Override
            public void accept(List<CollBookBean> collBookBeans) throws Exception {

            }
        }).compose(RxUtils::toSimpleSingle)
                .subscribe(
                        beans -> {
                            getView().finishRefresh((List<CollBookBean>) beans);
                            getView().complete();
                        },
                        (e) -> {
                            //提示没有网络
                            getView().showErrorTip(e.toString());
                            getView().complete();
                        }
                );
        addDisposable(disposable);
    }


    @Override
    protected void onViewDestroy() {

    }
}
