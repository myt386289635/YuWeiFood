package com.example.dllo.yuweifood.local.rest.details;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.dllo.yuweifood.R;

/**
 * Created by dllo on 16/9/8.
 */
public class AdvAdapter extends PagerAdapter{
    private static final String TAG = "AdvAdapter --> ***********";

    private RestDetailsBean mBean;
    private Context mContext;

    public AdvAdapter(Context context) {
        mContext = context;
    }

    public void setBean(RestDetailsBean bean) {
        mBean = bean;
    }

    @Override
    public int getCount() {
        return mBean.getData().getList().size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View  view = LayoutInflater.from(mContext).inflate(R.layout.activity_rest_details_adv_item_image,container,false);
        ImageView imageView = (ImageView) view.findViewById(R.id.activity_rest_details_adv_item_image_item_image);

        Glide.with(mContext).load(mBean.getData().getList().get(position).getCover()).into(imageView);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    }
}
