package com.book.novel.readerartifact.ui.seach.adapter;

import com.book.novel.readerartifact.base.adapter.BaseListAdapter;
import com.book.novel.readerartifact.base.adapter.IViewHolder;
import com.book.novel.readerartifact.ui.seach.entity.SearchBookPackage;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/6
 */

public class SearchBookAdapter extends BaseListAdapter<SearchBookPackage.BooksBean> {
    @Override
    protected IViewHolder<SearchBookPackage.BooksBean> createViewHolder(int viewType) {
        return new SearchBookHolder();
    }
}
