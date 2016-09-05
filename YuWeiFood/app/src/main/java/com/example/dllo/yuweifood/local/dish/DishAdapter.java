package com.example.dllo.yuweifood.local.dish;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dllo.yuweifood.R;
import com.example.dllo.yuweifood.local.LocalBean;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 16/9/4.
 */
public class DishAdapter extends BaseAdapter {
    private static final String TAG = "DishAdapter --> ***********";

    private LocalBean mBean;
    private Context mContext;
    private Boolean inShown;//判断是否展开

    public void setInShown(Boolean inShown) {
        this.inShown = inShown;
        notifyDataSetChanged();
    }

    public DishAdapter(Context context) {
        mContext = context;
    }

    public void setBean(LocalBean bean) {
        mBean = bean;
    }

    @Override
    public int getCount() {
        Object object = mBean.getData().getList().get(3).getContent();
        if(object instanceof List){
            if(inShown != null && inShown){
                return ((List) object).size();
            }else {
                return 2;
            }
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {

        Object object = mBean.getData().getList().get(3).getContent();
        if(object instanceof List){
            List<Map<String,String>> values = (List<Map<String, String>>) object;
            return values.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.local_fragment_dish_item_gridview_item,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        Object object = mBean.getData().getList().get(3).getContent();
        if(object instanceof List) {
            List<Map<String, String>> values = (List<Map<String, String>>) object;
            Picasso.with(mContext).load(values.get(position).get("cover")).into(holder.mImageView);
            holder.name.setText(values.get(position).get("name"));
            holder.content.setText(values.get(position).get("sum"));
        }

        return convertView;
    }

    class ViewHolder {

        private ImageView mImageView;
        private TextView name,content;


        public ViewHolder(View view) {

            mImageView = (ImageView) view.findViewById(R.id.local_fragment_dish_item_gridview_item_image);
            name = (TextView) view.findViewById(R.id.local_fragment_dish_item_gridview_item_name);
            content = (TextView) view.findViewById(R.id.local_fragment_dish_item_gridview_item_content);

        }
    }
}
