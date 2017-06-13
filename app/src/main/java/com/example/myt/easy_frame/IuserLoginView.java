package com.example.myt.easy_frame;

import com.example.myt.easy_frame.bean.User;

/**
 * Created by myt on 2017/4/24.
 */
public interface IuserLoginView {
    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();
}
