package com.book.novel.readerartifact.ui.seach.entity;

import com.book.novel.readerartifact.base.BaseBean;

import java.util.List;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/6
 */

public class KeyWordPackage extends BaseBean {

    private List<String> keywords;

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }
}
