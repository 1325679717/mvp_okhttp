package com.example.myt.easy_frame;

import android.os.Bundle;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.myt.easy_frame.base.BaseMVPActivity;
import com.example.myt.easy_frame.bean.User;
import com.example.myt.easy_frame.presenter.UserLoginPresenter;

public class MainActivity extends BaseMVPActivity<IuserLoginView,UserLoginPresenter> implements IuserLoginView{

    private String Tag = "";
    private EditText etName,etPwd;
    private Button button;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = (EditText) findViewById(R.id.etName);
        etPwd = (EditText) findViewById(R.id.edPwd);
        button = (Button) findViewById(R.id.button);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.login();
            }
        });

    }

    @Override
    protected UserLoginPresenter createPresenter() {
        return new UserLoginPresenter();
    }


    @Override
    public String getUserName() {
        return etName.getText().toString();
    }

    @Override
    public String getPassword() {
        return etPwd.getText().toString();
    }

    @Override
    public void clearUserName() {
        etName.setText("");
    }

    @Override
    public void clearPassword() {
        etPwd.setText("");
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this,user.getName(),0).show();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this,"error",0).show();
    }
}
