package com.tae.mobile.android.weatherapp.presentation;

import com.tae.mobile.android.weatherapp.pojo.ResponseModel;

/**
 * Created by Pippo on 5/16/2017.
 */

public interface WeatherView {

    void onShowDialog(String message);

    void onData(ResponseModel model);

    void onShowToast(String message);

    void onHideDialog();
}
