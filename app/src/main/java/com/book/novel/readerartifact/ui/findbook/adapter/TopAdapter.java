package com.book.novel.readerartifact.ui.findbook.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.book.novel.readerartifact.base.BaseFragment;
import com.book.novel.readerartifact.ui.findbook.sort.SortTypeFragment;
import com.book.novel.readerartifact.ui.findbook.top.TopBookTypeFragment;

import java.util.ArrayList;


/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/21
 */

public class TopAdapter extends FragmentPagerAdapter {

    private ArrayList<String> mTitles;

    public TopAdapter(FragmentManager fm, ArrayList<String> titles) {
        super(fm);
        mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        BaseFragment fragment = TopBookTypeFragment.getInstance(mTitles.get(position));
        return fragment;
    }

    @Override
    public int getCount() {
        return mTitles == null ? 0 : mTitles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
