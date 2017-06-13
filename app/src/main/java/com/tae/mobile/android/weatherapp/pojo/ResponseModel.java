package com.tae.mobile.android.weatherapp.pojo;

import java.util.List;

/**
 * Created by Pippo on 5/16/2017.
 */

public class ResponseModel {

    private String temperature;
    private String location;
    private String weatherIcon;
    private String state;
    private Long observationDate;
    private List<Forecast> forecastList;

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setWeatherIcon(String weatherIcon) {
        this.weatherIcon = weatherIcon;
    }

    public void setState(String state) {
        this.state = state;
    }


    public void setObservationDate(Long observationDate) {
        this.observationDate = observationDate;
    }

    public void setForecastList(List<Forecast> forecastList) {
        this.forecastList = forecastList;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getLocation() {
        return location;
    }

    public String getWeatherIcon() {
        return weatherIcon;
    }

    public String getState() {
        return state;
    }

    public Long getObservationDate() {
        return observationDate;
    }

    public List<Forecast> getForecastList() {
        return forecastList;
    }
}
