package com.example.dllo.yuweifood;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
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
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.dllo.yuweifood.base.BaseActivity;
import com.example.dllo.yuweifood.food.FoodFragment;
import com.example.dllo.yuweifood.food.movie.MediaController.onClickIsFullScreenListener;
import com.example.dllo.yuweifood.food.movie.MyVedioView;
import com.example.dllo.yuweifood.local.LocalFragment;
import com.example.dllo.yuweifood.mine.MineFragment;
import com.example.dllo.yuweifood.recommend.RecommendFragment;


public class MainActivity extends BaseActivity implements OnClickListener {


    private RadioButton mRadioButton_recommend, mRadioButton_local, mRadioButton_food, mRadioButton_mine;
    private TextView mTextView_recommend, mTextView_local, mTextView_food, mTextView_mine;
    private RadioButton[] mRadioButtons;
    private TextView[] mTextViews;

    private Boolean falg = true;//判断是否是第一次点击返回键

    private VideoView mVideoView;
    private Boolean playing = true;//是否开启线程
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private Boolean messageFlag = true; //判断消息有没有发送过

    private MyVedioView screenVideoView;
    private RelativeLayout mLayout;
    private com.example.dllo.yuweifood.food.movie.MediaController controller;

    private ImageView close;

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

        screenVideoView = (MyVedioView) findViewById(R.id.activity_fullScreen_videoview);
        mLayout = (RelativeLayout) findViewById(R.id.activity_layout);

        close = (ImageView) findViewById(R.id.videoView_colse);
    }

    @Override
    protected void initDate() {

        controller = new com.example.dllo.yuweifood.food.movie.MediaController(this);
        screenVideoView.setVisibility(View.GONE);
        close.setVisibility(View.GONE);
        mVideoView.setVisibility(View.GONE);
        mSharedPreferences = getSharedPreferences("videoview", MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
        mRadioButton_recommend.setOnClickListener(this);
        mRadioButton_food.setOnClickListener(this);
        mRadioButton_mine.setOnClickListener(this);
        mRadioButton_local.setOnClickListener(this);

        mRadioButtons = new RadioButton[]{mRadioButton_recommend, mRadioButton_local, mRadioButton_food, mRadioButton_mine};
        mTextViews = new TextView[]{mTextView_recommend, mTextView_local, mTextView_food, mTextView_mine};

        replaceFragment(new RecommendFragment());

        new Thread(new Runnable() {
            @Override
            public void run() {

                while (playing) {

                    if (mSharedPreferences.getBoolean("play", false)) {

                        if (messageFlag) {
                            hander.sendEmptyMessage(0);
                            messageFlag = false;
                        }

                    }
                }

            }
        }).start();

        close.setOnClickListener(this);

    }

    Handler hander = new Handler(new Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what == 0) {
                close.setVisibility(View.VISIBLE);
                mVideoView.setVisibility(View.VISIBLE);
                Uri uri = Uri.parse(mSharedPreferences.getString("url", ""));
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

        switch (v.getId()) {
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

            case R.id.videoView_colse:

                mVideoView.stopPlayback();
                close.setVisibility(View.GONE);
                mVideoView.setVisibility(View.GONE);
                mEditor.putBoolean("play", false);
                mEditor.commit();
                messageFlag = true;
                break;
        }

    }

    //设置替换的fragment
    public void replaceFragment(Fragment fragment) {

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();

    }

    //设置点亮的图标位置
    public void setSit(int sit) {

        for (int i = 0; i < mRadioButtons.length; i++) {
            if (i == sit) {
                mRadioButtons[i].setChecked(true);
                mTextViews[i].setTextColor(0xffffa12c);
            } else {
                mRadioButtons[i].setChecked(false);
                mTextViews[i].setTextColor(0xff000000);
            }

        }
    }

    @Override
    public void onBackPressed() {
        if (falg) {
            Toast.makeText(this, "再按一次退出应用", Toast.LENGTH_SHORT).show();
            falg = false;
            mHandler.sendEmptyMessageDelayed(0, 3000);//3秒之外回复第一次点击
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        mEditor.putBoolean("play", false);
        mEditor.putString("url", "");
        mEditor.commit();
        if (mVideoView.isPlaying()) {
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

    //屏幕改变改动该方法
    @Override
    public void onConfigurationChanged(Configuration newConfig) {

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Log.e("info", "横屏");
            screenVideoView.setVisibility(View.VISIBLE);
            mLayout.setVisibility(View.GONE);
            Uri uri = Uri.parse(mSharedPreferences.getString("url", ""));
            screenVideoView.setVideoURI(uri);
            screenVideoView.setMediaController(controller);
            controller.setClickIsFullScreenListener(new onClickIsFullScreenListener() {
                @Override
                public void setOnClickIsFullScreen() {
                    if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                        //设置RelativeLayout的全屏模式
                        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

                    } else {
                        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                    }
                }
            });
            screenVideoView.requestFocus();
            screenVideoView.start();
        } else {
            Log.e("info", "竖屏");
            screenVideoView.stopPlay();
            screenVideoView.setVisibility(View.GONE);
            mLayout.setVisibility(View.VISIBLE);

        }
        super.onConfigurationChanged(newConfig);
    }

}
