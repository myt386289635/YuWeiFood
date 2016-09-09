package com.example.dllo.yuweifood.local;

import android.graphics.Color;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnScrollChangeListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.dllo.yuweifood.OKHttp.NetTool;
import com.example.dllo.yuweifood.tool.Values;
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

    private RelativeLayout mLayout;
    private boolean loading = true;

    int pastVisiblesItems, visibleItemCount, totalItemCount;
    @Override
    protected int initLayout() {
        return R.layout.local_fragment;
    }

    @Override
    protected void initView(View view) {

        mRecyclerView = (RecyclerView) view.findViewById(R.id.local_fragment_recyclerView);
        mLayout = (RelativeLayout) view.findViewById(R.id.local_fragment_mlayout);
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

        //是否达到顶端.
       mRecyclerView.setOnScrollListener(new OnVerticalScrollListener() {
           @Override
           public void onScrolledDown() {
               mLayout.setBackgroundColor(0xaa000000);
           }

           @Override
           public void onScrolledToTop() {
               mLayout.setBackgroundColor(Color.TRANSPARENT);
           }
       });


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }


}
