package com.example.dllo.yuweifood.food.Game;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dllo.yuweifood.R;

/**
 * Created by dllo on 16/9/8.
 */
public class GameAdapter extends RecyclerView.Adapter{
    private static final String TAG = "GameAdapter --> ***********";

    private Context mContext;
    private int mI;

    public GameAdapter(Context context) {
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View  view = LayoutInflater.from(mContext).inflate(R.layout.game_fragment_item,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        MyViewHolder myViewHolder = (MyViewHolder) holder;

        if(position % 4 == 0){
            mI = (int) (Math.random() * 3 + position);
        }

        if(position == mI){
            myViewHolder.mTextView.setBackgroundColor(0xff000000);
            myViewHolder.mTextView.setText("");
        }else {
            myViewHolder.mTextView.setText("");
            myViewHolder.mTextView.setBackgroundResource(R.drawable.game);
        }




    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    class MyViewHolder extends ViewHolder{

        private TextView mTextView;

        public MyViewHolder(View itemView) {
            super(itemView);

            mTextView = (TextView) itemView.findViewById(R.id.game_fragment_item_text);
        }
    }
}
