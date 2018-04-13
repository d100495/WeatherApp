package com.example.dunger.weatherappandroidclient;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dunger.weatherappandroidclient.Models.IWeatherService;
import com.example.dunger.weatherappandroidclient.Services.WeatherFactoryService;
import com.example.dunger.weatherappandroidclient.UI.NavigationBar;
import com.squareup.picasso.Picasso;

public class WeatherCurrentActivity extends AppCompatActivity {

    static WeatherCurrentActivity weatherCurrentActivity;

    //Navigation bar
    DrawerLayout mDrawerLayout;

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

    private void initViews() {
        mDrawerLayout = findViewById(R.id.drawer_layout);
        currentWeatherImage=findViewById(R.id.currentWeatherImage);
        currentCityString=findViewById(R.id.currentCityString);
        currentLatString=findViewById(R.id.currentLatString);
        currentLongString=findViewById(R.id.currentLongString);
        currentHumidityValue=findViewById(R.id.currentHumidityValue);
        currentTemperatureValue=findViewById(R.id.currentTemperatureValue);
        currentWindspeedValue=findViewById(R.id.currentWindspeedValue);
        currentCloudsValue=findViewById(R.id.currentCloudsValue);
        currentPressureValue=findViewById(R.id.currentPressureValue);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_current);
        weatherCurrentActivity=this;
        initViews();

        NavigationBar navigationBar = new NavigationBar(this); //required if navigation bar exists in this activity_layout
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//required if navigation bar exists in this activity_layout

        IWeatherService  weatherService= WeatherFactoryService.createService("Apixu",WeatherCurrentActivity.this);
        weatherService.GetCurrentWeather("Katowice");


        //TODO Current weather data displaying

    }

    public static WeatherCurrentActivity getInstance(){
        return weatherCurrentActivity;
    }


    public void SetViewElementsValues(String image,String city, float lat, float lon, float humidity, float temperature, float windspeed,float clouds,float pressure ){
        Picasso.get().load(image).into(currentWeatherImage);
        currentCityString.setText(city);
        currentLatString.setText(Float.toString(lat));
        currentLongString.setText(Float.toString(lon));
        currentHumidityValue.setText(Float.toString(humidity));
        currentTemperatureValue.setText(Float.toString(temperature));
        currentWindspeedValue.setText(Float.toString(windspeed));
        currentCloudsValue.setText(Float.toString(clouds));
        currentPressureValue.setText(Float.toString(pressure));
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
