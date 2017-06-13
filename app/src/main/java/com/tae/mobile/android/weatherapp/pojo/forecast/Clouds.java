package com.tae.mobile.android.weatherapp.pojo.forecast;

/**
 * Created by Pippo on 5/16/2017.
 */

public class Clouds {

    private String all;

    public String getAll ()
    {
        return all;
    }

    public void setAll (String all)
    {
        this.all = all;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [all = "+all+"]";
    }
}
