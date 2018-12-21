package com.book.novel.readerartifact.ui.findbook.sort;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.book.novel.readerartifact.HiApplication;
import com.book.novel.readerartifact.R;
import com.book.novel.readerartifact.base.BaseActivity;
import com.book.novel.readerartifact.base.BaseFragment;
import com.book.novel.readerartifact.base.IModel;
import com.book.novel.readerartifact.base.IPresenter;
import com.book.novel.readerartifact.base.IView;
import com.book.novel.readerartifact.ui.findbook.adapter.SortVpAdapter;

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
 * @describe :  分类小说页面(包含各种类型的小说) ----第2层
 * @date :2018/12/14
 */

public class SortBookActivity extends BaseActivity {

    @BindView(R.id.sort_tab)
    VerticalTabLayout mTablayout;

    @BindView(R.id.sort_viewpager)
    VerticalViewPager mViewPager;

    List<String> titles = null;

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
        mTablayout.setTabAdapter(new MyTabAdapter());
        mTablayout.addOnTabSelectedListener(new VerticalTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabView tab, int position) {
                mViewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselected(TabView tab, int position) {

            }
        });
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTablayout.setTabSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        titles = new ArrayList<>();
        titles.add("男生");
        titles.add("女生");
        mViewPager.setAdapter(new SortVpAdapter(getSupportFragmentManager(), (ArrayList<String>) titles));
    }

    class MyTabAdapter implements TabAdapter {
        List<String> titles;

        {
            titles = new ArrayList<>();
            Collections.addAll(titles, "男频", "女频");
        }

        @Override
        public int getCount() {
            return titles.size();
        }

        @Override
        public ITabView.TabBadge getBadge(int position) {
            return new QTabView(HiApplication.getContext()).getBadge();
        }

        @Override
        public ITabView.TabIcon getIcon(int position) {
            return null;
        }

        @Override
        public ITabView.TabTitle getTitle(int position) {

            return new QTabView.TabTitle.Builder()
                    .setContent(titles.get(position))
                    .setTextColor(Color.BLUE, Color.BLACK)
                    .build();
        }

        @Override
        public int getBackground(int position) {
            return 0;
        }
    }
}
