package com.tae.mobile.android.weatherapp.api;

import com.tae.mobile.android.weatherapp.pojo.forecast.ForecastResponse;
import com.tae.mobile.android.weatherapp.pojo.weather.WeatherResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import io.reactivex.Observable;

/**
 * Created by Pippo on 5/16/2017.
 */

public interface ApiSignature {

    @GET("/data/2.5/weather")
    Observable<WeatherResponse>  getCurrentWeather(@Query("q") String location, @Query("appid") String appId);

    @GET("/data/2.5/forecast")
    Observable<ForecastResponse>  getForecast(@Query("q") String location, @Query("appid") String appId);
}
