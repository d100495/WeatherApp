package com.example.dunger.weatherappandroidclient.Services;

import android.app.Activity;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.dunger.weatherappandroidclient.Models.CurrentWeatherApixu;
import com.example.dunger.weatherappandroidclient.Models.ForecastWeatherApixu;
import com.example.dunger.weatherappandroidclient.Models.ForecastWeatherForListAdapter;
import com.example.dunger.weatherappandroidclient.Models.IWeatherService;
import com.example.dunger.weatherappandroidclient.Volley.RequestQueueSingleton;
import com.example.dunger.weatherappandroidclient.WeatherCurrentActivity;
import com.example.dunger.weatherappandroidclient.WeatherForecastActivity;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dunger on 2018-04-08.
 */

public class WeatherServiceApixu implements IWeatherService {

    //Debug variables
    private static final String TAG = WeatherServiceApixu.class.getSimpleName();
    Activity activity;
    String apixuAPIKey = "be73dbae410147e79fa130000183103";
    //HTTPConnection variables
    private StringRequest stringRequest;

    public WeatherServiceApixu(Activity activity) {
        this.activity = activity;
    }

    //TODO Implementing RxJava
    @Override
    public void GetCurrentWeather(String city) {

        String url = "http://api.apixu.com/v1/current.json?key=" + apixuAPIKey + "&q=" + city;

        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                CurrentWeatherApixu currentWeatherApixu = new Gson().fromJson(response.toString(), CurrentWeatherApixu.class);

                WeatherCurrentActivity.getInstance().SetViewElementsValues(
                        "https:" + currentWeatherApixu.getCurrent().getCondition().getIcon(),
                        currentWeatherApixu.getLocation().getName(),
                        currentWeatherApixu.getLocation().getLat(),
                        currentWeatherApixu.getLocation().getLon(),
                        currentWeatherApixu.getCurrent().getHumidity(),
                        currentWeatherApixu.getCurrent().getTemp_c(),
                        currentWeatherApixu.getCurrent().getWind_kph(),
                        currentWeatherApixu.getCurrent().getCloud(),
                        currentWeatherApixu.getCurrent().getPressure_mb(),
                        currentWeatherApixu.getCurrent().getCondition().getText()
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
        String url = "http://api.apixu.com/v1/forecast.json?key=" + apixuAPIKey + "&q=" + city + "&days=10";

        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                ForecastWeatherApixu forecastWeatherApixu = new Gson().fromJson(response.toString(), ForecastWeatherApixu.class);

                List<ForecastWeatherForListAdapter> forecastWeatherForListAdapter = new ArrayList<>();

                for (ForecastWeatherApixu.Forecastday forecastday : forecastWeatherApixu.getForecast().getForecastday()) {
                    forecastWeatherForListAdapter.add(new ForecastWeatherForListAdapter(
                                    forecastday.getDay().getAvghumidity(),
                                    forecastday.getDay().getAvgtempC(),
                                    forecastday.getDay().getMaxtempC(),
                                    forecastday.getDay().getMaxwindKph(),
                                    "https:" + forecastday.getDay().getCondition().getIcon(),
                                    forecastday.getDay().getCondition().getText(),
                                    forecastday.getDate()
                            )
                    );
                }

                WeatherForecastActivity.getInstance().SetForecastListAdapterValues(forecastWeatherForListAdapter);
                //TODO delete debug info
                Log.i(TAG, "ForecastWeatherForListAdapter Apixu GSON obj: " + forecastWeatherApixu.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG, "CONNECTION Error: " + error.toString());
            }
        });
        RequestQueueSingleton.getInstance(activity).addToRequestQueue(stringRequest);
    }
}
