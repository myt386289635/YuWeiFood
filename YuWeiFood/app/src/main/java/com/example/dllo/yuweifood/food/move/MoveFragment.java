package com.example.dllo.yuweifood.food.move;

import android.view.View;

import com.example.dllo.yuweifood.OKHttp.PostResponse;
import com.example.dllo.yuweifood.R;
import com.example.dllo.yuweifood.base.BaseFragment;

/**
 * Created by dllo on 16/8/31.
 */
public class MoveFragment extends BaseFragment {
    private static final String TAG = "MoveFragment --> ***********";

    private String str = "http://www.xinniangshuo.com/api/v2.4.2/release/get/home/video_list.php";
    @Override
    protected int initLayout() {
        return R.layout.food_fragment_move_fragment;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {

        new Thread(new Runnable() {
            @Override
            public void run() {

                PostResponse.sendPost(str,"status=-1&error_message=missing input!");
            }
        }).start();

    }
}
