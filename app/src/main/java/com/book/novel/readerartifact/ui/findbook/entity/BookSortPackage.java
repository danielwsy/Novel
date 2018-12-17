package com.book.novel.readerartifact.ui.findbook.entity;


import com.book.novel.readerartifact.base.BaseBean;

import java.util.List;

/**
 * Created by newbiechen on 17-4-23.
 */

public class BookSortPackage extends BaseBean {

    private List<BookSortBean> male;
    private List<BookSortBean> female;

    public List<BookSortBean> getMale() {
        return male;
    }

    public void setMale(List<BookSortBean> male) {
        this.male = male;
    }

    public List<BookSortBean> getFemale() {
        return female;
    }

    public void setFemale(List<BookSortBean> female) {
        this.female = female;
    }
}
