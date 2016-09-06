package com.example.dllo.liteormdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.litesuits.orm.LiteOrm;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Person> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LiteOrm liteOrm = LiteOrm.newCascadeInstance(this,"My.db");

    Person person = new Person(0,"张三",20);
        liteOrm.insert(person);
        //
        data = new ArrayList<>();
        for (int i = 0; i <50 ; i++) {
            Person person1 = new Person(i,"第三个"+1,20+i);
            data.add(person1);
        }
        liteOrm.save(data);
        Person person2 = new Person(10,"lisi",100);
        //添加集合
        liteOrm.save(person2);
        liteOrm.delete(person2);
//        liteOrm.deleteAll(person2.getClass());
        List<Person> list = liteOrm.query(Person.class);
        Log.d("MainActivity", "person2:" + person2);




}}
