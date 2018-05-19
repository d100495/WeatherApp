package com.example.dunger.weatherappandroidclient.Services;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.dunger.weatherappandroidclient.Models.AlertsInfomet;
import com.example.dunger.weatherappandroidclient.Models.CurrentWeatherInfomet;
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

    public void SetButtonForGettingAlerts(String stationId, final ImageButton imageButton) {
        String url = "http://www.infomet.nazwa.pl/data/alarms.php?stationid=" + stationId;

        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i(TAG, "GetAlerts INFOMET RESPONSE: " + response.toString());

                AlertsInfomet[] alertsInfomet = new Gson().fromJson(response.toString(), AlertsInfomet[].class);

                StringBuilder stringBuilder = new StringBuilder();
                for (AlertsInfomet alerts : alertsInfomet) {
                    stringBuilder.append(alerts.getDt() + ":\n" + alerts.getMessage() + "\n\n");
                }
                final String alerts = stringBuilder.toString();

                imageButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(activity);
                        builder1.setMessage(alerts);
                        builder1.setCancelable(true);
                        builder1.setPositiveButton(
                                "Ok",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                        AlertDialog alert11 = builder1.create();
                        alert11.show();
                    }
                });
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
    public void GetCurrentWeather(String stationId, final float latitude, final float longitude) {
        String url = "http://infomet.nazwa.pl/data/values.php?stationid=" + stationId;

        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i(TAG, "GetCurrentWeather INFOMET RESPONSE: " + response.toString());

                CurrentWeatherInfomet currentWeatherInfomet = new Gson().fromJson(response.toString(), CurrentWeatherInfomet.class);

                WeatherCurrentActivity.getInstance().SetViewElementsValues(
                        "android.resource://com.example.dunger.weatherappandroidclient/" + R.mipmap.ic_weather_partlycloudy,
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
