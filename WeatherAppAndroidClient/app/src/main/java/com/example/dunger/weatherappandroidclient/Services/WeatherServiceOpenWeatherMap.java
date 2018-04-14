package com.example.dunger.weatherappandroidclient.Services;

import android.app.Activity;

import com.example.dunger.weatherappandroidclient.Models.IWeatherService;

/**
 * Created by Dunger on 2018-04-09.
 */

public class WeatherServiceOpenWeatherMap implements IWeatherService {

    Activity activity;

    public WeatherServiceOpenWeatherMap(Activity activity) {
        this.activity=activity;
    }

    @Override
    public void GetCurrentWeather(String city) {

    }

    @Override
    public void GetForecastWeather(String city) {

    }
}
