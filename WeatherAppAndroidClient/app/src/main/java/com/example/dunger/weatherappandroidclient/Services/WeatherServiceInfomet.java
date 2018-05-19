package com.example.dunger.weatherappandroidclient.Services;

import android.app.Activity;

import com.android.volley.toolbox.StringRequest;
import com.example.dunger.weatherappandroidclient.Models.IWeatherService;

/**
 * Created by Dunger on 2018-05-18.
 */

public class WeatherServiceInfomet implements IWeatherService {

    //Debug variables
    private static final String TAG = WeatherServiceInfomet.class.getSimpleName();
    Activity activity;
    //HTTPConnection variables
    private StringRequest stringRequest;

    @Override
    public void GetCurrentWeather(String city) {

    }

    @Override
    public void GetForecastWeather(String city) {

    }
}
