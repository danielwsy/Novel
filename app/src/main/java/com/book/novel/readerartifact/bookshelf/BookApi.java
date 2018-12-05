package com.book.novel.readerartifact.bookshelf;

import com.book.novel.readerartifact.bookshelf.entity.BookChapterPackage;
import com.book.novel.readerartifact.bookshelf.entity.ChapterInfoPackage;
import com.book.novel.readerartifact.bookshelf.entity.RecommendBookPackage;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/5
 */

public interface BookApi {

    /**
     * 推荐书籍
     *
     * @param gender
     * @return
     */
    @GET("/book/recommend")
    Single<RecommendBookPackage> getRecommendBookPackage(@Query("gender") String gender);



    /**
     * 获取书籍的章节总列表
     *
     * @param bookId
     * @param view   默认参数为:chapters
     * @return
     */
    @GET("/mix-atoc/{bookId}")
    Single<BookChapterPackage> getBookChapterPackage(@Path("bookId") String bookId, @Query("view") String view);

    /**
     * 章节的内容
     * 这里采用的是同步请求。
     *
     * @param url
     * @return
     */
    @GET("http://chapter2.zhuishushenqi.com/chapter/{url}")
    Single<ChapterInfoPackage> getChapterInfoPackage(@Path("url") String url);
}
