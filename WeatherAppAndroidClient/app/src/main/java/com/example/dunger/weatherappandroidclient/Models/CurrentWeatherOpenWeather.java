package com.example.dunger.weatherappandroidclient.Models;

/**
 * Created by Dunger on 2018-04-14.
 */

public class CurrentWeatherOpenWeather {

    String base;
    float visibility;
    double dt;
    double id;
    String name;
    float cod;
    Coord coord;
    Weather[] weather;
    Main main;
    Wind wind;
    Clouds clouds;
    Sys sys;

    public CurrentWeatherOpenWeather(String base, float visibility, double dt, double id, String name, float cod, Coord coord, Weather[] weather, Main main, Wind wind, Clouds clouds, Sys sys) {
        this.base = base;
        this.visibility = visibility;
        this.dt = dt;
        this.id = id;
        this.name = name;
        this.cod = cod;
        this.coord = coord;
        this.weather = weather;
        this.main = main;
        this.wind = wind;
        this.clouds = clouds;
        this.sys = sys;
    }


    public String getBase() {
        return base;
    }

    public float getVisibility() {
        return visibility;
    }

    public double getDt() {
        return dt;
    }

    public double getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getCod() {
        return cod;
    }

    public Coord getCoord() {
        return coord;
    }

    public Main getMain() {
        return main;
    }

    public Wind getWind() {
        return wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public Sys getSys() {
        return sys;
    }

    public Weather[] getWeather() {
        return weather;
    }

    public class Coord{
        float lon;
        float lat;

        public Coord(float lon, float lat) {
            this.lon = lon;
            this.lat = lat;
        }

        public float getLon() {
            return lon;
        }

        public float getLat() {
            return lat;
        }
    }

    public class Weather{
        float id;
        String main;
        String description;
        String icon;

        public Weather(float id, String main, String description, String icon) {
            this.id = id;
            this.main = main;
            this.description = description;
            this.icon = icon;
        }

        public float getId() {
            return id;
        }

        public String getMain() {
            return main;
        }

        public String getDescription() {
            return description;
        }

        public String getIcon() {
            return icon;
        }
    }

    public class Main{
        float temp;
        float pressure;
        float humidity;
        float temp_min;
        float temp_max;

        public Main(float temp, float pressure, float humidity, float temp_min, float temp_max) {
            this.temp = temp;
            this.pressure = pressure;
            this.humidity = humidity;
            this.temp_min = temp_min;
            this.temp_max = temp_max;
        }

        public float getTemp() {
            return temp;
        }

        public float getPressure() {
            return pressure;
        }

        public float getHumidity() {
            return humidity;
        }

        public float getTemp_min() {
            return temp_min;
        }

        public float getTemp_max() {
            return temp_max;
        }
    }

    public class Wind{
        float speed;
        float deg;

        public Wind(float speed, float deg) {
            this.speed = speed;
            this.deg = deg;
        }

        public float getSpeed() {
            return speed;
        }

        public float getDeg() {
            return deg;
        }
    }

    public class Clouds{
        float all;

        public Clouds(float all) {
            this.all = all;
        }

        public float getAll() {
            return all;
        }
    }

    public class Sys{
        float type;
        float id;
        float message;
        double sunrise;
        double sunset;

        public Sys(float type, float id, float message, double sunrise, double sunset) {
            this.type = type;
            this.id = id;
            this.message = message;
            this.sunrise = sunrise;
            this.sunset = sunset;
        }

        public float getType() {
            return type;
        }

        public float getId() {
            return id;
        }

        public float getMessage() {
            return message;
        }

        public double getSunrise() {
            return sunrise;
        }

        public double getSunset() {
            return sunset;
        }
    }

}
