package com.example.myt.easy_frame.network;

import android.app.Activity;
import android.widget.Toast;

import com.example.myt.easy_frame.listener.MyReceiveDataListener;
import com.example.myt.easy_frame.listener.StringCallback;
import com.example.myt.easy_frame.utils.LogUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.internal.Platform;

/**
 * Created by myt on 2017/4/20.
 */
public class RequestCall extends BaseReuestCall{

    private final int ACTION = 10001;

    /*public void requestJson(GetParamsUtill paramsUtill, final MyReceiveDataListener listener){
        get(paramsUtill, new StringCallback() {
            @Override
            public void onFailure(Call call, IOException e) {

                 listener.onFile(ACTION,e.toString());
            }

            @Override
            public void onResponse(Call call,Object o) {

                 listener.onReceive(ACTION,"0","0",o);


            }
        });
    }*/
}
