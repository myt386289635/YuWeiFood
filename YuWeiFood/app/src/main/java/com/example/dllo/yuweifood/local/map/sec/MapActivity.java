package com.example.dllo.yuweifood.local.map.sec;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.dllo.yuweifood.R;
import com.example.dllo.yuweifood.base.BaseActivity;
import com.example.dllo.yuweifood.eventbusbean.Bean;
import com.example.dllo.yuweifood.local.map.sec.listfragment.ListFragment;
import com.example.dllo.yuweifood.local.map.sec.mapfragment.MapFragment;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/6.
 */
public class MapActivity extends BaseActivity implements OnClickListener {
    private static final String TAG = "MapActivity --> ***********";

    private ImageView mImageView;
    private CheckBox replace;
    private boolean flag = true;//判断是否是第一次点击
    private FrameLayout framelayout;


    @Override
    protected int setLayout() {
        overridePendingTransition(R.anim.activity_enter, R.anim.activity_exit);
        return R.layout.activity_map;
    }

    @Override
    protected void initView() {

        mImageView = (ImageView) findViewById(R.id.activity_map_back);
        replace = (CheckBox) findViewById(R.id.activity_map_replace);
        framelayout = (FrameLayout) findViewById(R.id.activity_map_frame);
    }

    @Override
    protected void initDate() {


        mImageView.setOnClickListener(this);
        replace.setOnClickListener(this);

        if(getIntent().getStringExtra("tag").equals("map")){
            replaceFragment(new MapFragment());
        }else {
            ListFragment fragment = new ListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("tag",getIntent().getStringExtra("tag"));
            fragment.setArguments(bundle);
            replaceFragment(fragment);
            replace.setChecked(true);
            flag = false;
        }
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.activity_into, R.anim.activity_out);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_map_back:
                finish();
                break;

            case R.id.activity_map_replace:
                if(flag){
                    applyRotation(true, new ListFragment(), 0, 90);
                    flag = false;
                }else {
                    applyRotation(false, new MapFragment(), 0, -90);
                    flag = true;
                }
                break;
        }
    }

    public void replaceFragment(Fragment fragment){

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.activity_map_frame,fragment);
        transaction.commit();
    }

    /**
     * 设置一个新的三维旋转的容器视图。只翻一般，然后设置新的现实内容
     *
     * @param zheng
     *            一个判断机制 如果为true 则向右翻转，如果false则向左翻转
     * @param fragment
     *            传入的片段
     * @param start
     *            起始位置
     * @param end
     *            结束位置
     */
    public void applyRotation(final boolean zheng, final Fragment fragment, final float start, final float end) {
        // Find the center of the container
        final float centerX = framelayout.getWidth() / 2.0f;
        final float centerY = framelayout.getHeight() / 2.0f;

        // Create a new 3D rotation with the supplied parameter
        // The animation listener is used to trigger the next animation
        final Util_Rotate3DAnimation rotation = new Util_Rotate3DAnimation(
                start, end, centerX, centerY, 310.0f, true);
        rotation.setDuration(500);//翻转时间
        rotation.setFillAfter(true); //动作完成后留在完成的那个界面
        //被用来修饰动画效果,定义动画的变化率
        //  AccelerateInterpolator  在动画开始的地方速率改变比较慢，然后开始加速
        rotation.setInterpolator(new AccelerateInterpolator());
        // 添加监听执行现实内容的切换
        rotation.setAnimationListener(new DisplayNextView(zheng, fragment));
        framelayout.startAnimation(rotation);// 执行上半场翻转动画 是第一个界面在翻转
    }

    /**
     * 执行完上半部分旋转之后，设置要显示的新的View然后继续执行下半部分旋转(下半场翻转是第二个界面在翻转)
     */
    private final class DisplayNextView implements Animation.AnimationListener {
        private final boolean mPosition;
        private final Fragment mfragment;

        private DisplayNextView(boolean zheng, Fragment fragment) {
            mPosition = zheng;
            mfragment = fragment;
        }

        public void onAnimationStart(Animation animation) {
        }

        //动画结束时调用
        public void onAnimationEnd(Animation animation) {
            framelayout.post(new SwapViews(mPosition, mfragment));// 添加新的View
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    /**
     * 添加要显示的新的View，并执行下半部分的旋转操作
     */
    private final class SwapViews implements Runnable {
        private final boolean mPosition;
        private final Fragment mfragment;

        public SwapViews(boolean position, Fragment fragment) {
            mPosition = position;
            mfragment = fragment;
        }

        public void run() {
            final float centerX = framelayout.getWidth() / 2.0f;
            final float centerY = framelayout.getHeight() / 2.0f;
            Util_Rotate3DAnimation rotation;
            FragmentTransaction tration = getSupportFragmentManager().beginTransaction();
            tration.replace(R.id.activity_map_frame, mfragment);
            if (mPosition) {
                rotation = new Util_Rotate3DAnimation(-90, 0, centerX, centerY,
                        310.0f, false);
            } else {
                rotation = new Util_Rotate3DAnimation(90, 0, centerX, centerY,
                        310.0f, false);
            }
            tration.commit();
            rotation.setDuration(500);
            rotation.setFillAfter(true);
            rotation.setInterpolator(new DecelerateInterpolator());
            //fragment的动画效果,还可以用祯布局的startAnimation()方法来添加
            framelayout.startAnimation(rotation);
        }

    }

}
