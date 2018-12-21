package com.book.novel.readerartifact.ui.findbook.adapter;

import android.widget.ImageView;
import android.widget.TextView;

import com.book.novel.readerartifact.R;
import com.book.novel.readerartifact.base.adapter.ViewHolderImpl;
import com.book.novel.readerartifact.ui.findbook.entity.SectionBean;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/21
 */

public class SectionHolder extends ViewHolderImpl<SectionBean> {


    private ImageView mIvIcon;
    private TextView mTvName;

    @Override
    public void initView(){
        mIvIcon =findById(R.id.section_iv_icon);
        mTvName =findById(R.id.section_tv_name);
    }

    @Override
    public void onBind(SectionBean value, int pos) {
        mIvIcon.setImageResource(value.getDrawableId());
        mTvName.setText(value.getName());
    }

    @Override
    protected int getItemLayoutId() {
        return  R.layout.item_section;
    }
}
