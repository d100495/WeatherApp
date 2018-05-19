package com.example.dunger.weatherappandroidclient.Models;

/**
 * Created by Dunger on 2018-05-19.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CurrentWeatherInfomet {

    @SerializedName("Place")
    @Expose
    private String place;
    @SerializedName("dt")
    @Expose
    private String dt;
    @SerializedName("TempOut")
    @Expose
    private String tempOut;
    @SerializedName("HiTemp")
    @Expose
    private String hiTemp;
    @SerializedName("LowTemp")
    @Expose
    private String lowTemp;
    @SerializedName("OutHum")
    @Expose
    private String outHum;
    @SerializedName("DevPt")
    @Expose
    private String devPt;
    @SerializedName("WindSpeed")
    @Expose
    private String windSpeed;
    @SerializedName("WindDir")
    @Expose
    private String windDir;
    @SerializedName("WindRun")
    @Expose
    private String windRun;
    @SerializedName("HiSpeed")
    @Expose
    private String hiSpeed;
    @SerializedName("HiDir")
    @Expose
    private String hiDir;
    @SerializedName("WindChill")
    @Expose
    private String windChill;
    @SerializedName("HeatIndex")
    @Expose
    private String heatIndex;
    @SerializedName("THWIndex")
    @Expose
    private String tHWIndex;
    @SerializedName("Bar")
    @Expose
    private String bar;
    @SerializedName("Rain")
    @Expose
    private String rain;
    @SerializedName("RainRate")
    @Expose
    private String rainRate;
    @SerializedName("HeatDD")
    @Expose
    private String heatDD;
    @SerializedName("CoolDD")
    @Expose
    private String coolDD;
    @SerializedName("InTemp")
    @Expose
    private String inTemp;
    @SerializedName("InHum")
    @Expose
    private String inHum;
    @SerializedName("InDev")
    @Expose
    private String inDev;
    @SerializedName("InHeat")
    @Expose
    private String inHeat;
    @SerializedName("InEMC")
    @Expose
    private String inEMC;
    @SerializedName("In_AirDencity")
    @Expose
    private String inAirDencity;
    @SerializedName("WindSamp")
    @Expose
    private String windSamp;
    @SerializedName("WindTx")
    @Expose
    private String windTx;
    @SerializedName("ISSRecepr")
    @Expose
    private String iSSRecepr;
    @SerializedName("Arc_Int")
    @Expose
    private String arcInt;

    /**
     * No args constructor for use in serialization
     */
    public CurrentWeatherInfomet() {
    }

    /**
     * @param dt
     * @param arcInt
     * @param inHeat
     * @param windSamp
     * @param inAirDencity
     * @param windRun
     * @param heatIndex
     * @param hiSpeed
     * @param inEMC
     * @param devPt
     * @param windTx
     * @param lowTemp
     * @param windChill
     * @param tHWIndex
     * @param place
     * @param rain
     * @param hiTemp
     * @param coolDD
     * @param rainRate
     * @param inDev
     * @param windSpeed
     * @param inHum
     * @param heatDD
     * @param tempOut
     * @param inTemp
     * @param bar
     * @param windDir
     * @param outHum
     * @param hiDir
     * @param iSSRecepr
     */
    public CurrentWeatherInfomet(String place, String dt, String tempOut, String hiTemp, String lowTemp, String outHum, String devPt, String windSpeed,
                                 String windDir, String windRun, String hiSpeed, String hiDir, String windChill, String heatIndex, String tHWIndex,
                                 String bar, String rain, String rainRate, String heatDD, String coolDD, String inTemp, String inHum,
                                 String inDev, String inHeat, String inEMC, String inAirDencity, String windSamp, String windTx, String iSSRecepr, String arcInt) {
        super();
        this.place = place;
        this.dt = dt;
        this.tempOut = tempOut;
        this.hiTemp = hiTemp;
        this.lowTemp = lowTemp;
        this.outHum = outHum;
        this.devPt = devPt;
        this.windSpeed = windSpeed;
        this.windDir = windDir;
        this.windRun = windRun;
        this.hiSpeed = hiSpeed;
        this.hiDir = hiDir;
        this.windChill = windChill;
        this.heatIndex = heatIndex;
        this.tHWIndex = tHWIndex;
        this.bar = bar;
        this.rain = rain;
        this.rainRate = rainRate;
        this.heatDD = heatDD;
        this.coolDD = coolDD;
        this.inTemp = inTemp;
        this.inHum = inHum;
        this.inDev = inDev;
        this.inHeat = inHeat;
        this.inEMC = inEMC;
        this.inAirDencity = inAirDencity;
        this.windSamp = windSamp;
        this.windTx = windTx;
        this.iSSRecepr = iSSRecepr;
        this.arcInt = arcInt;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public String getTempOut() {
        if (tempOut != null) {
            return tempOut;
        } else {
            return "0";
        }
    }

    public void setTempOut(String tempOut) {
        this.tempOut = tempOut;
    }

    public String getHiTemp() {
        return hiTemp;
    }

    public void setHiTemp(String hiTemp) {
        this.hiTemp = hiTemp;
    }

    public String getLowTemp() {
        return lowTemp;
    }

    public void setLowTemp(String lowTemp) {
        this.lowTemp = lowTemp;
    }

    public String getOutHum() {
        return outHum;
    }

    public void setOutHum(String outHum) {
        this.outHum = outHum;
    }

    public String getDevPt() {
        return devPt;
    }

    public void setDevPt(String devPt) {
        this.devPt = devPt;
    }

    public String getWindSpeed() {
        if (windSpeed != null) {
            return windSpeed;
        } else {
            return "0";
        }
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDir() {
        return windDir;
    }

    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }

    public String getWindRun() {
        return windRun;
    }

    public void setWindRun(String windRun) {
        this.windRun = windRun;
    }

    public String getHiSpeed() {
        return hiSpeed;
    }

    public void setHiSpeed(String hiSpeed) {
        this.hiSpeed = hiSpeed;
    }

    public String getHiDir() {
        return hiDir;
    }

    public void setHiDir(String hiDir) {
        this.hiDir = hiDir;
    }

    public String getWindChill() {
        return windChill;
    }

    public void setWindChill(String windChill) {
        this.windChill = windChill;
    }

    public String getHeatIndex() {
        return heatIndex;
    }

    public void setHeatIndex(String heatIndex) {
        this.heatIndex = heatIndex;
    }

    public String getTHWIndex() {
        return tHWIndex;
    }

    public void setTHWIndex(String tHWIndex) {
        this.tHWIndex = tHWIndex;
    }

    public String getBar() {
        if (bar != null) {
            return bar;
        } else {
            return "0";
        }

    }

    public void setBar(String bar) {
        this.bar = bar;
    }

    public String getRain() {
        return rain;
    }

    public void setRain(String rain) {
        this.rain = rain;
    }

    public String getRainRate() {
        return rainRate;
    }

    public void setRainRate(String rainRate) {
        this.rainRate = rainRate;
    }

    public String getHeatDD() {
        return heatDD;
    }

    public void setHeatDD(String heatDD) {
        this.heatDD = heatDD;
    }

    public String getCoolDD() {
        return coolDD;
    }

    public void setCoolDD(String coolDD) {
        this.coolDD = coolDD;
    }

    public String getInTemp() {
        return inTemp;
    }

    public void setInTemp(String inTemp) {
        this.inTemp = inTemp;
    }

    public String getInHum() {
        if (inHum != null) {
            return inHum;
        } else {
            return "0";
        }
    }

    public void setInHum(String inHum) {
        this.inHum = inHum;
    }

    public String getInDev() {
        return inDev;
    }

    public void setInDev(String inDev) {
        this.inDev = inDev;
    }

    public String getInHeat() {
        return inHeat;
    }

    public void setInHeat(String inHeat) {
        this.inHeat = inHeat;
    }

    public String getInEMC() {
        return inEMC;
    }

    public void setInEMC(String inEMC) {
        this.inEMC = inEMC;
    }

    public String getInAirDencity() {
        if (inAirDencity != null) {
            return inAirDencity;
        } else {
            return "0";
        }
    }

    public void setInAirDencity(String inAirDencity) {
        this.inAirDencity = inAirDencity;
    }

    public String getWindSamp() {
        return windSamp;
    }

    public void setWindSamp(String windSamp) {
        this.windSamp = windSamp;
    }

    public String getWindTx() {
        return windTx;
    }

    public void setWindTx(String windTx) {
        this.windTx = windTx;
    }

    public String getISSRecepr() {
        return iSSRecepr;
    }

    public void setISSRecepr(String iSSRecepr) {
        this.iSSRecepr = iSSRecepr;
    }

    public String getArcInt() {
        return arcInt;
    }

    public void setArcInt(String arcInt) {
        this.arcInt = arcInt;
    }

}