package com.book.novel.readerartifact.ui.bookshelf;

import com.book.novel.readerartifact.base.IView;
import com.book.novel.readerartifact.ui.bookshelf.entity.CollectBookBean;

import java.util.List;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/5
 */

public interface IBookShelfView extends IView {
    /**
     * 完成刷新
     *
     * @param collectBookBeans
     */
    void finishRefresh(List<CollectBookBean> collectBookBeans);

    /**
     * 更新完毕
     */
    void finishUpdate();

    /**
     * 异常报错
     *
     * @param error
     */
    void showErrorTip(String error);

    void complete();

}
