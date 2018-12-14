package com.book.novel.readerartifact;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.book.novel.readerartifact.base.BaseActivity;
import com.book.novel.readerartifact.base.IModel;
import com.book.novel.readerartifact.base.IPresenter;
import com.book.novel.readerartifact.base.IView;
import com.book.novel.readerartifact.base.SupportFragment;
import com.book.novel.readerartifact.ui.bookshelf.BookShelfFragment;
import com.book.novel.readerartifact.ui.findbook.FindBookFragment;
import com.book.novel.readerartifact.ui.seach.SearchActivity;
import com.book.novel.readerartifact.ui.setting.SettingActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.contentContainer)
    FrameLayout mView;

    @BindView(R.id.rg_bottoms)
    RadioGroup mRgBottom;

    @BindView(R.id.bookshelf)
    RadioButton mRbBookShelf;

    @BindView(R.id.find_book)
    RadioButton mRbFindBook;

    @BindView(R.id.iv_search)
    ImageView mIvSearch;

    @BindView(R.id.tv_setting)
    TextView mTvSetting;

    @OnClick(R.id.iv_search)
    public void onSearchClicked() {
        startActivity(new Intent(this, SearchActivity.class));
    }


    @OnClick(R.id.tv_setting)
    public void onSettingCliked() {
        startActivity(new Intent(this, SettingActivity.class));
    }


    private SupportFragment[] mFragments = new SupportFragment[2];

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            mFragments[0] = BookShelfFragment.getInstance();
            mFragments[1] = FindBookFragment.getInstance();
            getSupportDelegate().loadMultipleRootFragment(R.id.contentContainer, 0,
                    mFragments[0],
                    mFragments[1]
            );
        } else {
            mFragments[0] = findFragment(BookShelfFragment.class);
            mFragments[1] = findFragment(FindBookFragment.class);
        }
    }

    @Override
    public void initData() {
        mRbBookShelf.setChecked(true);
        mRgBottom.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.bookshelf:
                        getSupportDelegate().showHideFragment(mFragments[0]);//show一个Fragment,hide其他同栈所有Fragment
                        break;
                    case R.id.find_book:
                        getSupportDelegate().showHideFragment(mFragments[1]);
                        break;
                }
            }
        });
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
