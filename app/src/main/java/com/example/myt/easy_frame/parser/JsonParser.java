package com.example.myt.easy_frame.parser;

import android.os.Build;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.lang.reflect.Modifier;

import okhttp3.Response;

/**
 * Created by myt on 2017/6/13.
 */
public abstract class JsonParser<T> extends OkBaseJsonParser<T> {
    protected Gson mGson;

    public JsonParser(){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            GsonBuilder gsonBuilder = new GsonBuilder()
                    .excludeFieldsWithModifiers(
                            Modifier.FINAL,
                            Modifier.TRANSIENT,
                            Modifier.STATIC);
            mGson = gsonBuilder.create();
        } else {
            mGson = new Gson();
        }
    }
    @Override
    protected T parse(Response response) throws IOException {
        String body = response.body().string();
        return mGson.fromJson(body, mType);
    }
}
