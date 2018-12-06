package com.book.novel.readerartifact.ui.seach;

import com.book.novel.readerartifact.base.IView;
import com.book.novel.readerartifact.ui.seach.entity.SearchBookPackage;

import java.util.List;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/6
 */

public interface ISearchView extends IView {

    /**
     * 获取火热推荐书籍完毕
     *
     * @param hotWords
     */
    void finishHotBook(List<String> hotWords);

    /**
     * 自动补齐关键字完毕
     *
     * @param keyWords
     */
    void finishCompleteWord(List<String> keyWords);

    /**
     * 搜索完成
     *
     * @param books
     */
    void finishSearchBooks(List<SearchBookPackage.BooksBean> books);

    /**
     * 异常
     */
    void errorBooks(Throwable throwable);
}
