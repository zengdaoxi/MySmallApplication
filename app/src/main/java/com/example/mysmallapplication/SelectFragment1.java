package com.example.mysmallapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zaaach.citypicker.CityPicker;
import com.zaaach.citypicker.adapter.OnPickListener;
import com.zaaach.citypicker.model.City;
import com.zaaach.citypicker.model.HotCity;
import com.zaaach.citypicker.model.LocateState;
import com.zaaach.citypicker.model.LocatedCity;

import java.util.ArrayList;
import java.util.List;

public class SelectFragment1 extends Fragment {

    private TextView selectDate;
    private ImageView change,addPeople;
    private TextView fromcity,tocity;
    private TextView selectTime,loctype,addPeo;
    private Button btnSubmit;
    String strFrom;
    String strTo;
    private int picwhich = 0;

    public SelectFragment1() {
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.select_fragment1, container, false);
        selectDate = view.findViewById(R.id.selectDate);
        change = view.findViewById(R.id.change);
        fromcity = view.findViewById(R.id.from);
        tocity = view.findViewById(R.id.to);
        selectTime = view.findViewById(R.id.selectTime);
        loctype = view.findViewById(R.id.loctype);
        addPeople = view.findViewById(R.id.addPeople);
        addPeo = view.findViewById(R.id.addPeo);

        btnSubmit =view.findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),BookOrderActivity.class);
                startActivity(intent);
            }
        });

        addPeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),SelectPeopleActivity.class);
                startActivity(intent);
            }
        });

        addPeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),SelectPeopleActivity.class);
                startActivity(intent);
            }
        });

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
      //移动动画效果
                change.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        strFrom = fromcity.getText().toString();
                        strTo = tocity.getText().toString();

                        TranslateAnimation animationfrom = new TranslateAnimation(0, 300, 0, 0);
                        animationfrom.setDuration(600);
                        animationfrom.setInterpolator(new AccelerateDecelerateInterpolator());
                        animationfrom.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                tocity.setText(strFrom);
                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {

                            }
                        });

                        TranslateAnimation animationto = new TranslateAnimation(0, -300, 0, 0);
                        animationto.setDuration(600);
                        animationto.setInterpolator(new AccelerateDecelerateInterpolator());
                        animationto.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                fromcity.setText(strTo);
                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {

                            }
                        });
                        fromcity.startAnimation(animationfrom);
                        tocity.startAnimation(animationto);
                    }
                });

            }
        });


        selectTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("请选择时间段");
                final String[] time = new String[]{"00:00-24:00","00:00-06:00","06:00-12:00","12:00-18:00","18:00-24:00"};
                builder.setSingleChoiceItems(time,5, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which){
                                picwhich = which;
                            }});
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        selectTime.setText(time[picwhich]);
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        selectTime.setText(time[0]);
                    }
                });
                builder.create().show();
            }
        });

        loctype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("请选择坐席类别");
                final String[] time = new String[]{"不限","商务座","特等座","一等座","二等座","高级软卧","软卧","硬卧","软座","硬座"};

                builder.setSingleChoiceItems(time,10, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which){
                        picwhich = which;
                    }});
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        loctype.setText(time[picwhich]);
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        loctype.setText(time[0]);
                    }
                });
                builder.create().show();
            }
        });

        fromcity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<HotCity> hotCities = new ArrayList<>();
                hotCities.add(new HotCity("北京", "北京", "101010100"));
                hotCities.add(new HotCity("上海", "上海", "101020100"));
                hotCities.add(new HotCity("广州", "广东", "101280101"));
                hotCities.add(new HotCity("深圳", "广东", "101280601"));
                hotCities.add(new HotCity("杭州", "浙江", "101210101"));

                CityPicker.getInstance()
                        .setFragmentManager(getChildFragmentManager())
                        .setLocatedCity(new LocatedCity("杭州", "浙江", "101210101"))
                        .setHotCities(hotCities)	//指定热门城市
                        .setOnPickListener(new OnPickListener() {
                            @Override
                            public void onPick(int position, City data) {
                               // Toast.makeText(getActivity().getApplicationContext(), data.getName(), Toast.LENGTH_SHORT).show();
                                if(data!=null){
                                    fromcity.setText(data.getName());
                                }
                            }

                            @Override
                            public void onLocate() {
                                //开始定位，这里模拟一下定位
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        //定位完成之后更新数据
                                        CityPicker.getInstance()
                                                .locateComplete(new LocatedCity("深圳", "广东", "101280601"), LocateState.SUCCESS);
                                    }
                                }, 2000);
                            }
                        })
                        .show();
            }
        });

        tocity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<HotCity> hotCities = new ArrayList<>();
                hotCities.add(new HotCity("北京", "北京", "101010100"));
                hotCities.add(new HotCity("上海", "上海", "101020100"));
                hotCities.add(new HotCity("广州", "广东", "101280101"));
                hotCities.add(new HotCity("深圳", "广东", "101280601"));
                hotCities.add(new HotCity("杭州", "浙江", "101210101"));

                CityPicker.getInstance()
                        .setFragmentManager(getChildFragmentManager())
                        .setLocatedCity(new LocatedCity("杭州", "浙江", "101210101"))
                        .setHotCities(hotCities)	//指定热门城市
                        .setOnPickListener(new OnPickListener() {
                            @Override
                            public void onPick(int position, City data) {
                                tocity.setText(data.getName());
                            }

                            @Override
                            public void onLocate() {
                                //开始定位，这里模拟一下定位
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        //定位完成之后更新数据
                                        CityPicker.getInstance()
                                                .locateComplete(new LocatedCity("深圳", "广东", "101280601"), LocateState.SUCCESS);
                                    }
                                }, 2000);
                            }
                        })
                        .show();

            }
        });

        selectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),DateActivity.class);
                startActivityForResult(intent,RequestCodeInfo.DATE);
            }
        });

        return view;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case RequestCodeInfo.DATE:
                    String date = data.getExtras().getString("date");
                    if(date!= null) {
                        selectDate.setText(date);
                    }
                    break;
            }
        }
    }

}
