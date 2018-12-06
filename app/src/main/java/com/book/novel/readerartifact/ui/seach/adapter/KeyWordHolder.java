package com.book.novel.readerartifact.ui.seach.adapter;

import android.widget.TextView;

import com.book.novel.readerartifact.R;
import com.book.novel.readerartifact.base.adapter.ViewHolderImpl;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/6
 */

public class KeyWordHolder extends ViewHolderImpl<String> {
    private TextView mTvName;

    @Override
    public void initView() {
        mTvName = findById(R.id.keyword_tv_name);
    }

    @Override
    public void onBind(String data, int pos) {
        mTvName.setText(data);
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_keyword;
    }
}
