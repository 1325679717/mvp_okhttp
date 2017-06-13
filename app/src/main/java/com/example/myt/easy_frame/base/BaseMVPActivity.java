package com.example.myt.easy_frame.base;

import android.app.Activity;
import android.os.Bundle;

import com.example.myt.easy_frame.base.BasePresenter;

/**
 * Created by myt on 2017/5/16.
 */
public abstract class BaseMVPActivity<V,T extends BasePresenter<V>> extends Activity {
    protected T mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.attachView((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    protected abstract T createPresenter();
}
