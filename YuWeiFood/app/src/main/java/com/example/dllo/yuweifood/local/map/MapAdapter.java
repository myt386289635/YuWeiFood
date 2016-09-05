package com.example.dllo.yuweifood.local.map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.yuweifood.R;
import com.example.dllo.yuweifood.local.LocalBean;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 16/9/3.
 */
public class MapAdapter extends BaseAdapter {
    private static final String TAG = "MapAdapter --> ***********";

    private LocalBean mBean;
    private Context mContext;

    public MapAdapter(Context context) {
        mContext = context;
    }

    public void setBean(LocalBean bean) {
        mBean = bean;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Object getItem(int position) {
        Object content = mBean.getData().getList().get(1).getContent();
        if(content instanceof List){
            List<Map<String,String>> values = (List<Map<String, String>>) content;
            return  values.get(position);
        }else
            return  null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHodler hodler = null;
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.local_fragment_map_item_gridview_item,parent,false);
            hodler = new ViewHodler(convertView);
            convertView.setTag(hodler);
        }else {
            hodler = (ViewHodler) convertView.getTag();
        }


        if(position == 1){
            hodler.symbol.setImageResource(R.mipmap.citymap_2);
        }else if(position == 2){
            hodler.symbol.setImageResource(R.mipmap.citymap_3);
        }else {
            hodler.symbol.setImageResource(R.mipmap.citymap_1);
        }

        Object content = mBean.getData().getList().get(1).getContent();
        if(content instanceof List){
            List<Map<String,String>> values = (List<Map<String, String>>) content;
            hodler.name.setText(values.get(position).get("name"));
            hodler.content.setText(values.get(position).get("cost") + "元/人" + "\t"+ values.get(position).get("type"));
            Picasso.with(mContext).load(values.get(position).get("cover")).into(hodler.mImageView);
            hodler.local.setText(values.get(position).get("km"));
        }

        return convertView;
    }

    class ViewHodler{

        private ImageView mImageView;
        private TextView name,content,local;
        private ImageView symbol;
        public ViewHodler(View view) {

            mImageView = (ImageView) view.findViewById(R.id.local_fragment_map_item_gridView_item_image);
            name = (TextView) view.findViewById(R.id.local_fragment_map_item_gridView_item_name);
            content = (TextView) view.findViewById(R.id.local_fragment_map_item_gridView_item_content);
            local = (TextView) view.findViewById(R.id.local_fragment_map_item_gridView_item_local);
            symbol = (ImageView) view.findViewById(R.id.citymap_1);
        }
    }
}
