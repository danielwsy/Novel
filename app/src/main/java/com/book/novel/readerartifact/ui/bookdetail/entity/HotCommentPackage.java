package com.book.novel.readerartifact.ui.bookdetail.entity;

import com.book.novel.readerartifact.base.BaseBean;

import java.util.List;

/**
 * @author daniel-wang.
 * @describe : 小说热评
 * @date :2018/12/6
 */

public class HotCommentPackage  extends BaseBean{


    private List<HotCommentBean> reviews;

    public List<HotCommentBean> getReviews() {
        return reviews;
    }

    public void setReviews(List<HotCommentBean> reviews) {
        this.reviews = reviews;
    }
}
