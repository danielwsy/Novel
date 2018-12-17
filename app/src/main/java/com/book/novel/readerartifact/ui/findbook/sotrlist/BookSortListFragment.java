package com.book.novel.readerartifact.ui.findbook.sotrlist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.book.novel.readerartifact.R;
import com.book.novel.readerartifact.base.BaseFragment;
import com.book.novel.readerartifact.base.IModel;
import com.book.novel.readerartifact.base.IPresenter;
import com.book.novel.readerartifact.base.IView;
import com.book.novel.readerartifact.ui.findbook.entity.BookSortListType;

/**
 * @author daniel-wang.
 * @describe : 具体小说类型页面
 * @date :2018/12/17
 */

public class BookSortListFragment extends BaseFragment {
    private static final String EXTRA_GENDER = "extra_gender";
    private static final String EXTRA_TYPE = "extra_type";
    private static final String EXTRA_MAJOR = "extra_major";

    private String mGender;
    private String mMajor;
    private BookSortListType mType;
    private String mMinor = "";
    private int mStart = 0;
    private int mLimit = 20;

    public static Fragment getInstance(String gender, String major, BookSortListType type) {
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_GENDER, gender);
        bundle.putString(EXTRA_MAJOR, major);
        bundle.putSerializable(EXTRA_TYPE, type);
        Fragment fragment = new BookSortListFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {
        super.initView(view, savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            mGender = bundle.getString(EXTRA_GENDER);
            mMajor = bundle.getString(EXTRA_MAJOR);
            mType = bundle.getParcelable(EXTRA_TYPE);
        }

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
        return R.layout.fragment_refresh_list;
    }
}
