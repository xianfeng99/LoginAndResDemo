package com.jikexueyuan.loginandres;

import android.app.Application;

/**
 * Created by lixianfeng on 16/3/16.
 */
public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        NetManager.getInstance().init(this);
    }
}
