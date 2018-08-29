package com.example.mysmallapplication;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private int picwhich = 0 ;
    private MyDBHelper dbHelper;
    private ImageView pic_contact_back;
    private EditText editName,editPassword,editPassword2,type,peopleType;
    private Button btnSubmit,btnCancel;
    private int resultCode = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        pic_contact_back = findViewById(R.id.pic_contact_back);
        editName = findViewById(R.id.editName);
        editPassword = findViewById(R.id.editPassword);
        editPassword2 = findViewById(R.id.editPassword2);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnCancel = findViewById(R.id.btnCancel);
        type = findViewById(R.id.type);
        peopleType = findViewById(R.id.peopleType);

        type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                final String[] time = new String[]{"二代身份证","港澳居民来往内地通行证","台湾居民来往内地通行证","护照"};

                builder.setSingleChoiceItems(time,4, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which){
                        picwhich = which;
                    }});
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        type.setText(time[picwhich]);
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        type.setText(time[0]);
                    }
                });
                builder.create().show();
            }
        });

        peopleType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                final String[] people = new String[]{"成人","儿童","学生","残军"};

                builder.setSingleChoiceItems(people,4, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which){
                        picwhich = which;
                    }});
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        peopleType.setText(people[picwhich]);
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        peopleType.setText(people[0]);
                    }
                });
                builder.create().show();
            }
        });



        pic_contact_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        dbHelper = new MyDBHelper(RegisterActivity.this, "user.db", null, 1);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editName.getText().toString();
                String pwd = editPassword.getText().toString();
                String pwd2 = editPassword2.getText().toString();
                if (CheckIsDataAlreadyInDBorNot(name)) {
                    Toast.makeText(RegisterActivity.this,"该用户名已被注册，注册失败",Toast.LENGTH_SHORT).show();
                }
                else {
                    if (register(name, pwd, pwd2)) {
                        Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            String name = editName.getText().toString();
            String pwd = editPassword.getText().toString();
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                intent.putExtra("name",name);
                intent.putExtra("pwd",pwd);
                setResult(resultCode,intent);
                finish();
            }
        });
    }

    public boolean register(String username,String password,String password2){
        SQLiteDatabase db= dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        if(username.trim().equals("") || password.trim().equals("") || password2.trim().equals("")) {
            Toast.makeText(RegisterActivity.this, "用户名、密码或确认密码不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }else if(!(password.trim().equals(password2.trim()))){
            Toast.makeText(RegisterActivity.this, "两次密码输入不一致", Toast.LENGTH_SHORT).show();
            return false;
        }else {
            values.put("name", username);
            values.put("password", password);
            db.insert("user",null,values);
            db.close();
            return true;
        }
    }

    //检验用户名是否已存在
    public boolean CheckIsDataAlreadyInDBorNot(String value){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        String Query = "Select * from user where name =?";
        Cursor cursor = db.rawQuery(Query,new String[] { value });
        if (cursor.getCount()>0){
            cursor.close();
            return  true;
        }
        cursor.close();
        return false;
    }
}

