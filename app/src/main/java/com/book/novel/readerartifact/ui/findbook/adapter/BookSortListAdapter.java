package com.book.novel.readerartifact.ui.findbook.adapter;

import android.content.Context;

import com.book.novel.readerartifact.base.adapter.IViewHolder;
import com.book.novel.readerartifact.ui.findbook.entity.SortBookBean;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/17
 */

public class BookSortListAdapter extends WholeAdapter<SortBookBean> {
    public BookSortListAdapter(Context context, Options options) {
        super(context, options);
    }

    @Override
    protected IViewHolder<SortBookBean> createViewHolder(int viewType) {
        return new BookSortListHolder();
    }
}
