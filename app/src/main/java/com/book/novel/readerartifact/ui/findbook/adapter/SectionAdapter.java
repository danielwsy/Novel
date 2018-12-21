package com.book.novel.readerartifact.ui.findbook.adapter;

import com.book.novel.readerartifact.base.adapter.BaseListAdapter;
import com.book.novel.readerartifact.base.adapter.IViewHolder;
import com.book.novel.readerartifact.ui.findbook.entity.SectionBean;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/21
 */

public class SectionAdapter extends BaseListAdapter<SectionBean> {
    @Override
    protected IViewHolder<SectionBean> createViewHolder(int viewType) {
        return new SectionHolder();
    }
}
