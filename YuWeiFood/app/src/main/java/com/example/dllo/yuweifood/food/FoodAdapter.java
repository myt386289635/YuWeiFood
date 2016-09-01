package com.example.dllo.yuweifood.food;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by dllo on 16/8/31.
 */
public class FoodAdapter extends FragmentPagerAdapter {
    private static final String TAG = "FoodAdapter --> ***********";

    private ArrayList<Fragment> mFragments;
    private String[] titles = {"热门","关注","视频"};

    public void setFragments(ArrayList<Fragment> fragments) {
        mFragments = fragments;
    }

    public FoodAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
