package com.book.novel.readerartifact.ui.seach.entity;

import com.book.novel.readerartifact.base.BaseBean;

import java.util.List;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/6
 */

public class HotWordPackage extends BaseBean {
    private List<String> hotWords;

    public List<String> getHotWords() {
        return hotWords;
    }

    public void setHotWords(List<String> hotWords) {
        this.hotWords = hotWords;
    }
}
