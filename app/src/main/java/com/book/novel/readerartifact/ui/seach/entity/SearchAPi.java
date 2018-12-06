package com.book.novel.readerartifact.ui.seach.entity;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/6
 */

public interface SearchAPi {


    /**
     * 书籍查询
     *
     * @param query:作者名或者书名
     * @return
     */
    @GET("/book/fuzzy-search")
    Observable<SearchBookPackage> getSearchBookPackage(@Query("query") String query);


    /**
     * 搜索推荐书籍
     *
     * @return
     */
    @GET("/book/hot-word")
    Observable<HotWordPackage> getHotWordPackage();

    /**
     * 关键字自动补全
     *
     * @param query
     * @return
     */
    @GET("/book/auto-complete")
    Observable<KeyWordPackage> completeWord(@Query("query") String query);
}
