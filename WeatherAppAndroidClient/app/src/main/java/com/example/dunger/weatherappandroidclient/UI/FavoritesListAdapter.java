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
import android.widget.Button;
import android.widget.TextView;

import com.example.dunger.weatherappandroidclient.Models.WeatherStation;
import com.example.dunger.weatherappandroidclient.R;

import java.util.List;

/**
 * Created by Dunger on 2018-04-21.
 */

public class FavoritesListAdapter extends ArrayAdapter<WeatherStation> {
    //Debug variables
    private static final String TAG = FavoritesListAdapter.class.getSimpleName();

    private Context mContext;
    private int mResource;
    private int lastPosition = -1;

    public FavoritesListAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Row details
        int weatherStationId = getItem(position).getWeatherStationId();
        String cityName = getItem(position).getCityName();
        double lat = getItem(position).getLatitude();
        double lon = getItem(position).getLongitude();

        WeatherStation weatherStation = new WeatherStation(weatherStationId, cityName, lat, lon);

        //View result for showing animations
        final View result;
        //Holder init
        FavoritesListAdapter.ViewHolder holder = new FavoritesListAdapter.ViewHolder();

        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(mResource, parent, false);

            //Getting view elements
            holder.holderViewFavoriteCityName = convertView.findViewById(R.id.favoritesCityTextView);
            holder.holderViewFavoriteLat = convertView.findViewById(R.id.favoritesLatTextView);
            holder.holderViewFavoriteLon = convertView.findViewById(R.id.favoritesLonTextView);
            holder.holderViewFavoriteButton = convertView.findViewById(R.id.favoritesDeleteButton);

            result = convertView;
            convertView.setTag(holder);
        } else {
            //View referenced from memory
            holder = (FavoritesListAdapter.ViewHolder) convertView.getTag();
            result = convertView;
        }


        Animation animation = AnimationUtils.loadAnimation(
                mContext,
                (position > lastPosition) ? R.anim.loading_down_anim : R.anim.loading_up_anim);
        result.startAnimation(animation);
        lastPosition = position;

        //Setting values
        holder.holderViewFavoriteCityName.setText(cityName);
        holder.holderViewFavoriteLat.setText(String.valueOf(lat));
        holder.holderViewFavoriteLon.setText(String.valueOf(lon));
        holder.holderViewFavoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO delete single weatherstation in favorites by id
            }
        });

        return convertView;
    }

    static class ViewHolder {
        TextView holderViewFavoriteCityName;
        TextView holderViewFavoriteLat;
        TextView holderViewFavoriteLon;
        Button holderViewFavoriteButton;
    }
}
