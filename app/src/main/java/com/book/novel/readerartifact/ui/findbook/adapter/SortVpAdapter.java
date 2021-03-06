package com.book.novel.readerartifact.ui.findbook.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.book.novel.readerartifact.base.BaseFragment;
import com.book.novel.readerartifact.ui.findbook.sort.SortTypeFragment;

import java.util.ArrayList;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/17
 */

public class SortVpAdapter extends FragmentPagerAdapter {

    private ArrayList<String> mTitles;

    public SortVpAdapter(FragmentManager fm, ArrayList<String> titles) {
        super(fm);
        mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        BaseFragment fragment = SortTypeFragment.getInstance(mTitles.get(position));
        return fragment;
    }

    @Override
    public int getCount() {
        return mTitles.size();
    }

}
