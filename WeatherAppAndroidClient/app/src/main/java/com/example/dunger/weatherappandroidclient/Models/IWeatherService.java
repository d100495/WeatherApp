package com.example.dunger.weatherappandroidclient.Models;

/**
 * Created by Dunger on 2018-04-08.
 */

public interface IWeatherService {
    public String GetCurrentWeather(String city);
    public String GetForecastWeather(String city);
}
