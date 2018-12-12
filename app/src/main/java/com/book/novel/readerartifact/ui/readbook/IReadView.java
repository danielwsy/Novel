package com.book.novel.readerartifact.ui.readbook;

import com.book.novel.readerartifact.base.IView;
import com.book.novel.readerartifact.ui.bookshelf.entity.BookChapterBean;
import com.book.novel.readerartifact.ui.bookshelf.entity.ChapterInfoBean;
import com.book.novel.readerartifact.ui.bookshelf.entity.ChapterInfoPackage;

import java.util.List;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/10
 */

public interface IReadView extends IView {

    /**
     * 获取总章节成功
     *
     * @param bookChapterBeans
     */
    void getBookChapterSucceed(List<BookChapterBean> bookChapterBeans);

    /**
     * 获取单个章节目录成功
     *
     * @param chapterInfoPackage
     */
    void getChapterInfoSucceed(ChapterInfoBean chapterInfoPackage);

}
