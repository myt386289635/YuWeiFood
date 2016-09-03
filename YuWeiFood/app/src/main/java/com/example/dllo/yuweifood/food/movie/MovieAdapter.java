package com.example.dllo.yuweifood.food.movie;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;

import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.dllo.yuweifood.R;
import com.example.dllo.yuweifood.eventbusbean.Bean;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by dllo on 16/9/2.
 */
public class MovieAdapter extends BaseAdapter {
    private static final String TAG = "MovieAdapter --> ***********";

    private MovieBean mBean;
    private Context mContext;
    private MediaController controller;
    private Boolean isShowing;
    private SharedPreferences mSharedPreferences;
    private Editor mEditor;

    public void setContext(Context context) {
        mContext = context;
        controller = new MediaController(mContext);
        mSharedPreferences = mContext.getSharedPreferences("videoview", Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
    }

    public void setShowing(Boolean showing) {
        isShowing = showing;
        notifyDataSetChanged();
    }

    public void setBean(MovieBean bean) {
        mBean = bean;
    }

    @Override
    public int getCount() {
        return mBean.getData().getData().size();
    }

    @Override
    public Object getItem(int position) {
        return mBean.getData().getData().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.food_fragment_move_fragment_item,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        if(isShowing != null && isShowing){
            holder.startMovie.setVisibility(View.VISIBLE);

        }else if(isShowing != null){
            holder.startMovie.setVisibility(View.GONE);
        }else {

            if(holder.mVideoView.isPlaying()){
                Log.d("----", "++");
                mEditor.putBoolean("play",true);
                mEditor.commit();
            }

            holder.startMovie.setVisibility(View.VISIBLE);
            holder.startMovie.setChecked(false);
            holder.mVideoView.setVisibility(View.GONE);
            holder.mLayout.setVisibility(View.VISIBLE);
            holder.mRelativeLayout.setVisibility(View.VISIBLE);
            holder.movieImage.setVisibility(View.VISIBLE);
            Picasso.with(mContext).load(mBean.getData().getData().get(position).getGroup().getUser().getAvatar_url()).into(holder.UserImage);
            holder.UserName.setText(mBean.getData().getData().get(position).getGroup().getUser().getName());
            holder.content.setText(mBean.getData().getData().get(position).getGroup().getContent());
            Picasso.with(mContext).load(mBean.getData().getData().get(position).getGroup().getLarge_cover().getUrl_list().get(0).getUrl()).into(holder.movieImage);
            holder.moviePlayNumber.setText(""+mBean.getData().getData().get(position).getGroup().getPlay_count());

            int min  = (int) (mBean.getData().getData().get(position).getGroup().getDuration() / 60);
            int sec  = (int) (mBean.getData().getData().get(position).getGroup().getDuration()  - min * 60);
            if(sec >= 10){
                holder.movieTime.setText("0"+min+":"+sec);
            }else {
                holder.movieTime.setText("0" + min + ":" +  "0" +sec);
            }

            if(mBean.getData().getData().get(position).getComments().size() != 0){
                Picasso.with(mContext).load(mBean.getData().getData().get(position).getComments().get(0).getUser_profile_image_url()).into(holder.commentImage);
                holder.commentContent.setText(mBean.getData().getData().get(position).getComments().get(0).getText());
                holder.commentImageNum.setText(""+mBean.getData().getData().get(position).getComments().get(0).getDigg_count());
                holder.commentName.setText(mBean.getData().getData().get(position).getComments().get(0).getUser_name());
            }else {
                holder.mLayout.setVisibility(View.GONE);
            }

            holder.goodNum.setText(""+mBean.getData().getData().get(position).getGroup().getDigg_count());
            holder.badNum.setText(mBean.getData().getData().get(position).getGroup().getBury_count()+"");
            holder.shareNum.setText(mBean.getData().getData().get(position).getGroup().getShare_count()+"");
            holder.hotNum.setText(mBean.getData().getData().get(position).getGroup().getRepin_count()+"");

            final ViewHolder mFinalHolder = holder;
            //播放视频
            Uri uri = Uri.parse(mBean.getData().getData().get(position).getGroup().getMp4_url());
            mFinalHolder.mVideoView.setVideoURI(uri);
            mFinalHolder.mVideoView.setMediaController(controller);
            mFinalHolder.mVideoView.requestFocus();

        }

        final ViewHolder finalHolder = holder;
        holder.startMovie.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                finalHolder.movieImage.setVisibility(View.GONE);
                finalHolder.mRelativeLayout.setVisibility(View.GONE);
                finalHolder.startMovie.setVisibility(View.GONE);
                finalHolder.mVideoView.setVisibility(View.VISIBLE);

                if(!finalHolder.mVideoView.isPlaying()){

                    finalHolder.mVideoView.start();
                    mEditor.putString("url",mBean.getData().getData().get(position).getGroup().getMp4_url());
                    mEditor.commit();

                }else {
                    finalHolder.mVideoView.stopPlay();
                }

            }
        });

        return convertView;
    }

    class ViewHolder{

        private ImageView UserImage;
        private TextView UserName;

        private TextView content;
        private ImageView movieImage;
        private TextView moviePlayNumber,movieTime;

        private ImageView commentImage;
        private TextView commentName,commentImageNum,commentContent;

        private TextView goodNum,badNum,hotNum,shareNum;

        private LinearLayout mLayout;

        private MyVedioView mVideoView;
        private CheckBox startMovie;
        private RelativeLayout mRelativeLayout;

        public ViewHolder(View view) {
            UserImage = (ImageView) view.findViewById(R.id.movie_fragment_item_image);
            UserName = (TextView) view.findViewById(R.id.movie_fragment_item_name);
            content = (TextView) view.findViewById(R.id.movie_fragment_item_content);

            movieImage = (ImageView) view.findViewById(R.id.movie_fragment_item_movie);
            moviePlayNumber = (TextView) view.findViewById(R.id.movie_fragment_item_num);
            movieTime = (TextView) view.findViewById(R.id.movie_fragment_item_movieTime);
            commentImage  = (ImageView) view.findViewById(R.id.movie_fragment_item_commentImage);
            commentName = (TextView) view.findViewById(R.id.movie_fragment_item_commentName);
            commentImageNum = (TextView) view.findViewById(R.id.movie_fragment_item_commentGoodNumber);

            commentContent = (TextView) view.findViewById(R.id.movie_fragment_item_commentContent);

            goodNum = (TextView) view.findViewById(R.id.movie_fragment_item_good);
            badNum = (TextView) view.findViewById(R.id.movie_fragment_item_bad);
            hotNum = (TextView) view.findViewById(R.id.movie_fragment_item_hot);
            shareNum = (TextView) view.findViewById(R.id.movie_fragment_item_share);

            mLayout = (LinearLayout) view.findViewById(R.id.movie_fragment_item_layout_two);

            mVideoView = (MyVedioView) view.findViewById(R.id.movie_fragment_item_videoview);
            startMovie = (CheckBox) view.findViewById(R.id.movie_fragment_item_startMovie);
            mRelativeLayout = (RelativeLayout) view.findViewById(R.id.movie_fragment_item_rlayout);

        }
    }

}
