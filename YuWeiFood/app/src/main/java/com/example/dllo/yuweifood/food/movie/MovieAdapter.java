package com.example.dllo.yuweifood.food.movie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.yuweifood.R;

/**
 * Created by dllo on 16/9/2.
 */
public class MovieAdapter extends BaseAdapter {
    private static final String TAG = "MovieAdapter --> ***********";

    private MovieBean mBean;
    private Context mContext;

    public void setContext(Context context) {
        mContext = context;
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
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.food_fragment_move_fragment_item,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

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

        }
    }
}
