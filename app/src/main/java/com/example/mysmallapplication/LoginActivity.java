package com.example.mysmallapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private MyDBHelper dbHelper;
    private EditText editName,editPassword;
    private TextView textViewRegister,textViewFindPrd;
    private Button btnSubmit;
    private CheckBox rem_pw,auto_login;
    private int requestCode = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editName = findViewById(R.id.editName);
        editPassword=findViewById(R.id.editPassword);
        textViewRegister = findViewById(R.id.textViewRes);
        textViewFindPrd = findViewById(R.id.textViewFindPrd);
        btnSubmit=findViewById(R.id.btnSubmit);
        rem_pw=findViewById(R.id.rem_pw);
        auto_login=findViewById(R.id.auto_login);
        dbHelper = new MyDBHelper(LoginActivity.this,"user.db",null,1);

        SharedPreferences preferences = getSharedPreferences("preferences",MODE_PRIVATE);
        if(preferences.getBoolean("remember",false))
        {
            rem_pw.setChecked(true);
            editName.setText(preferences.getString("name", ""));
            editPassword.setText(preferences.getString("password", ""));
          /*  editName.setText("");
            editPassword.setText("");*/
            //判断自动登陆多选框状态
            if(preferences.getBoolean("AUTO_ISCHECK", false))
            {
                Intent intent = new Intent(LoginActivity.this,MainPageActivity.class);
                LoginActivity.this.startActivity(intent);
            }
        }

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stringName = editName.getText().toString();
                String stringPassword = editPassword.getText().toString();
                if(TextUtils.isEmpty(stringName)){
                    Toast.makeText(LoginActivity.this, "用户名为空", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(stringPassword)){
                    Toast.makeText(LoginActivity.this, "密码为空", Toast.LENGTH_SHORT).show();
                }else{
                      SharedPreferences preferences = getSharedPreferences("preferences",MODE_PRIVATE);
                       SharedPreferences.Editor editor = preferences.edit();
                    if (login(stringName,stringPassword)) {
                        if(rem_pw.isChecked())
                        {
                            //记住用户名、密码
                            editor.putString("name", stringName);
                            editor.putString("password",stringPassword);
                            editor.commit();
                        }
                        Intent intent = new Intent(LoginActivity.this,MainPageActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, "用户名与密码不匹配", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        textViewRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        textViewFindPrd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                /*Intent intent = new Intent(LoginActivity.this,FindPasswordActivity.class);
                startActivity(intent);*/
            }
        });

        rem_pw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                if (rem_pw.isChecked()) {
                    SharedPreferences preferences = getSharedPreferences("preferences",MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean("remember", true);
                    editor.commit();

                }else {
                    SharedPreferences preferences = getSharedPreferences("preferences",MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean("remember", false);
                    editor.commit();
                }
            }
        });

        auto_login.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                if (auto_login.isChecked()) {
                    System.out.println("自动登录已选中");
                    SharedPreferences preferences = getSharedPreferences("preferences",MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean("AUTO_ISCHECK", true);
                    editor.commit();
                } else {
                    System.out.println("自动登录没有选中");
                    SharedPreferences preferences = getSharedPreferences("preferences",MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean("AUTO_ISCHECK", false);
                    editor.commit();
                }
            }
        });

    }

    public boolean login(String username, String password) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql = "select* from user where name=? and password=?";
        Cursor cursor = db.rawQuery(sql, new String[]{username, password});
        if (cursor.moveToFirst()==true) {
            cursor.close();
            return true;
        }
        return false;
    }



}

