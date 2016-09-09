package com.example.dllo.yuweifood.food;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.dllo.yuweifood.R;
import com.example.dllo.yuweifood.base.BaseFragment;
import com.example.dllo.yuweifood.food.Game.GameFragment;
import com.example.dllo.yuweifood.food.attention.AttentFragment;
import com.example.dllo.yuweifood.food.hot.HotFragment;
import com.example.dllo.yuweifood.food.movie.MovieFragment;

import java.util.ArrayList;

/**
 * Created by dllo on 16/8/31.
 */
public class FoodFragment extends BaseFragment {
    private static final String TAG = "FoodFragment --> ***********";

    private SlidingTabLayout tabLayout;
    private ViewPager mViewPager;
    private FoodAdapter mAdapter;
    private ArrayList<Fragment> mFragments;

    @Override
    protected int initLayout() {
        return R.layout.food_fragment;
    }

    @Override
    protected void initView(View view) {

        mViewPager = (ViewPager) view.findViewById(R.id.foot_fragment_viewPager);
        tabLayout = (SlidingTabLayout) view.findViewById(R.id.food_fragment_tabLayout);

    }

    @Override
    protected void initData() {

        mAdapter = new FoodAdapter(getChildFragmentManager());
        mFragments = new ArrayList<>();

        mFragments.add(new HotFragment());
        mFragments.add(new AttentFragment());
        mFragments.add(new MovieFragment());
        mFragments.add(new GameFragment());

        mAdapter.setFragments(mFragments);
        mViewPager.setAdapter(mAdapter);
        tabLayout.setViewPager(mViewPager);
        tabLayout.setDividerColors(0xffc1c1c1);
        tabLayout.setSelectedIndicatorColors(0xff000000);

    }
}
