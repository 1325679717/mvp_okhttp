package com.example.myt.easy_frame.listener;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by myt on 2017/4/21.
 */
public interface StringCallback<T> {
    void onResponse(Call call
            , Object o);

    void onFailure(Call call, IOException e);
}
