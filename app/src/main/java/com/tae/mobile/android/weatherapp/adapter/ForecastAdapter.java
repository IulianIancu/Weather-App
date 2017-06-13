package com.tae.mobile.android.weatherapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.tae.mobile.android.weatherapp.R;
import com.tae.mobile.android.weatherapp.pojo.Forecast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Pippo on 5/15/2017.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastHolder> {

    private final LayoutInflater mLayoutInflater;
    private final List<Forecast> mForecastList = new ArrayList<>();

    public ForecastAdapter(LayoutInflater inflater) {
        mLayoutInflater = inflater;
    }

    @Override
    public ForecastHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.item_forecast_layout, parent, false);
        return new ForecastHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ForecastHolder holder, int position) {
        Forecast forecast = mForecastList.get(position);
        holder.mStateTxt.setText(forecast.getState());
        holder.mDescriptionTxt.setText(forecast.getDescription());
        holder.mTemperatureTxt.setText(forecast.getTemperature());
        holder.mDateTxt.setText(new SimpleDateFormat("dd/MM/yy").format(new Date(forecast.getDate())));
        Picasso.with(holder.itemView.getContext()).load(forecast.getIconURL()).into(holder.mIconURL);
    }

    @Override
    public int getItemCount() {
        return mForecastList.size();
    }

    public void update(List<Forecast> forecastList) {
        mForecastList.clear();
        mForecastList.addAll(forecastList);
        notifyDataSetChanged();
    }

    public class ForecastHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView mStateTxt;
        private final TextView mDescriptionTxt;
        private final TextView mTemperatureTxt;
        private final TextView mDateTxt;
        private final ImageView mIconURL;

        public ForecastHolder(View itemView) {
            super(itemView);
            mStateTxt = (TextView) itemView.findViewById(R.id.forecastState);
            mDescriptionTxt = (TextView) itemView.findViewById(R.id.forecastDescription);
            mTemperatureTxt = (TextView) itemView.findViewById(R.id.forecastTemperature);
            mDateTxt = (TextView) itemView.findViewById(R.id.forecastDate);
            mIconURL = (ImageView) itemView.findViewById(R.id.forecastIcon);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), "Clicked on Forecast!", Toast.LENGTH_SHORT).show();
        }
    }
}
