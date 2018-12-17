package com.book.novel.readerartifact.ui.findbook.sotrlist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.book.novel.readerartifact.R;
import com.book.novel.readerartifact.base.BaseTabActivity;
import com.book.novel.readerartifact.base.IModel;
import com.book.novel.readerartifact.base.IPresenter;
import com.book.novel.readerartifact.base.IView;
import com.book.novel.readerartifact.ui.findbook.entity.BookSortListType;
import com.book.novel.readerartifact.ui.findbook.entity.BookSubSortBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author daniel-wang.
 * @describe : 分类书籍列表
 * @date :2018/12/17
 */

public class BookSortListActivity extends BaseTabActivity {

    private static final String EXTRA_GENDER = "extra_gender";
    private static final String EXTRA_SUB_SORT = "extra_sub_sort";

    private String mGender = "";
    private BookSubSortBean mSubSortBean = null;

    public static void startActivity(Context context, String gender, BookSubSortBean subSortBean) {
        Intent intent = new Intent(context, BookSortListActivity.class);
        intent.putExtra(EXTRA_GENDER, gender);
        intent.putExtra(EXTRA_SUB_SORT, subSortBean);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mGender = getIntent().getStringExtra(EXTRA_GENDER);
        mSubSortBean = getIntent().getParcelableExtra(EXTRA_SUB_SORT);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_book_sort_list;
    }

    @Override
    protected List<Fragment> createTabFragments() {
        mGender = getIntent().getStringExtra(EXTRA_GENDER);
        mSubSortBean = getIntent().getParcelableExtra(EXTRA_SUB_SORT);
        List<Fragment> fragments = new ArrayList<>();
        if (mSubSortBean != null) {
            for (BookSortListType type : BookSortListType.values()) {
                fragments.add(BookSortListFragment.getInstance(mGender, mSubSortBean.getMajor(), type));
            }
        }
        return fragments;
    }

    @Override
    protected List<String> createTabTitles() {
        List<String> titles = new ArrayList<>();
        for (BookSortListType type : BookSortListType.values()) {
            titles.add(type.getTypeName());
        }
        return titles;
    }


    @Override
    public IModel createModel() {
        return null;
    }

    @Override
    public IView createView() {
        return null;
    }

    @Override
    public IPresenter createPresenter() {
        return null;
    }
}
