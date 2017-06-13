package com.example.myt.easy_frame.listener;

/**
 * Created by myt on 2017/4/20.
 */
public interface MyReceiveDataListener {
    void onReceive(int action,String code,String msg,Object data);

    void onFile(int action,Object data);
}
