package com.example.dllo.yuweifood.food.hot;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import android.view.ViewGroup;

import com.example.dllo.yuweifood.R;
import com.example.dllo.yuweifood.base.BaseFragment;
import com.wirelesspienetwork.overview.misc.Utilities;
import com.wirelesspienetwork.overview.model.OverviewAdapter;
import com.wirelesspienetwork.overview.model.ViewHolder;
import com.wirelesspienetwork.overview.views.Overview;
import com.wirelesspienetwork.overview.views.Overview.RecentsViewCallbacks;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by dllo on 16/8/31.
 */
public class HotFragment extends BaseFragment {
    private static final String TAG = "HotFragment --> ***********";

    private boolean mVisible;
    private Overview mRecentsView;
    private HotAdapter mAdapter;

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
        mRecentsView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);


        try {
            //设置阴影效果
            Utilities.setShadowProperty("ambientRatio", String.valueOf(1.5f));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        mVisible = true;

        ArrayList<Integer> models = new ArrayList<>();
        for(int i = 0; i < 10; ++i)
        {
            Random random = new Random();
            random.setSeed(i);
            models.add(0xffffffff);
        }
        mAdapter = new HotAdapter(context,models);
        mRecentsView.setTaskStack(mAdapter);

    }

}
