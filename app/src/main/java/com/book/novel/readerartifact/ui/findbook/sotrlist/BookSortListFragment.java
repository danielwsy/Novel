package com.book.novel.readerartifact.ui.findbook.sotrlist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.book.novel.readerartifact.R;
import com.book.novel.readerartifact.base.BaseFragment;
import com.book.novel.readerartifact.base.IModel;
import com.book.novel.readerartifact.base.IPresenter;
import com.book.novel.readerartifact.base.IView;
import com.book.novel.readerartifact.base.adapter.BaseListAdapter;
import com.book.novel.readerartifact.ui.bookdetail.BookDetailActivity;
import com.book.novel.readerartifact.ui.findbook.adapter.BookSortListAdapter;
import com.book.novel.readerartifact.ui.findbook.adapter.BookSubSortEvent;
import com.book.novel.readerartifact.ui.findbook.adapter.LoadMoreView;
import com.book.novel.readerartifact.ui.findbook.adapter.WholeAdapter;
import com.book.novel.readerartifact.ui.findbook.entity.BookSortListType;
import com.book.novel.readerartifact.ui.findbook.entity.SortBookPackage;
import com.book.novel.readerartifact.ui.seach.adapter.DividerItemDecoration;
import com.book.novel.readerartifact.util.RxBus;
import com.book.novel.readerartifact.widget.RefreshLayout;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

/**
 * @author daniel-wang.
 * @describe : 具体小说类型页面
 * @date :2018/12/17
 */

public class BookSortListFragment extends BaseFragment<ISortBookModel, ISoreBookView, SortBookPresenter> implements ISoreBookView {
    private static final String EXTRA_GENDER = "extra_gender";
    private static final String EXTRA_TYPE = "extra_type";
    private static final String EXTRA_MAJOR = "extra_major";


    /********************/
    @BindView(R.id.refresh_layout)
    RefreshLayout mRefreshLayout;
    @BindView(R.id.refresh_rv_content)
    RecyclerView mRvContent;
    /*************************************/
    BookSortListAdapter mBookSortListAdapter;
    /************************************/

    private String mGender;
    private String mMajor;
    private BookSortListType mType;
    private String mMinor = "";
    private int mStart = 0;
    private int mLimit = 20;

    public static Fragment getInstance(String gender, String major, BookSortListType type) {
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_GENDER, gender);
        bundle.putString(EXTRA_MAJOR, major);
        bundle.putSerializable(EXTRA_TYPE, type);
        Fragment fragment = new BookSortListFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {
        super.initView(view, savedInstanceState);
        Bundle bundle = getArguments();

        if (bundle != null) {
            mGender = bundle.getString(EXTRA_GENDER);
            mMajor = bundle.getString(EXTRA_MAJOR);
            mType = (BookSortListType) bundle.getSerializable(EXTRA_TYPE);
        }

        presenter.loadData(mGender, mType, mMajor, mMinor, mStart, mLimit);
        initAdapter();
        initClick();

    }

    private void initClick() {
        mBookSortListAdapter.setOnItemClickListener(new BaseListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int pos) {
                String bookId = mBookSortListAdapter.getItem(pos).get_id();
                BookDetailActivity.startActivity(getContext(), bookId);
            }
        });

        mBookSortListAdapter.setOnLoadMoreListener(new LoadMoreView.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                presenter.loadData(mGender, mType, mMajor, mMinor, mStart, mLimit);
            }
        });

        //子类的切换
        Disposable disposable = RxBus.getInstance()
                .toObservable(BookSubSortEvent.class)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        (event) -> {
                            mMinor = event.bookSubSort;
                            mRefreshLayout.showLoading();
                            mStart = 0;
                            presenter.refrashData(mGender, mType, mMajor, mMinor, mStart, mLimit);
                        }
                );
        addDisposable(disposable);


    }

    private void initAdapter() {
        mBookSortListAdapter = new BookSortListAdapter(getContext(), new WholeAdapter.Options());
        mRvContent.setLayoutManager(new LinearLayoutManager(getContext()));
        mRvContent.addItemDecoration(new DividerItemDecoration(getContext()));
        mRvContent.setAdapter(mBookSortListAdapter);
    }

    @Override
    public ISortBookModel createModel() {
        return new ISortBookModelImpl();
    }

    @Override
    public ISoreBookView createView() {
        return this;
    }

    @Override
    public SortBookPresenter createPresenter() {
        return new SortBookPresenter();
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_refresh_list;
    }

    @Override
    public void loadSucceed(SortBookPackage sortBookPackage) {
        mBookSortListAdapter.addItems(sortBookPackage.getBooks());
        mStart += sortBookPackage.getBooks().size();
        mRefreshLayout.showFinish();
    }

    @Override
    public void RefreshSucceed(SortBookPackage sortBookPackage) {
        if (sortBookPackage == null || sortBookPackage.getBooks().isEmpty()) {
            mRefreshLayout.showEmpty();
            return;
        }
        mBookSortListAdapter.refreshItems(sortBookPackage.getBooks());
        mStart = sortBookPackage.getBooks().size();
    }

}
