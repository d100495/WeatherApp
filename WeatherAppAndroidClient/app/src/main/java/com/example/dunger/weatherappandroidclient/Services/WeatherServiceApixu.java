package com.example.dunger.weatherappandroidclient.Services;

import android.app.Activity;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.dunger.weatherappandroidclient.Models.IWeatherService;
import com.example.dunger.weatherappandroidclient.R;
import com.example.dunger.weatherappandroidclient.Volley.RequestQueueSingleton;
import com.google.gson.Gson;

/**
 * Created by Dunger on 2018-04-08.
 */

public class WeatherServiceApixu implements IWeatherService{

    Activity activity;

    //View variables
    TextView TestTextViewCurrentWeather;

    //HTTPConnection variables
    private StringRequest stringRequest;
    private static final String TAG = WeatherServiceApixu.class.getSimpleName();
    String apixuAPIKey = "be73dbae410147e79fa130000183103";

    //Null objects
    String currentWeather="";
    String forecastWeather="";

    public WeatherServiceApixu(Activity activity) {
        this.activity = activity;
        initViews();

    }

    private void initViews() {
        TestTextViewCurrentWeather = activity.findViewById(R.id.TestTextViewCurrentWeather);
    }

    //TODO Implementing RxJava
    @Override
    public void GetCurrentWeather(String city) {

        String url = "http://api.apixu.com/v1/current.json?key="+apixuAPIKey+"&q="+city;

        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //TODO CurrentWeatherApixu model fix for Gson serialization
                Gson gson = new Gson();
                //gson.fromJson(response.toString(),WeatherServiceApixu.class);
                TestTextViewCurrentWeather.setText(response.toString());
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
