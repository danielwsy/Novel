package com.book.novel.readerartifact.ui.findbook.sotrlist;

import com.book.novel.readerartifact.base.IModel;
import com.book.novel.readerartifact.ui.findbook.entity.SortBookPackage;

import io.reactivex.Observable;

/**
 * @author daniel-wang.
 * @describe : 获取具体类型书籍业务类
 * @date :2018/12/17
 */

public interface ISortBookModel extends IModel {

    Observable<SortBookPackage> getSortBookPackage();

}
