package com.book.novel.readerartifact.ui.findbook.top;

import android.os.Bundle;

import com.book.novel.readerartifact.R;
import com.book.novel.readerartifact.base.BaseFragment;
import com.book.novel.readerartifact.base.IModel;
import com.book.novel.readerartifact.base.IPresenter;
import com.book.novel.readerartifact.base.IView;
import com.book.novel.readerartifact.ui.findbook.entity.BillBookPackage;
import com.book.novel.readerartifact.ui.findbook.entity.BillboardPackage;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/14
 */

public class TopBookFragment extends BaseFragment<ITopModel, ITopView, TopPresenter> implements ITopView {

    public static TopBookFragment getInstance() {
        Bundle args = new Bundle();
        TopBookFragment fragment = new TopBookFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public ITopModel createModel() {
        return new TopViewImpl();
    }

    @Override
    public ITopView createView() {
        return this;
    }

    @Override
    public TopPresenter createPresenter() {
        return new TopPresenter();
    }


    @Override
    public void initData() {
        super.initData();
        presenter.getAllTop();
        presenter.getSingleTop("54d42d92321052167dfb75e3");
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_findbook_sort;
    }

    @Override
    public void getAllTopSucceed(BillboardPackage billboardPackage) {
        BillboardPackage billboardPackage1 = billboardPackage;

    }

    @Override
    public void getSingleTopSucceed(BillBookPackage billBookPackage) {
        BillBookPackage a = billBookPackage;
    }

    @Override
    public void getError(Throwable throwable) {

    }
}
