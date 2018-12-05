package com.book.novel.readerartifact.network;

import android.content.Context;
import android.util.Log;

import com.book.novel.readerartifact.HiApplication;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.internal.schedulers.IoScheduler;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/5
 */

public class BaseHttpUtils {
    public static final int CACHE_SIZE = 4 * 1024 * 1024; //cache size
    public static final int NETWORK_TIME_OUT = 60; //network time out

    private static OkHttpClient okHttpClient;
    private String mServerUrl;
    private Context mContext;
    private Retrofit mRetrofit;

    public BaseHttpUtils(String serverUrl) {
        mContext = HiApplication.getContext();
        mServerUrl = serverUrl;
    }

    public Retrofit getRetrofit() {
        if (mRetrofit == null) {
            synchronized (BaseHttpUtils.class) {
                if (mRetrofit == null) {
                    mRetrofit = initDefault();
                }
            }
        }
        return mRetrofit;
    }

    /**
     * Retrofit 和 OKHttp进行结合
     *
     * @return
     */
    private Retrofit initDefault() {
        Retrofit.Builder builder = new Retrofit.Builder();
        if (okHttpClient == null) {
            OkHttpClient.Builder okBuilder = buildDefalutClient(mContext);
            okHttpClient = okBuilder.build();
        }
        builder.client(okHttpClient);
        builder.addConverterFactory(GsonConverterFactory.create());
        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(new IoScheduler()));
        builder.baseUrl(mServerUrl);
        return builder.build();
    }


    /**
     * 初始化OKHttp
     *
     * @param context
     * @return
     */
    private static OkHttpClient.Builder buildDefalutClient(Context context) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.cache(new Cache(context.getCacheDir(), CACHE_SIZE));
        builder.connectTimeout(NETWORK_TIME_OUT, TimeUnit.SECONDS);
        builder.readTimeout(NETWORK_TIME_OUT, TimeUnit.SECONDS);
        builder.writeTimeout(NETWORK_TIME_OUT, TimeUnit.SECONDS);
        builder.addNetworkInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                //在这里获取到request后就可以做任何事情了
                Response response = chain.proceed(request);
                Log.d("daniel", "intercept: " + request.url().toString());
                return response;
            }
        });
        return builder;
    }

}
