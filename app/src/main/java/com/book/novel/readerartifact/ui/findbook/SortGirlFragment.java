package com.book.novel.readerartifact.ui.findbook;

import android.os.Bundle;

import com.book.novel.readerartifact.R;
import com.book.novel.readerartifact.base.BaseFragment;
import com.book.novel.readerartifact.base.IModel;
import com.book.novel.readerartifact.base.IPresenter;
import com.book.novel.readerartifact.base.IView;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/17
 */

public class SortGirlFragment extends BaseFragment {


    public static SortGirlFragment getInstance() {
        Bundle args = new Bundle();
        SortGirlFragment fragment = new SortGirlFragment();
        fragment.setArguments(args);
        return fragment;
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

    @Override
    public int getContentView() {
        return R.layout.fragment_findbook_sort_girl;
    }
}
