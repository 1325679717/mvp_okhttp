package com.example.myt.easy_frame.callback;

import com.example.myt.easy_frame.network.HttpUtils;
import com.example.myt.easy_frame.parser.OkBaseParser;
import com.example.myt.easy_frame.utils.Platform;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by myt on 2017/6/13.
 */
public abstract class CallBackImpl<T> implements Callback {

    final Platform platform = HttpUtils.getInstance().getmPlatform();
    private OkBaseParser<T> mParser;
    public CallBackImpl(OkBaseParser<T> mParser){
        this.mParser = mParser;
    }
    @Override
    public void onFailure(Call call, final IOException e) {
        platform.execute(new Runnable() {
            @Override
            public void run() {

                onFailure(e);
            }
        });
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        final int code = mParser.getCode();
        final T t = mParser.parseResponse(response);
        platform.execute(new Runnable() {
            @Override
            public void run() {
                onSuccess(code,t);
            }
        });
    }

    public abstract void onSuccess(int code, T t);

    public abstract void onFailure(Throwable e);
}
