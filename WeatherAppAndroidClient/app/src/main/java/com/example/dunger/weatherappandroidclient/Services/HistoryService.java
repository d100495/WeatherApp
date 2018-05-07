package com.example.dunger.weatherappandroidclient.Services;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.dunger.weatherappandroidclient.FavoritesActivity;
import com.example.dunger.weatherappandroidclient.HistoryActivity;
import com.example.dunger.weatherappandroidclient.Models.WeatherHistory;
import com.example.dunger.weatherappandroidclient.Models.WeatherStation;
import com.example.dunger.weatherappandroidclient.R;
import com.example.dunger.weatherappandroidclient.Volley.RequestQueueSingleton;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.dunger.weatherappandroidclient.Services.accountService.GetToken;

/**
 * Created by Dunger on 2018-04-22.
 */

public class HistoryService {
    private static final String TAG = HistoryService.class.getSimpleName();
    private static Activity activity;
    //HTTPConnection variables
    private static StringRequest stringRequest;
    String baseurl = "http://mypenisred1-001-site1.atempurl.com/";
    //Variables for GSON
    WeatherHistory[] history;

    public HistoryService(Activity activity) {
        this.activity = activity;
    }

    public void GetHistory() {
        String url = baseurl+"api/weatherhistory/GetAllWeatherHistoryByUserId";

        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                history = new Gson().fromJson(response, WeatherHistory[].class);

                Log.i(TAG, "Favorites : " + response.toString());

                List<WeatherHistory> weatherHistories = new ArrayList<>();

                for (WeatherHistory weatherHistory : history) {
                    weatherHistories.add(new WeatherHistory(
                            weatherHistory.getWeatherId(),
                            weatherHistory.getLongitude(),
                            weatherHistory.getLatitude(),
                            weatherHistory.getTemperature(),
                            weatherHistory.getPressure(),
                            weatherHistory.getWindSpeed(),
                            weatherHistory.getWindChill(),
                            weatherHistory.getDate(),
                            weatherHistory.getId()
                            )
                    );
                }
                HistoryActivity.getInstance().SetHistoryListAdapterValues(weatherHistories);
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
