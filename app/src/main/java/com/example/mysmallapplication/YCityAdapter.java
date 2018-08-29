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
        YCity fruit = (YCity) getItem(position); // 获取当前项的Fruit实例
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);//实例化一个对象
        //ImageView fruitImage = (ImageView) view.findViewById(R.id.fruit_image);//获取该布局内的图片视图
        TextView fruitName = (TextView) view.findViewById(R.id.tvStartCity);//获取该布局内的文本视图
        TextView fruitName2 = (TextView) view.findViewById(R.id.tvEndCity);//获取该布局内的文本视图
        //fruitImage.setImageResource(fruit.getImageId());//为图片视图设置图片资源
        fruitName.setText(fruit.getName());//为文本视图设置文本内容
        fruitName2.setText(fruit.getName2());
        return view;
    }
}

