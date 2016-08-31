package com.example.dllo.yuweifood;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;

import com.example.dllo.yuweifood.food.FoodFragment;
import com.example.dllo.yuweifood.local.LocalFragment;
import com.example.dllo.yuweifood.mine.MineFragment;
import com.example.dllo.yuweifood.recommend.RecommendFragment;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private RadioButton mRadioButton_recommend,mRadioButton_local,mRadioButton_food,mRadioButton_mine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRadioButton_recommend = (RadioButton) findViewById(R.id.btn_recommend);
        mRadioButton_local = (RadioButton) findViewById(R.id.btn_local);
        mRadioButton_food = (RadioButton) findViewById(R.id.btn_food);
        mRadioButton_mine = (RadioButton) findViewById(R.id.btn_mine);

        mRadioButton_recommend.setOnClickListener(this);
        mRadioButton_food.setOnClickListener(this);
        mRadioButton_mine.setOnClickListener(this);
        mRadioButton_local.setOnClickListener(this);

        replaceFragment(new RecommendFragment());
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_recommend:

                replaceFragment(new RecommendFragment());
                break;

            case R.id.btn_local:

                replaceFragment(new LocalFragment());
                break;
            case R.id.btn_food:

                replaceFragment(new FoodFragment());
                break;
            case R.id.btn_mine:

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
