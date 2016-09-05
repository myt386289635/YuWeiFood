package com.example.dllo.yuweifood.local.strategy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dllo.yuweifood.R;
import com.example.dllo.yuweifood.local.LocalBean;

import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 16/9/4.
 */
public class StrategyAdapter extends BaseAdapter {
    private static final String TAG = "StrategyAdapter --> ***********";

    private LocalBean mBean;
    private Context mContext;

    public StrategyAdapter(Context context) {
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

        Object content = mBean.getData().getList().get(2).getContent();
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

        ViewHolder holder = null;

        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.local_fragment_strategy_item_gridview_item,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        Object content = mBean.getData().getList().get(2).getContent();
        if(content instanceof List) {
            List<Map<String, String>> values = (List<Map<String, String>>) content;
            if(position == 0){
                holder.mTextView.setBackgroundResource(R.drawable.strategy_text_zn_background);
                holder.mTextView.setText(values.get(position).get("title"));
            }else if(position == 1){
                holder.mTextView.setBackgroundResource(R.drawable.strategy_text_jp_background);
                holder.mTextView.setText(values.get(position).get("title"));
            }else {
                holder.mTextView.setBackgroundResource(R.drawable.strategy_text_background);
                holder.mTextView.setText("+ 撰写攻略");
            }
        }


        return convertView;
    }

    class  ViewHolder{

        private TextView mTextView;

        public ViewHolder(View view) {
            mTextView = (TextView) view.findViewById(R.id.local_fragment_strategy_item_gridView_item_content);
        }
    }
}
