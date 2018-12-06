package com.book.novel.readerartifact.ui.seach.adapter;

import com.book.novel.readerartifact.base.adapter.BaseListAdapter;
import com.book.novel.readerartifact.base.adapter.IViewHolder;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/6
 */

public class KeyWordAdapter extends BaseListAdapter<String> {
    @Override
    protected IViewHolder<String> createViewHolder(int viewType) {
        return new KeyWordHolder();
    }
}
