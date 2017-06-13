package com.example.myt.easy_frame.biz;

import com.example.myt.easy_frame.bean.User;
import com.example.myt.easy_frame.constants.Contants;
import com.example.myt.easy_frame.listener.MyReceiveDataListener;
import com.example.myt.easy_frame.network.GetParamsUtill;
import com.example.myt.easy_frame.network.RequestCall;

/**
 * Created by myt on 2017/4/24.
 */
public class UserBiz implements IUserBiz {
    @Override
    public void login(String username, String password, final OnLoginListener onLoginListener) {
        RequestCall requestCall = new RequestCall();
        GetParamsUtill getParamsUtill = new GetParamsUtill(Contants.strUrl);
        getParamsUtill.add("name","wang");
        getParamsUtill.add("password","000000");
//        getParamsUtill.add("page","1");
        requestCall.requestJson(getParamsUtill, new MyReceiveDataListener() {
            @Override
            public void onReceive(int action, String code, String msg, Object data) {
                String num = data+"";
                if ( "4".equals(num)) {
                    User user = new User();
                    user.setName("wang");
                    user.setPassword("password");
                    onLoginListener.loginSuccess(user);
                }else {
                    onLoginListener.loginFailed();
                }
            }

            @Override
            public void onFile(int action, Object data) {

            }
        });
    }
}
