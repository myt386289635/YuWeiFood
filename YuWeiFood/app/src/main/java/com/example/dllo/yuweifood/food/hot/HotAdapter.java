package com.example.dllo.yuweifood.food.hot;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dllo.yuweifood.R;
import com.wirelesspienetwork.overview.model.OverviewAdapter;
import com.wirelesspienetwork.overview.model.ViewHolder;

import java.util.List;

/**
 * Created by dllo on 16/9/1.
 */
public class HotAdapter extends OverviewAdapter<ViewHolder<View, Integer>, Integer>{
    private static final String TAG = "HotAdapter --> ***********";

    private Context mContext;

    public HotAdapter(Context context,List<Integer> integers) {
        super(integers);
        mContext = context;
    }

    @Override
    public ViewHolder<View, Integer> onCreateViewHolder(Context context, ViewGroup parent) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.food_fragment_hot_fragment_item,parent,false);
        return new ViewHolder<View, Integer>(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder<View, Integer> viewIntegerViewHolder, int position) {
        viewIntegerViewHolder.itemView.setBackgroundColor(viewIntegerViewHolder.model);
    }

}
