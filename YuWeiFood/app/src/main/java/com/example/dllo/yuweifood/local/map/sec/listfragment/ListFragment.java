package com.example.dllo.yuweifood.local.map.sec.listfragment;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.example.dllo.yuweifood.OKHttp.NetTool;
import com.example.dllo.yuweifood.OKHttp.onHttpCallBack;
import com.example.dllo.yuweifood.R;
import com.example.dllo.yuweifood.base.BaseFragment;
import com.example.dllo.yuweifood.eventbusbean.Bean;
import com.example.dllo.yuweifood.local.map.sec.mapfragment.SecMapBean;
import com.example.dllo.yuweifood.tool.Values;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by dllo on 16/9/6.
 */
public class ListFragment extends BaseFragment {
    private static final String TAG = "ListFragment --> ***********";

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ListAdapter mAdapter;

    @Override
    protected int initLayout() {
        return R.layout.list_fragment;
    }

    @Override
    protected void initView(View view) {

        mTabLayout = (TabLayout) view.findViewById(R.id.activity_list_fragment_tablayout);
        mViewPager = (ViewPager) view.findViewById(R.id.activity_list_fragment_viewpager);
    }

    @Override
    protected void initData() {

        mAdapter = new ListAdapter(getChildFragmentManager());

        NetTool.getInstance().startRequest(Values.Sec_MapActivity_url, SecMapBean.class, new onHttpCallBack<SecMapBean>() {
            @Override
            public void onSuccess(SecMapBean response) {

                mAdapter.setBean(response);
                mViewPager.setAdapter(mAdapter);
                mTabLayout.setupWithViewPager(mViewPager);
                mTabLayout.setTabTextColors(0xffc1c1c1,0xffffa12c);
                mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
                mTabLayout.setSelectedTabIndicatorColor(Color.TRANSPARENT);

                if(getArguments() != null){
//                    Log.d("--", ",,,");
                    for (int i = 0; i < mAdapter.getTitle().length; i++) {
//                        Log.d("00", ",,,");
                        if(mAdapter.getTitle()[i].equals(getArguments().getString("tag"))){
//                            Log.d("11", ",,,");
                            mViewPager.setCurrentItem(i);
                            return;
                        }
                    }
                }
            }

            @Override
            public void onError(Throwable e) {

            }
        });



    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}
