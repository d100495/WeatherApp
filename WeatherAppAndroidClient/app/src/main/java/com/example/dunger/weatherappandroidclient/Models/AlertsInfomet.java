package com.example.dunger.weatherappandroidclient.Models;

/**
 * Created by Dunger on 2018-05-19.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AlertsInfomet {

    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("dt")
    @Expose
    private String dt;

    /**
     * No args constructor for use in serialization
     *
     */
    public AlertsInfomet() {
    }

    /**
     *
     * @param dt
     * @param message
     */
    public AlertsInfomet(String message, String dt) {
        super();
        this.message = message;
        this.dt = dt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

}