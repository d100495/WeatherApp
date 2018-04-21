package com.example.dunger.weatherappandroidclient;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.dunger.weatherappandroidclient.Models.ForecastWeatherForListAdapter;
import com.example.dunger.weatherappandroidclient.Models.IWeatherService;
import com.example.dunger.weatherappandroidclient.Services.WeatherFactoryService;
import com.example.dunger.weatherappandroidclient.UI.ForecastListAdapter;
import com.example.dunger.weatherappandroidclient.UI.NavigationBar;

import java.util.ArrayList;
import java.util.List;

import static com.example.dunger.weatherappandroidclient.OptionsActivity.GetChosenAPI;

public class WeatherForecastActivity extends AppCompatActivity {

    IWeatherService weatherService;
    Intent intent;
    static WeatherForecastActivity weatherForecastActivity;

    //View variables
    ListView forecastWeatherListView;

    void initViews(){
        forecastWeatherListView=findViewById(R.id.forecastWeatherListView);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_forecast);

        weatherForecastActivity=this;
        initViews();

        //TODO static getInstance() for navigation bar
        NavigationBar navigationBar = new NavigationBar(weatherForecastActivity); //required if navigation bar exists in this activity_layout
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//required if navigation bar exists in this activity_layout

        //TODO city/lat,lon as parameters
        intent = getIntent();

        weatherService= WeatherFactoryService.createService(GetChosenAPI(this),WeatherForecastActivity.this);
        weatherService.GetForecastWeather(intent.getStringExtra("station"));
    }

    @Override
    protected void onResume() {
        super.onResume();
        weatherService= WeatherFactoryService.createService(GetChosenAPI(this),WeatherForecastActivity.this);
        weatherService.GetForecastWeather(intent.getStringExtra("station"));
    }

    public void SetForecastListAdapterValues(List<ForecastWeatherForListAdapter> forecastWeather){
        ForecastListAdapter adapter = new ForecastListAdapter(this,R.layout.adapter_view_weather_forecast,forecastWeather);
        forecastWeatherListView.setAdapter(adapter);
    }

    public static WeatherForecastActivity getInstance(){
        return weatherForecastActivity;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Navigation bar
        DrawerLayout mDrawerLayout = findViewById(R.id.drawer_layout);
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
