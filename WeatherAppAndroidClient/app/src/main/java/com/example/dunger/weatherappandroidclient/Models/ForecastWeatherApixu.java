package com.example.dunger.weatherappandroidclient.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ForecastWeatherApixu {

    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("current")
    @Expose
    private Current current;
    @SerializedName("forecast")
    @Expose
    private Forecast forecast;

    /**
     * No args constructor for use in serialization
     */
    public ForecastWeatherApixu() {
    }

    /**
     * @param forecast
     * @param location
     * @param current
     */
    public ForecastWeatherApixu(Location location, Current current, Forecast forecast) {
        super();
        this.location = location;
        this.current = current;
        this.forecast = forecast;
    }

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

    @Override
    public String toString() {
        return "ForecastWeatherApixu{" +
                "location=" + location +
                ", current=" + current +
                ", forecast=" + forecast +
                '}';
    }


    public class Astro {

        @SerializedName("sunrise")
        @Expose
        private String sunrise;
        @SerializedName("sunset")
        @Expose
        private String sunset;
        @SerializedName("moonrise")
        @Expose
        private String moonrise;
        @SerializedName("moonset")
        @Expose
        private String moonset;

        /**
         * No args constructor for use in serialization
         */
        public Astro() {
        }

        /**
         * @param moonset
         * @param sunset
         * @param sunrise
         * @param moonrise
         */
        public Astro(String sunrise, String sunset, String moonrise, String moonset) {
            super();
            this.sunrise = sunrise;
            this.sunset = sunset;
            this.moonrise = moonrise;
            this.moonset = moonset;
        }

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

        @Override
        public String toString() {
            return "Astro{" +
                    "sunrise='" + sunrise + '\'' +
                    ", sunset='" + sunset + '\'' +
                    ", moonrise='" + moonrise + '\'' +
                    ", moonset='" + moonset + '\'' +
                    '}';
        }
    }

    public class Condition {

        @SerializedName("text")
        @Expose
        private String text;
        @SerializedName("icon")
        @Expose
        private String icon;
        @SerializedName("code")
        @Expose
        private double code;

        /**
         * No args constructor for use in serialization
         */
        public Condition() {
        }

        /**
         * @param icon
         * @param text
         * @param code
         */
        public Condition(String text, String icon, double code) {
            super();
            this.text = text;
            this.icon = icon;
            this.code = code;
        }

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

        public double getCode() {
            return code;
        }

        public void setCode(double code) {
            this.code = code;
        }

        @Override
        public String toString() {
            return "Condition{" +
                    "text='" + text + '\'' +
                    ", icon='" + icon + '\'' +
                    ", code=" + code +
                    '}';
        }
    }

    public class Condition_ {

        @SerializedName("text")
        @Expose
        private String text;
        @SerializedName("icon")
        @Expose
        private String icon;
        @SerializedName("code")
        @Expose
        private double code;

        /**
         * No args constructor for use in serialization
         */
        public Condition_() {
        }

        /**
         * @param icon
         * @param text
         * @param code
         */
        public Condition_(String text, String icon, double code) {
            super();
            this.text = text;
            this.icon = icon;
            this.code = code;
        }

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

        public double getCode() {
            return code;
        }

        public void setCode(double code) {
            this.code = code;
        }

        @Override
        public String toString() {
            return "Condition_{" +
                    "text='" + text + '\'' +
                    ", icon='" + icon + '\'' +
                    ", code=" + code +
                    '}';
        }
    }

    public class Current {

        @SerializedName("last_updated_epoch")
        @Expose
        private double lastUpdatedEpoch;
        @SerializedName("last_updated")
        @Expose
        private String lastUpdated;
        @SerializedName("temp_c")
        @Expose
        private double tempC;
        @SerializedName("temp_f")
        @Expose
        private double tempF;
        @SerializedName("is_day")
        @Expose
        private double isDay;
        @SerializedName("condition")
        @Expose
        private Condition condition;
        @SerializedName("wind_mph")
        @Expose
        private double windMph;
        @SerializedName("wind_kph")
        @Expose
        private double windKph;
        @SerializedName("wind_degree")
        @Expose
        private double windDegree;
        @SerializedName("wind_dir")
        @Expose
        private String windDir;
        @SerializedName("pressure_mb")
        @Expose
        private double pressureMb;
        @SerializedName("pressure_in")
        @Expose
        private double pressureIn;
        @SerializedName("precip_mm")
        @Expose
        private double precipMm;
        @SerializedName("precip_in")
        @Expose
        private double precipIn;
        @SerializedName("humidity")
        @Expose
        private double humidity;
        @SerializedName("cloud")
        @Expose
        private double cloud;
        @SerializedName("feelslike_c")
        @Expose
        private double feelslikeC;
        @SerializedName("feelslike_f")
        @Expose
        private double feelslikeF;
        @SerializedName("vis_km")
        @Expose
        private double visKm;
        @SerializedName("vis_miles")
        @Expose
        private double visMiles;

        /**
         * No args constructor for use in serialization
         */
        public Current() {
        }

        /**
         * @param tempC
         * @param feelslikeC
         * @param visKm
         * @param condition
         * @param pressureMb
         * @param windKph
         * @param precipMm
         * @param lastUpdated
         * @param isDay
         * @param visMiles
         * @param windMph
         * @param windDegree
         * @param humidity
         * @param lastUpdatedEpoch
         * @param precipIn
         * @param cloud
         * @param pressureIn
         * @param tempF
         * @param feelslikeF
         * @param windDir
         */
        public Current(double lastUpdatedEpoch, String lastUpdated, double tempC, double tempF, double isDay, Condition condition, double windMph, double windKph, double windDegree, String windDir, double pressureMb, double pressureIn, double precipMm, double precipIn, double humidity, double cloud, double feelslikeC, double feelslikeF, double visKm, double visMiles) {
            super();
            this.lastUpdatedEpoch = lastUpdatedEpoch;
            this.lastUpdated = lastUpdated;
            this.tempC = tempC;
            this.tempF = tempF;
            this.isDay = isDay;
            this.condition = condition;
            this.windMph = windMph;
            this.windKph = windKph;
            this.windDegree = windDegree;
            this.windDir = windDir;
            this.pressureMb = pressureMb;
            this.pressureIn = pressureIn;
            this.precipMm = precipMm;
            this.precipIn = precipIn;
            this.humidity = humidity;
            this.cloud = cloud;
            this.feelslikeC = feelslikeC;
            this.feelslikeF = feelslikeF;
            this.visKm = visKm;
            this.visMiles = visMiles;
        }

        public double getLastUpdatedEpoch() {
            return lastUpdatedEpoch;
        }

        public void setLastUpdatedEpoch(double lastUpdatedEpoch) {
            this.lastUpdatedEpoch = lastUpdatedEpoch;
        }

        public String getLastUpdated() {
            return lastUpdated;
        }

        public void setLastUpdated(String lastUpdated) {
            this.lastUpdated = lastUpdated;
        }

        public double getTempC() {
            return tempC;
        }

        public void setTempC(double tempC) {
            this.tempC = tempC;
        }

        public double getTempF() {
            return tempF;
        }

        public void setTempF(double tempF) {
            this.tempF = tempF;
        }

        public double getIsDay() {
            return isDay;
        }

        public void setIsDay(double isDay) {
            this.isDay = isDay;
        }

        public Condition getCondition() {
            return condition;
        }

        public void setCondition(Condition condition) {
            this.condition = condition;
        }

        public double getWindMph() {
            return windMph;
        }

        public void setWindMph(double windMph) {
            this.windMph = windMph;
        }

        public double getWindKph() {
            return windKph;
        }

        public void setWindKph(double windKph) {
            this.windKph = windKph;
        }

        public double getWindDegree() {
            return windDegree;
        }

        public void setWindDegree(double windDegree) {
            this.windDegree = windDegree;
        }

        public String getWindDir() {
            return windDir;
        }

        public void setWindDir(String windDir) {
            this.windDir = windDir;
        }

        public double getPressureMb() {
            return pressureMb;
        }

        public void setPressureMb(double pressureMb) {
            this.pressureMb = pressureMb;
        }

        public double getPressureIn() {
            return pressureIn;
        }

        public void setPressureIn(double pressureIn) {
            this.pressureIn = pressureIn;
        }

        public double getPrecipMm() {
            return precipMm;
        }

        public void setPrecipMm(double precipMm) {
            this.precipMm = precipMm;
        }

        public double getPrecipIn() {
            return precipIn;
        }

        public void setPrecipIn(double precipIn) {
            this.precipIn = precipIn;
        }

        public double getHumidity() {
            return humidity;
        }

        public void setHumidity(double humidity) {
            this.humidity = humidity;
        }

        public double getCloud() {
            return cloud;
        }

        public void setCloud(double cloud) {
            this.cloud = cloud;
        }

        public double getFeelslikeC() {
            return feelslikeC;
        }

        public void setFeelslikeC(double feelslikeC) {
            this.feelslikeC = feelslikeC;
        }

        public double getFeelslikeF() {
            return feelslikeF;
        }

        public void setFeelslikeF(double feelslikeF) {
            this.feelslikeF = feelslikeF;
        }

        public double getVisKm() {
            return visKm;
        }

        public void setVisKm(double visKm) {
            this.visKm = visKm;
        }

        public double getVisMiles() {
            return visMiles;
        }

        public void setVisMiles(double visMiles) {
            this.visMiles = visMiles;
        }

        @Override
        public String toString() {
            return "Current{" +
                    "lastUpdatedEpoch=" + lastUpdatedEpoch +
                    ", lastUpdated='" + lastUpdated + '\'' +
                    ", tempC=" + tempC +
                    ", tempF=" + tempF +
                    ", isDay=" + isDay +
                    ", condition=" + condition +
                    ", windMph=" + windMph +
                    ", windKph=" + windKph +
                    ", windDegree=" + windDegree +
                    ", windDir='" + windDir + '\'' +
                    ", pressureMb=" + pressureMb +
                    ", pressureIn=" + pressureIn +
                    ", precipMm=" + precipMm +
                    ", precipIn=" + precipIn +
                    ", humidity=" + humidity +
                    ", cloud=" + cloud +
                    ", feelslikeC=" + feelslikeC +
                    ", feelslikeF=" + feelslikeF +
                    ", visKm=" + visKm +
                    ", visMiles=" + visMiles +
                    '}';
        }
    }

    public class Day {

        @SerializedName("maxtemp_c")
        @Expose
        private double maxtempC;
        @SerializedName("maxtemp_f")
        @Expose
        private double maxtempF;
        @SerializedName("mdoubleemp_c")
        @Expose
        private double mdoubleempC;
        @SerializedName("mdoubleemp_f")
        @Expose
        private double mdoubleempF;
        @SerializedName("avgtemp_c")
        @Expose
        private double avgtempC;
        @SerializedName("avgtemp_f")
        @Expose
        private double avgtempF;
        @SerializedName("maxwind_mph")
        @Expose
        private double maxwindMph;
        @SerializedName("maxwind_kph")
        @Expose
        private double maxwindKph;
        @SerializedName("totalprecip_mm")
        @Expose
        private double totalprecipMm;
        @SerializedName("totalprecip_in")
        @Expose
        private double totalprecipIn;
        @SerializedName("avgvis_km")
        @Expose
        private double avgvisKm;
        @SerializedName("avgvis_miles")
        @Expose
        private double avgvisMiles;
        @SerializedName("avghumidity")
        @Expose
        private double avghumidity;
        @SerializedName("condition")
        @Expose
        private Condition_ condition;
        @SerializedName("uv")
        @Expose
        private double uv;

        /**
         * No args constructor for use in serialization
         */
        public Day() {
        }

        /**
         * @param totalprecipMm
         * @param condition
         * @param avghumidity
         * @param mdoubleempF
         * @param avgtempF
         * @param maxwindMph
         * @param avgvisMiles
         * @param totalprecipIn
         * @param avgtempC
         * @param avgvisKm
         * @param uv
         * @param mdoubleempC
         * @param maxtempC
         * @param maxtempF
         * @param maxwindKph
         */
        public Day(double maxtempC, double maxtempF, double mdoubleempC, double mdoubleempF, double avgtempC, double avgtempF, double maxwindMph, double maxwindKph, double totalprecipMm, double totalprecipIn, double avgvisKm, double avgvisMiles, double avghumidity, Condition_ condition, double uv) {
            super();
            this.maxtempC = maxtempC;
            this.maxtempF = maxtempF;
            this.mdoubleempC = mdoubleempC;
            this.mdoubleempF = mdoubleempF;
            this.avgtempC = avgtempC;
            this.avgtempF = avgtempF;
            this.maxwindMph = maxwindMph;
            this.maxwindKph = maxwindKph;
            this.totalprecipMm = totalprecipMm;
            this.totalprecipIn = totalprecipIn;
            this.avgvisKm = avgvisKm;
            this.avgvisMiles = avgvisMiles;
            this.avghumidity = avghumidity;
            this.condition = condition;
            this.uv = uv;
        }

        public double getMaxtempC() {
            return maxtempC;
        }

        public void setMaxtempC(double maxtempC) {
            this.maxtempC = maxtempC;
        }

        public double getMaxtempF() {
            return maxtempF;
        }

        public void setMaxtempF(double maxtempF) {
            this.maxtempF = maxtempF;
        }

        public double getMdoubleempC() {
            return mdoubleempC;
        }

        public void setMdoubleempC(double mdoubleempC) {
            this.mdoubleempC = mdoubleempC;
        }

        public double getMdoubleempF() {
            return mdoubleempF;
        }

        public void setMdoubleempF(double mdoubleempF) {
            this.mdoubleempF = mdoubleempF;
        }

        public double getAvgtempC() {
            return avgtempC;
        }

        public void setAvgtempC(double avgtempC) {
            this.avgtempC = avgtempC;
        }

        public double getAvgtempF() {
            return avgtempF;
        }

        public void setAvgtempF(double avgtempF) {
            this.avgtempF = avgtempF;
        }

        public double getMaxwindMph() {
            return maxwindMph;
        }

        public void setMaxwindMph(double maxwindMph) {
            this.maxwindMph = maxwindMph;
        }

        public double getMaxwindKph() {
            return maxwindKph;
        }

        public void setMaxwindKph(double maxwindKph) {
            this.maxwindKph = maxwindKph;
        }

        public double getTotalprecipMm() {
            return totalprecipMm;
        }

        public void setTotalprecipMm(double totalprecipMm) {
            this.totalprecipMm = totalprecipMm;
        }

        public double getTotalprecipIn() {
            return totalprecipIn;
        }

        public void setTotalprecipIn(double totalprecipIn) {
            this.totalprecipIn = totalprecipIn;
        }

        public double getAvgvisKm() {
            return avgvisKm;
        }

        public void setAvgvisKm(double avgvisKm) {
            this.avgvisKm = avgvisKm;
        }

        public double getAvgvisMiles() {
            return avgvisMiles;
        }

        public void setAvgvisMiles(double avgvisMiles) {
            this.avgvisMiles = avgvisMiles;
        }

        public double getAvghumidity() {
            return avghumidity;
        }

        public void setAvghumidity(double avghumidity) {
            this.avghumidity = avghumidity;
        }

        public Condition_ getCondition() {
            return condition;
        }

        public void setCondition(Condition_ condition) {
            this.condition = condition;
        }

        public double getUv() {
            return uv;
        }

        public void setUv(double uv) {
            this.uv = uv;
        }

        @Override
        public String toString() {
            return "Day{" +
                    "maxtempC=" + maxtempC +
                    ", maxtempF=" + maxtempF +
                    ", mdoubleempC=" + mdoubleempC +
                    ", mdoubleempF=" + mdoubleempF +
                    ", avgtempC=" + avgtempC +
                    ", avgtempF=" + avgtempF +
                    ", maxwindMph=" + maxwindMph +
                    ", maxwindKph=" + maxwindKph +
                    ", totalprecipMm=" + totalprecipMm +
                    ", totalprecipIn=" + totalprecipIn +
                    ", avgvisKm=" + avgvisKm +
                    ", avgvisMiles=" + avgvisMiles +
                    ", avghumidity=" + avghumidity +
                    ", condition=" + condition +
                    ", uv=" + uv +
                    '}';
        }
    }

   public class Forecast {

        @SerializedName("forecastday")
        @Expose
        private List<Forecastday> forecastday = null;

        /**
         * No args constructor for use in serialization
         */
        public Forecast() {
        }

        /**
         * @param forecastday
         */
        public Forecast(List<Forecastday> forecastday) {
            super();
            this.forecastday = forecastday;
        }

        public List<Forecastday> getForecastday() {
            return forecastday;
        }

        public void setForecastday(List<Forecastday> forecastday) {
            this.forecastday = forecastday;
        }

        @Override
        public String toString() {
            return "Forecast{" +
                    "forecastday=" + forecastday +
                    '}';
        }
    }

    public class Forecastday {

        @SerializedName("date")
        @Expose
        private String date;
        @SerializedName("date_epoch")
        @Expose
        private double dateEpoch;
        @SerializedName("day")
        @Expose
        private Day day;
        @SerializedName("astro")
        @Expose
        private Astro astro;

        /**
         * No args constructor for use in serialization
         */
        public Forecastday() {
        }

        /**
         * @param astro
         * @param dateEpoch
         * @param day
         * @param date
         */
        public Forecastday(String date, double dateEpoch, Day day, Astro astro) {
            super();
            this.date = date;
            this.dateEpoch = dateEpoch;
            this.day = day;
            this.astro = astro;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public double getDateEpoch() {
            return dateEpoch;
        }

        public void setDateEpoch(double dateEpoch) {
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

        @Override
        public String toString() {
            return "Forecastday{" +
                    "date='" + date + '\'' +
                    ", dateEpoch=" + dateEpoch +
                    ", day=" + day +
                    ",\n astro=" + astro +
                    '}';
        }
    }

    public class Location {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("region")
        @Expose
        private String region;
        @SerializedName("country")
        @Expose
        private String country;
        @SerializedName("lat")
        @Expose
        private double lat;
        @SerializedName("lon")
        @Expose
        private double lon;
        @SerializedName("tz_id")
        @Expose
        private String tzId;
        @SerializedName("localtime_epoch")
        @Expose
        private double localtimeEpoch;
        @SerializedName("localtime")
        @Expose
        private String localtime;

        /**
         * No args constructor for use in serialization
         */
        public Location() {
        }

        /**
         * @param region
         * @param localtime
         * @param tzId
         * @param lon
         * @param localtimeEpoch
         * @param name
         * @param lat
         * @param country
         */
        public Location(String name, String region, String country, double lat, double lon, String tzId, double localtimeEpoch, String localtime) {
            super();
            this.name = name;
            this.region = region;
            this.country = country;
            this.lat = lat;
            this.lon = lon;
            this.tzId = tzId;
            this.localtimeEpoch = localtimeEpoch;
            this.localtime = localtime;
        }

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

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLon() {
            return lon;
        }

        public void setLon(double lon) {
            this.lon = lon;
        }

        public String getTzId() {
            return tzId;
        }

        public void setTzId(String tzId) {
            this.tzId = tzId;
        }

        public double getLocaltimeEpoch() {
            return localtimeEpoch;
        }

        public void setLocaltimeEpoch(double localtimeEpoch) {
            this.localtimeEpoch = localtimeEpoch;
        }

        public String getLocaltime() {
            return localtime;
        }

        public void setLocaltime(String localtime) {
            this.localtime = localtime;
        }

        @Override
        public String toString() {
            return "Location{" +
                    "name='" + name + '\'' +
                    ", region='" + region + '\'' +
                    ", country='" + country + '\'' +
                    ", lat=" + lat +
                    ", lon=" + lon +
                    ", tzId='" + tzId + '\'' +
                    ", localtimeEpoch=" + localtimeEpoch +
                    ",\n localtime='" + localtime + '\'' +
                    '}';
        }
    }

}
