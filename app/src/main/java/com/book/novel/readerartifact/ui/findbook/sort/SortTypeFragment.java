package com.book.novel.readerartifact.ui.findbook.sort;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.book.novel.readerartifact.R;
import com.book.novel.readerartifact.base.BaseFragment;
import com.book.novel.readerartifact.base.adapter.BaseListAdapter;
import com.book.novel.readerartifact.ui.findbook.adapter.SookBookAdpter;
import com.book.novel.readerartifact.ui.findbook.entity.BookSortPackage;
import com.book.novel.readerartifact.ui.findbook.entity.BookSubSortBean;
import com.book.novel.readerartifact.ui.findbook.entity.BookSubSortPackage;
import com.book.novel.readerartifact.ui.findbook.sort.sotrlist.BookSortListActivity;
import com.book.novel.readerartifact.widget.DividerGridItemDecoration;

import butterknife.BindView;

/**
 * @author daniel-wang.
 * @describe :  具体每个类型的页面-------第3层
 * @date :2018/12/17
 */

public class SortTypeFragment extends BaseFragment<ISortModel, ISortView, SortPresenter> implements ISortView {

    @BindView(R.id.recycler_boy)
    RecyclerView mRecycler;
    SookBookAdpter mBoyAdapter;

    String tag = "";
    private BookSubSortPackage mSubSortPackage;

    public static SortTypeFragment getInstance(String tag) {
        Bundle args = new Bundle();
        SortTypeFragment fragment = new SortTypeFragment();
        args.putString("tag", tag);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public ISortModel createModel() {
        return new ISortModelImpl();
    }

    @Override
    public ISortView createView() {
        return this;
    }

    @Override
    public SortPresenter createPresenter() {
        return new SortPresenter();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void initView(View view, Bundle savedInstanceState) {
        super.initView(view, savedInstanceState);
        presenter.getSortinfo();
        RecyclerView.ItemDecoration itemDecoration = new DividerGridItemDecoration(getActivity(), R.drawable.shape_divider_row, R.drawable.shape_divider_col);

        mRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
        mRecycler.addItemDecoration(itemDecoration);
        mBoyAdapter = new SookBookAdpter();
        mRecycler.setAdapter(mBoyAdapter);

        mBoyAdapter.setOnItemClickListener(new BaseListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int pos) {
                BookSubSortBean subSortBean = null;
                String gender = "";
                if ("男生".equals(tag)) {
                    subSortBean = mSubSortPackage.getMale().get(pos);
                    gender = "male";
                } else {
                    subSortBean = mSubSortPackage.getFemale().get(pos);
                    gender = "female";
                }
                BookSortListActivity.startActivity(getContext(), gender, subSortBean);
            }
        });
    }

    @Override
    public void initData() {
        super.initData();
        tag = getArguments().getString("tag");
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_findbook_sort_boy;
    }

    @Override
    public void finishBookSort(BookSortPackage sortPackage) {
        if ("男生".equals(tag)) {
            mBoyAdapter.refreshItems(sortPackage.getMale());
        } else {
            mBoyAdapter.refreshItems(sortPackage.getFemale());
        }

    }

    @Override
    public void finishBooSubkSort(BookSubSortPackage subSortPackage) {
        mSubSortPackage = subSortPackage;
    }
}
