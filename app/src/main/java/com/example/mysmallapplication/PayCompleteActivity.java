package com.example.mysmallapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PayCompleteActivity extends AppCompatActivity {


    private ImageView pic_contact_back;
    private Button readorder,btnReSt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_complete);
        pic_contact_back = findViewById(R.id.pic_contact_back);
        readorder = findViewById(R.id.readorder);//查看订单
        btnReSt = findViewById(R.id.btnReSt);//继续购票
        pic_contact_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        readorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PayCompleteActivity.this,OrderFragment3.class);
                startActivity(intent);
            }
        });

        btnReSt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PayCompleteActivity.this,SelectFragment1.class);
                startActivity(intent);
            }
        });
    }
}
