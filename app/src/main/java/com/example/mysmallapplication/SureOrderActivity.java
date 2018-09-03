package com.example.mysmallapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;

public class SureOrderActivity extends AppCompatActivity {

    private ImageView pic_contact_back,addPeople;
    private TextView addPeo,people,tvTrainNum1,tvStartCity,tvEndCity,durationtime,tvStartTime,tvEndTime,shangwu,yideng,erdeng,wuzuo,startTime;
    private Button btnSure;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sure_order);
        pic_contact_back = findViewById(R.id.pic_contact_back);
        btnSure = findViewById(R.id.btnSubmit);
        addPeople = findViewById(R.id.addPeople);
        addPeo = findViewById(R.id.addPeo);
        tvTrainNum1 = findViewById(R.id.tvTrainNum1);
        tvStartCity = findViewById(R.id.tvStartCity);
        tvEndCity = findViewById(R.id.tvEndCity);
        durationtime = findViewById(R.id.durationtime);
        tvStartTime =findViewById(R.id.tvStartTime);
        tvEndTime = findViewById(R.id.tvEndTime);
        shangwu = findViewById(R.id.shangwu);
        yideng = findViewById(R.id.yideng);
        erdeng = findViewById(R.id.erdeng);
        wuzuo = findViewById(R.id.wuzuo);
        startTime = findViewById(R.id.startTime);

        Intent intent = getIntent();
        YCity ycity= (YCity) intent.getSerializableExtra("ycity");
        tvTrainNum1.setText(ycity.getCheci());
        tvStartCity.setText(ycity.getCity1());
        tvEndCity.setText(ycity.getCity2());
        durationtime.setText(ycity.getTime1());
        tvStartTime.setText(ycity.getTvStartTime());
        tvEndTime.setText(ycity.getTvEndTime());
        shangwu.setText(ycity.getShangwu());
        yideng.setText(ycity.getYideng());
        erdeng.setText(ycity.getErdeng());
        startTime.setText(intent.getStringExtra("date"));


        pic_contact_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(SureOrderActivity.this,PayActivity.class);
               intent.putExtra("tvTrainNum1",tvTrainNum1.getText());
               intent.putExtra("tvStartCity",tvStartCity.getText());
               intent.putExtra("tvEndCity",tvEndCity.getText());
               intent.putExtra("tvStartTime",tvStartTime.getText());
               intent.putExtra("tvEndTime",tvEndTime.getText());
               intent.putExtra("shangwu",shangwu.getText());
               intent.putExtra("yideng",yideng.getText());
               intent.putExtra("erdeng",erdeng.getText());
                intent.putExtra("wuzuo",wuzuo.getText());
                intent.putExtra("startTime",startTime.getText());
                startActivity(intent);
            }
        });
        addPeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SureOrderActivity.this,SelectPeopleActivity.class);
                startActivityForResult(intent,0x003);
            }
        });

        addPeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SureOrderActivity.this,SelectPeopleActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case 0x003:
                    String date = data.getExtras().getString("people");
                    if (date != null) {
                        people.setText(date);
                    }
                    break;
            }
        }
    }
}
