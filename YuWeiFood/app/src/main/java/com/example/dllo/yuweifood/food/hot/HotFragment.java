package com.example.dllo.yuweifood.food.hot;

import android.view.View;

import com.example.dllo.yuweifood.OKHttp.NetTool;
import com.example.dllo.yuweifood.OKHttp.Values;
import com.example.dllo.yuweifood.OKHttp.onHttpCallBack;
import com.example.dllo.yuweifood.R;
import com.example.dllo.yuweifood.base.BaseFragment;
import com.wirelesspienetwork.overview.misc.Utilities;
import com.wirelesspienetwork.overview.views.Overview;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by dllo on 16/8/31.
 */
public class HotFragment extends BaseFragment {
    private static final String TAG = "HotFragment --> ***********";

    private boolean mVisible;
    private Overview mRecentsView;
    private HotAdapter mAdapter;
//    private String[] image_head;//防止头像错位

    @Override
    protected int initLayout() {
        return R.layout.food_fragment_hot_fragment;
    }

    @Override
    protected void initView(View view) {
        mRecentsView = (Overview) view.findViewById(R.id.hot_fragment_overview);
    }

    @Override
    protected void initData() {

        mVisible = true;

        final ArrayList<Integer> models = new ArrayList<>();


        NetTool.getInstance().startRequest(Values.FoodFragment_str, HotBean.class, new onHttpCallBack<HotBean>() {
            @Override
            public void onSuccess(HotBean response) {

//                image_head = new String[response.getData().getList().size()];
                for (int i = 0; i < response.getData().getList().size(); ++i) {
                    Random random = new Random();
                    random.setSeed(i);
                    models.add(0xffffffff);
//                    image_head[i]= response.getData().getList().get(i).getAuthor().getHeader();
                }
                mAdapter = new HotAdapter(context, models);
                mAdapter.setBean(response);
//                mAdapter.setImage_head(image_head);
                mRecentsView.setTaskStack(mAdapter);
            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }

}
