package com.book.novel.readerartifact.ui.findbook.adapter;

import android.widget.TextView;

import com.book.novel.readerartifact.R;
import com.book.novel.readerartifact.base.adapter.ViewHolderImpl;
import com.book.novel.readerartifact.ui.findbook.entity.BookSortBean;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/17
 */

public class BookSortHolder extends ViewHolderImpl<BookSortBean> {

    private TextView mTvType;
    private TextView mTvCount;

    @Override
    public void initView() {
        mTvType = findById(R.id.sort_tv_type);
        mTvCount = findById(R.id.sort_tv_count);
    }

    @Override
    public void onBind(BookSortBean data, int pos) {
        mTvType.setText(data.getName());
        mTvCount.setText(getContext().getResources().getString(R.string.nb_sort_book_count, data.getBookCount()));
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_sort;
    }
}
