package com.example.dunger.weatherappandroidclient.Models;

import java.util.List;

/**
 * Created by Dunger on 2018-04-19.
 */

public interface IForecastWeather {
    List<String> getTemperatureList();
    List<String> getHumidityList();
    List<String> getImageList();
}
