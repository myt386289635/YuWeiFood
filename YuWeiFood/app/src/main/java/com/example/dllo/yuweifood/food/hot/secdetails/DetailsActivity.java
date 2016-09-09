package com.example.dllo.yuweifood.food.hot.secdetails;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.dllo.yuweifood.OKHttp.NetTool;
import com.example.dllo.yuweifood.OKHttp.onHttpCallBack;
import com.example.dllo.yuweifood.R;
import com.example.dllo.yuweifood.base.BaseActivity;

/**
 * Created by dllo on 16/9/6.
 */
public class DetailsActivity extends BaseActivity {
    private static final String TAG = "DetailsActivity --> ***********";

    private RecyclerView mRecyclerView;
    private DetailsAdapter mAdapter;

    @Override
    protected int setLayout() {
        return R.layout.activity_details;
    }

    @Override
    protected void initView() {

        mRecyclerView = (RecyclerView) findViewById(R.id.activity_details_recyclerview);

    }

    @Override
    protected void initDate() {

        String str = getIntent().getStringExtra("url");

        mAdapter = new DetailsAdapter(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        NetTool.getInstance().startRequest(str, DetailsBean.class, new onHttpCallBack<DetailsBean>() {
            @Override
            public void onSuccess(DetailsBean response) {
                mAdapter.setBean(response);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }
}
