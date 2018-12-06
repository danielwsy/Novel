package com.book.novel.readerartifact.ui.seach;

import com.book.novel.readerartifact.base.IModel;
import com.book.novel.readerartifact.ui.seach.entity.HotWordPackage;
import com.book.novel.readerartifact.ui.seach.entity.KeyWordPackage;
import com.book.novel.readerartifact.ui.seach.entity.SearchBookPackage;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/6
 */

public interface ISearchModel extends IModel {

    /**
     * 根据作者名和书籍名字查询书籍
     *
     * @param word
     * @return
     */
    Observable<SearchBookPackage> searchBook(String word);


    /**
     * 根据用户输入的智能补齐
     *
     * @param complete
     * @return
     */
    Observable<KeyWordPackage> completeSearchWord(String complete);


    /**
     * 查询热门推荐书籍
     *
     * @return
     */
    Observable<HotWordPackage> getHotBook();

}
