package com.example.myt.easy_frame.utils;

import android.util.Log;

/**
 * Created by Administrator on 2015/7/15.
 */
public class LogUtil {
    private static boolean isPrint = true;

    public static void i(String tag, String content){
        if (isPrint){
            Log.i(tag,content);
        }
    }
}
