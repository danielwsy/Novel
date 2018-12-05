package com.book.novel.readerartifact;

import android.os.Bundle;

import com.book.novel.readerartifact.base.BaseFragment;
import com.book.novel.readerartifact.base.IModel;
import com.book.novel.readerartifact.base.IPresenter;
import com.book.novel.readerartifact.base.IView;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/5
 */

public class FindBookFragment extends BaseFragment {


    public static FindBookFragment getInstance(){
        Bundle args = new Bundle();
        FindBookFragment fragment = new FindBookFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public int getContentView() {
        return R.layout.fragment_findbook;
    }

    @Override
    public IModel createModel() {
        return null;
    }

    @Override
    public IView createView() {
        return null;
    }

    @Override
    public IPresenter createPresenter() {
        return null;
    }
}
