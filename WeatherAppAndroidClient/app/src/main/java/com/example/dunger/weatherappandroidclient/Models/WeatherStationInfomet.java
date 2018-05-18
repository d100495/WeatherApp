package com.example.dunger.weatherappandroidclient.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Random;

/**
 * Created by Dunger on 2018-05-18.
 */
public class WeatherStationInfomet implements IWeatherStation {

    @SerializedName("station")
    @Expose
    private String station;
    @SerializedName("ID")
    @Expose
    private String iD;
    @SerializedName("Longitude")
    @Expose
    private String longitude;
    @SerializedName("Latitude")
    @Expose
    private String latitude;

    /**
     * No args constructor for use in serialization
     */
    public WeatherStationInfomet() {
    }

    /**
     * @param station
     * @param longitude
     * @param latitude
     * @param iD
     */
    public WeatherStationInfomet(String station, String iD, String longitude, String latitude) {
        super();
        this.station = station;
        this.iD = iD;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return getID() + ". " + getCityName();
    }

    public String getID() {
        return iD;
    }

    public void setID(String iD) {
        this.iD = iD;
    }

    @Override
    public String getCityName() {
        return station;
    }

    public double getLongitude() {
        if (longitude != null && !(longitude.equals(" ")) && !(longitude.equals("  ")) && !(longitude.equals("")) && longitude.length() > 0 && !longitude.isEmpty()) {
            return Double.parseDouble(longitude);
        } else {
            //TODO Geocoding
            Random r = new Random();
            double randomValue = 0 + (10 - 0) * r.nextDouble();
            return randomValue;
        }
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        if (latitude != null && !(latitude.equals(" ")) && !(latitude.equals("  ")) && !(latitude.equals("")) && latitude.length() > 0 && !latitude.isEmpty()) {
            return Double.parseDouble(latitude);
        } else {
            //TODO Geocoding
            Random r = new Random();
            double randomValue = 0 + (10 - 0) * r.nextDouble();
            return randomValue;
        }
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

}