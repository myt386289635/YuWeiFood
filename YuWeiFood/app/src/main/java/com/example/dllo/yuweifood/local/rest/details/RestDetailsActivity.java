package com.example.dllo.yuweifood.local.rest.details;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.yuweifood.OKHttp.NetTool;
import com.example.dllo.yuweifood.OKHttp.onHttpCallBack;
import com.example.dllo.yuweifood.R;
import com.example.dllo.yuweifood.base.BaseActivity;

/**
 * Created by dllo on 16/9/8.
 */
public class RestDetailsActivity extends BaseActivity implements OnClickListener {
    private static final String TAG = "RestDetailsActivity --> ***********";

    private TextView mTextView;
    private ImageView backImg;

    private RecyclerView mRecyclerView;
    private RestDetailsAdapter mAdapter;


    @Override
    protected int setLayout() {
        overridePendingTransition(R.anim.activity_enter, R.anim.activity_exit);
        return R.layout.activity_rest_details;
    }

    @Override
    protected void initView() {

        mTextView = (TextView) findViewById(R.id.activity_rest_details_title);
        backImg = (ImageView) findViewById(R.id.activity_rest_details_back);
        mRecyclerView = (RecyclerView) findViewById(R.id.activity_rest_details_recyclerview);
    }

    @Override
    protected void initDate() {

        String str = getIntent().getStringExtra("str");
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new RestDetailsAdapter(this);

        NetTool.getInstance().startRequest(str, RestDetailsBean.class, new onHttpCallBack<RestDetailsBean>() {
            @Override
            public void onSuccess(RestDetailsBean response) {
                mTextView.setText(response.getData().getRestinfo().getName());

                mAdapter.setBean(response);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onError(Throwable e) {

            }
        });

        backImg.setOnClickListener(this);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.activity_into, R.anim.activity_out);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_rest_details_back:
                finish();
                break;
        }
    }
}
