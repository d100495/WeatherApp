package com.example.dunger.weatherappandroidclient.Models;

/**
 * Created by Dunger on 2018-04-21.
 */

        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class ForecastWeatherOpenWeather {

    @SerializedName("cod")
    @Expose
    private String cod;
    @SerializedName("message")
    @Expose
    private Double message;
    @SerializedName("cnt")
    @Expose
    private Double cnt;
    @SerializedName("list")
    @Expose
    private java.util.List<List> list = null;
    @SerializedName("city")
    @Expose
    private City city;

    /**
     * No args constructor for use in serialization
     *
     */
    public ForecastWeatherOpenWeather() {
    }

    /**
     *
     * @param message
     * @param cnt
     * @param cod
     * @param list
     * @param city
     */
    public ForecastWeatherOpenWeather(String cod, Double message, Double cnt, java.util.List<List> list, City city) {
        super();
        this.cod = cod;
        this.message = message;
        this.cnt = cnt;
        this.list = list;
        this.city = city;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Double getMessage() {
        return message;
    }

    public void setMessage(Double message) {
        this.message = message;
    }

    public Double getCnt() {
        return cnt;
    }

    public void setCnt(Double cnt) {
        this.cnt = cnt;
    }

    public java.util.List<List> getList() {
        return list;
    }

    public void setList(java.util.List<List> list) {
        this.list = list;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }


    public class City {

        @SerializedName("id")
        @Expose
        private Double id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("coord")
        @Expose
        private Coord coord;
        @SerializedName("country")
        @Expose
        private String country;
        @SerializedName("population")
        @Expose
        private Double population;

        /**
         * No args constructor for use in serialization
         *
         */
        public City() {
        }

        /**
         *
         * @param coord
         * @param id
         * @param name
         * @param population
         * @param country
         */
        public City(Double id, String name, Coord coord, String country, Double population) {
            super();
            this.id = id;
            this.name = name;
            this.coord = coord;
            this.country = country;
            this.population = population;
        }

        public Double getId() {
            return id;
        }

        public void setId(Double id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Coord getCoord() {
            return coord;
        }

        public void setCoord(Coord coord) {
            this.coord = coord;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public Double getPopulation() {
            return population;
        }

        public void setPopulation(Double population) {
            this.population = population;
        }

    }

    public class Clouds {

        @SerializedName("all")
        @Expose
        private Double all;

        /**
         * No args constructor for use in serialization
         *
         */
        public Clouds() {
        }

        /**
         *
         * @param all
         */
        public Clouds(Double all) {
            super();
            this.all = all;
        }

        public Double getAll() {
            return all;
        }

        public void setAll(Double all) {
            this.all = all;
        }

    }

    public class Coord {

        @SerializedName("lat")
        @Expose
        private Double lat;
        @SerializedName("lon")
        @Expose
        private Double lon;

        /**
         * No args constructor for use in serialization
         *
         */
        public Coord() {
        }

        /**
         *
         * @param lon
         * @param lat
         */
        public Coord(Double lat, Double lon) {
            super();
            this.lat = lat;
            this.lon = lon;
        }

        public Double getLat() {
            return lat;
        }

        public void setLat(Double lat) {
            this.lat = lat;
        }

        public Double getLon() {
            return lon;
        }

        public void setLon(Double lon) {
            this.lon = lon;
        }

    }

    public class List {

        @SerializedName("dt")
        @Expose
        private Double dt;
        @SerializedName("main")
        @Expose
        private Main main;
        @SerializedName("weather")
        @Expose
        private java.util.List<Weather> weather = null;
        @SerializedName("clouds")
        @Expose
        private Clouds clouds;
        @SerializedName("wind")
        @Expose
        private Wind wind;
        @SerializedName("sys")
        @Expose
        private Sys sys;
        @SerializedName("dt_txt")
        @Expose
        private String dtTxt;
        @SerializedName("rain")
        @Expose
        private Rain rain;

        /**
         * No args constructor for use in serialization
         *
         */
        public List() {
        }

        /**
         *
         * @param clouds
         * @param dt
         * @param wind
         * @param sys
         * @param dtTxt
         * @param weather
         * @param rain
         * @param main
         */
        public List(Double dt, Main main, java.util.List<Weather> weather, Clouds clouds, Wind wind, Sys sys, String dtTxt, Rain rain) {
            super();
            this.dt = dt;
            this.main = main;
            this.weather = weather;
            this.clouds = clouds;
            this.wind = wind;
            this.sys = sys;
            this.dtTxt = dtTxt;
            this.rain = rain;
        }

        public Double getDt() {
            return dt;
        }

        public void setDt(Double dt) {
            this.dt = dt;
        }

        public Main getMain() {
            return main;
        }

        public void setMain(Main main) {
            this.main = main;
        }

        public java.util.List<Weather> getWeather() {
            return weather;
        }

        public void setWeather(java.util.List<Weather> weather) {
            this.weather = weather;
        }

        public Clouds getClouds() {
            return clouds;
        }

        public void setClouds(Clouds clouds) {
            this.clouds = clouds;
        }

        public Wind getWind() {
            return wind;
        }

        public void setWind(Wind wind) {
            this.wind = wind;
        }

        public Sys getSys() {
            return sys;
        }

        public void setSys(Sys sys) {
            this.sys = sys;
        }

        public String getDtTxt() {
            return dtTxt;
        }

        public void setDtTxt(String dtTxt) {
            this.dtTxt = dtTxt;
        }

        public Rain getRain() {
            return rain;
        }

        public void setRain(Rain rain) {
            this.rain = rain;
        }

    }

    public class Main {

        @SerializedName("temp")
        @Expose
        private Double temp;
        @SerializedName("temp_min")
        @Expose
        private Double tempMin;
        @SerializedName("temp_max")
        @Expose
        private Double tempMax;
        @SerializedName("pressure")
        @Expose
        private Double pressure;
        @SerializedName("sea_level")
        @Expose
        private Double seaLevel;
        @SerializedName("grnd_level")
        @Expose
        private Double grndLevel;
        @SerializedName("humidity")
        @Expose
        private Double humidity;
        @SerializedName("temp_kf")
        @Expose
        private Double tempKf;

        /**
         * No args constructor for use in serialization
         *
         */
        public Main() {
        }

        /**
         *
         * @param seaLevel
         * @param humidity
         * @param pressure
         * @param grndLevel
         * @param tempMax
         * @param temp
         * @param tempKf
         * @param tempMin
         */
        public Main(Double temp, Double tempMin, Double tempMax, Double pressure, Double seaLevel, Double grndLevel, Double humidity, Double tempKf) {
            super();
            this.temp = temp;
            this.tempMin = tempMin;
            this.tempMax = tempMax;
            this.pressure = pressure;
            this.seaLevel = seaLevel;
            this.grndLevel = grndLevel;
            this.humidity = humidity;
            this.tempKf = tempKf;
        }

        public Double getTemp() {
            return temp;
        }

        public void setTemp(Double temp) {
            this.temp = temp;
        }

        public Double getTempMin() {
            return tempMin;
        }

        public void setTempMin(Double tempMin) {
            this.tempMin = tempMin;
        }

        public Double getTempMax() {
            return tempMax;
        }

        public void setTempMax(Double tempMax) {
            this.tempMax = tempMax;
        }

        public Double getPressure() {
            return pressure;
        }

        public void setPressure(Double pressure) {
            this.pressure = pressure;
        }

        public Double getSeaLevel() {
            return seaLevel;
        }

        public void setSeaLevel(Double seaLevel) {
            this.seaLevel = seaLevel;
        }

        public Double getGrndLevel() {
            return grndLevel;
        }

        public void setGrndLevel(Double grndLevel) {
            this.grndLevel = grndLevel;
        }

        public Double getHumidity() {
            return humidity;
        }

        public void setHumidity(Double humidity) {
            this.humidity = humidity;
        }

        public Double getTempKf() {
            return tempKf;
        }

        public void setTempKf(Double tempKf) {
            this.tempKf = tempKf;
        }

    }

    public class Rain {

        @SerializedName("3h")
        @Expose
        private Double _3h;

        /**
         * No args constructor for use in serialization
         *
         */
        public Rain() {
        }

        /**
         *
         * @param _3h
         */
        public Rain(Double _3h) {
            super();
            this._3h = _3h;
        }

        public Double get3h() {
            return _3h;
        }

        public void set3h(Double _3h) {
            this._3h = _3h;
        }

    }

    public class Sys {

        @SerializedName("pod")
        @Expose
        private String pod;

        /**
         * No args constructor for use in serialization
         *
         */
        public Sys() {
        }

        /**
         *
         * @param pod
         */
        public Sys(String pod) {
            super();
            this.pod = pod;
        }

        public String getPod() {
            return pod;
        }

        public void setPod(String pod) {
            this.pod = pod;
        }

    }

    public class Weather {

        @SerializedName("id")
        @Expose
        private Double id;
        @SerializedName("main")
        @Expose
        private String main;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("icon")
        @Expose
        private String icon;

        /**
         * No args constructor for use in serialization
         *
         */
        public Weather() {
        }

        /**
         *
         * @param id
         * @param icon
         * @param description
         * @param main
         */
        public Weather(Double id, String main, String description, String icon) {
            super();
            this.id = id;
            this.main = main;
            this.description = description;
            this.icon = icon;
        }

        public Double getId() {
            return id;
        }

        public void setId(Double id) {
            this.id = id;
        }

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

    }

    public class Wind {

        @SerializedName("speed")
        @Expose
        private Double speed;
        @SerializedName("deg")
        @Expose
        private Double deg;

        /**
         * No args constructor for use in serialization
         *
         */
        public Wind() {
        }

        /**
         *
         * @param speed
         * @param deg
         */
        public Wind(Double speed, Double deg) {
            super();
            this.speed = speed;
            this.deg = deg;
        }

        public Double getSpeed() {
            return speed;
        }

        public void setSpeed(Double speed) {
            this.speed = speed;
        }

        public Double getDeg() {
            return deg;
        }

        public void setDeg(Double deg) {
            this.deg = deg;
        }

    }


}
