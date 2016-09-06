package com.example.dllo.yuweifood.food.movie;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;

import com.example.dllo.yuweifood.OKHttp.NetTool;
import com.example.dllo.yuweifood.tool.Values;
import com.example.dllo.yuweifood.OKHttp.onHttpCallBack;
import com.example.dllo.yuweifood.R;
import com.example.dllo.yuweifood.base.BaseFragment;
import com.example.dllo.yuweifood.eventbusbean.Bean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by dllo on 16/8/31.
 */
public class MovieFragment extends BaseFragment implements OnScrollListener {
    private static final String TAG = "MovieFragment --> ***********";

    private ListView mListView;
    private MovieAdapter mAdapter;
    private SharedPreferences mSharedPreferences;
    private Editor mEditor;

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
        EventBus.getDefault().register(this);
        mAdapter = new MovieAdapter();
        mAdapter.setContext(context);
        mSharedPreferences = context.getSharedPreferences("videoview", Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();

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

        View view = LayoutInflater.from(context).inflate(R.layout.food_fragment_movie_fragment_foot_item,null);
        mListView.addFooterView(view);
        //滚动监听,当listview滚动时候停止播放视频
        mListView.setOnScrollListener(this);
    }


    @Subscribe
    public void getShow(Bean bean){

        if(bean.getShowing() != null){
            if(bean.getShowing()){
                mAdapter.setShowing(true);
            }else {
                mAdapter.setShowing(false);
            }
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }


    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        switch(scrollState){
            case OnScrollListener.SCROLL_STATE_IDLE://空闲状态
                // TODO: 16/9/3
                break;
            case OnScrollListener.SCROLL_STATE_FLING://滚动状态
                //// TODO: 16/9/3
                break;
            case OnScrollListener.SCROLL_STATE_TOUCH_SCROLL://触摸后滚动
                mAdapter.setShowing(null);
                break;
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }

}
