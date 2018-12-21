package com.book.novel.readerartifact.ui.findbook.top;

import android.graphics.Color;

import com.book.novel.readerartifact.HiApplication;

import java.util.List;

import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.ITabView;
import q.rorbin.verticaltablayout.widget.QTabView;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/21
 */

public class MyTabAdapter implements TabAdapter {
    List<String> mTitles;

    public MyTabAdapter() {

    }

    public MyTabAdapter(List<String> titles) {
        mTitles = titles;
    }


    public void setDatas(List<String> titles) {
        mTitles = titles;
    }

    @Override
    public int getCount() {
        return mTitles.size();
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
                .setContent(mTitles.get(position))
                .setTextColor(Color.BLUE, Color.BLACK)
                .build();
    }

    @Override
    public int getBackground(int position) {
        return 0;
    }
}
