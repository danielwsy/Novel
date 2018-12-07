package com.book.novel.readerartifact.ui.bookshelf;

import com.book.novel.readerartifact.base.IModel;
import com.book.novel.readerartifact.ui.bookshelf.entity.CollectBookBean;

import java.util.List;

import io.reactivex.Single;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/5
 */

public interface IBookShelfModel extends IModel {
    List<CollectBookBean> refreshCollBooks();

    void createDownloadTask(CollectBookBean collectBookBean);

    void updateCollBooks(List<CollectBookBean> collectBookBeans);

    Single<List<CollectBookBean>> loadRecommendBooks(String gender);

}
