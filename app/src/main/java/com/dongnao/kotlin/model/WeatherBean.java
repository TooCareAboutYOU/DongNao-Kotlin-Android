package com.dongnao.kotlin.model;

import com.google.gson.Gson;

import org.jetbrains.anko.db.ClassParserConstructor;

import java.io.Serializable;

/**
 * {
 * "date": "28",
 * "high": "高温 18℃",
 * "low": "低温 8℃",
 * "ymd": "2019-10-28",
 * "week": "星期一",
 * "sunrise": "06:32",
 * "sunset": "17:17",
 * "fx": "北风",
 * "fl": "4-5级",
 * "type": "晴",
 * "notice": "愿你拥有比阳光明媚的心情"
 * }
 *
 * @author zhangshuai
 */

public class WeatherBean implements Serializable {

    private static final long serialVersionUID = 912498014735550072L;

    public static final String TABLE_NAME = "Db_Weather";

    public static final String ID = "id";
    public static final String DATE = "date";
    public static final String HIGH = "high";
    public static final String LOW = "low";
    public static final String YMD = "ymd";
    public static final String WEEK = "week";
    public static final String SUNRISE = "sunrise";
    public static final String SUNSET = "sunset";
    public static final String FX = "fx";
    public static final String FL = "fl";
    public static final String TYPE = "type";
    public static final String NOTICE = "notice";

    //演示自定义parser
//    public WeatherBean(int _id) {
//        this._id = _id;
//    }
//
//    public int _id;

    private int id;
    private String date;
    private String high;
    private String low;
    private String ymd;
    private String week;
    private String sunrise;
    private String sunset;
    private String fx;
    private String fl;
    private String type;
    private String notice;

    @ClassParserConstructor
    public WeatherBean(int id, String date, String high, String low, String ymd, String week, String sunrise, String sunset, String fx, String fl, String type, String notice) {
        this.id = id;
        this.date = date;
        this.high = high;
        this.low = low;
        this.ymd = ymd;
        this.week = week;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.fx = fx;
        this.fl = fl;
        this.type = type;
        this.notice = notice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getYmd() {
        return ymd;
    }

    public void setYmd(String ymd) {
        this.ymd = ymd;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getFx() {
        return fx;
    }

    public void setFx(String fx) {
        this.fx = fx;
    }

    public String getFl() {
        return fl;
    }

    public void setFl(String fl) {
        this.fl = fl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
