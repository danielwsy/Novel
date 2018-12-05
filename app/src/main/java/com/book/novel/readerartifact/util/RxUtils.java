package com.book.novel.readerartifact.util;

import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/5
 */

public class RxUtils {

    public static <T> SingleSource<T> toSimpleSingle(Single<T> upstream) {
        return upstream.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
