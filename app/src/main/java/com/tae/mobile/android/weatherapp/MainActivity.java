package com.tae.mobile.android.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tae.mobile.android.weatherapp.adapter.ForecastAdapter;
import com.tae.mobile.android.weatherapp.api.ApiConstant;
import com.tae.mobile.android.weatherapp.api.ApiSignature;
import com.tae.mobile.android.weatherapp.base.BaseActivity;
import com.tae.mobile.android.weatherapp.helper.ItemsMarginDecorator;
import com.tae.mobile.android.weatherapp.helper.WeatherMapper;
import com.tae.mobile.android.weatherapp.pojo.ResponseModel;
import com.tae.mobile.android.weatherapp.presentation.WeatherView;
import com.tae.mobile.android.weatherapp.presenter.WeatherPresenter;
import com.tae.mobile.android.weatherapp.service.ApiService;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends BaseActivity implements WeatherView {

    @BindView(R.id.recyclerView) protected RecyclerView mForecastList;
    @BindView(R.id.currentWeatherIcon) protected ImageView mWeatherIcon;
    @BindView(R.id.currentWeatherTemperatureTxt) protected TextView mTemperature;
    @BindView(R.id.currentWeatherLocationTxt) protected TextView mLocation;
    @BindView(R.id.currentWeatherTypeTxt) protected TextView mState;
    @BindView(R.id.currentWeatherObservationTxt) protected TextView mObservationTime;

    private WeatherPresenter mPresenter;
    private ForecastAdapter mForecastAdapter;

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        MenuItem searchMenuItem = menu.findItem(R.id.actionSearch);
        SearchView searchView =
                (SearchView) MenuItemCompat.getActionView(searchMenuItem);
        searchView.setSubmitButtonEnabled(true);
        searchView.setQueryHint("Type a location...");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                invalidateOptionsMenu();
                mPresenter.getWeather(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onActivityCreated(Bundle savedInstanceState, Intent intent) {
        super.onActivityCreated(savedInstanceState, intent);
        mForecastList.setHasFixedSize(true);
        mForecastList.setLayoutManager(new LinearLayoutManager(this));
        mForecastList.addItemDecoration(new ItemsMarginDecorator(getResources().getDimensionPixelSize(R.dimen.item_spacing)));
        mForecastAdapter = new ForecastAdapter(getLayoutInflater());
        mForecastList.setAdapter(mForecastAdapter);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .baseUrl(ApiConstant.BASE_URL)
                .build();

        ApiService apiService = new ApiService(retrofit.create(ApiSignature.class), new WeatherMapper());

        mPresenter = new WeatherPresenter(this, apiService);
        mPresenter.getWeather("London");
    }

    @Override
    public void onShowDialog(String message) {
        showDialog(message);
    }

    @Override
    public void onData(ResponseModel model) {
        handleCurrentWeather(model.getLocation(), model.getState(), model.getTemperature(), model.getObservationDate(), model.getWeatherIcon());
        mForecastAdapter.update(model.getForecastList());
    }

    private void handleCurrentWeather(String location, String state, String temperature, Long observationDate, String weatherIcon) {
        mLocation.setText(location);
        mState.setText(state);
        mTemperature.setText(temperature);
        mObservationTime.setText(new SimpleDateFormat("dd/MM/yy").format(new Date(observationDate)));
        Picasso.with(this).load(weatherIcon).into(mWeatherIcon);
    }

    @Override
    public void onShowToast(String message) {
        showToast(message);
    }

    @Override
    public void onHideDialog() {
        hideDialog();
    }
}
