package com.example.dunger.weatherappandroidclient.Models;

/**
 * Created by Dunger on 2018-04-22.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherHistory {

    @SerializedName("weatherId")
    @Expose
    private double weatherId;
    @SerializedName("longitude")
    @Expose
    private double longitude;
    @SerializedName("latitude")
    @Expose
    private double latitude;
    @SerializedName("temperature")
    @Expose
    private double temperature;
    @SerializedName("pressure")
    @Expose
    private double pressure;
    @SerializedName("windSpeed")
    @Expose
    private double windSpeed;
    @SerializedName("windChill")
    @Expose
    private double windChill;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("id")
    @Expose
    private String id;

    /**
     * No args constructor for use in serialization
     */
    public WeatherHistory() {
    }

    /**
     * @param id
     * @param windSpeed
     * @param pressure
     * @param longitude
     * @param windChill
     * @param latitude
     * @param date
     * @param temperature
     * @param weatherId
     */
    public WeatherHistory(double weatherId, double longitude, double latitude, double temperature, double pressure, double windSpeed, double windChill, String date, String id) {
        super();
        this.weatherId = weatherId;
        this.longitude = longitude;
        this.latitude = latitude;
        this.temperature = temperature;
        this.pressure = pressure;
        this.windSpeed = windSpeed;
        this.windChill = windChill;
        this.date = date;
        this.id = id;
    }

    public double getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(double weatherId) {
        this.weatherId = weatherId;
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

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getWindChill() {
        return windChill;
    }

    public void setWindChill(double windChill) {
        this.windChill = windChill;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
