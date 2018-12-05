package com.book.novel.readerartifact.base;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author daniel-wang.
 * @describe : 所有Presenter层的抽象类，负责Model、View层的引用和销毁
 * @date :2018/12/5
 */

public abstract class BasePresenter<M extends IModel, V extends IView> implements IPresenter<M, V> {
    /**
     * 使用弱引用来防止内存泄漏
     */
    private WeakReference<V> mView;
    protected M mModel;

    protected CompositeDisposable mDisposable;

    protected void addDisposable(Disposable subscription) {
        if (mDisposable == null) {
            mDisposable = new CompositeDisposable();
        }
        mDisposable.add(subscription);
    }


    /**
     * 注册Model
     *
     * @param model
     */
    @Override
    public void registerModel(M model) {
        this.mModel = model;
    }

    /**
     * 注册 View
     *
     * @param view
     */
    @Override
    public void registerView(V view) {
        mView = new WeakReference<V>(view);
    }

    /**
     * 获取View
     *
     * @return
     */
    @Override
    public V getView() {
        return mView == null ? null : mView.get();
    }


    /**
     * 在Activity或Fragment卸载时调用View结束的方法
     */
    @Override
    public void destroy() {
        if (mView != null) {
            mView.clear();
            mView = null;
        }
        onViewDestroy();
    }

    protected abstract void onViewDestroy();

}
