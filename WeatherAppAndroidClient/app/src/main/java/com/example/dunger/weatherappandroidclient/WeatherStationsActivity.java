package com.example.dunger.weatherappandroidclient;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.dunger.weatherappandroidclient.Models.CurrentWeatherApixu;
import com.example.dunger.weatherappandroidclient.Models.WeatherStation;
import com.example.dunger.weatherappandroidclient.UI.NavigationBar;
import com.example.dunger.weatherappandroidclient.Volley.RequestQueueSingleton;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import static com.example.dunger.weatherappandroidclient.Services.accountService.GetToken;


public class WeatherStationsActivity extends AppCompatActivity {


    //Variables for GSON
    WeatherStation[] stations;
    CurrentWeatherApixu currentWeatherApixu;

    //UI variables
    Button TestButton;
    TextView TestTextView;
    ListView listView1;
    //Navigation bar
    DrawerLayout mDrawerLayout;
    NavigationView nav_bar;

    //HTTPConnection variables
    private StringRequest stringRequest;
    private static final String TAG = WeatherStationsActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_stations);

        initViews();

        GetWeatherStations();
        //TODO Delete Debug info
        Log.i(TAG, "OnCreate ==========================");

        NavigationBar navigationBar = new NavigationBar(WeatherStationsActivity.this); //required if navigation bar is used in this activity

        //TODO Delete Debug info
        TestTextView.setMovementMethod(new ScrollingMovementMethod());
        //TODO Delete Debug info
        TestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TestTextView.append(
                        "\nJSON Obj: " +
                                "\naccess_token: " + GetToken().getAccess_token() +
                                "\n\nToken_type: " + GetToken().getToken_type() +
                                "\n\nExpires_in: " + GetToken().getExpires_in());

                Intent intent = new Intent(getApplicationContext(), WeatherCurrentActivity.class);
                startActivity(intent);
            }
        });
    }//onCreate


    private void GetWeatherStations() {
        String url = "http://weatherapp-001-site1.gtempurl.com/api/weatherstation/getall";

        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                stations = new Gson().fromJson(response, WeatherStation[].class);

                PopulateWeatherStationsListView();
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
        RequestQueueSingleton.getInstance(this).addToRequestQueue(stringRequest);
    }

    private void initViews() {
        TestButton = findViewById(R.id.TestButton2);
        TestTextView = findViewById(R.id.TestTextView2);
        listView1 = findViewById(R.id.listView1);
        nav_bar = findViewById(R.id.nav_bar);
        mDrawerLayout = findViewById(R.id.drawer_layout);
    }

    private void PopulateWeatherStationsListView() {
        if (stations != null) {
            //TODO Delete Debug info
            for (WeatherStation x : stations) {
                TestTextView.append("\n" + x.wholeString() + "\n");
            }
            ArrayAdapter<WeatherStation> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stations);
            listView1.setAdapter(adapter);
        } else {
            Log.i(TAG, "\n\nStations==NULL");
        }

    }

}
