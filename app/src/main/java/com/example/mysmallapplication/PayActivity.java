package com.example.mysmallapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PayActivity extends AppCompatActivity {


    private ImageView pic_contact_back;
    private TextView tvTrainNum1,tvStartCity,tvEndCity,tvStartTime,tvEndTime,startTime;
    private Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        btnSubmit = findViewById(R.id.btnSubmit);
        pic_contact_back = findViewById(R.id.pic_contact_back);
        tvTrainNum1 = findViewById(R.id.tvTrainNum1);
        tvStartCity = findViewById(R.id.tvStartCity);
        tvEndCity = findViewById(R.id.tvEndCity);
        tvStartTime =findViewById(R.id.tvStartTime);
        tvEndTime = findViewById(R.id.tvEndTime);
        startTime = findViewById(R.id.startTime);

        Intent intent = getIntent();
        tvTrainNum1.setText(intent.getStringExtra("tvTrainNum1"));
        tvStartCity.setText(intent.getStringExtra("tvStartCity"));
        tvEndCity.setText(intent.getStringExtra("tvEndCity"));
        tvStartTime.setText(intent.getStringExtra("tvStartTime"));
        tvEndTime.setText(intent.getStringExtra("tvEndTime"));
        startTime.setText(intent.getStringExtra("startTime"));

        pic_contact_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PayActivity.this,PayCompleteActivity.class);
                startActivity(intent);
            }
        });

    }
}
