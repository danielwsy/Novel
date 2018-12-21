package com.book.novel.readerartifact.ui.findbook.adapter;

import com.book.novel.readerartifact.base.adapter.BaseListAdapter;
import com.book.novel.readerartifact.base.adapter.IViewHolder;
import com.book.novel.readerartifact.ui.findbook.entity.BillBookPackage;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/21
 */

public class TopSpecificAdapter extends BaseListAdapter<BillBookPackage> {

    @Override
    protected IViewHolder<BillBookPackage> createViewHolder(int viewType) {
        return new TopSpHolder();
    }
}
