package com.example.dunger.weatherappandroidclient.Services;

import android.app.Activity;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.dunger.weatherappandroidclient.MapsActivity;
import com.example.dunger.weatherappandroidclient.Models.IWeatherStation;
import com.example.dunger.weatherappandroidclient.Models.WeatherStation;
import com.example.dunger.weatherappandroidclient.Models.WeatherStationInfomet;
import com.example.dunger.weatherappandroidclient.Volley.RequestQueueSingleton;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import static com.example.dunger.weatherappandroidclient.OptionsActivity.GetChosenAPI;
import static com.example.dunger.weatherappandroidclient.Services.accountService.GetToken;

/**
 * Created by Dunger on 2018-04-14.
 */

public class WeatherStationsService {

    //Debug variables
    private static final String TAG = WeatherStationsService.class.getName();
    Activity activity;
    //Variables for GSON
    IWeatherStation[] stations;
    //HTTPConnection variables
    private StringRequest stringRequest;

    public WeatherStationsService(Activity activity) {
        this.activity = activity;
    }

    private IWeatherStation[] ConvertResponseWithWeatherStations(String APIforStations, String response) {
        switch (APIforStations) {
            case "Infomet":
                return new Gson().fromJson(response, WeatherStationInfomet[].class);
            default:
                return new Gson().fromJson(response, WeatherStation[].class);
        }
    }

    private String GetURL(String APIforStations) {
        switch (APIforStations) {
            case "Infomet":
                return "http://infomet.nazwa.pl/data/stations.php";
            default:
                return "http://mypenisred1-001-site1.atempurl.com/api/weatherstation/getall";
        }
    }

    private void GetLatLonForIncompleteStations(final IWeatherStation[] stationsArr) {
        final IWeatherStation[] validStations = new IWeatherStation[stationsArr.length];
        int counter = 0;
        int nullCounter = 0;
        for (final IWeatherStation ws : stationsArr) {
            if (ws != null) {
                String city = ws.getCityName();
                String url = "http://maps.googleapis.com/maps/api/geocode/json?address=" + city + "&sensor=false";
                final int finalCounter = counter;
                final int finalNullCounter = nullCounter;
                stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i(TAG, "ResponseWeatherStations: " + response.toString());
                        validStations[finalCounter] = ws;
                        if (finalCounter == stationsArr.length - (finalNullCounter + 2)) {
                            MapsActivity.getInstance().PopulateMapWithWeatherStations(validStations);
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i(TAG, "CONNECTION Error: " + error.toString());
                    }
                })

                {
                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("Authorization", GetToken().getToken_type() + " " + GetToken().getAccess_token());
                        return params;
                    }
                };
                RequestQueueSingleton.getInstance(activity).addToRequestQueue(stringRequest);
                counter++;
            } else {
                nullCounter++;
            }
        }
    }

    public void GetWeatherStations() {
        final String chosenAPI = GetChosenAPI(activity);
        String url = GetURL(chosenAPI);

        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                stations = ConvertResponseWithWeatherStations(chosenAPI, response);
                MapsActivity.getInstance().PopulateMapWithWeatherStations(stations);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG, "CONNECTION Error: " + error.toString());
            }
        })

        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Authorization", GetToken().getToken_type() + " " + GetToken().getAccess_token());
                return params;
            }
        };
        RequestQueueSingleton.getInstance(activity).addToRequestQueue(stringRequest);
    }

}
