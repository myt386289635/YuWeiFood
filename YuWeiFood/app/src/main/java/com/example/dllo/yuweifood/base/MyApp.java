package com.example.dllo.yuweifood.base;

import android.app.Application;
import android.content.Context;

import com.baidu.mapapi.SDKInitializer;

/**
 * Created by dllo on 16/9/6.
 */
public class MyApp extends Application{
    private static final String TAG = "MyApp --> ***********";

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
//        System.loadLibrary("test");
        SDKInitializer.initialize(getApplicationContext());
        mContext = this;

    }

    public static Context getContext(){
        return mContext;
    }
}
