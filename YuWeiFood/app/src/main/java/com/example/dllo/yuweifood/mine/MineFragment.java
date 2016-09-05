package com.example.dllo.yuweifood.mine;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView.FindListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.dllo.yuweifood.R;
import com.example.dllo.yuweifood.base.BaseFragment;
import com.example.dllo.yuweifood.mine.collection.CollectionActivity;


/**
 * Created by dllo on 16/8/31.
 */
public class MineFragment extends BaseFragment implements OnClickListener {
    private ImageView imageView;
    private RelativeLayout relative_collection;



    @Override
    protected int initLayout() {
        return R.layout.mine_fragment;
    }

    @Override
    protected void initView(View view) {
        imageView = (ImageView) view.findViewById(R.id.item_me_imageview_sign);
        relative_collection = (RelativeLayout) view.findViewById(R.id.item_me_collection);
        imageView.setOnClickListener(this);
        relative_collection.setOnClickListener(this);

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.item_me_collection:
                Toast.makeText(context, "点击了介个", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(getContext(),CollectionActivity.class);
                startActivity(intent1);
                break;
            case R.id.item_me_imageview_sign:
                Intent intent = new Intent(getContext(),SignActivity.class);
                startActivity(intent);
                break;

        }
    }
}
