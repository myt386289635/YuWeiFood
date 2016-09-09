package com.example.dllo.yuweifood.food.hot.secdetails;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dllo.yuweifood.R;
import com.example.dllo.yuweifood.tool.FastBlurUtil;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by dllo on 16/9/7.
 */
public class DetailsAdapter extends RecyclerView.Adapter {
    private static final String TAG = "DetailsAdapter --> ***********";

    private DetailsBean mBean;
    private Context mContext;

    public DetailsAdapter(Context context) {
        mContext = context;
    }

    public void setBean(DetailsBean bean) {
        mBean = bean;
    }

    @Override
    public int getItemViewType(int position) {

        if (position == 0){
            return 0;
        }else {
            if(mBean.getData().getContent().get(position-1).getType().equals("text")){
                return 1;
            }else {
                return 2;
            }
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ViewHolder holder = null;

        switch (viewType){
            case 0:

                View headView = LayoutInflater.from(mContext).inflate(R.layout.activity_details_head_item,parent,false);
                holder = new HeadViewHolder(headView);
                break;

            case 1:

                View textView = LayoutInflater.from(mContext).inflate(R.layout.activity_details_text_item,parent,false);
                holder = new TextViewHolder(textView);
                break;

            case 2:

                View imgView = LayoutInflater.from(mContext).inflate(R.layout.activity_details_img_item,parent,false);
                holder = new ImgViewHolder(imgView);
                break;
        }


        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        int type = getItemViewType(position);

        switch (type){
            case 0:

                final HeadViewHolder headViewHolder = (HeadViewHolder) holder;
                //设置毛玻璃背景
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        headViewHolder.mBlurBitmap2 = FastBlurUtil.GetUrlBitmap(mBean.getData().getCover(), 3);
                        headViewHolder.mHandler.sendEmptyMessage(0);
                    }
                }).start();

                headViewHolder.mHandler = new Handler(new Callback() {
                    @Override
                    public boolean handleMessage(Message msg) {

                        headViewHolder.background.setImageBitmap(headViewHolder.mBlurBitmap2);

                        return false;
                    }
                });

                headViewHolder.title.setText(mBean.getData().getTitle());
                headViewHolder.name.setText(mBean.getData().getAuthor().getUname());
                headViewHolder.date.setText(mBean.getData().getCtime());

                headViewHolder.level.setText("LV"+mBean.getData().getAuthor().getLevel());
                Glide.with(mContext).load(mBean.getData().getAuthor().getHeader()).bitmapTransform(new CropCircleTransformation(mContext)).into(headViewHolder.image);
                headViewHolder.likeNum.setText(mBean.getData().getVote());
                headViewHolder.favNum.setText(mBean.getData().getFav());

                headViewHolder.cityname.setText(mBean.getData().getCity());
                headViewHolder.restname.setText(mBean.getData().getRest());
                headViewHolder.numname.setText(mBean.getData().getNumber());
                headViewHolder.costname.setText(mBean.getData().getCost());
                break;

            case 1:

                TextViewHolder textViewHolder = (TextViewHolder) holder;
                textViewHolder.text.setText(mBean.getData().getContent().get(position-1).getValue());

                break;

            case 2:
                ImgViewHolder imgViewHolder = (ImgViewHolder) holder;
                Glide.with(mContext).load(mBean.getData().getContent().get(position-1).getValue()).into(imgViewHolder.mImageView);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mBean.getData().getContent().size()+1;
    }

    class HeadViewHolder extends RecyclerView.ViewHolder{

        private ImageView background;
        private TextView title;
        private TextView name,date,level;
        private ImageView image;
        private TextView likeNum,favNum;

        private TextView cityname,restname,numname,costname;

        private Handler  mHandler = null;
        private Bitmap mBlurBitmap2;

        public HeadViewHolder(View itemView) {
            super(itemView);
            background = (ImageView) itemView.findViewById(R.id.activity_details_head_item_background);
            title = (TextView) itemView.findViewById(R.id.activity_details_head_item_title);
            name = (TextView) itemView.findViewById(R.id.activity_details_head_item_name);
            date = (TextView) itemView.findViewById(R.id.activity_details_head_item_date);
            level = (TextView) itemView.findViewById(R.id.activity_details_head_item_level);
            image = (ImageView) itemView.findViewById(R.id.activity_details_head_item_userImage);

            likeNum  = (TextView) itemView.findViewById(R.id.activity_details_head_item_likeNum);
            favNum = (TextView) itemView.findViewById(R.id.activity_details_head_item_favNum);

            cityname  = (TextView) itemView.findViewById(R.id.activity_details_head_item_cityName);
            restname = (TextView) itemView.findViewById(R.id.activity_details_head_item_restName);
            numname = (TextView) itemView.findViewById(R.id.activity_details_head_item_numName);
            costname = (TextView) itemView.findViewById(R.id.activity_details_head_item_costName);

        }
    }

    class TextViewHolder extends RecyclerView.ViewHolder{

        private TextView text;

        public TextViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.activity_details_text_item_text);
        }
    }

    class ImgViewHolder extends RecyclerView.ViewHolder{

        private ImageView mImageView;
        public ImgViewHolder(View itemView) {
            super(itemView);

            mImageView = (ImageView) itemView.findViewById(R.id.activity_details_img_item_img);
        }
    }
}
