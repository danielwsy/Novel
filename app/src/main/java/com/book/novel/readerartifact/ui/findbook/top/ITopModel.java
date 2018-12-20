package com.book.novel.readerartifact.ui.findbook.top;

import com.book.novel.readerartifact.base.IModel;
import com.book.novel.readerartifact.ui.findbook.entity.BillBookPackage;
import com.book.novel.readerartifact.ui.findbook.entity.BillboardPackage;

import io.reactivex.Observable;

/**
 * @author daniel-wang.
 * @describe : 排行榜业务类
 * @date :2018/12/20
 */

public interface ITopModel extends IModel {

    /**
     * 获取所有排行榜
     *
     * @return
     */
    Observable<BillboardPackage> getAllTop();

    /**
     * 获取单一排行榜
     *
     * @return
     */
    Observable<BillBookPackage> getSingleTop(String rankingId);
}
