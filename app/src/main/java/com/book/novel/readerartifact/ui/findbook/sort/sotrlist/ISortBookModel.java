package com.book.novel.readerartifact.ui.findbook.sort.sotrlist;

import com.book.novel.readerartifact.base.IModel;
import com.book.novel.readerartifact.ui.findbook.entity.BookSortListType;
import com.book.novel.readerartifact.ui.findbook.entity.SortBookPackage;

import io.reactivex.Observable;

/**
 * @author daniel-wang.
 * @describe : 获取具体类型书籍业务类
 * @date :2018/12/17
 */

public interface ISortBookModel extends IModel {

    Observable<SortBookPackage> getSortBookPackage(String gender, BookSortListType type, String major, String minor, int start, int limit);


    Observable<SortBookPackage> refrashSortBookPackage(String gender, BookSortListType type, String major, String minor, int start, int limit);

}

