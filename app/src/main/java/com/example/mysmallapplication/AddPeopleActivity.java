package com.example.mysmallapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AddPeopleActivity extends AppCompatActivity {
    private ImageView pic_contact_back;
    private TextView completeAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_people);
        pic_contact_back = findViewById(R.id.pic_contact_back);
        completeAdd = findViewById(R.id.completeAdd);
        pic_contact_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        completeAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddPeopleActivity.this,SelectPeopleActivity.class);
                startActivity(intent);
            }
        });
    }
}
