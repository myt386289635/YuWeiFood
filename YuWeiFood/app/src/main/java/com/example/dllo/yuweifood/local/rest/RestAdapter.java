package com.example.dllo.yuweifood.local.rest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dllo.yuweifood.R;
import com.example.dllo.yuweifood.local.LocalBean;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 16/9/4.
 */
public class RestAdapter extends BaseAdapter{
    private static final String TAG = "RestAdapter --> ***********";

    private LocalBean mBean;
    private Context mContext;

    public RestAdapter(Context context) {
        mContext = context;
    }

    public void setBean(LocalBean bean) {
        mBean = bean;
    }

    @Override
    public int getCount() {

        Object object = mBean.getData().getList().get(4).getContent();
        if(object instanceof List){
            return ((List) object).size();
        }

        return 0;
    }

    @Override
    public Object getItem(int position) {

        Object object = mBean.getData().getList().get(4).getContent();
        if(object instanceof List){
            List<Map<String,String>> list = (List<Map<String, String>>) object;
            return list.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Viewholder viewholder = null;

        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.local_fragment_rest_item_gridview_item,parent,false);
            viewholder = new Viewholder(convertView);
            convertView.setTag(viewholder);
        }else {
            viewholder = (Viewholder) convertView.getTag();
        }

        Object object = mBean.getData().getList().get(4).getContent();
        if(object instanceof List){
            List<Map<String,String>> list = (List<Map<String, String>>) object;
            Glide.with(mContext).load(list.get(position).get("cover")).into(viewholder.image);
            viewholder.title.setText(list.get(position).get("name"));
            viewholder.content.setText(list.get(position).get("summary"));
            viewholder.price.setText(list.get(position).get("cost")+"元/人");
        }

        return convertView;
    }

    class Viewholder {

        private TextView title,content,price;
        private ImageView image;

        public Viewholder(View view) {
            title = (TextView) view.findViewById(R.id.local_fragment_rest_item_gridview_item_name);
            content = (TextView) view.findViewById(R.id.local_fragment_rest_item_gridview_item_content);
            price = (TextView) view.findViewById(R.id.local_fragment_rest_item_gridview_item_price);
            image = (ImageView) view.findViewById(R.id.local_fragment_rest_item_gridview_item_image);
        }
    }
}
