package com.example.dllo.yuweifood.recommend;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dllo.yuweifood.OKHttp.NetTool;
import com.example.dllo.yuweifood.OKHttp.onHttpCallBack;
import com.example.dllo.yuweifood.R;
import com.example.dllo.yuweifood.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/8/31.
 */
public class RecommendFragment extends BaseFragment {

    private static final String KEY_POSITION = "position";
    private static final String TAG = "http://www.youyuwei.com/api/recommend?oauth_version=1.0&oauth_nonce=1ee184cd-f076-4739-af9d-6a7c3d2d4613&oauth_consumer_key=5&device_type=android&screen_width=1080&device_id=08%3A00%3A27%3A4c%3A0a%3A58&ver=6&ywsdk_ver=20140507&sys_ver=4.4.4&ver_code=33&channel_id=yingyongbao&oauth_signature=9OqlcBsGBHTp9im2szsCW1jlbE0%3D&x_auth_mode=client_auth&device_token=AqSjKQzxiUql-xNhXUhJnYxgyz28bd1b-CmwKtweSkqb&oauth_signature_method=HMAC-SHA1&oauth_token=0_9837387abc33331ab&open_udid=08%3A00%3A27%3A4c%3A0a%3A58&app_ver=3.1&app_code=com.yuwei.android&oauth_timestamp=1472814332&screen_height=1776";

    private ListView listView;
    private RecommendAdapter recommendAdapter;
    private ViewPagerHeadAdapter viewPagerHeadAdapter;
    private HotCityViewPagerAdapter hotCityViewPagerAdapter;


    private ViewPager viewPager,viewPager2;
    private View view1,view_pager,view_pager2;

    private boolean lock = true;
    private boolean flag = true;
    private Handler handler;
    

//    private HotCityAdapter mAdapter;
    
    @Override
    protected int initLayout() {
        return R.layout.recommend_fragment;
    }

    @Override
    protected void initView(View view) {
        listView = (ListView) view.findViewById(R.id.list_recommend);
         view1 = LayoutInflater.from(context).inflate(R.layout.item_recom_onehead_text,null);
        view_pager = LayoutInflater.from(context).inflate(R.layout.item_recom_viewpager,null);
        view_pager2 = LayoutInflater.from(context).inflate(R.layout.item_recom_viewpager_two,null);

        viewPager2 = (ViewPager) view_pager2.findViewById(R.id.item_recom_view_pager_two);
        viewPager = (ViewPager) view_pager.findViewById(R.id.item_recom_view_pager);

        //头布局
        listView.addHeaderView(view_pager);
        listView.addHeaderView(view_pager2);
        listView.addHeaderView(view1);



    }

    @Override
    protected void initData() {

        viewPagerHeadAdapter = new ViewPagerHeadAdapter(context);
        hotCityViewPagerAdapter = new HotCityViewPagerAdapter(getChildFragmentManager());
        recommendAdapter = new RecommendAdapter(context);



        NetTool.getInstance().startRequest(TAG, RecommendBean.class, new onHttpCallBack<RecommendBean>() {
            @Override
            public void onSuccess(RecommendBean response) {
                //第一个viewpager

                Log.d("ViewPagerHeadAdapter", ""+response.getData().getList().get(0).getContent().size());
                viewPagerHeadAdapter.setRecommendBean(response);
                viewPager.setAdapter(viewPagerHeadAdapter);
                LunBo();


                //第二个viewpager
                hotCityViewPagerAdapter.setRecommendBean(response);
                viewPager2.setAdapter(hotCityViewPagerAdapter);

                //第三个部分
                recommendAdapter.setRecommendBean(response);
                listView.setAdapter(recommendAdapter);



            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }

    //轮播线程
    private void LunBo() {
        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {

                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                return false;
            }
        });
        if (lock) {
            new Thread(new Runnable() {
                @Override
                public void run() {

                    while (flag) {

                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        handler.sendEmptyMessage(0);

                    }
                }
            }).start();
        }
        lock = false;
    }
}
