package com.book.novel.readerartifact.ui.findbook.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.book.novel.readerartifact.ui.findbook.SortBookFragment;
import com.book.novel.readerartifact.ui.findbook.TopBookFragment;

/**
 * @author daniel-wang.
 * @describe : 发现小说适配器
 * @date :2018/12/14
 */

public class FindBookAdapter extends FragmentPagerAdapter {

    private String[] mTitles;

    public FindBookAdapter(FragmentManager fm, String... titles) {
        super(fm);
        mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return SortBookFragment.getInstance();
        } else {
            return TopBookFragment.getInstance();
        }
    }

    @Override
    public int getCount() {
        return mTitles == null ? 0 : mTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
