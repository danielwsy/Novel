package com.book.novel.readerartifact.ui.readbook;

import com.book.novel.readerartifact.base.IModel;
import com.book.novel.readerartifact.ui.bookdetail.entity.BookDetailBean;
import com.book.novel.readerartifact.ui.bookshelf.entity.BookChapterPackage;
import com.book.novel.readerartifact.ui.bookshelf.entity.ChapterInfoPackage;

import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/10
 */

public interface IReadModel  extends IModel{

    /**
     * 获取书籍的章节总列表
     *
     * @param bookId
     * @param view
     * @return
     */
    Observable<BookChapterPackage> getBookChapter(String bookId, String view);


    /**
     * 章节的内容
     *
     * @param url
     * @return
     */
    Single<ChapterInfoPackage> getChapterInfo(String url);

}
