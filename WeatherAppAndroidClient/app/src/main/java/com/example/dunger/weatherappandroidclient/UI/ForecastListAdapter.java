package com.example.dunger.weatherappandroidclient.UI;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
    private int lastPosition=-1;

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

        //View result for showing animations
        final View result;
        //Holder init
        ViewHolder holder = new ViewHolder();

        if(convertView==null){
            LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(mResource,parent,false);

            //Getting view elements
            holder.holderViewForecastTextView_Humidity = convertView.findViewById(R.id.adapterViewForecastTextView_Humidity);
            holder.holderViewForecastTextView_avgTemperature = convertView.findViewById(R.id.adapterViewForecastTextView_avgTemperature);
            holder.holderViewForecastTextView_Description = convertView.findViewById(R.id.adapterViewForecastTextView_Description);
            holder.holderViewForecastTextView_maxTemperature = convertView.findViewById(R.id.adapterViewForecastTextView_maxTemperature);
            holder.holderViewForecastTextView_WindSpeed = convertView.findViewById(R.id.adapterViewForecastTextView_WindSpeed);
            holder.holderViewForecastTextView_Icon = convertView.findViewById(R.id.adapterViewForecastTextView_Icon);
            holder.holderViewForecastTextView_DateTime = convertView.findViewById(R.id.adapterViewForecastTextView_DateTime);

            result=convertView;
            convertView.setTag(holder);
        }
        else {
            //View referenced from memory
            holder=(ViewHolder)convertView.getTag();
            result=convertView;
        }


        Animation animation = AnimationUtils.loadAnimation(
                mContext,
                (position>lastPosition) ? R.anim.loading_down_anim : R.anim.loading_up_anim);
        result.startAnimation(animation);
        lastPosition=position;

        //Setting values
        holder.holderViewForecastTextView_Humidity.setText(String.valueOf(humidity));
        holder.holderViewForecastTextView_avgTemperature.setText(String.valueOf(avgTemperature));
        holder.holderViewForecastTextView_Description.setText(description);
        holder.holderViewForecastTextView_maxTemperature.setText(String.valueOf(maxTemperature));
        holder.holderViewForecastTextView_WindSpeed.setText(String.valueOf(windspeed));
        holder.holderViewForecastTextView_DateTime.setText(dateTime);
        Picasso.get().load(icon).into(holder.holderViewForecastTextView_Icon);

        return convertView;
    }

    static class ViewHolder {
        TextView holderViewForecastTextView_Humidity;
        TextView holderViewForecastTextView_avgTemperature;
        TextView holderViewForecastTextView_Description;
        TextView holderViewForecastTextView_maxTemperature;
        TextView holderViewForecastTextView_WindSpeed;
        ImageView holderViewForecastTextView_Icon;
        TextView holderViewForecastTextView_DateTime;
    }

}
