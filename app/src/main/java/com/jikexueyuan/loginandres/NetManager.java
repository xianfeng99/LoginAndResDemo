package com.jikexueyuan.loginandres;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by lixianfeng on 16/3/16.
 */
public class NetManager {

    private RequestQueue mQueue;


    private static NetManager instance;

    private NetManager() {}

    public static NetManager getInstance(){
        if (instance == null){
            instance = new NetManager();
        }

        return instance;
    }

    public void init(Context context){

        mQueue = Volley.newRequestQueue(context);
        mQueue.start();
    }

    public void addRequest(Request request){
        mQueue.add(request);
    }
}
