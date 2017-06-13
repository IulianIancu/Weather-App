package com.tae.mobile.android.weatherapp.service;

import com.tae.mobile.android.weatherapp.api.ApiSignature;
import com.tae.mobile.android.weatherapp.base.BaseService;
import com.tae.mobile.android.weatherapp.helper.WeatherMapper;
import com.tae.mobile.android.weatherapp.pojo.ResponseModel;
import com.tae.mobile.android.weatherapp.pojo.forecast.ForecastResponse;
import com.tae.mobile.android.weatherapp.pojo.weather.WeatherResponse;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;

/**
 * Created by Pippo on 5/16/2017.
 */

public class ApiService extends BaseService {

    private final ApiSignature mSignature;
    private final WeatherMapper mWeatherMapper;

    public ApiService(ApiSignature signature, WeatherMapper weatherMapper) {
        mSignature = signature;
        mWeatherMapper = weatherMapper;
    }

    public void getWeather(String location, Consumer<ResponseModel> observer) {
        BiFunction<WeatherResponse, ForecastResponse, ResponseModel> function = new BiFunction<WeatherResponse, ForecastResponse, ResponseModel>() {
            @Override
            public ResponseModel apply(@NonNull WeatherResponse weatherResponse, @NonNull ForecastResponse forecastResponse) throws Exception {
                return mWeatherMapper.mapResponse(weatherResponse, forecastResponse);
            }
        };
        subscribe(zip(mSignature.getCurrentWeather(location, APP_ID),
                mSignature.getForecast(location, APP_ID), function), observer);
    }
}
