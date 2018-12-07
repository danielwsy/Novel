package com.book.novel.readerartifact.ui.bookshelf;

import android.os.Bundle;

import com.book.novel.readerartifact.R;
import com.book.novel.readerartifact.base.BaseFragment;
import com.book.novel.readerartifact.ui.bookshelf.entity.CollectBookBean;

import java.util.List;

/**
 * @author daniel-wang.
 * @describe : 书架
 * @date :2018/12/5
 */

public class BookShelfFragment extends BaseFragment<IBookShelfModel, IBookShelfView, BookShelfPresenter> implements IBookShelfView {


    public static BookShelfFragment getInstance() {
        Bundle args = new Bundle();
        BookShelfFragment fragment = new BookShelfFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_bookshelf;
    }

    @Override
    public IBookShelfModel createModel() {
        return new IBookShelfModeImpl();
    }

    @Override
    public IBookShelfView createView() {
        return this;
    }

    @Override
    public BookShelfPresenter createPresenter() {
        return new BookShelfPresenter();
    }

    @Override
    public void finishRefresh(List<CollectBookBean> collectBookBeans) {

    }

    @Override
    public void finishUpdate() {

    }

    @Override
    public void showErrorTip(String error) {

    }

    @Override
    public void complete() {

    }
}
