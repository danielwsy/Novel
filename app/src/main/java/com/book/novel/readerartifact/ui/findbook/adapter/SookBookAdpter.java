package com.book.novel.readerartifact.ui.findbook.adapter;

import android.view.View;
import android.view.ViewGroup;

import com.book.novel.readerartifact.base.adapter.BaseListAdapter;
import com.book.novel.readerartifact.base.adapter.IViewHolder;
import com.book.novel.readerartifact.ui.findbook.entity.BookSortBean;

/**
 * @author daniel-wang.
 * @describe : 男生频道RecycleView 的适配器
 * @date :2018/12/17
 */

public class SookBookAdpter extends BaseListAdapter<BookSortBean> {

    @Override
    protected IViewHolder<BookSortBean> createViewHolder(int viewType) {
        return new BookSortHolder();
    }
}
