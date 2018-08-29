package com.example.mysmallapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class BookOrderActivity extends AppCompatActivity {
    private ImageView pic_contact_back;
    private List<YCity> cityList = new ArrayList<YCity>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_order);
        pic_contact_back =  findViewById(R.id.pic_contact_back);
        pic_contact_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        initData(); // 初始化水果数据
        YCityAdapter adapter = new YCityAdapter(BookOrderActivity.this, R.layout.ycity_item, cityList);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }

    private void initData() {
        YCity c1 = new YCity("深圳","成都");
        cityList.add(c1);
        YCity c2 = new YCity("广州","上海");
        cityList.add(c2);
        YCity c3 = new YCity("南京","成都");
        cityList.add(c3);
        YCity c4 = new YCity("深圳","北京");
        cityList.add(c4);
        YCity c5 = new YCity("福建","成都");
        cityList.add(c5);
        YCity c6 = new YCity("深圳","天津");
        cityList.add(c6);
        YCity c7 = new YCity("云南","成都");
        cityList.add(c7);
        YCity c8 = new YCity("南京","成都");
        cityList.add(c8);
        YCity c9 = new YCity("南京","天津");
        cityList.add(c9);
        YCity cw = new YCity("浙江","成都");
        cityList.add(cw);
    }
}
