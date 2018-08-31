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

public class SureOrderActivity extends AppCompatActivity {

    private ImageView pic_contact_back,addPeople;
    private TextView addPeo,people;
    private Button btnSure;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sure_order);
        pic_contact_back = findViewById(R.id.pic_contact_back);
        btnSure = findViewById(R.id.btnSubmit);
        addPeople = findViewById(R.id.addPeople);
        addPeo = findViewById(R.id.addPeo);
        people = findViewById(R.id.People);
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
               startActivity(intent);
            }
        });
        addPeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SureOrderActivity.this,SelectPeopleActivity.class);
                startActivityForResult(intent,0);
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
                case 0:
                    String date = data.getExtras().getString("people");
                    if (date != null) {
                        people.setText(date);
                    }
                    break;
            }
        }
    }
}
