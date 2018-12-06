package com.book.novel.readerartifact.ui.bookdetail;

import com.book.novel.readerartifact.base.IModel;
import com.book.novel.readerartifact.ui.bookdetail.entity.BookDetailBean;
import com.book.novel.readerartifact.ui.bookdetail.entity.HotCommentPackage;
import com.book.novel.readerartifact.ui.bookdetail.entity.RecommendBookListPackage;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/6
 */

public interface IBookDetailModel extends IModel {

    /**
     * 书籍详情
     *
     * @param bookId
     * @return
     */
    Observable<BookDetailBean> getBookDetail(String bookId);

    /**
     * 书籍热门评论
     *
     * @param book
     * @return
     */
    Observable<HotCommentPackage> getHotCommnent(String book);


    /**
     * 书籍推荐书单
     *
     * @param bookId
     * @param limit
     * @return
     */

    Observable<RecommendBookListPackage> getRecommendList(String bookId, int limit);
}
