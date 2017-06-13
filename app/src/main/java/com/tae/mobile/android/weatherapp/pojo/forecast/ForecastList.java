package com.tae.mobile.android.weatherapp.pojo.forecast;

/**
 * Created by Pippo on 5/16/2017.
 */

public class ForecastList {

    private Clouds clouds;

    private Long dt;

    private Wind wind;

    private Sys sys;

    private Weather[] weather;

    private String dt_txt;

    private Main main;

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Long getDt() {
        return dt;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public Weather[] getWeather() {
        return weather;
    }

    public void setWeather(Weather[] weather) {
        this.weather = weather;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    @Override
    public String toString() {
        return "ClassPojo [clouds = " + clouds + ", dt = " + dt + ", wind = " + wind + ", sys = " + sys + ", weather = " + weather + ", dt_txt = " + dt_txt + ", main = " + main + "]";
    }
}
