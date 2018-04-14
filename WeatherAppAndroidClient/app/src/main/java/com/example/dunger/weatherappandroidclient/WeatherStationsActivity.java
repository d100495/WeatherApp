package com.example.dunger.weatherappandroidclient;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.dunger.weatherappandroidclient.Models.CurrentWeatherApixu;
import com.example.dunger.weatherappandroidclient.Models.WeatherStation;
import com.example.dunger.weatherappandroidclient.Services.WeatherStationsService;
import com.example.dunger.weatherappandroidclient.UI.NavigationBar;
import com.example.dunger.weatherappandroidclient.Volley.RequestQueueSingleton;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import static com.example.dunger.weatherappandroidclient.Services.accountService.GetToken;


public class WeatherStationsActivity extends AppCompatActivity {

    static WeatherStationsActivity weatherStationsActivity;

    //UI variables
    Button TestButton;
    ListView listView1;

    //Navigation bar
    DrawerLayout mDrawerLayout;

    //Debug variables
    private static final String TAG = WeatherStationsActivity.class.getName();

    private void initViews() {
        TestButton = findViewById(R.id.TestButton2);
        listView1 = findViewById(R.id.listView1);
        mDrawerLayout = findViewById(R.id.drawer_layout);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_stations);

        initViews();
        weatherStationsActivity=this;

        WeatherStationsService weatherStationsService = new WeatherStationsService(this);
        weatherStationsService.GetWeatherStations();

        //TODO static getInstance() for navigation bar
        NavigationBar navigationBar = new NavigationBar(this); //required if navigation bar exists in this activity_layout
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//required if navigation bar exists in this activity_layout

        //TODO Delete Debug info
        TestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Log.i(TAG,
                           "\nJSON Obj: " +
                                "\naccess_token: " + GetToken().getAccess_token() +
                                "\n\nToken_type: " + GetToken().getToken_type() +
                                "\n\nExpires_in: " + GetToken().getExpires_in());

                Intent intent = new Intent(getApplicationContext(), WeatherCurrentActivity.class);
                startActivity(intent);
            }
        });

        //TODO Markers from Google Maps API
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                WeatherStation weatherStation = (com.example.dunger.weatherappandroidclient.Models.WeatherStation)(adapterView.getItemAtPosition(i));

                Intent intent = new Intent(getApplicationContext(), WeatherCurrentActivity.class);
                intent.putExtra("station",weatherStation.getCityName());
                startActivity(intent);
            }
        });

    }//onCreate

    public static WeatherStationsActivity getInstance(){
        return weatherStationsActivity;
    }

    public void PopulateWeatherStationsListView(WeatherStation[] stations) {
        if (stations != null) {
            ArrayAdapter<WeatherStation> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stations);
            listView1.setAdapter(adapter);
        } else {
            Log.i(TAG, "\n\nStations==NULL");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if(mDrawerLayout.isDrawerOpen(GravityCompat.START))
                {
                    mDrawerLayout.closeDrawer(GravityCompat.START);
                }
                else
                {
                    mDrawerLayout.openDrawer(GravityCompat.START);  // OPEN DRAWER
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }//required if navigation bar exists in this activity_layout

}
