package com.tae.mobile.android.weatherapp.pojo;

/**
 * Created by Pippo on 5/16/2017.
 */

public class Forecast {

    private String state;
    private String description;
    private String temperature;
    private Long date;
    private String iconURL;

    public void setState(String state) {
        this.state = state;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public String getDescription() {
        return description;
    }

    public String getTemperature() {
        return temperature;
    }

    public Long getDate() {
        return date;
    }

    public String getIconURL() {
        return iconURL;
    }

    public void setIconURL(String iconURL) {

        this.iconURL = iconURL;
    }
}
