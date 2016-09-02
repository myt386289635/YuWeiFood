package com.example.dllo.yuweifood.food.attention;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.yuweifood.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by dllo on 16/9/1.
 */
public class AttentAdapter extends BaseAdapter {
    private static final String TAG = "AttentAdapter --> ***********";

    private AttentBean mBean;
    private Context mContext;

    public AttentAdapter(Context context) {
        mContext = context;
    }

    public void setBean(AttentBean bean) {
        mBean = bean;
    }

    @Override
    public int getCount() {
        return mBean.getData().getList().size();
    }

    @Override
    public Object getItem(int position) {
        return mBean.getData().getList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHoder viewHoder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.food_fragment_attent_fragment_item, parent, false);
            viewHoder = new ViewHoder(convertView);
            convertView.setTag(viewHoder);
        } else {
            viewHoder = (ViewHoder) convertView.getTag();
        }

        Picasso.with(mContext).load(mBean.getData().getList().get(position).getHeader()).into(viewHoder.Image);
        viewHoder.name.setText(mBean.getData().getList().get(position).getUname());
        viewHoder.mine.setText(mBean.getData().getList().get(position).getVname());
        viewHoder.content.setText(mBean.getData().getList().get(position).getDesc());

        Object object = mBean.getData().getList().get(position).getLabel();
        if(object instanceof ArrayList){
            ArrayList<Map<String,String>> been = (ArrayList<Map<String, String>>) object;
            if (been.size() > 3 && been != null) {
                viewHoder.first_symbol.setText(been.get(0).get("name"));
                int first_color = Color.parseColor( "#"+been.get(0).get("color"));
                viewHoder.first_symbol.setBackgroundColor(first_color);

                viewHoder.sec_symbol.setText(been.get(1).get("name"));
                int sec_color = Color.parseColor("#"+been.get(1).get("color"));
                viewHoder.sec_symbol.setBackgroundColor(sec_color);

                viewHoder.thr_symbol.setText(been.get(2).get("name"));
                int thr_color = Color.parseColor("#"+been.get(2).get("color"));
                viewHoder.thr_symbol.setBackgroundColor(thr_color);
            }else if(been.size() == 2){
                viewHoder.first_symbol.setText(been.get(0).get("name"));
                int first_color = Color.parseColor( "#"+been.get(0).get("color"));
                viewHoder.first_symbol.setBackgroundColor(first_color);

                viewHoder.sec_symbol.setText(been.get(1).get("name"));
                int sec_color = Color.parseColor("#"+been.get(1).get("color"));
                viewHoder.sec_symbol.setBackgroundColor(sec_color);
            }else if(been.size() == 1){
                viewHoder.first_symbol.setText(been.get(0).get("name"));
                int first_color = Color.parseColor( "#"+been.get(0).get("color"));
                viewHoder.first_symbol.setBackgroundColor(first_color);
            }else {
                viewHoder.first_symbol.setText("");
                viewHoder.sec_symbol.setText("");
                viewHoder.thr_symbol.setText("");
            }


        }


        return convertView;
    }


    class ViewHoder {

        private ImageView Image;
        private TextView name, mine, content, first_symbol, sec_symbol, thr_symbol;

        public ViewHoder(View view) {

            Image = (ImageView) view.findViewById(R.id.attent_fragment_item_image);
            name = (TextView) view.findViewById(R.id.attent_fragment_item_name);
            mine = (TextView) view.findViewById(R.id.attent_fragment_item_mine);
            content = (TextView) view.findViewById(R.id.attent_fragment_item_content);
            first_symbol = (TextView) view.findViewById(R.id.attent_fragment_item_symbol_first);
            sec_symbol = (TextView) view.findViewById(R.id.attent_fragment_item_symbol_two);
            thr_symbol = (TextView) view.findViewById(R.id.attent_fragment_item_symbol_three);
        }
    }
}
