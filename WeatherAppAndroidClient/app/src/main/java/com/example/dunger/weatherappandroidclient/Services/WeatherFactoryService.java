package com.example.dunger.weatherappandroidclient.Services;

import android.app.Activity;

import com.example.dunger.weatherappandroidclient.Models.IWeatherService;

/**
 * Created by Dunger on 2018-04-09.
 */

public class WeatherFactoryService {
    public static IWeatherService createService(final String service, final Activity activity) {
        switch (service) {
            case "Apixu":
                return new WeatherServiceApixu(activity);
            case "OpenWeather":
                return new WeatherServiceOpenWeatherMap(activity);
            case "Infomet":
                return new WeatherServiceInfomet(activity);
            default:
                return new WeatherServiceApixu(activity);
        }
    }
}
