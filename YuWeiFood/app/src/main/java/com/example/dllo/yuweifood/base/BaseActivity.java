package com.example.dllo.yuweifood.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by dllo on 16/8/31.
 */
public abstract class BaseActivity extends AppCompatActivity{
    private static final String TAG = "BaseActivity --> ***********";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());

        initView();
        initDate();
    }

    protected abstract int setLayout();

    protected abstract void initView();


    protected abstract void initDate();


}
