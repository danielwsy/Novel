package com.book.novel.readerartifact.ui.readbook;

import com.book.novel.readerartifact.ui.bookshelf.entity.BookChapterPackage;
import com.book.novel.readerartifact.ui.bookshelf.entity.ChapterInfoPackage;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author daniel-wang.
 * @describe : 阅读页面
 * @date :2018/12/10
 */

public interface ReadBookApi {

    /**
     * 获取书籍的章节总列表
     *
     * @param bookId
     * @param view   默认参数为:chapters
     * @return
     */
    @GET("/mix-atoc/{bookId}")
    Observable<BookChapterPackage> getBookChapterPackage(@Path("bookId") String bookId, @Query("view") String view);


    /**
     * 章节的内容
     * 这里采用的是同步请求。
     * @param url
     * @return
     */
    @GET("http://chapter2.zhuishushenqi.com/chapter/{url}")
    Single<ChapterInfoPackage> getChapterInfoPackage(@Path("url") String url);
}
