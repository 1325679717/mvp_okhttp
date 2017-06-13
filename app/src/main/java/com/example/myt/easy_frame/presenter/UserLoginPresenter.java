package com.example.myt.easy_frame.presenter;

import com.example.myt.easy_frame.IuserLoginView;
import com.example.myt.easy_frame.base.BasePresenter;
import com.example.myt.easy_frame.bean.User;
import com.example.myt.easy_frame.constants.Contants;
import com.example.myt.easy_frame.listener.MyReceiveDataListener;
import com.example.myt.easy_frame.network.GetParamsUtill;
import com.example.myt.easy_frame.network.RequestCall;

/**
 * Created by myt on 2017/4/24.
 */
public class UserLoginPresenter extends BasePresenter<IuserLoginView> {
//    private IUserBiz iUserBiz;

    RequestCall requestCall = new RequestCall();

    public UserLoginPresenter() {
        this.requestCall = new RequestCall();
    }
    public void login(){
        if (isViewAttached()) {
            getView().showLoading();
        }

        GetParamsUtill getParamsUtill = new GetParamsUtill(Contants.strUrl);
        getParamsUtill.add("name","wang");
        getParamsUtill.add("password","000000");
        requestCall.requestJson(getParamsUtill, new MyReceiveDataListener() {
            @Override
            public void onReceive(int action, String code, String msg, Object data) {

                User user = new User();
                user.setName("wang");
                user.setPassword("password");
                if (isViewAttached()) {
                    getView().showLoading();
                    getView().toMainActivity(user);
                    getView().hideLoading();
                }
            }

            @Override
            public void onFile(int action, Object data) {

                if (isViewAttached()) {
                    getView().showFailedError();
                    getView().hideLoading();
                }

            }
        });
        /*iUserBiz.login(iuserLoginView.getUserName(), iuserLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(User user) {
                iuserLoginView.toMainActivity(user);
                iuserLoginView.hideLoading();

            }

            @Override
            public void loginFailed() {
                iuserLoginView.showFailedError();
                iuserLoginView.hideLoading();

            }
        });*/
    }
    public void clear(){

        if (isViewAttached()) {
            getView().clearUserName();
            getView().clearPassword();
        }
    }
}
