package com.lcns.lemotree.newtest.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.lcns.lemotree.newtest.R;


public class LoginActivity extends Activity {
    private Button mLoginButton;
    private EditText mUsernameEditText, mPasswordEditText;// 账号，密码，验证码

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.login:
                    jump2Main();
                    break;
            }
        }
    };
    /**
     * 初始化View
     */
    private void initView() {
        mUsernameEditText = (EditText) findViewById(R.id.username);
        mPasswordEditText = (EditText) findViewById(R.id.password);
        mLoginButton = (Button) findViewById(R.id.login);
        mLoginButton.setOnClickListener(listener);
    }
    /**
     * 跳转到主页
     */
    private void jump2Main() {

        Intent intent=new Intent(LoginActivity.this,CourseActivity.class);
        startActivity(intent);
        finish();
    }
}
