package com.example.dllo.yuweifood.local.map.sec.mapfragment;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dllo.yuweifood.R;

import java.util.List;

/**
 * Created by dllo on 16/9/5.
 */
public class SecMapAdapter extends PagerAdapter {
    private static final String TAG = "SecMapAdapter --> ***********";

    private Context mContext;
    private List<ViewPagerBean> mList;

    public SecMapAdapter(Context context) {
        mContext = context;
    }

    public void setList(List<ViewPagerBean> list) {
        mList = list;
    }

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object ;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.activity_map_viewpager_item,container,false);
        ImageView image = (ImageView) view.findViewById(R.id.activity_map_viewpager_item_image);
        TextView name = (TextView) view.findViewById(R.id.activity_map_viewpager_item_name);
        TextView price  = (TextView) view.findViewById(R.id.activity_map_viewpager_item_price);
        TextView content  = (TextView) view.findViewById(R.id.activity_map_viewpager_item_content);

        Glide.with(mContext).load(mList.get(position).getImage()).into(image);
        name.setText(mList.get(position).getName());
        price.setText(mList.get(position).getPrice()+"元/人");
        content.setText(mList.get(position).getContent());

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    }
}
