package com.book.novel.readerartifact.ui.bookdetail.adapter;

import com.book.novel.readerartifact.base.adapter.BaseListAdapter;
import com.book.novel.readerartifact.base.adapter.IViewHolder;
import com.book.novel.readerartifact.ui.bookdetail.entity.BookListBean;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/6
 */

public class BookListAdapter extends BaseListAdapter<BookListBean> {
    @Override
    protected IViewHolder<BookListBean> createViewHolder(int viewType) {
        return new BookListHolder();
    }
}
