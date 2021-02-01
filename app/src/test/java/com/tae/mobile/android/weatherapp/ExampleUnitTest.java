package com.tae.mobile.android.weatherapp;

import com.tae.mobile.android.weatherapp.helper.WeatherMapper;
import com.tae.mobile.android.weatherapp.pojo.ResponseModel;
import com.tae.mobile.android.weatherapp.pojo.forecast.ForecastResponse;
import com.tae.mobile.android.weatherapp.pojo.weather.Clouds;
import com.tae.mobile.android.weatherapp.pojo.weather.Main;
import com.tae.mobile.android.weatherapp.pojo.weather.Weather;
import com.tae.mobile.android.weatherapp.pojo.weather.WeatherResponse;
import com.tae.mobile.android.weatherapp.presenter.WeatherPresenter;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    public WeatherMapper mapper;

    @Before
    public void before() {
        mapper = new WeatherMapper();
    }

    @Test
    public void givenApiResponses_thenMapperProvidesResponseModel() {
        WeatherResponse weather = new WeatherResponse();
        weather.setId("42");
        weather.setName("42nd Street");
        weather.setMain(getMain());
        weather.setWeather(getWeatherList());

        ForecastResponse forecast = new ForecastResponse();


        ResponseModel response = mapper.mapResponse(weather, forecast);
        assertEquals(response.getWeatherIcon(),"Icon URL");
        assertEquals(response.getState(),"Main");
        assertEquals(response.getLocation(),"42nd Street");
        assertEquals(response.getTemperature(),"Hot");
    }

    private Weather[] getWeatherList() {
        Weather[] weathers = new Weather[1];
        weathers[0] = new Weather();
        weathers[0].setIcon("Icon URL");
        weathers[0].setMain("Main");
        return weathers;
    }

    private Main getMain() {
        Main main = new Main();
        main.setTemp("Hot");
        return main;
    }
}