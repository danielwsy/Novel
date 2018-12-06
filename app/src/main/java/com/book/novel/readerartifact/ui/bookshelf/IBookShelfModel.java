package com.book.novel.readerartifact.ui.bookshelf;

import com.book.novel.readerartifact.base.IModel;
import com.book.novel.readerartifact.ui.bookshelf.entity.CollBookBean;
import com.book.novel.readerartifact.ui.bookshelf.entity.RecommendBookPackage;

import java.util.List;

import io.reactivex.Single;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/5
 */

public interface IBookShelfModel extends IModel {
    List<CollBookBean> refreshCollBooks();

    void createDownloadTask(CollBookBean collBookBean);

    void updateCollBooks(List<CollBookBean> collBookBeans);

    Single<List<CollBookBean>> loadRecommendBooks(String gender);

}
