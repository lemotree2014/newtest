package com.lcns.lemotree.newtest.util;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by Lemotree on 2016/6/20.
 */

public class CommonUtil {

    /**获得指定范围内的随机数
     * @param max
     * @return int
     */
    public static int getRandom(int max){
        return (int)(Math.random()*max);
    }

    /**
     * 返回一个对话框
     * @param context
     * @param tips
     * @return
     */
    public static ProgressDialog getProcessDialog(Context context, String tips){
        ProgressDialog dialog = new ProgressDialog(context);
        dialog.setMessage(tips);
        dialog.setCancelable(false);
        return dialog;
    }

}

