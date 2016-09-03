package com.example.dllo.yuweifood.mine;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.example.dllo.yuweifood.R;
import com.example.dllo.yuweifood.base.BaseFragment;



/**
 * Created by dllo on 16/8/31.
 */
public class MineFragment extends BaseFragment  {
    private ImageView imageView;



    @Override
    protected int initLayout() {
        return R.layout.mine_fragment;
    }

    @Override
    protected void initView(View view) {
        imageView = (ImageView) view.findViewById(R.id.item_me_imageview_sign);
        imageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),SignActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {


    }


}
