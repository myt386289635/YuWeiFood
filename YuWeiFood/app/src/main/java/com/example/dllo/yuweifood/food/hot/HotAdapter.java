package com.example.dllo.yuweifood.food.hot;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dllo.yuweifood.R;
import com.squareup.picasso.Picasso;
import com.wirelesspienetwork.overview.model.OverviewAdapter;
import com.wirelesspienetwork.overview.model.ViewHolder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by dllo on 16/9/1.
 */
public class HotAdapter extends OverviewAdapter<ViewHolder<View, Integer>, Integer> {
    private static final String TAG = "HotAdapter --> ***********";

    private Context mContext;
    private HotBean mBean;

    public void setBean(HotBean bean) {
        mBean = bean;
    }

    public HotAdapter(Context context, List<Integer> integers) {
        super(integers);
        mContext = context;

    }

    @Override
    public ViewHolder<View, Integer> onCreateViewHolder(Context context, ViewGroup parent) {
        View v = View.inflate(context, R.layout.food_fragment_hot_fragment_item, null);
        return new ViewHolder<View, Integer>(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder<View, Integer> viewIntegerViewHolder, int position) {
        viewIntegerViewHolder.itemView.setBackgroundColor(viewIntegerViewHolder.model);
//        Log.d(TAG, "position:" + position);

        ImageView image;
        TextView text_name, text_leves, text_date, text_content;
        ImageView head_image;
        TextView text_good, text_comment, text_read;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");


        image = viewIntegerViewHolder.getView(R.id.hot_fragment_item_image);
        text_name = viewIntegerViewHolder.getView(R.id.hot_fragment_item_name);
        text_leves = viewIntegerViewHolder.getView(R.id.hot_fragment_item_leves);
        text_date = viewIntegerViewHolder.getView(R.id.hot_fragment_item_date);
        text_content = viewIntegerViewHolder.getView(R.id.hot_fragment_item_text);
        head_image = viewIntegerViewHolder.getView(R.id.hot_fragment_item_imageview);
        text_good = viewIntegerViewHolder.getView(R.id.hot_fragment_item_textGood);
        text_comment = viewIntegerViewHolder.getView(R.id.hot_fragment_item_textComment);
        text_read = viewIntegerViewHolder.getView(R.id.hot_fragment_item_textRead);


        if (mBean.getData().getList().get(viewIntegerViewHolder.getPosition()).getAuthor().getHeader() != "") {
            Glide.with(mContext).load(mBean.getData().getList().get(viewIntegerViewHolder.getPosition()).getAuthor().getHeader()).error(R.mipmap.default_header).placeholder(R.mipmap.default_header).into(image);

        } else {
            image.setImageResource(R.mipmap.default_header);
        }
//        Log.d(TAG, mBean.getData().getList().get(position).getAuthor().getUname());
        text_name.setText(mBean.getData().getList().get(position).getAuthor().getUname());
        text_leves.setText("LV" + mBean.getData().getList().get(position).getAuthor().getLevel());
        String time = simpleDateFormat.format(new Date(mBean.getData().getList().get(position).getTime()));
        text_date.setText(time);
        text_content.setText(mBean.getData().getList().get(position).getText());
        Glide.with(mContext).load(mBean.getData().getList().get(position).getCover()).into(head_image);
        text_good.setText(mBean.getData().getList().get(position).getVote() + "赞");
        text_comment.setText(mBean.getData().getList().get(position).getPlnum() + "评论");
        text_read.setText(mBean.getData().getList().get(position).getReadnum() + "阅读");
    }

}
