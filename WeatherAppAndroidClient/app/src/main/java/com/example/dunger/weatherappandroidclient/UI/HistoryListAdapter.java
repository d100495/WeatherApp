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
import com.example.dunger.weatherappandroidclient.Models.WeatherHistory;
import com.example.dunger.weatherappandroidclient.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Dunger on 2018-04-22.
 */

public class HistoryListAdapter extends ArrayAdapter<WeatherHistory> {

    //Debug variables
    private static final String TAG = ForecastListAdapter.class.getSimpleName();

    private Context mContext;
    private int mResource;
    private int lastPosition = -1;

    public HistoryListAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Row details
        double weatherId = getItem(position).getWeatherId();
        double lon =getItem(position).getLongitude();
        double lat = getItem(position).getLatitude();
        double temperature =getItem(position).getTemperature();
        double pressure = getItem(position).getPressure();
        double windspeed = getItem(position).getWindSpeed();
        double windchill = getItem(position).getWindChill();
        String dateTime = getItem(position).getDate();


        WeatherHistory weatherHistory = new WeatherHistory(

        );

        //View result for showing animations
        final View result;
        //Holder init
        HistoryListAdapter.ViewHolder holder = new HistoryListAdapter.ViewHolder();

        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(mResource, parent, false);

            //Getting view elements
            holder.holderHistoryTextViewLat = convertView.findViewById(R.id.historyTextViewLat);
            holder.holderHistoryTextViewLon = convertView.findViewById(R.id.historyTextViewLon);
            holder.holderHistoryTextViewTemp =convertView.findViewById(R.id.historyTextViewTemp);
            holder.holderHistoryTextViewPressure = convertView.findViewById(R.id.historyTextViewPressure);
            holder.holderHistoryTextViewWindspeed = convertView.findViewById(R.id.historyTextViewWindSpeed);
            holder.holderHistoryTextViewWindchill = convertView.findViewById(R.id.historyTextViewWindChill);
            holder.holderHistoryTextViewDateTime = convertView.findViewById(R.id.historyTextViewDateTime);

            result = convertView;
            convertView.setTag(holder);
        } else {
            //View referenced from memory
            holder = (HistoryListAdapter.ViewHolder) convertView.getTag();
            result = convertView;
        }


        Animation animation = AnimationUtils.loadAnimation(
                mContext,
                (position > lastPosition) ? R.anim.loading_down_anim : R.anim.loading_up_anim);
        result.startAnimation(animation);
        lastPosition = position;

        //Setting values
        holder.holderHistoryTextViewLat.setText(String.valueOf(lat));
        holder.holderHistoryTextViewLon.setText(String.valueOf(lon));
        holder.holderHistoryTextViewTemp.setText(String.valueOf(temperature));
        holder.holderHistoryTextViewPressure.setText(String.valueOf(pressure));
        holder.holderHistoryTextViewWindspeed.setText(String.valueOf(windspeed));
        holder.holderHistoryTextViewWindchill.setText(String.valueOf(windchill));
        holder.holderHistoryTextViewDateTime.setText(dateTime);

        return convertView;
    }

    static class ViewHolder {
        TextView holderHistoryTextViewLat;
        TextView holderHistoryTextViewLon;
        TextView holderHistoryTextViewTemp;
        TextView holderHistoryTextViewPressure;
        TextView holderHistoryTextViewWindspeed;
        TextView holderHistoryTextViewWindchill;
        TextView holderHistoryTextViewDateTime;
    }
}
