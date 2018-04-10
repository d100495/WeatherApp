package com.example.dunger.weatherappandroidclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dunger.weatherappandroidclient.Models.IWeatherService;
import com.example.dunger.weatherappandroidclient.Services.WeatherFactoryService;

public class WeatherCurrentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_current);

        IWeatherService  weatherService= WeatherFactoryService.createService("Apixu",WeatherCurrentActivity.this);
        weatherService.GetCurrentWeather("Katowice");
    }

}
