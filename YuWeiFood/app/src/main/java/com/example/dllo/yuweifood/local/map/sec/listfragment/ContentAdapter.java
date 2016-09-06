package com.example.dllo.yuweifood.local.map.sec.listfragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dllo.yuweifood.R;
import com.example.dllo.yuweifood.local.map.sec.mapfragment.ViewPagerBean;

import java.util.ArrayList;

/**
 * Created by dllo on 16/9/6.
 */
public class ContentAdapter extends BaseAdapter{
    private static final String TAG = "ContentAdapter --> ***********";

    private ArrayList<ViewPagerBean> mList;
    private Context mContext;

    public ContentAdapter(Context context) {
        mContext = context;
    }

    public void setList(ArrayList<ViewPagerBean> list) {
        mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.content_fragment_item,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        Glide.with(mContext).load(mList.get(position).getImage()).into(holder.mImageView);
        holder.name.setText(mList.get(position).getName());
        holder.price.setText(mList.get(position).getPrice()+"元/人");
        holder.content.setText(mList.get(position).getContent());

        return convertView;
    }

    class ViewHolder {

        private ImageView mImageView;
        private TextView name,price,content;

        public ViewHolder(View view) {

            mImageView = (ImageView) view.findViewById(R.id.content_fragment_item_image);
            name = (TextView) view.findViewById(R.id.content_fragment_item_name);
            price  = (TextView) view.findViewById(R.id.content_fragment_item_price);
            content = (TextView) view.findViewById(R.id.content_fragment_item_content);
        }
    }
}
