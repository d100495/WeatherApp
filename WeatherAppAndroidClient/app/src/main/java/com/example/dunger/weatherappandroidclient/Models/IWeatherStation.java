package com.example.dunger.weatherappandroidclient.Models;

/**
 * Created by Dunger on 2018-05-18.
 */

public interface IWeatherStation {
    String getCityName();
    double getLongitude();
    double getLatitude();
    void setLatitude(double latitude);
    void setLongitude(double longitude);
    String getID();
}
