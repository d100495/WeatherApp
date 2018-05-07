package com.example.dunger.weatherappandroidclient.Models;

/**
 * Created by Dunger on 2018-04-21.
 */

public class ForecastWeatherForListAdapter {

    double humidity;
    double avgTemperature;
    double maxTemperature;
    double windspeed;
    String icon;
    String description;
    String dateTime;

    public ForecastWeatherForListAdapter(double humidity, double avgTemperature, double maxTemperature, double windspeed, String icon, String description, String dateTime) {
        this.humidity = humidity;
        this.avgTemperature = avgTemperature;
        this.maxTemperature = maxTemperature;
        this.windspeed = windspeed;
        this.icon = icon;
        this.description = description;
        this.dateTime = dateTime;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getAvgTemperature() {
        return avgTemperature;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public double getWindspeed() {
        return windspeed;
    }

    public String getIcon() {
        return icon;
    }

    public String getDescription() {
        return description;
    }

    public String getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "ForecastWeatherForListAdapter{" +
                "humidity=" + humidity +
                ", avgTemperature=" + avgTemperature +
                ", maxTemperature=" + maxTemperature +
                ", windspeed=" + windspeed +
                ", icon='" + icon + '\'' +
                ", description='" + description + '\'' +
                ", dateTime='" + dateTime + '\'' +
                '}';
    }
}
