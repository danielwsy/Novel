package com.book.novel.readerartifact.ui.findbook.sort;

import com.book.novel.readerartifact.base.IView;
import com.book.novel.readerartifact.ui.findbook.entity.BookSortPackage;
import com.book.novel.readerartifact.ui.findbook.entity.BookSubSortPackage;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/17
 */

public interface ISortView extends IView {
    /**
     * 获取分类
     *
     * @param sortPackage
     */
    void finishBookSort(BookSortPackage sortPackage);

    /**
     * 获取二级目录
     *
     * @param subSortPackage
     */
    void finishBooSubkSort(BookSubSortPackage subSortPackage);
}
