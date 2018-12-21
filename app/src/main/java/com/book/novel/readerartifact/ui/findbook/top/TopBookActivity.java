package com.book.novel.readerartifact.ui.findbook.top;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.book.novel.readerartifact.R;
import com.book.novel.readerartifact.base.BaseActivity;
import com.book.novel.readerartifact.base.BasePresenter;
import com.book.novel.readerartifact.base.IModel;
import com.book.novel.readerartifact.base.IView;
import com.book.novel.readerartifact.ui.findbook.adapter.TopAdapter;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/14
 */

public class TopBookActivity extends BaseActivity {

    @BindView(R.id.tab)
    TabLayout tabLayout;

    @BindView(R.id.viewpager)
    ViewPager viewPager;
    private ArrayList<String> mTitles;
    private TopAdapter mAdapter;

    @Override
    public IModel createModel() {
        return null;
    }

    @Override
    public IView createView() {
        return null;
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }


    @Override
    public void initData() {
        super.initData();
        mTitles = new ArrayList<>();
        mTitles.add("男频");
        mTitles.add("女频");

        for (int i = 0; i < mTitles.size(); i++) {
            tabLayout.addTab(tabLayout.newTab());
            tabLayout.getTabAt(i).setText(mTitles.get(i));
        }
        tabLayout.setupWithViewPager(viewPager,false);
        mAdapter = new TopAdapter(getSupportFragmentManager(), mTitles);
        viewPager.setAdapter(mAdapter);


    }

    @Override
    public int getContentView() {
        return R.layout.activity_top;
    }

}
