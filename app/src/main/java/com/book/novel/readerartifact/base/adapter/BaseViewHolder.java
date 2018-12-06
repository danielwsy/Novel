package com.book.novel.readerartifact.base.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/6
 */

public class BaseViewHolder<T> extends RecyclerView.ViewHolder {
    public IViewHolder<T> holder;

    public BaseViewHolder(View itemView, IViewHolder<T> holder) {
        super(itemView);
        this.holder = holder;
        holder.initView();
    }
}
