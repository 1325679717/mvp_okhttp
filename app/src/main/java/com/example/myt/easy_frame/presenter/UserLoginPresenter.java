package com.example.myt.easy_frame.presenter;

import android.util.Log;

import com.example.myt.easy_frame.IuserLoginView;
import com.example.myt.easy_frame.base.BasePresenter;
import com.example.myt.easy_frame.bean.Channel;
import com.example.myt.easy_frame.bean.User;
import com.example.myt.easy_frame.constants.Contants;
import com.example.myt.easy_frame.listener.MyReceiveDataListener;
import com.example.myt.easy_frame.listener.StringCallback;
import com.example.myt.easy_frame.network.BaseReuestCall;
import com.example.myt.easy_frame.network.GetParamsUtill;
import com.example.myt.easy_frame.network.RequestCall;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;

/**
 * Created by myt on 2017/4/24.
 */
public class UserLoginPresenter extends BasePresenter<IuserLoginView> {
//    private IUserBiz iUserBiz;

    BaseReuestCall requestCall = new BaseReuestCall();

    public UserLoginPresenter() {
        this.requestCall = new RequestCall();
    }
    public void login(){
        if (isViewAttached()) {
            getView().showLoading();
        }

        GetParamsUtill getParamsUtill = new GetParamsUtill(Contants.strUrl);
        getParamsUtill.add("q","可爱");
        requestCall.get(getParamsUtill, new StringCallback<List<Channel>>() {


            @Override
            public void onResponse(int code, List<Channel> data) {
                Log.i("UserLoginPresenter","data =" + data.size());

            }

            @Override
            public void onFailure(Throwable e) {

                if (isViewAttached()) {
                    getView().showFailedError();
                    getView().hideLoading();
                }
            }
        });
        /*, new MyReceiveDataListener() {
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
        });*/
    }
    public void clear(){

        if (isViewAttached()) {
            getView().clearUserName();
            getView().clearPassword();
        }
    }
}
