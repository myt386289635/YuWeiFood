package com.example.dllo.yuweifood.local.map.sec.listfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.TextView;

import com.example.dllo.yuweifood.local.map.sec.mapfragment.SecMapBean;
import com.example.dllo.yuweifood.local.map.sec.mapfragment.ViewPagerBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/6.
 */
public class ListAdapter extends FragmentPagerAdapter{
    private static final String TAG = "ListAdapter --> ***********";

   private String[] title = {"全部","当地菜","东北菜","海鲜","日本料理","特色小吃","西餐","自助餐","酒吧","甜品店","烧烤","湘菜","杭帮菜","商务品味","一人食","饮食男女","亲子美食","组团嗨吃"};
    private SecMapBean mBean;
    private  ArrayList<ViewPagerBean> mlist;
    private String tag;

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setBean(SecMapBean bean) {
        mBean = bean;
    }

    public String[] getTitle() {
        return title;
    }

    public ListAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {

        mlist  = new ArrayList<>();
        for (int i = 0; i < mBean.getData().getList().get(position).getRestlist().getList().size(); i++) {

            mlist.add(new ViewPagerBean(mBean.getData().getList().get(position).getRestlist().getList().get(i).getCover(),mBean.getData().getList().get(position).getRestlist().getList().get(i).getName(),mBean.getData().getList().get(position).getRestlist().getList().get(i).getCost(),mBean.getData().getList().get(position).getRestlist().getList().get(i).getSummary()));
        }
        return ContentFragment.newInstance(mlist);
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
