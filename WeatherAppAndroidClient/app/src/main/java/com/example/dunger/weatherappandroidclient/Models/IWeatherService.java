package com.example.dunger.weatherappandroidclient.Models;

/**
 * Created by Dunger on 2018-04-08.
 */

public interface IWeatherService {
    void GetCurrentWeather(String city);
    void GetForecastWeather(String city);
}
