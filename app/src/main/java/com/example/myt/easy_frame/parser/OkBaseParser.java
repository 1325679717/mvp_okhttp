package com.example.myt.easy_frame.parser;

import java.io.IOException;

import okhttp3.Response;

/**
 * Created by myt on 2017/6/13.
 */
public abstract class OkBaseParser<T> {

    protected int code;

    protected abstract T parse(Response response) throws IOException;

    public T parseResponse(Response response) throws IOException {
        code = response.code();
        return parse(response);
    }

    public int getCode() {
        return code;
    }
}
