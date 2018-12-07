package com.book.novel.readerartifact.util;

import android.database.sqlite.SQLiteDatabase;

import com.book.novel.readerartifact.HiApplication;
import com.book.novel.readerartifact.base.gen.DaoMaster;
import com.book.novel.readerartifact.base.gen.DaoSession;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/7
 */

public class DaoDbHelper {
    private static final String DB_NAME = "IReader_DB";

    private static volatile DaoDbHelper sInstance;
    private SQLiteDatabase mDb;
    private DaoMaster mDaoMaster;
    private DaoSession mSession;

    public DaoDbHelper() {
        //封装数据库的创建、更新、删除
        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(HiApplication.getContext(), DB_NAME, null);
        //获取数据库
        mDb = openHelper.getWritableDatabase();
        //封装数据库中表的创建、更新、删除
        mDaoMaster = new DaoMaster(mDb);  //合起来就是对数据库的操作
        //对表操作的对象。
        mSession = mDaoMaster.newSession(); //可以认为是对数据的操作

    }

}
