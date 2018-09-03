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
        YCity city = (YCity) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);//实例化一个对象
        TextView cityName = view.findViewById(R.id.tvStartCity);//获取该布局内的文本视图
        TextView cityName2 = view.findViewById(R.id.tvEndCity);//获取该布局内的文本视图
        TextView tvTrainNum = view.findViewById(R.id.tvTrainNum);//获取该布局内的文本视图
        TextView tvDuration = view.findViewById(R.id.tvDuration);//获取该布局内的文本视图
        TextView tvStartTime = view.findViewById(R.id.tvStartTime);//获取该布局内的文本视图
        TextView tvEndTime = view.findViewById(R.id.tvEndTime);//获取该布局内的文本视图
        TextView shangwu = view.findViewById(R.id.shangwu);//获取该布局内的文本视图
        TextView yideng = view.findViewById(R.id.yideng);
        TextView erdeng = view.findViewById(R.id.erdeng);

        cityName.setText(city.getCity1());//为文本视图设置文本内容
        cityName2.setText(city.getCity2());
        tvTrainNum.setText(city.getCheci());//为文本视图设置文本内容
        tvDuration.setText(city.getTime1());
        tvStartTime.setText(city.getTvStartTime());//为文本视图设置文本内容
        tvEndTime.setText(city.getTvEndTime());
        shangwu.setText(city.getShangwu());//为文本视图设置文本内容
        yideng.setText(city.getYideng());//为文本视图设置文本内容
        erdeng.setText(city.getErdeng());//为文本视图设置文本内容
        return view;
    }
}

