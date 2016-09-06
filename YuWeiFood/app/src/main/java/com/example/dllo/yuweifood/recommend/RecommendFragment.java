package com.example.dllo.yuweifood.recommend;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import com.example.dllo.yuweifood.OKHttp.NetTool;
import com.example.dllo.yuweifood.tool.Values;
import com.example.dllo.yuweifood.OKHttp.onHttpCallBack;
import com.example.dllo.yuweifood.R;
import com.example.dllo.yuweifood.base.BaseFragment;


/**
 * Created by dllo on 16/8/31.
 */
public class RecommendFragment extends BaseFragment {
    private ListView listView;
    private RecommendAdapter recommendAdapter;
    private ViewPagerHeadAdapter viewPagerHeadAdapter;
    private HotCityViewPagerAdapter hotCityViewPagerAdapter;


    private ViewPager viewPager,viewPager2;
    private View view1,view2,view3,view4;

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
        view2 = LayoutInflater.from(context).inflate(R.layout.item_recom_viewpager,null);
        view3 = LayoutInflater.from(context).inflate(R.layout.item_recom_viewpager_two,null);
        view4 = LayoutInflater.from(context).inflate(R.layout.item_recom_miqilin_head,null);

        viewPager2 = (ViewPager) view3.findViewById(R.id.item_recom_view_pager_two);
        viewPager = (ViewPager) view2.findViewById(R.id.item_recom_view_pager);

        //头布局
        listView.addHeaderView(view2);
        listView.addHeaderView(view3);
        listView.addHeaderView(view4);
        listView.addHeaderView(view1);



    }

    @Override
    protected void initData() {

        viewPagerHeadAdapter = new ViewPagerHeadAdapter(context);
        hotCityViewPagerAdapter = new HotCityViewPagerAdapter(getChildFragmentManager());
        recommendAdapter = new RecommendAdapter(context);



        NetTool.getInstance().startRequest(Values.RecommendFragment_All_Intent, RecommendBean.class, new onHttpCallBack<RecommendBean>() {
            @Override
            public void onSuccess(RecommendBean response) {
                //第一个viewpager
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
