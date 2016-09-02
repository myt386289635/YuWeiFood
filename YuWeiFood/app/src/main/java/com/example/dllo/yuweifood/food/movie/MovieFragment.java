package com.example.dllo.yuweifood.food.movie;

import android.view.View;
import android.widget.ListView;

import com.example.dllo.yuweifood.OKHttp.NetTool;
import com.example.dllo.yuweifood.OKHttp.Values;
import com.example.dllo.yuweifood.OKHttp.onHttpCallBack;
import com.example.dllo.yuweifood.R;
import com.example.dllo.yuweifood.base.BaseFragment;

/**
 * Created by dllo on 16/8/31.
 */
public class MovieFragment extends BaseFragment {
    private static final String TAG = "MovieFragment --> ***********";

    private ListView mListView;
    private MovieAdapter mAdapter;


    @Override
    protected int initLayout() {
        return R.layout.food_fragment_move_fragment;
    }

    @Override
    protected void initView(View view) {

        mListView = (ListView) view.findViewById(R.id.move_fragment_listview);
    }

    @Override
    protected void initData() {

        mAdapter = new MovieAdapter();
        mAdapter.setContext(context);

        NetTool.getInstance().startRequest(Values.FoodFragment_MoveFragment_str, MovieBean.class, new onHttpCallBack<MovieBean>() {
            @Override
            public void onSuccess(MovieBean response) {
                mAdapter.setBean(response);
                mListView.setAdapter(mAdapter);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }
}
