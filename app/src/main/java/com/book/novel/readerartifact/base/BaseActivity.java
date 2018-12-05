package com.book.novel.readerartifact.base;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/5
 */

public abstract class BaseActivity<M extends IModel, V extends IView, P extends BasePresenter> extends SupportActivity implements IBaseMvp<M, V, P>, IBase {
    protected View mRootView;
    Unbinder unbinder;
    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //创建Presenter
        presenter = createPresenter();
        if (presenter != null) {
            //将Model层注册到Presenter中
            presenter.registerModel(createModel());
            //将View层注册到Presenter中
            presenter.registerView(createView());
        }

        mRootView = createView(null, null, savedInstanceState);
        setContentView(mRootView);
        initView(mRootView, savedInstanceState);
        initData();
    }

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = getLayoutInflater().inflate(getContentView(), container);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    public void initData() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            //Activity销毁时的调用，让具体实现BasePresenter中onViewDestroy()方法做出决定
            presenter.destroy();
        }
        unbinder.unbind();
    }
}
