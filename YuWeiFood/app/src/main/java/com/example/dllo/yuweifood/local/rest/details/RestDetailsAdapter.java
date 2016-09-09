package com.example.dllo.yuweifood.local.rest.details;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dllo.yuweifood.R;

/**
 * Created by dllo on 16/9/8.
 */
public class RestDetailsAdapter extends RecyclerView.Adapter{
    private static final String TAG = "RestDetailsAdapter --> ***********";

    private RestDetailsBean mBean;
    private Context mContext;

    public RestDetailsAdapter(Context context) {
        mContext = context;
    }

    public void setBean(RestDetailsBean bean) {
        mBean = bean;
    }

    @Override
    public int getItemViewType(int position) {

        if(position == 0){
            return 0;
        }else if(position == 1) {
            return 1;
        }else if(position == 2){
            return 2;
        }else {
            return 3;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        ViewHolder holder = null;

        switch (viewType){

            case 0:

                View advView  = LayoutInflater.from(mContext).inflate(R.layout.activity_rest_details_adv_item,parent,false);
                holder = new AdvViewHolder(advView);

                break;

            case 1:

                View timeView = LayoutInflater.from(mContext).inflate(R.layout.activity_rest_details_time_item,parent,false);
                holder = new TimeViewHolder(timeView);
                break;

            case 2:

                View reasonView = LayoutInflater.from(mContext).inflate(R.layout.activity_rest_details_reason_item,parent,false);
                holder = new ReasonViewHolder(reasonView);

                break;

            case 3:

                View contentView = LayoutInflater.from(mContext).inflate(R.layout.activity_rest_details_content_item,parent,false);
                holder  = new ContentViewHolder(contentView);

                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        int type = getItemViewType(position);

        switch (type){
            case 0:

                final AdvViewHolder advViewHolder = (AdvViewHolder) holder;
                advViewHolder.addressText.setText(mBean.getData().getRestinfo().getAddress());
                advViewHolder.mAdvAdapter.setBean(mBean);
                advViewHolder.mViewPager.setAdapter(advViewHolder.mAdvAdapter);
                if (advViewHolder.flag) {

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            while (true){
                                try {
                                    Thread.sleep(3000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                advViewHolder.mHandler.sendEmptyMessage(0);
                            }
                        }
                    }).start();

                    advViewHolder.mHandler = new Handler(new Callback() {
                        @Override
                        public boolean handleMessage(Message msg) {
                            if(advViewHolder.mViewPager.getCurrentItem() == mBean.getData().getList().size() - 1){
                                advViewHolder.mViewPager.setCurrentItem(0);
                            }else {
                                advViewHolder.mViewPager.setCurrentItem(advViewHolder.mViewPager.getCurrentItem()+1);
                            }

                            return false;
                        }
                    });

                    advViewHolder.flag = false;
                }

                break;
            case 1:

                TimeViewHolder timeViewHolder = (TimeViewHolder) holder;
                timeViewHolder.costText.setText("人均"+mBean.getData().getRestinfo().getCost()+"元");
                timeViewHolder.timeOpen.setText("营业时间:  "+mBean.getData().getRestinfo().getOpen_time());
                timeViewHolder.phoneText.setText(mBean.getData().getRestinfo().getPhone());

                break;

            case 2:

                ReasonViewHolder reasonViewHolder = (ReasonViewHolder) holder;
                reasonViewHolder.reasonText.setText(mBean.getData().getRestinfo().getReason());

                break;
            case 3:

                ContentViewHolder contentViewHolder = (ContentViewHolder) holder;
                Glide.with(mContext).load(mBean.getData().getList().get(position - 3).getCover()).into(contentViewHolder.mImageView);
                contentViewHolder.name.setText(mBean.getData().getList().get(position - 3).getName());
                contentViewHolder.content.setText(mBean.getData().getList().get(position -3 ).getSummary());

                break;
        }
    }

    @Override
    public int getItemCount() {
        return mBean.getData().getList().size() + 3;
    }

    class AdvViewHolder extends RecyclerView.ViewHolder{

        private TextView addressText;
        private ViewPager mViewPager;
        private AdvAdapter mAdvAdapter;
        private Boolean flag = true;
        private Handler mHandler;

        public AdvViewHolder(View itemView) {
            super(itemView);

            addressText = (TextView) itemView.findViewById(R.id.activity_rest_details_adv_item_address);
            mViewPager = (ViewPager) itemView.findViewById(R.id.activity_rest_details_adv_item_viewpager);
            mAdvAdapter  = new AdvAdapter(mContext);
        }
    }

    class TimeViewHolder extends RecyclerView.ViewHolder{

        private TextView costText;
        private TextView timeOpen;
        private TextView phoneText;

        public TimeViewHolder(View itemView) {
            super(itemView);

            phoneText = (TextView) itemView.findViewById(R.id.activity_rest_details_time_item_phone);
            timeOpen = (TextView) itemView.findViewById(R.id.activity_rest_details_time_item_openTime);
            costText = (TextView) itemView.findViewById(R.id.activity_rest_details_time_item_cost);

        }
    }

    class ReasonViewHolder extends RecyclerView.ViewHolder{

        private TextView reasonText;

        public ReasonViewHolder(View itemView) {
            super(itemView);

            reasonText = (TextView) itemView.findViewById(R.id.activity_rest_details_reason_item_Text);
        }
    }

    class ContentViewHolder extends RecyclerView.ViewHolder{

        private ImageView mImageView;
        private TextView name;
        private TextView content;

        public ContentViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.activity_rest_details_content_item_image);
            name = (TextView) itemView.findViewById(R.id.activity_rest_details_content_item_name);
            content = (TextView) itemView.findViewById(R.id.activity_rest_details_content_item_content);
        }
    }
}
