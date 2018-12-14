package com.book.novel.readerartifact.ui.findbook;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.book.novel.readerartifact.HiApplication;
import com.book.novel.readerartifact.R;
import com.book.novel.readerartifact.base.BaseFragment;
import com.book.novel.readerartifact.base.IModel;
import com.book.novel.readerartifact.base.IPresenter;
import com.book.novel.readerartifact.base.IView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import fr.castorflex.android.verticalviewpager.VerticalViewPager;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.ITabView;
import q.rorbin.verticaltablayout.widget.QTabView;
import q.rorbin.verticaltablayout.widget.TabView;

/**
 * @author daniel-wang.
 * @describe :  分类小说页面
 * @date :2018/12/14
 */

public class SortBookFragment extends BaseFragment {

    @BindView(R.id.sort_tab)
    VerticalTabLayout mTablayout;

    @BindView(R.id.sort_viewpager)
    VerticalViewPager mViewPager;


    public static SortBookFragment getInstance() {
        Bundle args = new Bundle();
        SortBookFragment fragment = new SortBookFragment();
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
        return R.layout.fragment_findbook_sort;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {
        super.initView(view, savedInstanceState);
        mTablayout.addTab(new QTabView(HiApplication.getContext()) {
        });
    }

    class MyTabAdapter implements TabAdapter {
        List<String> titles;

        {
            titles = new ArrayList<>();
            Collections.addAll(titles, "Android", "IOS", "Web", "JAVA", "C++"
            );
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public ITabView.TabBadge getBadge(int position) {
            return null;
        }

        @Override
        public ITabView.TabIcon getIcon(int position) {
            return null;
        }

        @Override
        public ITabView.TabTitle getTitle(int position) {
            return null;
        }

        @Override
        public int getBackground(int position) {
            return 0;
        }
    }
}
