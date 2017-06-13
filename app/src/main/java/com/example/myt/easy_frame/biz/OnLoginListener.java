package com.example.myt.easy_frame.biz;

import com.example.myt.easy_frame.bean.User;

/**Invalid
 * Created by myt on 2017/4/24.
 */
public interface OnLoginListener {
    void loginSuccess(User user);

    void loginFailed();
}
