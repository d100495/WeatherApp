package com.example.dunger.weatherappandroidclient.UI;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import com.example.dunger.weatherappandroidclient.Models.ForecastWeatherApixu;
import com.example.dunger.weatherappandroidclient.Models.IForecastWeather;

import java.util.List;

/**
 * Created by Dunger on 2018-04-19.
 */

public class ForecastListAdapter extends ArrayAdapter<IForecastWeather>{

    public ForecastListAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
    }
}
