package com.example.dunger.weatherappandroidclient.Models;

/**
 * Created by Dunger on 2018-04-08.
 */

public interface IWeatherService {
    void GetCurrentWeather(String city);
    //TODO Implementing forecast weather for every service
    void GetForecastWeather(String city);
}
