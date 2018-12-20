package com.book.novel.readerartifact.ui.findbook;

import com.book.novel.readerartifact.ui.findbook.entity.BillBookPackage;
import com.book.novel.readerartifact.ui.findbook.entity.BillboardPackage;
import com.book.novel.readerartifact.ui.findbook.entity.BookSortPackage;
import com.book.novel.readerartifact.ui.findbook.entity.BookSubSortPackage;
import com.book.novel.readerartifact.ui.findbook.entity.SortBookPackage;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/17
 */

public interface FindApi {

    /**
     * 获取所有排行榜
     *
     * @return
     */
    @GET("/ranking/gender")
    Observable<BillboardPackage> getBillboardPackage();

    /**
     * 获取单一排行榜
     * 周榜：rankingId-> _id
     * 月榜：rankingId-> monthRank
     * 总榜：rankingId-> totalRank
     *
     * @return
     */
    @GET("/ranking/{rankingId}")
    Observable<BillBookPackage> getBillBookPackage(@Path("rankingId") String rankingId);

    /*******************************分类***************************************/
    /**
     * 获取分类
     *
     * @return
     */
    @GET("/cats/lv2/statistics")
    Observable<BookSortPackage> getBookSortPackage();

    /**
     * 获取二级分类
     *
     * @return
     */
    @GET("/cats/lv2")
    Observable<BookSubSortPackage> getBookSubSortPackage();

    /**
     * 按分类获取书籍列表
     *
     * @param gender male、female
     * @param type   hot(热门)、new(新书)、reputation(好评)、over(完结)
     * @param major  玄幻
     * @param minor  东方玄幻、异界大陆、异界争霸、远古神话
     * @param limit  50
     * @return
     */
    @GET("/book/by-categories")
    Observable<SortBookPackage> getSortBookPackage(@Query("gender") String gender, @Query("type") String type,
                                                   @Query("major") String major, @Query("minor") String minor,
                                                   @Query("start") int start, @Query("limit") int limit);

}
