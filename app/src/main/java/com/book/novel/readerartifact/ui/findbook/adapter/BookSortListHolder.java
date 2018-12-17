package com.book.novel.readerartifact.ui.findbook.adapter;

import android.widget.ImageView;
import android.widget.TextView;

import com.book.novel.readerartifact.R;
import com.book.novel.readerartifact.base.adapter.ViewHolderImpl;
import com.book.novel.readerartifact.network.UrlConfig;
import com.book.novel.readerartifact.ui.findbook.entity.SortBookBean;
import com.bumptech.glide.Glide;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/17
 */

public class BookSortListHolder extends ViewHolderImpl<SortBookBean> {
    private ImageView mIvPortrait;
    private TextView mTvTitle;
    private TextView mTvAuthor;
    private TextView mTvBrief;
    private TextView mTvMsg;

    @Override
    public void initView() {
        mIvPortrait = findById(R.id.book_brief_iv_portrait);
        mTvTitle = findById(R.id.book_brief_tv_title);
        mTvAuthor = findById(R.id.book_brief_tv_author);
        mTvBrief = findById(R.id.book_brief_tv_brief);
        mTvMsg = findById(R.id.book_brief_tv_msg);
    }

    @Override
    public void onBind(SortBookBean value, int pos) {
        //头像
        Glide.with(getContext())
                .load(UrlConfig.IMG_BASE_URL + value.getCover())
                .placeholder(R.drawable.ic_default_portrait)
                .error(R.drawable.ic_load_error)
                .fitCenter()
                .into(mIvPortrait);
        //书单名
        mTvTitle.setText(value.getTitle());
        //作者
        mTvAuthor.setText(value.getAuthor());
        //简介
        mTvBrief.setText(value.getShortIntro());
        //信息
        mTvMsg.setText(getContext().getResources().getString(R.string.nb_book_message,
                value.getLatelyFollower(), value.getRetentionRatio()));
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_book_brief;
    }
}
