package com.example.dunger.weatherappandroidclient.Models;

/**
 * Created by Dunger on 2018-04-08.
 */

public interface IWeatherService {
    public void GetCurrentWeather(String city);
    //TODO Implementing forecast weather for every service
    public void GetForecastWeather(String city);
}
