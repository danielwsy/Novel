package com.book.novel.readerartifact.ui.readbook.adapter;

import android.view.View;
import android.view.ViewGroup;

import com.book.novel.readerartifact.base.adapter.IViewHolder;
import com.book.novel.readerartifact.widget.page.TxtChapter;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/10
 */

public class CategoryAdapter extends EasyAdapter {
    private int currentSelected = 0;
    @Override
    protected IViewHolder<TxtChapter> onCreateViewHolder(int viewType) {
        return new CategoryHolder();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        CategoryHolder holder = (CategoryHolder) view.getTag();

        if (position == currentSelected){
            holder.setSelectedChapter();
        }

        return view;
    }

    public void setChapter(int pos){
        currentSelected = pos;
        notifyDataSetChanged();
    }
}
