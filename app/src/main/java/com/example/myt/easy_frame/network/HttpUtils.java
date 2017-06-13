package com.example.myt.easy_frame.network;

import com.example.myt.easy_frame.utils.Platform;

import java.util.concurrent.Executor;

import okhttp3.OkHttpClient;

/**
 * Created by myt on 2017/4/20.
 */
public class HttpUtils {
    public static final long DEFAULT_MILLISECONDS = 10_000L;
    private volatile static HttpUtils mInstance;
    private OkHttpClient mOkHttpClient;
    private Platform mPlatform;

    public HttpUtils(OkHttpClient okHttpClient)
    {
        if (okHttpClient == null)
        {
            mOkHttpClient = new OkHttpClient();
        } else
        {
            mOkHttpClient = okHttpClient;
        }

        mPlatform = Platform.get();
    }

    public Platform getmPlatform(){
        return mPlatform;
    }
    public OkHttpClient getOkHttpClient()
    {
        return mOkHttpClient;
    }

    public static HttpUtils initClient(OkHttpClient okHttpClient)
    {
        if (mInstance == null)
        {
            synchronized (HttpUtils.class)
            {
                if (mInstance == null)
                {
                    mInstance = new HttpUtils(okHttpClient);
                }
            }
        }
        return mInstance;
    }

    public static HttpUtils getInstance()
    {
        return initClient(null);
    }

}
