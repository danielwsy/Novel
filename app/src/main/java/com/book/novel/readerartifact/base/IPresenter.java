package com.book.novel.readerartifact.base;

/**
 * @author daniel-wang.
 * @describe : 程序中的逻辑超类，负责处理具体事务
 * @date :2018/12/5
 */

public interface IPresenter<M extends IModel, V extends IView> {
    /**
     * 注册Model层
     *
     * @param model
     */
    void registerModel(M model);

    /**
     * 注册View层
     *
     * @param view
     */
    void registerView(V view);

    /**
     * 获取View
     *
     * @return
     */
    V getView();

    /**
     * 销毁动作（如Activity、Fragment的卸载）
     */
    void destroy();
}
