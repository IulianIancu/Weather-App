package com.tae.mobile.android.weatherapp.pojo.weather;

/**
 * Created by Pippo on 5/16/2017.
 */

public class Coord {

    private String lon;

    private String lat;

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "ClassPojo [lon = " + lon + ", lat = " + lat + "]";
    }
}
