package com.book.novel.readerartifact.util;

import com.book.novel.readerartifact.base.gen.CollectBookBeanDao;
import com.book.novel.readerartifact.ui.bookshelf.entity.CollectBookBean;

import java.util.List;

/**
 * @author daniel-wang.
 * @describe : 存储关于书籍内容的信息
 * CollectBook : 收藏书籍
 * BookChapter :书籍列表
 * ChapterInfo :书籍章节
 * BookRecord : 记录
 * @date :2018/12/5
 */

public class BookRepository {
    private static volatile BookRepository sInstance;
    private CollectBookBeanDao mCollectBookDao;

    public BookRepository() {
    }

    public static BookRepository getInstance() {
        if (sInstance == null) {
            synchronized (BookRepository.class) {
                if (sInstance == null) {
                    sInstance = new BookRepository();
                }
            }
        }
        return sInstance;
    }


    /**
     * 从数据库中读取书架中的书籍
     *
     * @return
     */
    public List<CollectBookBean> getCollBooks() {
        return null;
    }
}
