package com.example.dunger.weatherappandroidclient.Services;

import android.app.Activity;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.dunger.weatherappandroidclient.FavoritesActivity;
import com.example.dunger.weatherappandroidclient.Models.WeatherStation;
import com.example.dunger.weatherappandroidclient.Volley.RequestQueueSingleton;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.dunger.weatherappandroidclient.Services.accountService.GetToken;

/**
 * Created by Dunger on 2018-04-21.
 */

public class FavoritesService {
    private static final String TAG = FavoritesService.class.getSimpleName();
    private static Activity activity;
    //HTTPConnection variables
    private static StringRequest stringRequest;
    //Variables for GSON
    WeatherStation[] stations;

    public FavoritesService(Activity activity) {
        this.activity = activity;
    }

    public void GetFavorites() {
        String url = "http://mypenisred1-001-site1.atempurl.com/api/favorite/GetByUserId";

        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                stations = new Gson().fromJson(response, WeatherStation[].class);

                Log.i(TAG, "Favorites : " + response.toString());

                List<WeatherStation> weatherStations = new ArrayList<>();

                for (WeatherStation weatherStation : stations) {
                    weatherStations.add(new WeatherStation(
                                    weatherStation.getWeatherStationId(),
                                    weatherStation.getCityName(),
                                    weatherStation.getLatitude(),
                                    weatherStation.getLongitude()
                            )
                    );
                }
                FavoritesActivity.getInstance().SetForecastListAdapterValues(weatherStations);
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
