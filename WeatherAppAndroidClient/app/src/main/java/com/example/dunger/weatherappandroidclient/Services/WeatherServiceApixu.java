package com.example.dunger.weatherappandroidclient.Services;

import android.app.Activity;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.dunger.weatherappandroidclient.Models.CurrentWeatherApixu;
import com.example.dunger.weatherappandroidclient.Models.IWeatherService;
import com.example.dunger.weatherappandroidclient.Volley.RequestQueueSingleton;
import com.example.dunger.weatherappandroidclient.WeatherStationsActivity;
import com.google.gson.Gson;

/**
 * Created by Dunger on 2018-04-08.
 */

public class WeatherServiceApixu implements IWeatherService{

    Activity activity;

    //HTTPConnection variables
    private StringRequest stringRequest;
    private static final String TAG = WeatherServiceApixu.class.getSimpleName();
    String apixuAPIKey = "be73dbae410147e79fa130000183103";

    //Null objects
    String currentWeather="";
    String forecastWeather="";

    public WeatherServiceApixu(Activity activity) {
        this.activity = activity;
    }
    //TODO Implementing RxJava
    @Override
    public String GetCurrentWeather(String city) {

   /*     String url = "http://api.apixu.com/v1/current.json?key="+apixuAPIKey+"&q=Warszawa";

        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                currentWeather = response.toString();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG, "CONNECTION Error: " + error.toString());
            }
        });
        RequestQueueSingleton.getInstance(activity).addToRequestQueue(stringRequest);*/
        return null;
    }

    @Override
    public String GetForecastWeather(String city) {
        return null;
    }
}
