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

import com.example.dllo.yuweifood.food.FoodFragment;
import com.example.dllo.yuweifood.local.LocalFragment;
import com.example.dllo.yuweifood.mine.MineFragment;
import com.example.dllo.yuweifood.recommend.RecommendFragment;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private RadioButton mRadioButton_recommend,mRadioButton_local,mRadioButton_food,mRadioButton_mine;
    private TextView mTextView_recommend,mTextView_local,mTextView_food,mTextView_mine;

    private RadioButton[] mRadioButtons;
    private TextView[] mTextViews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRadioButton_recommend = (RadioButton) findViewById(R.id.btn_recommend);
        mRadioButton_local = (RadioButton) findViewById(R.id.btn_local);
        mRadioButton_food = (RadioButton) findViewById(R.id.btn_food);
        mRadioButton_mine = (RadioButton) findViewById(R.id.btn_mine);
        mTextView_recommend = (TextView) findViewById(R.id.btn_recommend_text);
        mTextView_local = (TextView) findViewById(R.id.btn_local_text);
        mTextView_food = (TextView) findViewById(R.id.btn_food_text);
        mTextView_mine = (TextView) findViewById(R.id.btn_mine_text);

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

                for (int i = 0; i < mRadioButtons.length; i++) {
                    if(i == 0){
                        mRadioButtons[i].setChecked(true);
                        mTextViews[i].setTextColor(0xffffa12c);
                    }else {
                        mRadioButtons[i].setChecked(false);
                        mTextViews[i].setTextColor(0xff000000);
                    }

                }
                replaceFragment(new RecommendFragment());
                break;

            case R.id.btn_local:

                for (int i = 0; i < mRadioButtons.length; i++) {
                    if(i == 1){
                        mRadioButtons[i].setChecked(true);
                        mTextViews[i].setTextColor(0xffffa12c);
                    }else {
                        mRadioButtons[i].setChecked(false);
                        mTextViews[i].setTextColor(0xff000000);
                    }

                }
                replaceFragment(new LocalFragment());
                break;
            case R.id.btn_food:
                for (int i = 0; i < mRadioButtons.length; i++) {
                    if(i == 2){
                        mRadioButtons[i].setChecked(true);
                        mTextViews[i].setTextColor(0xffffa12c);
                    }else {
                        mRadioButtons[i].setChecked(false);
                        mTextViews[i].setTextColor(0xff000000);
                    }

                }
                replaceFragment(new FoodFragment());
                break;
            case R.id.btn_mine:
                for (int i = 0; i < mRadioButtons.length; i++) {
                    if(i == 3){
                        mRadioButtons[i].setChecked(true);
                        mTextViews[i].setTextColor(0xffffa12c);
                    }else {
                        mRadioButtons[i].setChecked(false);
                        mTextViews[i].setTextColor(0xff000000);
                    }

                }
                replaceFragment(new MineFragment());
                break;
        }

    }

    public void replaceFragment(Fragment fragment){

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();

    }
}
