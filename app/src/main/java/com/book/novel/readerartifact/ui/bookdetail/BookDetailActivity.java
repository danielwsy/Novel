package com.book.novel.readerartifact.ui.bookdetail;

import android.content.Context;
import android.content.Intent;

import com.book.novel.readerartifact.R;
import com.book.novel.readerartifact.base.BaseActivity;
import com.book.novel.readerartifact.base.IModel;
import com.book.novel.readerartifact.base.IPresenter;
import com.book.novel.readerartifact.base.IView;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/6
 */

public class BookDetailActivity extends BaseActivity {

    private static final String BOOK_ID = "book_id";
    public static void startActivity(Context context, String bookId) {
        Intent intent = new Intent(context, BookDetailActivity.class);
        intent.putExtra(BOOK_ID, bookId);
        context.startActivity(intent);
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
    public int getContentView() {
        return R.layout.activity_book_detail;
    }
}
