package com.book.novel.readerartifact.ui.findbook;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.TabLayout;

import com.book.novel.readerartifact.R;
import com.book.novel.readerartifact.base.BaseFragment;
import com.book.novel.readerartifact.base.IModel;
import com.book.novel.readerartifact.base.IPresenter;
import com.book.novel.readerartifact.base.IView;
import com.book.novel.readerartifact.ui.findbook.adapter.FindBookAdapter;

import butterknife.BindView;

/**
 * @author daniel-wang.
 * @describe : 发现小说 ------第1层
 * @date :2018/12/5
 */

public class FindBookFragment extends BaseFragment {

    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;

    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    FindBookAdapter mAdapter;


    public static FindBookFragment getInstance() {
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
    public void initView(View view, Bundle savedInstanceState) {
        super.initView(view, savedInstanceState);
        mTabLayout.addTab(mTabLayout.newTab().setText("分类"));
        mTabLayout.addTab(mTabLayout.newTab().setText("排行榜"));
        mAdapter = new FindBookAdapter(getChildFragmentManager(), "分类", "排行榜");
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
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
