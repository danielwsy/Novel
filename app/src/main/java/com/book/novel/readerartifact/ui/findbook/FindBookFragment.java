package com.book.novel.readerartifact.ui.findbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.book.novel.readerartifact.HiApplication;
import com.book.novel.readerartifact.R;
import com.book.novel.readerartifact.base.BaseFragment;
import com.book.novel.readerartifact.base.IModel;
import com.book.novel.readerartifact.base.IPresenter;
import com.book.novel.readerartifact.base.IView;
import com.book.novel.readerartifact.base.adapter.BaseListAdapter;
import com.book.novel.readerartifact.ui.findbook.adapter.SectionAdapter;
import com.book.novel.readerartifact.ui.findbook.entity.FindType;
import com.book.novel.readerartifact.ui.findbook.entity.SectionBean;
import com.book.novel.readerartifact.ui.findbook.sort.SortBookActivity;
import com.book.novel.readerartifact.ui.findbook.top.TopBookActivity;
import com.book.novel.readerartifact.ui.seach.adapter.DividerItemDecoration;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * @author daniel-wang.
 * @describe : 发现小说 ------第1层
 * @date :2018/12/5
 */

public class FindBookFragment extends BaseFragment implements BaseListAdapter.OnItemClickListener {

    @BindView(R.id.rc_content)
    RecyclerView mRcContent;

    SectionAdapter mAdapter;

    public static FindBookFragment getInstance() {
        Bundle args = new Bundle();
        FindBookFragment fragment = new FindBookFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_findbook;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {
        super.initView(view, savedInstanceState);
        initAdapter();
    }

    private void initAdapter() {
        ArrayList<SectionBean> sections = new ArrayList<>();
        for (FindType type : FindType.values()) {
            sections.add(new SectionBean(type.getTypeName(), type.getIconId()));
        }

        mAdapter = new SectionAdapter();
        mRcContent.setHasFixedSize(true);
        mRcContent.setLayoutManager(new LinearLayoutManager(getContext()));
        mRcContent.addItemDecoration(new DividerItemDecoration(getContext()));
        mRcContent.setAdapter(mAdapter);
        mAdapter.addItems(sections);
        mAdapter.setOnItemClickListener(this);
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

    @Override
    public void onItemClick(View view, int pos) {
        FindType type = FindType.values()[pos];
        Intent intent;
        switch (type) {
            case TOP:
                intent = new Intent(getContext(), TopBookActivity.class);
                startActivity(intent);
                break;
            case SORT:
                intent = new Intent(getContext(), SortBookActivity.class);
                startActivity(intent);
                break;
            case THEME:
                Toast.makeText(HiApplication.getContext(), "努力开发中", Toast.LENGTH_SHORT).show();
                break;
            case LISTEN:
                Toast.makeText(HiApplication.getContext(), "努力开发中", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
