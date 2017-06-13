package com.tae.mobile.android.weatherapp.presenter;

import com.tae.mobile.android.weatherapp.pojo.ResponseModel;
import com.tae.mobile.android.weatherapp.presentation.WeatherView;
import com.tae.mobile.android.weatherapp.service.ApiService;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by Pippo on 5/16/2017.
 */

public class WeatherPresenter {

    private final ApiService mApiService;
    private final WeatherView mWeatherView;

    public WeatherPresenter(WeatherView weatherView, ApiService apiService) {
        mWeatherView = weatherView;
        mApiService = apiService;
    }

    public void getWeather(String location) {
        mWeatherView.onShowDialog("Loading....");
        mApiService.getWeather(location, new Consumer<ResponseModel>() {
            @Override
            public void accept(@NonNull ResponseModel responseModel) throws Exception {
                mWeatherView.onData(responseModel);
                mWeatherView.onHideDialog();
            }
        });
    }
}
