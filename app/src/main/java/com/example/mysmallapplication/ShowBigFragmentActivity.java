package com.example.mysmallapplication;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class ShowBigFragmentActivity extends AppCompatActivity {
    LinearLayout frament_contant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_big_fragment);
        frament_contant= (LinearLayout) findViewById(R.id.frament_contant);
        Intent intent=getIntent();
        int bigMake=intent.getIntExtra("bigMake",0);
        SelectFragment1 bigMakeFragment=new SelectFragment1();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frament_contant,bigMakeFragment).commit();

    }
}
