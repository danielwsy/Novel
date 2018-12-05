package com.book.novel.readerartifact;

import android.app.Application;
import android.content.Context;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/5
 */

public class HiApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }

}
