package com.example.dunger.weatherappandroidclient.UI;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dunger.weatherappandroidclient.Models.ForecastWeatherForListAdapter;
import com.example.dunger.weatherappandroidclient.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dunger on 2018-04-19.
 */

public class ForecastListAdapter extends ArrayAdapter<ForecastWeatherForListAdapter>{

    //Debug variables
    private static final String TAG = ForecastListAdapter.class.getSimpleName();

    private Context mContext;
    private int mResource;

    public ForecastListAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        mContext=context;
        mResource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String dateTime = getItem(position).getDateTime();
        String icon = getItem(position).getIcon();
        String description = getItem(position).getDescription();
        double humidity = getItem(position).getHumidity();
        double avgTemperature = getItem(position).getAvgTemperature();
        double windspeed = getItem(position).getWindspeed();
        double maxTemperature = getItem(position).getMaxTemperature();


        ForecastWeatherForListAdapter forecastWeatherForListAdapter = new ForecastWeatherForListAdapter(
            humidity,avgTemperature,maxTemperature,windspeed,icon,description,dateTime
        );

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        convertView = layoutInflater.inflate(mResource,parent,false);

        //Getting view elements
        TextView adapterViewForecastTextView_Humidity = convertView.findViewById(R.id.adapterViewForecastTextView_Humidity);
        TextView adapterViewForecastTextView_avgTemperature = convertView.findViewById(R.id.adapterViewForecastTextView_avgTemperature);
        TextView adapterViewForecastTextView_Description = convertView.findViewById(R.id.adapterViewForecastTextView_Description);
        TextView adapterViewForecastTextView_maxTemperature = convertView.findViewById(R.id.adapterViewForecastTextView_maxTemperature);
        TextView adapterViewForecastTextView_WindSpeed = convertView.findViewById(R.id.adapterViewForecastTextView_WindSpeed);
        ImageView adapterViewForecastTextView_Icon = convertView.findViewById(R.id.adapterViewForecastTextView_Icon);
        TextView adapterViewForecastTextView_DateTime = convertView.findViewById(R.id.adapterViewForecastTextView_DateTime);

        //Setting values
        adapterViewForecastTextView_Humidity.setText(String.valueOf(humidity));
        adapterViewForecastTextView_avgTemperature.setText(String.valueOf(avgTemperature));
        adapterViewForecastTextView_Description.setText(description);
        adapterViewForecastTextView_maxTemperature.setText(String.valueOf(maxTemperature));
        adapterViewForecastTextView_WindSpeed.setText(String.valueOf(windspeed));
        Picasso.get().load("https:"+icon).into( adapterViewForecastTextView_Icon);
        adapterViewForecastTextView_DateTime.setText(dateTime);

        return convertView;
    }

}
