package com.tae.mobile.android.weatherapp.pojo.forecast;

/**
 * Created by Pippo on 5/16/2017.
 */

public class Sys {

    private String pod;

    public String getPod ()
    {
        return pod;
    }

    public void setPod (String pod)
    {
        this.pod = pod;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [pod = "+pod+"]";
    }
}
