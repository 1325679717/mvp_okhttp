package com.example.myt.easy_frame.biz;

/**
 * Invalid
 * Created by myt on 2017/4/24.
 */
public interface IUserBiz {
    void login(String username,String password,OnLoginListener onLoginListener);
}
