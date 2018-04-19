package com.example.dunger.weatherappandroidclient.Models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dunger on 2018-04-19.
 */

public class ForecastWeatherApixu {

    public class Astro {

        private String sunrise;
        private String sunset;
        private String moonrise;
        private String moonset;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        public String getSunrise() {
            return sunrise;
        }

        public void setSunrise(String sunrise) {
            this.sunrise = sunrise;
        }

        public String getSunset() {
            return sunset;
        }

        public void setSunset(String sunset) {
            this.sunset = sunset;
        }

        public String getMoonrise() {
            return moonrise;
        }

        public void setMoonrise(String moonrise) {
            this.moonrise = moonrise;
        }

        public String getMoonset() {
            return moonset;
        }

        public void setMoonset(String moonset) {
            this.moonset = moonset;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    public class Condition {

        private String text;
        private String icon;
        private Integer code;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    public class Condition_ {

        private String text;
        private String icon;
        private Integer code;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    public class Current {

        private Integer lastUpdatedEpoch;
        private String lastUpdated;
        private Integer tempC;
        private Integer tempF;
        private Integer isDay;
        private Condition condition;
        private Double windMph;
        private Double windKph;
        private Integer windDegree;
        private String windDir;
        private Integer pressureMb;
        private Double pressureIn;
        private Integer precipMm;
        private Integer precipIn;
        private Integer humidity;
        private Integer cloud;
        private Integer feelslikeC;
        private Integer feelslikeF;
        private Integer visKm;
        private Integer visMiles;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        public Integer getLastUpdatedEpoch() {
            return lastUpdatedEpoch;
        }

        public void setLastUpdatedEpoch(Integer lastUpdatedEpoch) {
            this.lastUpdatedEpoch = lastUpdatedEpoch;
        }

        public String getLastUpdated() {
            return lastUpdated;
        }

        public void setLastUpdated(String lastUpdated) {
            this.lastUpdated = lastUpdated;
        }

        public Integer getTempC() {
            return tempC;
        }

        public void setTempC(Integer tempC) {
            this.tempC = tempC;
        }

        public Integer getTempF() {
            return tempF;
        }

        public void setTempF(Integer tempF) {
            this.tempF = tempF;
        }

        public Integer getIsDay() {
            return isDay;
        }

        public void setIsDay(Integer isDay) {
            this.isDay = isDay;
        }

        public Condition getCondition() {
            return condition;
        }

        public void setCondition(Condition condition) {
            this.condition = condition;
        }

        public Double getWindMph() {
            return windMph;
        }

        public void setWindMph(Double windMph) {
            this.windMph = windMph;
        }

        public Double getWindKph() {
            return windKph;
        }

        public void setWindKph(Double windKph) {
            this.windKph = windKph;
        }

        public Integer getWindDegree() {
            return windDegree;
        }

        public void setWindDegree(Integer windDegree) {
            this.windDegree = windDegree;
        }

        public String getWindDir() {
            return windDir;
        }

        public void setWindDir(String windDir) {
            this.windDir = windDir;
        }

        public Integer getPressureMb() {
            return pressureMb;
        }

        public void setPressureMb(Integer pressureMb) {
            this.pressureMb = pressureMb;
        }

        public Double getPressureIn() {
            return pressureIn;
        }

        public void setPressureIn(Double pressureIn) {
            this.pressureIn = pressureIn;
        }

        public Integer getPrecipMm() {
            return precipMm;
        }

        public void setPrecipMm(Integer precipMm) {
            this.precipMm = precipMm;
        }

        public Integer getPrecipIn() {
            return precipIn;
        }

        public void setPrecipIn(Integer precipIn) {
            this.precipIn = precipIn;
        }

        public Integer getHumidity() {
            return humidity;
        }

        public void setHumidity(Integer humidity) {
            this.humidity = humidity;
        }

        public Integer getCloud() {
            return cloud;
        }

        public void setCloud(Integer cloud) {
            this.cloud = cloud;
        }

        public Integer getFeelslikeC() {
            return feelslikeC;
        }

        public void setFeelslikeC(Integer feelslikeC) {
            this.feelslikeC = feelslikeC;
        }

        public Integer getFeelslikeF() {
            return feelslikeF;
        }

        public void setFeelslikeF(Integer feelslikeF) {
            this.feelslikeF = feelslikeF;
        }

        public Integer getVisKm() {
            return visKm;
        }

        public void setVisKm(Integer visKm) {
            this.visKm = visKm;
        }

        public Integer getVisMiles() {
            return visMiles;
        }

        public void setVisMiles(Integer visMiles) {
            this.visMiles = visMiles;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    public class Day {

        private Double maxtempC;
        private Double maxtempF;
        private Double mintempC;
        private Double mintempF;
        private Double avgtempC;
        private Double avgtempF;
        private Double maxwindMph;
        private Double maxwindKph;
        private Double totalprecipMm;
        private Double totalprecipIn;
        private Double avgvisKm;
        private Integer avgvisMiles;
        private Integer avghumidity;
        private Condition_ condition;
        private Integer uv;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        public Double getMaxtempC() {
            return maxtempC;
        }

        public void setMaxtempC(Double maxtempC) {
            this.maxtempC = maxtempC;
        }

        public Double getMaxtempF() {
            return maxtempF;
        }

        public void setMaxtempF(Double maxtempF) {
            this.maxtempF = maxtempF;
        }

        public Double getMintempC() {
            return mintempC;
        }

        public void setMintempC(Double mintempC) {
            this.mintempC = mintempC;
        }

        public Double getMintempF() {
            return mintempF;
        }

        public void setMintempF(Double mintempF) {
            this.mintempF = mintempF;
        }

        public Double getAvgtempC() {
            return avgtempC;
        }

        public void setAvgtempC(Double avgtempC) {
            this.avgtempC = avgtempC;
        }

        public Double getAvgtempF() {
            return avgtempF;
        }

        public void setAvgtempF(Double avgtempF) {
            this.avgtempF = avgtempF;
        }

        public Double getMaxwindMph() {
            return maxwindMph;
        }

        public void setMaxwindMph(Double maxwindMph) {
            this.maxwindMph = maxwindMph;
        }

        public Double getMaxwindKph() {
            return maxwindKph;
        }

        public void setMaxwindKph(Double maxwindKph) {
            this.maxwindKph = maxwindKph;
        }

        public Double getTotalprecipMm() {
            return totalprecipMm;
        }

        public void setTotalprecipMm(Double totalprecipMm) {
            this.totalprecipMm = totalprecipMm;
        }

        public Double getTotalprecipIn() {
            return totalprecipIn;
        }

        public void setTotalprecipIn(Double totalprecipIn) {
            this.totalprecipIn = totalprecipIn;
        }

        public Double getAvgvisKm() {
            return avgvisKm;
        }

        public void setAvgvisKm(Double avgvisKm) {
            this.avgvisKm = avgvisKm;
        }

        public Integer getAvgvisMiles() {
            return avgvisMiles;
        }

        public void setAvgvisMiles(Integer avgvisMiles) {
            this.avgvisMiles = avgvisMiles;
        }

        public Integer getAvghumidity() {
            return avghumidity;
        }

        public void setAvghumidity(Integer avghumidity) {
            this.avghumidity = avghumidity;
        }

        public Condition_ getCondition() {
            return condition;
        }

        public void setCondition(Condition_ condition) {
            this.condition = condition;
        }

        public Integer getUv() {
            return uv;
        }

        public void setUv(Integer uv) {
            this.uv = uv;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    public class Example {

        private Location location;
        private Current current;
        private Forecast forecast;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }

        public Current getCurrent() {
            return current;
        }

        public void setCurrent(Current current) {
            this.current = current;
        }

        public Forecast getForecast() {
            return forecast;
        }

        public void setForecast(Forecast forecast) {
            this.forecast = forecast;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    public class Forecast {

        private List<Forecastday> forecastday = null;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        public List<Forecastday> getForecastday() {
            return forecastday;
        }

        public void setForecastday(List<Forecastday> forecastday) {
            this.forecastday = forecastday;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    public class Forecastday {

        private String date;
        private Integer dateEpoch;
        private Day day;
        private Astro astro;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public Integer getDateEpoch() {
            return dateEpoch;
        }

        public void setDateEpoch(Integer dateEpoch) {
            this.dateEpoch = dateEpoch;
        }

        public Day getDay() {
            return day;
        }

        public void setDay(Day day) {
            this.day = day;
        }

        public Astro getAstro() {
            return astro;
        }

        public void setAstro(Astro astro) {
            this.astro = astro;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    public class Location {

        private String name;
        private String region;
        private String country;
        private Double lat;
        private Integer lon;
        private String tzId;
        private Integer localtimeEpoch;
        private String localtime;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public Double getLat() {
            return lat;
        }

        public void setLat(Double lat) {
            this.lat = lat;
        }

        public Integer getLon() {
            return lon;
        }

        public void setLon(Integer lon) {
            this.lon = lon;
        }

        public String getTzId() {
            return tzId;
        }

        public void setTzId(String tzId) {
            this.tzId = tzId;
        }

        public Integer getLocaltimeEpoch() {
            return localtimeEpoch;
        }

        public void setLocaltimeEpoch(Integer localtimeEpoch) {
            this.localtimeEpoch = localtimeEpoch;
        }

        public String getLocaltime() {
            return localtime;
        }

        public void setLocaltime(String localtime) {
            this.localtime = localtime;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }
}
