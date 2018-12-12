package com.book.novel.readerartifact.ui.bookdetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.book.novel.readerartifact.R;
import com.book.novel.readerartifact.base.BaseActivity;
import com.book.novel.readerartifact.base.IModel;
import com.book.novel.readerartifact.base.IPresenter;
import com.book.novel.readerartifact.base.IView;
import com.book.novel.readerartifact.network.UrlConfig;
import com.book.novel.readerartifact.ui.bookdetail.adapter.BookListAdapter;
import com.book.novel.readerartifact.ui.bookdetail.adapter.HotCommentAdapter;
import com.book.novel.readerartifact.ui.bookdetail.entity.BookDetailBean;
import com.book.novel.readerartifact.ui.bookdetail.entity.HotCommentPackage;
import com.book.novel.readerartifact.ui.bookdetail.entity.RecommendBookListPackage;
import com.book.novel.readerartifact.ui.bookshelf.entity.CollectBookBean;
import com.book.novel.readerartifact.ui.readbook.ReadingActivity;
import com.book.novel.readerartifact.ui.seach.adapter.DividerItemDecoration;
import com.book.novel.readerartifact.util.StringUtils;
import com.book.novel.readerartifact.widget.RefreshLayout;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author daniel-wang.
 * @describe : 小说详情页
 * @date :2018/12/6
 */

public class BookDetailActivity extends BaseActivity<IBookDetailModel, IBookDetailView, BookDetailPresenter> implements IBookDetailView {

    private static final String BOOK_ID = "book_id";

    @BindView(R.id.refresh_layout)
    RefreshLayout mRefreshLayout;
    @BindView(R.id.book_detail_iv_cover)
    ImageView mIvCover;
    @BindView(R.id.book_detail_tv_title)
    TextView mTvTitle;
    @BindView(R.id.book_detail_tv_author)
    TextView mTvAuthor;
    @BindView(R.id.book_detail_tv_type)
    TextView mTvType;
    @BindView(R.id.book_detail_tv_word_count)
    TextView mTvWordCount;
    @BindView(R.id.book_detail_tv_lately_update)
    TextView mTvLatelyUpdate;
    @BindView(R.id.book_list_tv_chase)
    TextView mTvChase;
    @BindView(R.id.book_detail_tv_read)
    TextView mTvRead;
    @BindView(R.id.book_detail_tv_follower_count)
    TextView mTvFollowerCount;
    @BindView(R.id.book_detail_tv_retention)
    TextView mTvRetention;
    @BindView(R.id.book_detail_tv_day_word_count)
    TextView mTvDayWordCount;
    @BindView(R.id.book_detail_tv_brief)
    TextView mTvBrief;
    @BindView(R.id.book_detail_tv_more_comment)
    TextView mTvMoreComment;
    @BindView(R.id.book_detail_rv_hot_comment)
    RecyclerView mRvHotComment;
    @BindView(R.id.book_detail_rv_community)
    RelativeLayout mRvCommunity;
    @BindView(R.id.book_detail_tv_community)
    TextView mTvCommunity;
    @BindView(R.id.book_detail_tv_posts_count)
    TextView mTvPostsCount;
    @BindView(R.id.book_list_tv_recommend_book_list)
    TextView mTvRecommendBookList;
    @BindView(R.id.book_detail_rv_recommend_book_list)
    RecyclerView mRvRecommendBookList;

    private HotCommentAdapter mHotCommentAdapter;
    private BookListAdapter mBookListAdapter;
    private String mBookId;

    private CollectBookBean mCollBookBean;
    public static final String EXTRA_COLL_BOOK = "extra_coll_book";

    @OnClick(R.id.book_detail_tv_read)
    public void startReadBook() {
        Intent intent = new Intent(this, ReadingActivity.class);
        intent.putExtra(EXTRA_COLL_BOOK, mCollBookBean);
        startActivity(intent);
    }

    @Override
    public IBookDetailModel createModel() {
        return new IBookDetailModelImpl();
    }

    @Override
    public IBookDetailView createView() {
        return this;
    }

    @Override
    public BookDetailPresenter createPresenter() {
        return new BookDetailPresenter();
    }

    @Override
    public int getContentView() {
        return R.layout.activity_book_detail;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {
        super.initView(view, savedInstanceState);
    }

    @Override
    public void initData() {
        super.initData();
        mBookId = getIntent().getStringExtra(BOOK_ID);
    }

    @Override
    protected void processLoading() {
        super.processLoading();
        if (presenter != null) {
            presenter.refreshBookDetail(mBookId);
        }
    }

    @Override
    public void loadDetailSucceed(BookDetailBean bean) {
        //封面
        Glide.with(this)
                .load(UrlConfig.IMG_BASE_URL + bean.getCover())
                .placeholder(R.drawable.ic_book_loading)
                .error(R.drawable.ic_load_error)
                .centerCrop()
                .into(mIvCover);
        //书名
        mTvTitle.setText(bean.getTitle());
        //作者
        mTvAuthor.setText(bean.getAuthor());
        //类型
        mTvType.setText(bean.getMajorCate());

        //总字数
        mTvWordCount.setText(getResources().getString(R.string.nb_book_word, bean.getWordCount() / 10000));
        //更新时间
        mTvLatelyUpdate.setText(StringUtils.dateConvert(bean.getUpdated(), "yyyy-MM-dd"));
        //追书人数
        mTvFollowerCount.setText(bean.getFollowerCount() + "");
        //存留率
        mTvRetention.setText(bean.getRetentionRatio() + "%");
        //日更字数
        mTvDayWordCount.setText(bean.getSerializeWordCount() + "");
        //简介
        mTvBrief.setText(bean.getLongIntro());
        //社区
        mTvCommunity.setText(getResources().getString(R.string.nb_book_detail_community, bean.getTitle()));
        //帖子数
        mTvPostsCount.setText(getResources().getString(R.string.nb_book_detail_posts_count, bean.getPostCount()));
        mCollBookBean = bean.getCollBookBean();
    }

    @Override
    public void loadHotCommnentSucceed(HotCommentPackage hotCommentPackage) {
        if (hotCommentPackage == null) {
            return;
        }
        mHotCommentAdapter = new HotCommentAdapter();
        mRvHotComment.setLayoutManager(new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                //与外部ScrollView滑动冲突
                return false;
            }
        });
        mRvHotComment.addItemDecoration(new DividerItemDecoration(this));
        mRvHotComment.setAdapter(mHotCommentAdapter);
        mHotCommentAdapter.addItems(hotCommentPackage.getReviews());
    }

    @Override
    public void loadRecommendListSucceed(RecommendBookListPackage beans) {
        mRefreshLayout.showFinish();
        if (beans == null) {
            mTvRecommendBookList.setVisibility(View.GONE);
            return;
        }
        //推荐书单列表
        mBookListAdapter = new BookListAdapter();
        mRvRecommendBookList.setLayoutManager(new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                //与外部ScrollView滑动冲突
                return false;
            }
        });
        mRvRecommendBookList.addItemDecoration(new DividerItemDecoration(this));
        mRvRecommendBookList.setAdapter(mBookListAdapter);
        mBookListAdapter.addItems(beans.getBooklists());

    }

    @Override
    public void errorBooks(Throwable throwable) {

    }

    public static void startActivity(Context context, String bookId) {
        Intent intent = new Intent(context, BookDetailActivity.class);
        intent.putExtra(BOOK_ID, bookId);
        context.startActivity(intent);
    }

}
