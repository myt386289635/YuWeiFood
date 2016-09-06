package com.example.dllo.recycleviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        data = new ArrayList<>();
        for (int i = 0; i <50 ; i++) {
            data.add("heiheihei");

        }
        BaseAdapter<String> adapter = new BaseAdapter<String>
                (R.layout.item,this,data){

            @Override
            public void convert(ViewHolder holder, String s) {
               holder.setText(R.id.item_tv,"");
            }
        };
        recyclerView.setAdapter(adapter);

    }
}
