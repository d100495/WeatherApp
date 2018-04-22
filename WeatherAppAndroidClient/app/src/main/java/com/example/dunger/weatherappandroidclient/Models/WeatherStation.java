package com.example.dunger.weatherappandroidclient.Models;

/**
 * Created by Dunger on 2018-04-03.
 */

public class WeatherStation {

    int weatherStationId;
    String cityName;
    double longitude;
    double latitude;
    String date;



    @Override
    public String toString() {
        return weatherStationId + ". " + cityName;
    }


    public String wholeString(){
        return "WeatherStation{" +
                "weatherStationId=" + weatherStationId +
                ", cityName='" + cityName + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }


    public WeatherStation(int weatherStationId, String cityName, double longitude, double latitude, String date) {
        this.weatherStationId = weatherStationId;
        this.cityName = cityName;
        this.longitude = longitude;
        this.latitude = latitude;
        this.date = date;
    }

    public WeatherStation(int weatherStationId, String cityName, double longitude, double latitude) {
        this.weatherStationId = weatherStationId;
        this.cityName = cityName;
        this.longitude = longitude;
        this.latitude = latitude;
        this.date="0";
    }

    public int getWeatherStationId() {

        return weatherStationId;
    }

    public void setWeatherStationId(int weatherStationId) {
        this.weatherStationId = weatherStationId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
