package com.example.myt.easy_frame.parser;

import android.util.Log;

import com.google.gson.internal.$Gson$Types;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Response;

/**
 * Created by myt on 2017/6/13.
 */
public abstract class OkBaseJsonParser<T> extends OkBaseParser<T>{

    public Type mType;

    public OkBaseJsonParser() {
        mType = getSuperclassTypeParameter(getClass());
    }

    protected abstract T parse(Response response) throws IOException;

    private static Type getSuperclassTypeParameter(Class<?> subclass) {
        Type superclass = subclass.getGenericSuperclass();
        Log.i("OkBaseJsonParser","subclass = " + superclass);
        if (superclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        ParameterizedType parameter = (ParameterizedType) superclass;
        return $Gson$Types.canonicalize(parameter.getActualTypeArguments()[0]);
    }
}
