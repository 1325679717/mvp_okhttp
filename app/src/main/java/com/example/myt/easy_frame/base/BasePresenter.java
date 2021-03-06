package com.example.myt.easy_frame.base;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by myt on 2017/5/16.
 */
public class BasePresenter<T> {
    protected Reference<T> mViewRef;

    public void attachView(T view){
        mViewRef = new WeakReference<T>(view);
    }
    protected T getView(){
        return mViewRef.get();
    }
    public boolean isViewAttached(){
        return mViewRef != null && mViewRef.get() != null;
    }
    public  void detachView(){
        if (mViewRef != null){
            mViewRef.clear();
            mViewRef = null;
        }
    }
}
