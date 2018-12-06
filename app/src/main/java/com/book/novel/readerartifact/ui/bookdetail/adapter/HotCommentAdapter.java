package com.book.novel.readerartifact.ui.bookdetail.adapter;

import com.book.novel.readerartifact.base.adapter.BaseListAdapter;
import com.book.novel.readerartifact.base.adapter.IViewHolder;
import com.book.novel.readerartifact.ui.bookdetail.entity.HotCommentBean;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/6
 */

public class HotCommentAdapter extends BaseListAdapter<HotCommentBean> {
    @Override
    protected IViewHolder<HotCommentBean> createViewHolder(int viewType) {
        return new HotCommentHolder();
    }
}
