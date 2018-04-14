package com.example.dunger.weatherappandroidclient.Services;

import android.app.Activity;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.dunger.weatherappandroidclient.Models.CurrentWeatherApixu;
import com.example.dunger.weatherappandroidclient.Models.CurrentWeatherOpenWeather;
import com.example.dunger.weatherappandroidclient.Models.IWeatherService;
import com.example.dunger.weatherappandroidclient.Volley.RequestQueueSingleton;
import com.example.dunger.weatherappandroidclient.WeatherCurrentActivity;
import com.google.gson.Gson;

/**
 * Created by Dunger on 2018-04-09.
 */

public class WeatherServiceOpenWeatherMap implements IWeatherService {

    Activity activity;

    //HTTPConnection variables
    private StringRequest stringRequest;
    String openWeatherAPIkey = "&APPID=409014fbcefa18db869de6c154c71e71";

    //Debug variables
    private static final String TAG = WeatherServiceOpenWeatherMap.class.getSimpleName();

    public WeatherServiceOpenWeatherMap(Activity activity) {
        this.activity=activity;
    }

    @Override
    public void GetCurrentWeather(String city) {
        String url = "http://api.openweathermap.org/data/2.5/weather?q="+city+"&units=metric$"+openWeatherAPIkey;

        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                CurrentWeatherOpenWeather currentWeatherOpenWeather = new Gson().fromJson(response.toString(),CurrentWeatherOpenWeather.class);

                float temperature_Celsius=Math.round(currentWeatherOpenWeather.getMain().getTemp()-273.15f);
                float windspeed_kmh = Math.round(currentWeatherOpenWeather.getWind().getSpeed()*3.6f);

                WeatherCurrentActivity.getInstance().SetViewElementsValues(
                        "http://openweathermap.org/img/w/"+currentWeatherOpenWeather.getWeather()[0].getIcon()+".png",
                        currentWeatherOpenWeather.getName(),
                        currentWeatherOpenWeather.getCoord().getLat(),
                        currentWeatherOpenWeather.getCoord().getLon(),
                        currentWeatherOpenWeather.getMain().getHumidity(),
                        temperature_Celsius,
                        windspeed_kmh,
                        currentWeatherOpenWeather.getClouds().getAll(),
                        currentWeatherOpenWeather.getMain().getPressure(),
                        currentWeatherOpenWeather.getWeather()[0].getDescription()
                );
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG, "CONNECTION Error: " + error.toString());
            }
        });
        RequestQueueSingleton.getInstance(activity).addToRequestQueue(stringRequest);
    }

    @Override
    public void GetForecastWeather(String city) {

    }
}
