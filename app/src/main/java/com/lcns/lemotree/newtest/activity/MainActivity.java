package com.lcns.lemotree.newtest.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import com.lcns.lemotree.newtest.R;
/***
 * @Author:Lemotree
 * @Date:2016-06-20
 * @Desc:主页面
 */
public class MainActivity extends AppCompatActivity {
    //初始化类
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_course);
    }
}
