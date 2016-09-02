package com.example.dllo.yuweifood.food.attention;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.dllo.yuweifood.OKHttp.NetTool;
import com.example.dllo.yuweifood.OKHttp.Values;
import com.example.dllo.yuweifood.OKHttp.onHttpCallBack;
import com.example.dllo.yuweifood.R;
import com.example.dllo.yuweifood.base.BaseFragment;

/**
 * Created by dllo on 16/8/31.
 */
public class AttentFragment extends BaseFragment implements OnClickListener {
    private static final String TAG = "AttentFragment --> ***********";

    private ImageView mImageView_x;
    private RelativeLayout mLayout;
    private ListView mListView;
    private AttentAdapter mAdapter;
    @Override
    protected int initLayout() {
        return R.layout.food_fragment_attent_fragment;
    }

    @Override
    protected void initView(View view) {

        mImageView_x = (ImageView) view.findViewById(R.id.attent_fragment_x);
        mLayout = (RelativeLayout) view.findViewById(R.id.attent_fragment_mLayout);
        mListView = (ListView) view.findViewById(R.id.attent_fragment_listview);

    }

    @Override
    protected void initData() {
        mImageView_x.setOnClickListener(this);
        mAdapter = new AttentAdapter(context);
        NetTool.getInstance().startRequest(Values.FoodFragment_attentFragment_str, AttentBean.class, new onHttpCallBack<AttentBean>() {
            @Override
            public void onSuccess(AttentBean response) {

                mAdapter.setBean(response);
                mListView.setAdapter(mAdapter);
            }

            @Override
            public void onError(Throwable e) {

            }
        });

        View view = LayoutInflater.from(context).inflate(R.layout.food_fragment_attent_fragment_foot_item,null);
        mListView.addFooterView(view);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.attent_fragment_x:

                mLayout.setVisibility(View.GONE);

                break;
        }

    }
}
