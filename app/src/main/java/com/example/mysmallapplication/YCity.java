package com.example.mysmallapplication;

/**
 * Created by 曾道喜 on 2018/8/29.
 */
//1) 定义一个实体类 YCity，作为 ListView 适配器的适配类型。
public class YCity {
    private String name;
    private String name2;

    public YCity(String name, String name2) {
        this.name = name;
        this.name2 = name2;;
    }

    public String getName() {
        return name;
    }

    public String getName2() {
        return name2;
    }
}

