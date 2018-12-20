package com.book.novel.readerartifact.ui.findbook.top;

import com.book.novel.readerartifact.base.IView;
import com.book.novel.readerartifact.ui.findbook.entity.BillBookPackage;
import com.book.novel.readerartifact.ui.findbook.entity.BillboardPackage;

/**
 * @author daniel-wang.
 * @describe : 排行榜
 * @date :2018/12/20
 */

public interface ITopView extends IView {

    /**
     * 获取所有排行榜成功
     *
     * @param billboardPackage
     */
    void getAllTopSucceed(BillboardPackage billboardPackage);

    /**
     * 获取单一排行榜成功
     *
     * @param billBookPackage
     */
    void getSingleTopSucceed(BillBookPackage billBookPackage);


    void getError(Throwable throwable);

}
