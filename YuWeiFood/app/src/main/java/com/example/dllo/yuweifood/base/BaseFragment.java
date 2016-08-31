package com.example.dllo.yuweifood.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by dllo on 16/8/31.
 */
public abstract class BaseFragment extends Fragment {
    private static final String TAG = "BaseFragment --> ***********";

        protected Context context;
        @Override
        public void onAttach(Context context) {
            super.onAttach(context);
            this.context = context;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(initLayout(),container,false);
        }

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            initView(view);
        }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            initData();
        }
        //获取布局
        protected abstract int initLayout();
        //绑定组件
        protected abstract void initView(View view);
        //初始化数据
        protected abstract void initData();



}
