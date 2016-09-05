package com.example.dllo.yuweifood.local;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.dllo.yuweifood.OKHttp.NetTool;
import com.example.dllo.yuweifood.OKHttp.Values;
import com.example.dllo.yuweifood.OKHttp.onHttpCallBack;
import com.example.dllo.yuweifood.R;
import com.example.dllo.yuweifood.base.BaseFragment;

/**
 * Created by dllo on 16/8/31.
 */
public class LocalFragment extends BaseFragment{
    private static final String TAG = "LocalFragment --> ***********";

    private RecyclerView mRecyclerView;
    private LocalAdaapter mAdaapter;

    @Override
    protected int initLayout() {
        return R.layout.local_fragment;
    }

    @Override
    protected void initView(View view) {

        mRecyclerView = (RecyclerView) view.findViewById(R.id.local_fragment_recyclerView);
    }

    @Override
    protected void initData() {

        mAdaapter = new LocalAdaapter(context);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        NetTool.getInstance().startRequest(Values.LocalFragment_All_url, LocalBean.class, new onHttpCallBack<LocalBean>() {
            @Override
            public void onSuccess(LocalBean response) {
                mAdaapter.setBean(response);
                mRecyclerView.setAdapter(mAdaapter);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }
}
