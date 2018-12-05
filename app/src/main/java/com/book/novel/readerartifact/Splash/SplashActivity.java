package com.book.novel.readerartifact.Splash;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.book.novel.readerartifact.MainActivity;
import com.book.novel.readerartifact.R;
import com.book.novel.readerartifact.R2;
import com.book.novel.readerartifact.base.BaseActivity;
import com.book.novel.readerartifact.base.IModel;
import com.book.novel.readerartifact.base.IPresenter;
import com.book.novel.readerartifact.base.IView;
import com.book.novel.readerartifact.network.UrlConfig;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;

/**
 * @author daniel-wang.
 * @describe :
 * @date :2018/12/5
 */

public class SplashActivity extends BaseActivity {

    @BindView(R.id.iv_ad)
    ImageView mSplashView;

    /**
     * 跳转按钮
     */
    @BindView(R2.id.tv_skip)
    TextView tvSkip;

    /**
     * 点击跳转
     */
    @OnClick(R2.id.fl_skip)
    public void onViewClicked() {
        toMain();
    }

    private CompositeDisposable mCompositeDisposable;

    @Override
    public int getContentView() {
        return R.layout.activity_splash;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {
        Glide.with(this).load(UrlConfig.SPLASH_URL)
                .apply(new RequestOptions()
                        .centerCrop()
                        .diskCacheStrategy(DiskCacheStrategy.ALL))
                .transition(new DrawableTransitionOptions().crossFade(800))
                .into(mSplashView);
    }

    @Override
    public void initData() {
        mCompositeDisposable = new CompositeDisposable();
        mCompositeDisposable.add(countDown(3).doOnSubscribe(new Consumer<Disposable>() {
            @Override
            public void accept(@NonNull Disposable disposable) throws Exception {
                tvSkip.setText("跳过 4");
            }
        }).subscribeWith(new DisposableObserver<Integer>() {
            @Override
            public void onNext(Integer integer) {
                tvSkip.setText("跳过 " + (integer + 1));
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                toMain();
            }
        }));
    }

    private void toMain() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.dispose();
        }
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }


    public Observable<Integer> countDown(int time) {
        if (time < 0) time = 0;
        final int countTime = time;
        return Observable.interval(0, 1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<Long, Integer>() {
                    @Override
                    public Integer apply(@NonNull Long aLong) throws Exception {
                        return countTime - aLong.intValue();
                    }
                })
                .take(countTime + 1);
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
}
