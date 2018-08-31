package com.example.mysmallapplication;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.mysmallapplication.SelectPeoAdapter.ViewC;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class SelectPeopleActivity extends AppCompatActivity {

    private TextView CompleteSelPeople;
    private ImageView pic_contact_back;
    private ImageView addPeople;
    private List<HashMap<String,Object>> list;
    private ListView listView;
    private SelectPeoAdapter sbAdapter;
    private List<String> listStr = new ArrayList<String>();
    String[] name = new String[]{"曾道喜","王小明","王晓光","曾道喜","王小明"};
    String[] number = new String[]{"510112*********730","510112*********730","510112*********730","510112*********730","510112*********730"};
    String[] piao = new String[]{"成人票","成人票","学生票","学生票","学生票"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_people);
        addPeople = findViewById(R.id.addPeople);
        CompleteSelPeople = findViewById(R.id.CompleteSelPeople);
        pic_contact_back = findViewById(R.id.pic_contact_back);
        listView = findViewById(R.id.list_view);

        list = new ArrayList<HashMap<String,Object>>();
        for(int i=0;i<=4;i++){
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("name", name[i]);
            map.put("number", number[i]);
            map.put("piao", piao[i]);
            map.put("boolean", false);//初始化为未选
            list.add(map);
        }
        sbAdapter = new SelectPeoAdapter(this,list);
        listView.setAdapter(sbAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                ViewC viewCache = (ViewC) view.getTag();
                viewCache.cb.toggle();
                list.get(position).put("boolean", viewCache.cb.isChecked());
                sbAdapter.notifyDataSetChanged();

                if(viewCache.cb.isChecked()){//被选中状态
                    listStr.add(list.get(position).get("name").toString());
                }else//从选中状态转化为未选中
                {
                    listStr.remove(list.get(position).get("name").toString());
                }
            }
        });

        pic_contact_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        CompleteSelPeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                intent.putExtra("people", (Serializable) listStr);
                setResult(RESULT_OK,intent);
            }
        });

        addPeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectPeopleActivity.this,AddPeopleActivity.class);
                startActivity(intent);
            }
        });
    }
}
