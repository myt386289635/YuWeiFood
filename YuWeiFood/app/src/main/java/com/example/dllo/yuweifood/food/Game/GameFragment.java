package com.example.dllo.yuweifood.food.Game;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.dllo.yuweifood.R;
import com.example.dllo.yuweifood.base.BaseFragment;

/**
 * Created by dllo on 16/9/8.
 */
public class GameFragment extends BaseFragment {
    private static final String TAG = "GameFragment --> ***********";

    private RecyclerView mRecyclerView;
    private GameAdapter mAdapter;


    @Override
    protected int initLayout() {
        return R.layout.game_fragment;
    }

    @Override
    protected void initView(View view) {

        mRecyclerView = (RecyclerView) view.findViewById(R.id.game_fragment_layout);

    }

    @Override
    protected void initData() {

        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),4,1,true));
        mAdapter = new GameAdapter(context);

        mRecyclerView.setAdapter(mAdapter);

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                mHandler.sendEmptyMessage(0);
//            }
//        }).start();
    }

//    Handler mHandler = new Handler(new Callback() {
//        @Override
//        public boolean handleMessage(Message msg) {
//
//
//            return false;
//        }
//    });

}
