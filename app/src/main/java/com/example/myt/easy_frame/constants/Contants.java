package com.example.myt.easy_frame.constants;

import android.util.Log;

/**
 * Created by myt on 2017/4/20.
 */
public class Contants {
    public static final String BASE_URL = "https://www.zhuangbi.info/search";


    public static String strUrl = BASE_URL;

    private static final boolean LOG_TAG = true;
    public static void log_i(String className, String tag, String text) {
        if (LOG_TAG) {
            Log.i(className, tag + "----->>" + text);
        }
    }
}
