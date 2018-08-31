package com.example.mysmallapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
/**
 * Created by 曾道喜 on 2018/8/29.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class YCityAdapter extends ArrayAdapter {
    private final int resourceId;

    public YCityAdapter(Context context, int textViewResourceId, List<YCity> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        YCity city = (YCity) getItem(position); // 获取当前项的Fruit实例
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);//实例化一个对象
        TextView cityName = view.findViewById(R.id.tvStartCity);//获取该布局内的文本视图
        TextView cityName2 = view.findViewById(R.id.tvEndCity);//获取该布局内的文本视图
        cityName.setText(city.getName());//为文本视图设置文本内容
        cityName2.setText(city.getName2());
        return view;
    }
}

