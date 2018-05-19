package com.example.dunger.weatherappandroidclient.Services;

import android.app.Activity;
import android.net.Uri;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.dunger.weatherappandroidclient.Models.CurrentWeatherInfomet;
import com.example.dunger.weatherappandroidclient.Models.GoogleAPIsGeocode;
import com.example.dunger.weatherappandroidclient.Models.IWeatherService;
import com.example.dunger.weatherappandroidclient.R;
import com.example.dunger.weatherappandroidclient.Volley.RequestQueueSingleton;
import com.example.dunger.weatherappandroidclient.WeatherCurrentActivity;
import com.google.gson.Gson;

/**
 * Created by Dunger on 2018-05-18.
 */

public class WeatherServiceInfomet implements IWeatherService {

    //Debug variables
    private static final String TAG = WeatherServiceInfomet.class.getSimpleName();
    Activity activity;
    //HTTPConnection variables
    private StringRequest stringRequest;

    public WeatherServiceInfomet(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void GetCurrentWeather(String stationId, final float latitude, final float longitude) {
        String url = "http://infomet.nazwa.pl/data/values.php?stationid=" + stationId;

        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i(TAG, "GetCurrentWeather INFOMET RESPONSE Error: " + response.toString());

                CurrentWeatherInfomet currentWeatherInfomet = new Gson().fromJson(response.toString(), CurrentWeatherInfomet.class);

                WeatherCurrentActivity.getInstance().SetViewElementsValues(
                        "android.resource://com.example.dunger.weatherappandroidclient/"+R.mipmap.ic_weather_partlycloudy,
                        currentWeatherInfomet.getPlace(),
                        latitude,
                        longitude,
                        Float.parseFloat(currentWeatherInfomet.getInHum()),
                        Float.parseFloat(currentWeatherInfomet.getTempOut()),
                        Float.parseFloat(currentWeatherInfomet.getWindSpeed()),
                        Float.parseFloat(currentWeatherInfomet.getInAirDencity()),
                        Float.parseFloat(currentWeatherInfomet.getBar()),
                        currentWeatherInfomet.getDt()
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
