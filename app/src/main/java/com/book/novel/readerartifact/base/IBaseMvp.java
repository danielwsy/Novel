package com.book.novel.readerartifact.base;

/**
 * @author daniel-wang.
 * @describe :用于创建Model、View和Presente
 * @date :2018/12/5
 */

public interface IBaseMvp<M extends IModel, V extends IView, P extends IPresenter> {
    M createModel();

    V createView();

    P createPresenter();
}
