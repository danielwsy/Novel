package com.book.novel.readerartifact.ui.findbook.entity;

import com.book.novel.readerartifact.base.BaseBean;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/17
 */

public class BookSortBean extends BaseBean {
    /**
     * name : 玄幻
     * bookCount : 437252
     */
    private String name;
    private int bookCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }
}
