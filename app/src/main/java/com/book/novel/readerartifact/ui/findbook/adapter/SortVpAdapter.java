package com.book.novel.readerartifact.ui.findbook.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.book.novel.readerartifact.base.BaseFragment;
import com.book.novel.readerartifact.ui.findbook.SortBoyFragment;
import com.book.novel.readerartifact.ui.findbook.SortGirlFragment;

import java.util.ArrayList;
import java.util.List;

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
        BaseFragment fragment = null;
//        if (position == 0) {
//            fragment = SortBoyFragment.getInstance();
//        } else {
//            fragment = SortGirlFragment.getInstance();
//        }
        fragment = SortBoyFragment.getInstance(mTitles.get(position));
        return fragment;
    }

    @Override
    public int getCount() {
        return mTitles.size();
    }

}
