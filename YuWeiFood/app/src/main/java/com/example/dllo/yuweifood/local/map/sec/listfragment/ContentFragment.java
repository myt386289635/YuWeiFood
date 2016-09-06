package com.example.dllo.yuweifood.local.map.sec.listfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ListView;

import com.example.dllo.yuweifood.R;
import com.example.dllo.yuweifood.base.BaseFragment;
import com.example.dllo.yuweifood.local.map.sec.mapfragment.ViewPagerBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/6.
 */
public class ContentFragment  extends BaseFragment{
    private static final String TAG = "ContentFragment --> ***********";

    public static Fragment newInstance(ArrayList<ViewPagerBean> list){
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("key",list);
        ContentFragment fragment = new ContentFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    private ListView mListView;
    private ArrayList<ViewPagerBean> mList;
    private ContentAdapter mAdapter;

    @Override
    protected int initLayout() {
        return R.layout.content_fragment;
    }

    @Override
    protected void initView(View view) {

        mListView = (ListView) view.findViewById(R.id.content_fragment_listview);
    }

    @Override
    protected void initData() {

        mAdapter = new ContentAdapter(context);
        mList = getArguments().getParcelableArrayList("key");

        mAdapter.setList(mList);
        mListView.setAdapter(mAdapter);
    }
}
