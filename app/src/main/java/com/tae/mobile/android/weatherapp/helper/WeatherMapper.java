package com.tae.mobile.android.weatherapp.helper;

import android.support.annotation.NonNull;

import com.tae.mobile.android.weatherapp.pojo.Forecast;
import com.tae.mobile.android.weatherapp.pojo.ResponseModel;
import com.tae.mobile.android.weatherapp.pojo.forecast.ForecastList;
import com.tae.mobile.android.weatherapp.pojo.forecast.ForecastResponse;
import com.tae.mobile.android.weatherapp.pojo.weather.Weather;
import com.tae.mobile.android.weatherapp.pojo.weather.WeatherResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pippo on 5/16/2017.
 */

public class WeatherMapper {

    public ResponseModel mapResponse(WeatherResponse weatherResponse, ForecastResponse forecastResponse) {
        ResponseModel model = new ResponseModel();
        if (weatherResponse != null) {
            model.setTemperature(weatherResponse.getMain().getTemp());
            model.setLocation(weatherResponse.getName());
            model.setObservationDate(weatherResponse.getDt());

            Weather[] weather = weatherResponse.getWeather();
            if (weather != null) {
                Weather weather1 = weather[0];
                model.setWeatherIcon(getIconURL(weather1.getIcon()));
                model.setState(weather1.getMain());
            }
        }

        if (forecastResponse != null) {
            List<Forecast> forecastList = new ArrayList<>();

            ForecastList[] forecastLists = forecastResponse.getList();
            for (int i = 0; i < forecastLists.length; i++) {
                ForecastList list = forecastLists[i];
                Forecast forecast = new Forecast();
                com.tae.mobile.android.weatherapp.pojo.forecast.Weather weather = list.getWeather()[0];
                forecast.setState(weather.getMain());
                forecast.setTemperature(list.getMain().getTemp());
                forecast.setDescription(weather.getDescription());
                forecast.setDate(list.getDt());
                forecast.setIconURL(getIconURL(weather.getIcon()));
                forecastList.add(forecast);
            }

            model.setForecastList(forecastList);
        }
        return model;
    }

    @NonNull
    private String getIconURL(String icon) {
        return "http://openweathermap.org/img/w/" + icon + ".png";
    }
}
