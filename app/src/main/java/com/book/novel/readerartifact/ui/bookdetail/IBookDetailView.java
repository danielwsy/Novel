package com.book.novel.readerartifact.ui.bookdetail;

import com.book.novel.readerartifact.base.IView;
import com.book.novel.readerartifact.ui.bookdetail.entity.BookDetailBean;
import com.book.novel.readerartifact.ui.bookdetail.entity.HotCommentPackage;
import com.book.novel.readerartifact.ui.bookdetail.entity.RecommendBookListPackage;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/6
 */

public interface IBookDetailView extends IView {

    /**
     * 获取小说详情
     *
     * @param bookDetailBean
     */
    void loadDetailSucceed(BookDetailBean bookDetailBean);

    /**
     * 获取热评
     *
     * @param hotCommentPackage
     */
    void loadHotCommnentSucceed(HotCommentPackage hotCommentPackage);

    /**
     * 获取推荐小说
     *
     * @param recommendBookListPackage
     */
    void loadRecommendListSucceed(RecommendBookListPackage recommendBookListPackage);

    /**
     * 异常
     */
    void errorBooks(Throwable throwable);

}
