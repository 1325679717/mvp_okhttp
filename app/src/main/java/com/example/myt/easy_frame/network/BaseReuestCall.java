package com.example.myt.easy_frame.network;

import android.net.Uri;

import com.example.myt.easy_frame.bean.User;
import com.example.myt.easy_frame.callback.CallBackImpl;
import com.example.myt.easy_frame.listener.MyReceiveDataListener;
import com.example.myt.easy_frame.listener.StringCallback;
import com.example.myt.easy_frame.parser.JsonParser;
import com.example.myt.easy_frame.utils.LogUtil;
import com.example.myt.easy_frame.utils.Platform;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by myt on 2017/4/20.
 */
public class BaseReuestCall {

    public static Map<String,String> map = null;

    public static Map<String, String> getMap() {
        if (map == null){
            synchronized (BaseReuestCall.class) {
                if (map == null) {
                    map = new HashMap<String, String>();
                }
            }
        }
        if (map.size() > 0)
            map.clear();
        return map;
    }

    public void post(GetParamsUtill paramsUtill, final StringCallback callback){
        Map<String,String> map = getMap();
        Request.Builder builder = paramsUtill.getParams(map);
        FormBody.Builder pBuilder = new FormBody.Builder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            pBuilder.add(entry.getKey(),entry.getValue());
        }

        builder.url(paramsUtill.getHttpUrl());
        builder.post(pBuilder.build());
        final HttpUtils httpUtils = HttpUtils.getInstance();
        final Platform platform = httpUtils.getmPlatform();
        httpUtils.getOkHttpClient().newCall(builder.build()).enqueue(new Callback() {
            @Override
            public void onFailure(final Call call, final IOException e) {
                platform.execute(new Runnable() {
                    @Override
                    public void run() {
//                        callback.onFailure(call,e);
                    }
                });
            }

            @Override
            public void onResponse(final Call call, final Response response) throws IOException {
                final String data = response.body().string();
                platform.execute(new Runnable() {
                    @Override
                    public void run() {
//                        callback.onResponse(call,data);
                    }
                });
            }
        });
    }


    public <T> void get(GetParamsUtill paramsUtill,final StringCallback<T> callback){

        Map<String,String> map = getMap();
        Request.Builder builder = paramsUtill.getParams(map);
        final HttpUtils httpUtils = HttpUtils.getInstance();
        builder.url(appendParams(paramsUtill.getHttpUrl(),map));
        httpUtils.getOkHttpClient().newCall(builder.build()).enqueue(new CallBackImpl<T>(new JsonParser<T>(){}) {
            @Override
            public void onSuccess(int code, T t) {
                callback.onResponse(code,t);
            }

            @Override
            public void onFailure(Throwable e) {
                callback.onFailure(e);
            }
        });
    }
    protected String appendParams(String url, Map<String, String> params)
    {
        if (url == null || params == null || params.isEmpty())
        {
            return url;
        }
        Uri.Builder builder = Uri.parse(url).buildUpon();
        Set<String> keys = params.keySet();
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext())
        {
            String key = iterator.next();
            builder.appendQueryParameter(key, params.get(key));
        }
        return builder.build().toString();
    }
}
