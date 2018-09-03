package com.example.mysmallapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class BookOrderActivity extends AppCompatActivity {
    private ImageView pic_contact_back;
    private List<YCity> cityList = new ArrayList<YCity>();
    private int Year,Month,data;
    private String str;
    private TextView tvDate;
    private DatePickerDialog.OnDateSetListener onDateSetListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_order);
        pic_contact_back =  findViewById(R.id.pic_contact_back);
        tvDate = findViewById(R.id.tvDate);
        pic_contact_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Calendar ca = Calendar.getInstance();
        final Calendar temp = Calendar.getInstance();
        Year = ca.get(Calendar.YEAR);
        Month = ca.get(Calendar.MONTH);
        data = ca.get(Calendar.DAY_OF_MONTH);
        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(BookOrderActivity.this, onDateSetListener,Year,Month,data).show();
            }
        });
        onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                if (year >= Year && month >= month && dayOfMonth >= data) {
                    Year = year;
                    Month = month;
                    data = dayOfMonth;
                    StringBuffer days;
                    if ((Month + 1) < 10) {
                        if (data < 10) {
                            days = new StringBuffer().append(Year).append("-").append(0).append(Month + 1).append("-").append(0).append(data).append(" ");
                        } else {
                            days = new StringBuffer().append(Year).append("-").append(0).append(Month + 1).append("-").append(data).append(" ");
                        }

                    } else {
                        if (data < 10) {
                            days = new StringBuffer().append(Year).append("-").append(Month + 1).append("-").append(0).append(data).append(" ");
                        } else {
                            days = new StringBuffer().append(Year).append("-").append(Month + 1).append("-").append(data).append(" ");
                        }
                    }
                    temp.set(year, month, dayOfMonth);
                    tvDate.setText(days);
                }
            }
        };

        initData(); // 初始化
        YCityAdapter adapter = new YCityAdapter(BookOrderActivity.this, R.layout.ycity_item, cityList);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("ycity",cityList.get(position));
                Intent intent=new Intent(BookOrderActivity.this,SureOrderActivity.class);
                intent.putExtras(bundle);
                intent.putExtra("date",tvDate.getText());
                startActivity(intent);
            }
        });
    }

    private void initData() {
        YCity c1 = new YCity("深圳","成都","G102","1小时20分","08:20","09:40","商务：70","一等：10","二等：20");
        cityList.add(c1);
        YCity c2 = new YCity("深圳","成都","G103","4小时20分","09:28","10:40","商务：10","一等：10","二等：20");
        cityList.add(c2);
        YCity c3 = new YCity("深圳","成都","G104","5小时20分","09:20","10:40","商务：10","一等：80","二等：70");
        cityList.add(c3);
        YCity c4 = new YCity("深圳","成都","G105","9小时20分","10:23","14:40","商务：20","一等：10","二等：20");
        cityList.add(c4);
        YCity c5 = new YCity("深圳","成都","G106","2小时20分","11:26","07:40","商务：30","一等：10","二等：20");
        cityList.add(c5);
        YCity c6 = new YCity("深圳","成都","G107","6小时20分","18:20","15:40","商务：40","一等：90","二等：90");
        cityList.add(c6);
        YCity c7 = new YCity("深圳","成都","G108","1小时20分","07:20","09:20","商务：50","一等：10","二等：50");
        cityList.add(c7);
        YCity c8 = new YCity("深圳","成都","G100","9小时20分","08:29","17:40","商务：60","一等：20","二等：20");
        cityList.add(c8);
        YCity c9 = new YCity("深圳","成都","G111","8小时20分","04:20","16:40","商务：70","一等：10","二等：30");
        cityList.add(c9);
        YCity cw = new YCity("深圳","成都","G122","7小时20分","03:20","10:40","商务：80","一等：60","二等：20");
        cityList.add(cw);
    }
}
