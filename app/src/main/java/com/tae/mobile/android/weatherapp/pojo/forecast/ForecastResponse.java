package com.tae.mobile.android.weatherapp.pojo.forecast;

/**
 * Created by Pippo on 5/16/2017.
 */

public class ForecastResponse {

    private String message;
    private String cnt;
    private String cod;
    private ForecastList[] list;
    private City city;

    public String getMessage() {
        return message;
    }

    public String getCnt() {
        return cnt;
    }

    public String getCod() {
        return cod;
    }

    public ForecastList[] getList() {
        return list;
    }

    public City getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "ForecastResponse [message = " + message + ", cnt = " + cnt + ", cod = " + cod + ", list = " + list + ", city = " + city + "]";
    }
}
