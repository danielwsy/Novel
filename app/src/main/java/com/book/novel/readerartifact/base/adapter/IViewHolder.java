package com.book.novel.readerartifact.base.adapter;

import android.view.View;
import android.view.ViewGroup;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/6
 */

public interface IViewHolder<T> {
    View createItemView(ViewGroup parent);

    void initView();

    void onBind(T data, int pos);

    void onClick();
}
