package com.example.dllo.yuweifood;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.MediaController;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.dllo.yuweifood.base.BaseActivity;
import com.example.dllo.yuweifood.food.FoodFragment;
import com.example.dllo.yuweifood.local.LocalFragment;
import com.example.dllo.yuweifood.mine.MineFragment;
import com.example.dllo.yuweifood.recommend.RecommendFragment;


public class MainActivity extends BaseActivity implements OnClickListener {



    private RadioButton mRadioButton_recommend,mRadioButton_local,mRadioButton_food,mRadioButton_mine;
    private TextView mTextView_recommend,mTextView_local,mTextView_food,mTextView_mine;
    private RadioButton[] mRadioButtons;
    private TextView[] mTextViews;

    private Boolean falg = true;//判断是否是第一次点击返回键

    private VideoView mVideoView;
    private Boolean playing = true;//是否开启线程
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private Boolean messageFlag = true; //判断消息有没有发送过

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mRadioButton_recommend = (RadioButton) findViewById(R.id.btn_recommend);
        mRadioButton_local = (RadioButton) findViewById(R.id.btn_local);
        mRadioButton_food = (RadioButton) findViewById(R.id.btn_food);
        mRadioButton_mine = (RadioButton) findViewById(R.id.btn_mine);
        mTextView_recommend = (TextView) findViewById(R.id.btn_recommend_text);
        mTextView_local = (TextView) findViewById(R.id.btn_local_text);
        mTextView_food = (TextView) findViewById(R.id.btn_food_text);
        mTextView_mine = (TextView) findViewById(R.id.btn_mine_text);
        mVideoView = (VideoView) findViewById(R.id.videoView);

    }

    @Override
    protected void initDate() {

        mVideoView.setVisibility(View.GONE);
        mSharedPreferences = getSharedPreferences("videoview",MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
        mRadioButton_recommend.setOnClickListener(this);
        mRadioButton_food.setOnClickListener(this);
        mRadioButton_mine.setOnClickListener(this);
        mRadioButton_local.setOnClickListener(this);

        mRadioButtons = new RadioButton[]{mRadioButton_recommend, mRadioButton_local, mRadioButton_food, mRadioButton_mine};
        mTextViews  = new TextView[]{mTextView_recommend, mTextView_local, mTextView_food, mTextView_mine};

        replaceFragment(new RecommendFragment());

        new Thread(new Runnable() {
            @Override
            public void run() {

                while (playing){

                    if(mSharedPreferences.getBoolean("play",false)){

                        if(messageFlag){
                            hander.sendEmptyMessage(0);
                            messageFlag = false;
                        }

                    }
                }

            }
        }).start();

    }

    Handler hander = new Handler(new Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if(msg.what == 0){
                mVideoView.setVisibility(View.VISIBLE);
                Uri uri = Uri.parse(mSharedPreferences.getString("url",""));
                mVideoView.setVideoURI(uri);
                mVideoView.setMediaController(new MediaController(MainActivity.this));
                mVideoView.requestFocus();
                mVideoView.start();
            }

            return false;
        }
    });

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_recommend:
                setSit(0);
                replaceFragment(new RecommendFragment());
                break;
            case R.id.btn_local:
                setSit(1);
                replaceFragment(new LocalFragment());
                break;
            case R.id.btn_food:
                setSit(2);
                replaceFragment(new FoodFragment());
                break;
            case R.id.btn_mine:
                setSit(3);
                replaceFragment(new MineFragment());
                break;
        }

    }

    //设置替换的fragment
    public void replaceFragment(Fragment fragment){

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();

    }

    //设置点亮的图标位置
    public void setSit(int sit){

        for (int i = 0; i < mRadioButtons.length; i++) {
            if(i == sit){
                mRadioButtons[i].setChecked(true);
                mTextViews[i].setTextColor(0xffffa12c);
            }else {
                mRadioButtons[i].setChecked(false);
                mTextViews[i].setTextColor(0xff000000);
            }

        }
    }

    @Override
    public void onBackPressed() {
        if(falg){
            Toast.makeText(this, "再按一次退出应用", Toast.LENGTH_SHORT).show();
            falg = false;
            mHandler.sendEmptyMessageDelayed(0,3000);//3秒之外回复第一次点击
        }else {
            super.onBackPressed();
        }
    }


    @Override
    protected void onStop() {
        super.onStop();
        mEditor.putBoolean("play",false);
        mEditor.putString("url","");
        mEditor.commit();
        if(mVideoView.isPlaying()){
            mVideoView.stopPlayback();

        }
        mVideoView.setVisibility(View.GONE);
        messageFlag = true;
    }

    Handler mHandler = new Handler(new Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            falg = true;
            return false;
        }
    });




    @Override
    protected void onDestroy() {

        super.onDestroy();
        playing = false;
    }




}
