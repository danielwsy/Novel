package com.book.novel.readerartifact.ui.bookshelf.entity;

import com.book.novel.readerartifact.base.BaseBean;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/10
 */

public class ChapterInfoBean extends BaseBean {
    private String title;
    private String body;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
