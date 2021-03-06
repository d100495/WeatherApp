package com.example.dunger.weatherappandroidclient;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dunger.weatherappandroidclient.Models.IWeatherService;
import com.example.dunger.weatherappandroidclient.Models.WeatherStation;
import com.example.dunger.weatherappandroidclient.Services.FavoritesService;
import com.example.dunger.weatherappandroidclient.Services.WeatherFactoryService;
import com.example.dunger.weatherappandroidclient.Services.WeatherServiceInfomet;
import com.example.dunger.weatherappandroidclient.UI.NavigationBar;
import com.squareup.picasso.Picasso;

import static com.example.dunger.weatherappandroidclient.OptionsActivity.GetChosenAPI;

public class WeatherCurrentActivity extends AppCompatActivity {

    static WeatherCurrentActivity weatherCurrentActivity;

    IWeatherService weatherService;
    Intent intent;

    //UI variables
    ImageView currentWeatherImage;
    TextView currentCityString;
    TextView currentLatString;
    TextView currentLongString;
    TextView currentHumidityValue;
    TextView currentTemperatureValue;
    TextView currentWindspeedValue;
    TextView currentCloudsValue;
    TextView currentPressureValue;
    TextView currentWeatherDescription;
    LinearLayout currentLinearLayoutTemperature;
    Button showForecastWeatherButton;
    Button showMapButton;
    FloatingActionButton addToFavoritesButton;
    FloatingActionButton showAlertsButton;

    public static WeatherCurrentActivity getInstance() {
        return weatherCurrentActivity;
    }

    private void initViews() {
        currentWeatherImage = findViewById(R.id.currentWeatherImage);
        currentCityString = findViewById(R.id.currentCityString);
        currentLatString = findViewById(R.id.currentLatString);
        currentLongString = findViewById(R.id.currentLongString);
        currentHumidityValue = findViewById(R.id.currentHumidityValue);
        currentTemperatureValue = findViewById(R.id.currentTemperatureValue);
        currentWindspeedValue = findViewById(R.id.currentWindspeedValue);
        currentCloudsValue = findViewById(R.id.currentCloudsValue);
        currentPressureValue = findViewById(R.id.currentPressureValue);
        currentWeatherDescription = findViewById(R.id.currentWeatherDescription);
        currentLinearLayoutTemperature = findViewById(R.id.currentLinearLayoutTemperature);
        showForecastWeatherButton = findViewById(R.id.showForecastWeatherButton);
        showMapButton = findViewById(R.id.showMapButton);
        addToFavoritesButton = findViewById(R.id.addToFavoritesButton);
        showAlertsButton=findViewById(R.id.showAlertsButton);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_current);
        weatherCurrentActivity = this;
        initViews();

        //TODO static getInstance() for navigation bar
        NavigationBar navigationBar = new NavigationBar(this); //required if navigation bar exists in this activity_layout
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//required if navigation bar exists in this activity_layout

        //TODO city/lat,lon as parameters
        intent = getIntent();

        weatherService = WeatherFactoryService.createService(GetChosenAPI(this), WeatherCurrentActivity.this);
        weatherService.GetCurrentWeather(intent.getStringExtra("station"), (float) intent.getDoubleExtra("lat", 0), (float) intent.getDoubleExtra("lon", 0));

        showForecastWeatherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), WeatherForecastActivity.class);
                intent1.putExtra("station", intent.getStringExtra("station"));
                startActivity(intent1);
            }
        });

        showMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(intent);
            }
        });

        addToFavoritesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                WeatherStation weatherStation = new WeatherStation(
                        1,
                        intent.getStringExtra("station"),
                        intent.getDoubleExtra("lon", 50),
                        intent.getDoubleExtra("lat", 50)
                );

                FavoritesService favoritesService = new FavoritesService(weatherCurrentActivity);
                favoritesService.AddToFavorites(weatherStation);
            }
        });

        if(GetChosenAPI(weatherCurrentActivity).equals(getString(R.string.APIoption_Infomet))){
            showAlertsButton.setVisibility(View.VISIBLE);
            WeatherServiceInfomet weatherServiceInfomet = new WeatherServiceInfomet(weatherCurrentActivity);
            weatherServiceInfomet.SetButtonForGettingAlerts(intent.getStringExtra("station"),showAlertsButton);
        }else {
            showAlertsButton.setVisibility(View.GONE);
        }

    }//onCreate()

    public void SetViewElementsValues(String image, String city, float lat, float lon, float humidity, float temperature, float windspeed, float clouds, float pressure, String description) {
        Picasso.get().load(image).into(currentWeatherImage);
        currentCityString.setText(city);
        currentLatString.setText(String.valueOf(lat));
        currentLongString.setText(String.valueOf(lon));
        currentHumidityValue.setText(String.valueOf(humidity));
        currentTemperatureValue.setText(String.valueOf(temperature));
        currentWindspeedValue.setText(String.valueOf(windspeed));
        currentCloudsValue.setText(String.valueOf(clouds));
        currentPressureValue.setText(String.valueOf(pressure));
        currentWeatherDescription.setText(description);

        SetViewElementsColors(temperature);
    }

    private void SetViewElementsColors(float temperature) {
        //TODO Add more elements
        if (temperature > 11 && temperature <= 25) {
            currentLinearLayoutTemperature.setBackgroundColor(getResources().getColor(R.color.yellow_100));
        }
        if (temperature > 0 && temperature <= 11) {
            currentLinearLayoutTemperature.setBackgroundColor(getResources().getColor(R.color.light_blue_100));
        }
        if (temperature <= 0) {
            currentLinearLayoutTemperature.setBackgroundColor(getResources().getColor(R.color.blue_100));
        }
        if (temperature > 25) {
            currentLinearLayoutTemperature.setBackgroundColor(getResources().getColor(R.color.red_100));
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Navigation bar
        DrawerLayout mDrawerLayout = findViewById(R.id.drawer_layout);
        switch (item.getItemId()) {
            case android.R.id.home:
                if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                    mDrawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    mDrawerLayout.openDrawer(GravityCompat.START);  // OPEN DRAWER
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }//required if navigation bar exists in this activity_layout

}
