package com.example.dllo.yuweifood.local;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.yuweifood.R;
import com.example.dllo.yuweifood.local.dish.DishAdapter;
import com.example.dllo.yuweifood.local.map.MapAdapter;
import com.example.dllo.yuweifood.local.strategy.StrategyAdapter;
import com.example.dllo.yuweifood.recommend.MyGridView;
import com.squareup.picasso.Picasso;

import java.util.Map;

/**
 * Created by dllo on 16/9/3.
 */
public class LocalAdaapter extends RecyclerView.Adapter {
    private static final String TAG = "LocalAdaapter --> ***********";

    private Context mContext;
    private LocalBean mBean;

    public LocalAdaapter(Context context) {
        mContext = context;
    }

    public void setBean(LocalBean bean) {
        mBean = bean;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ViewHolder holder = null;

        switch (viewType){
            case 0:

                View headView = LayoutInflater.from(mContext).inflate(R.layout.local_fragment_head_item,parent,false);
                holder = new HeadViewHolder(headView);

                break;

            case 1:

                View mapView  =  LayoutInflater.from(mContext).inflate(R.layout.local_fragment_map_item,parent,false);
                holder = new MapViewHolder(mapView);

                break;
            case 2:

                View strategyView = LayoutInflater.from(mContext).inflate(R.layout.local_fragment_strategy_item,parent,false);
                holder = new StrategyViewHolder(strategyView);

                break;
            case 3:

                View dishView = LayoutInflater.from(mContext).inflate(R.layout.local_fragment_dish_item,parent,false);
                holder = new DishViewHolder(dishView);

                break;

            case 4:

                View restView = LayoutInflater.from(mContext).inflate(R.layout.local_fragment_rest_item,parent,false);
                holder = new RestViewHolder(restView);

                break;

            case 5:

                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        int type = getItemViewType(position);

        switch (type){

            case 0:

                HeadViewHolder headViewHolder = (HeadViewHolder) holder;
                Object content = mBean.getData().getList().get(position).getContent();
                if(content instanceof Map){

                    Map<String,String> map  = (Map<String, String>) content;
                    Picasso.with(mContext).load(map.get("cover")).into(headViewHolder.mImageView);
                }

                break;
            case 1:

                MapViewHolder mapViewHolder = (MapViewHolder) holder;
                mapViewHolder.mAdapter.setBean(mBean);
                mapViewHolder.mMyGridView.setAdapter(mapViewHolder.mAdapter);

                break;
            case 2:

                StrategyViewHolder strategyViewHolder = (StrategyViewHolder) holder;
                strategyViewHolder.title.setText(mBean.getData().getList().get(position).getTitle());
                strategyViewHolder.mAdapter.setBean(mBean);
                strategyViewHolder.mMyGridView.setAdapter(strategyViewHolder.mAdapter);

                break;
            case 3:

                final DishViewHolder dishViewHolder = (DishViewHolder) holder;
                dishViewHolder.title.setText(mBean.getData().getList().get(position).getTitle());
                dishViewHolder.mAdapter.setBean(mBean);
                dishViewHolder.mMyGridView.setAdapter(dishViewHolder.mAdapter);
                dishViewHolder.shown.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(dishViewHolder.user){
                            dishViewHolder.mAdapter.setInShown(true);
                            dishViewHolder.user = false;
                            dishViewHolder.shown.setText("已经全部展开,可收回!");
                        }else {
                            dishViewHolder.mAdapter.setInShown(false);
                            dishViewHolder.user  = true;
                            dishViewHolder.shown.setText("展开全部4道特色菜");
                        }

                    }
                });

                break;

            case 4:

                RestViewHolder restViewHolder = (RestViewHolder) holder;

                break;

            case 5:

                break;
        }

    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    //第一个holder
    class HeadViewHolder extends RecyclerView.ViewHolder{

        private ImageView mImageView;
        public HeadViewHolder(View itemView) {
            super(itemView);
            mImageView  = (ImageView) itemView.findViewById(R.id.local_fragment_head_item_image);
        }
    }

    //第二个holder
    class MapViewHolder extends RecyclerView.ViewHolder{

        private MyGridView mMyGridView;
        private MapAdapter mAdapter;

        public MapViewHolder(View itemView) {
            super(itemView);
            mMyGridView = (MyGridView) itemView.findViewById(R.id.local_fragment_map_item_gridView);
            mAdapter = new MapAdapter(mContext);
        }
    }

    //第三个holder
    class StrategyViewHolder extends RecyclerView.ViewHolder{

        private MyGridView mMyGridView;
        private TextView title;
        private StrategyAdapter mAdapter;

        public StrategyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.local_fragment_strategy_item_title);
            mMyGridView = (MyGridView) itemView.findViewById(R.id.local_fragment_strategy_item_gridview);
            mAdapter = new StrategyAdapter(mContext);
        }
    }

    class DishViewHolder extends RecyclerView.ViewHolder{

        private TextView title;
        private TextView shown;
        private MyGridView mMyGridView;
        private DishAdapter mAdapter;
        private Boolean user = true;//判断是否是第一次点击

        public DishViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.local_fragment_dish_item_title);
            shown = (TextView) itemView.findViewById(R.id.local_fragment_dish_item_shown);
            mMyGridView = (MyGridView) itemView.findViewById(R.id.local_fragment_dish_item_gridview);
            mAdapter = new DishAdapter(mContext);
        }
    }

    class RestViewHolder extends RecyclerView.ViewHolder{

        public RestViewHolder(View itemView) {
            super(itemView);
        }
    }
}
