package com.book.novel.readerartifact.ui.findbook.top;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;

import com.book.novel.readerartifact.R;
import com.book.novel.readerartifact.base.BaseFragment;
import com.book.novel.readerartifact.base.IModel;
import com.book.novel.readerartifact.base.IPresenter;
import com.book.novel.readerartifact.base.IView;
import com.book.novel.readerartifact.ui.findbook.adapter.TopSpecificAdapter;
import com.book.novel.readerartifact.ui.findbook.entity.BillBookPackage;
import com.book.novel.readerartifact.ui.findbook.entity.BillboardBean;
import com.book.novel.readerartifact.ui.findbook.entity.BillboardPackage;
import com.book.novel.readerartifact.ui.findbook.sort.SortBookActivity;
import com.book.novel.readerartifact.ui.findbook.sort.SortTypeFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import fr.castorflex.android.verticalviewpager.VerticalViewPager;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.widget.TabView;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/21
 */

public class TopBookTypeFragment extends BaseFragment<ITopModel, ITopView, TopPresenter> implements ITopView {


    @BindView(R.id.sort_tab)
    VerticalTabLayout mTablayout;

    @BindView(R.id.top_rcl)
    RecyclerView mRcl;

    List<BillboardBean> mDatas = null;

    private String mGender = "";

    public static TopBookTypeFragment getInstance(String tag) {
        Bundle args = new Bundle();
        TopBookTypeFragment fragment = new TopBookTypeFragment();
        args.putString("tag", tag);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public ITopModel createModel() {
        return new TopViewImpl();
    }

    @Override
    public ITopView createView() {
        return this;
    }

    @Override
    public TopPresenter createPresenter() {
        return new TopPresenter();
    }

    @Override
    public void initData() {
        super.initData();
        mGender = getArguments().getString("tag");
        presenter.getAllTop();

        mTablayout.addOnTabSelectedListener(new VerticalTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabView tab, int position) {
                presenter.getSingleTop(mDatas.get(position).get_id());
            }

            @Override
            public void onTabReselected(TabView tab, int position) {

            }
        });


    }


    @Override
    public int getContentView() {
        return R.layout.fragment_topbook;
    }

    @Override
    public void getAllTopSucceed(BillboardPackage billboardPackage) {
        List<BillboardBean> males = billboardPackage.getMale();
        List<BillboardBean> females = billboardPackage.getFemale();
        List<String> title = new ArrayList<>();
        if ("男频".equals(mGender)) {
            mDatas = males;
            for (BillboardBean beanm : males) {
                title.add(beanm.getTitle());
            }
        } else {
            mDatas = females;
            for (BillboardBean beanm : females) {
                title.add(beanm.getTitle());
            }
        }
        mTablayout.setTabAdapter(new MyTabAdapter(title));
    }

    @Override
    public void getSingleTopSucceed(BillBookPackage billBookPackage) {
        BillBookPackage a = billBookPackage;
    }

    @Override
    public void getError(Throwable throwable) {

    }
}
