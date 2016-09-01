package com.example.dllo.yuweifood;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.TextView;

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

    }

    @Override
    protected void initDate() {

        mRadioButton_recommend.setOnClickListener(this);
        mRadioButton_food.setOnClickListener(this);
        mRadioButton_mine.setOnClickListener(this);
        mRadioButton_local.setOnClickListener(this);

        mRadioButtons = new RadioButton[]{mRadioButton_recommend, mRadioButton_local, mRadioButton_food, mRadioButton_mine};
        mTextViews  = new TextView[]{mTextView_recommend, mTextView_local, mTextView_food, mTextView_mine};

        replaceFragment(new RecommendFragment());
    }

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

}
