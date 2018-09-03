package com.example.mysmallapplication;

import java.io.Serializable;

/**
 * Created by 曾道喜 on 2018/8/29.
 */
//1) 定义一个实体类 YCity，作为 ListView 适配器的适配类型。
public class YCity implements Serializable {
    private String city1;//出发车站
    private String city2;//到达城市
    private String checi;//车次
    private String time1;//时间
    private String tvStartTime;//出发时间
    private String tvEndTime;//到达时间
    private String shangwu;//商务
    private String yideng;//一等
    private String erdeng;//二等



    public YCity(String city1, String city2, String checi, String time1,
                 String tvstartTime, String tvEndTime, String shangwu,
                 String yideng, String erdeng) {
        this.city1 = city1;
        this.city2 = city2;
        this.checi = checi;
        this.time1 = time1;
        this.tvStartTime = tvstartTime;
        this.tvEndTime = tvEndTime;
        this.shangwu = shangwu;
        this.yideng = yideng;
        this.erdeng = erdeng;

    }

    public String getCity1() {
        return city1;
    }

    public String getCity2() {
        return city2;
    }

    public String getCheci() {
        return checi;
    }

    public String getTime1() {
        return time1;
    }

    public String getTvStartTime() {
        return tvStartTime;
    }

    public String getTvEndTime() {
        return tvEndTime;
    }

    public String getShangwu() {
        return shangwu;
    }


    public String getYideng() {
        return yideng;
    }



    public String getErdeng() {
        return erdeng;
    }

}

