package com.book.novel.readerartifact.ui.findbook.sort;

import com.book.novel.readerartifact.base.IModel;
import com.book.novel.readerartifact.ui.findbook.entity.BookSortPackage;
import com.book.novel.readerartifact.ui.findbook.entity.BookSubSortPackage;

import io.reactivex.Observable;


/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/17
 */

public interface ISortModel extends IModel {
    /**
     * 获取男频女频
     *
     * @return
     */
    Observable<BookSortPackage> getBookSort();

    /**
     * 获取二级分类
     *
     * @return
     */
    Observable<BookSubSortPackage> getBookSubSort();
}
