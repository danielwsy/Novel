package com.book.novel.readerartifact.ui.findbook.sort.sotrlist;

import com.book.novel.readerartifact.base.IView;
import com.book.novel.readerartifact.ui.findbook.entity.SortBookPackage;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/17
 */

public interface ISoreBookView extends IView {

    /**
     * 加载成功
     *
     * @param sortBookPackage
     */
    void loadSucceed(SortBookPackage sortBookPackage);

    /**
     * 刷新成功
     *
     * @param sortBookPackage
     */
    void RefreshSucceed(SortBookPackage sortBookPackage);
}
