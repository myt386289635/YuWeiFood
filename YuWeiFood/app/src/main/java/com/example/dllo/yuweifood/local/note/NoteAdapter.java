package com.example.dllo.yuweifood.local.note;

import android.content.Context;
import android.content.Intent;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dllo.yuweifood.R;
import com.example.dllo.yuweifood.food.hot.secdetails.DetailsActivity;
import com.example.dllo.yuweifood.local.LocalBean;
import com.example.dllo.yuweifood.tool.Values;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by dllo on 16/9/5.
 */
public class NoteAdapter extends BaseAdapter {
    private static final String TAG = "NoteAdapter --> ***********";

    private LocalBean mBean;
    private Context mContext;

    public NoteAdapter(Context context) {
        mContext = context;
    }

    public void setBean(LocalBean bean) {
        mBean = bean;
    }

    @Override
    public int getCount() {
        Object object = mBean.getData().getList().get(5).getContent();
        if(object instanceof List){
            return ((List) object).size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        Object object = mBean.getData().getList().get(4).getContent();
        if(object instanceof List){
            List<Map<String,Object>> list = (List<Map<String, Object>>) object;
            return list.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        ViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.local_fragment_note_item_gridview_item,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        Object object = mBean.getData().getList().get(5).getContent();
        if(object instanceof List){
            List<Map<String,Object>> list = (List<Map<String, Object>>) object;
            Object value_image = list.get(position).get("cover");
            Object value_content = list.get(position).get("name");
            Object value_date = list.get(position).get("time");
            Object value_author = list.get(position).get("author");
            if(value_image instanceof  String){
                String image = (String) value_image;
                if(image != null){
                    Glide.with(mContext).load(image).into(holder.mImageView);
                }
            }
            if(value_content instanceof String){
                String content = (String) value_content;
                holder.content.setText(content);
            }

            if(value_date instanceof  Double){
                Double date  = (Double) value_date;
                String time = Double.toString(date);
                String values = time.substring(2,time.length()-2);
                String v = time.substring(0,1)+values;
                holder.date.setText(holder.simpleDateFormat.format(new Date(Long.valueOf(v))));
            }

            if (value_author instanceof Map){
                Map<String,String> autors = (Map<String, String>) value_author;
                Glide.with(mContext).load(autors.get("header")).bitmapTransform(new CropCircleTransformation(mContext)).into(holder.userImage);
                holder.userName.setText(autors.get("uname"));
            }
        }

        holder.mLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetailsActivity.class);
                intent.putExtra("url", Values.LocalFragment_note_item[position]);
                mContext.startActivity(intent);
            }
        });

        return convertView;
    }

    class ViewHolder{

        private ImageView mImageView;
        private TextView content,date,userName;
        private ImageView userImage;
        private SimpleDateFormat simpleDateFormat;
        private RelativeLayout mLayout;


        public ViewHolder(View  view) {
            mImageView = (ImageView) view.findViewById(R.id.local_fragment_note_item_gridview_item_image);
            content = (TextView) view.findViewById(R.id.local_fragment_note_item_gridview_item_content);
            date = (TextView) view.findViewById(R.id.local_fragment_note_item_gridview_item_date);
            userName = (TextView) view.findViewById(R.id.local_fragment_note_item_gridview_item_userName);
            userImage = (ImageView) view.findViewById(R.id.local_fragment_note_item_gridview_item_userImage);
            simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");

            mLayout = (RelativeLayout) view.findViewById(R.id.local_fragment_note_item_gridview_item_mLayout);
        }
    }
}
