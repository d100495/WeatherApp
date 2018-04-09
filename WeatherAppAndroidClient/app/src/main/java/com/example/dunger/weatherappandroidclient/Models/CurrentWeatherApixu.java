package com.example.dunger.weatherappandroidclient.Models;

/**
 * Created by Dunger on 2018-04-08.
 */

public class CurrentWeatherApixu {

    Location location;
    Current current;

    public CurrentWeatherApixu(Location location, Current current) {
        this.location = location;
        this.current = current;
    }

    public Location getLocation() {
        return location;
    }

    public Current getCurrent() {
        return current;
    }

    @Override
    public String toString() {
        return "CurrentWeatherApixu{" +
                "location:" + location.toString() +
                ", current:" + current.toString() +
                '}';
    }

    public class Location{
        String name;
        String region;
        String country;
        float lat;
        float lon;
        String tz_id;
        int localtime_epoch;
        String localtime;

        public Location(String name, String region, String country, float lat, float lon, String tz_id, int localtime_epoch, String localtime) {
            this.name = name;
            this.region = region;
            this.country = country;
            this.lat = lat;
            this.lon = lon;
            this.tz_id = tz_id;
            this.localtime_epoch = localtime_epoch;
            this.localtime = localtime;
        }

        public String getName() {
            return name;
        }

        public String getRegion() {
            return region;
        }

        public String getCountry() {
            return country;
        }

        public float getLat() {
            return lat;
        }

        public float getLon() {
            return lon;
        }

        public String getTz_id() {
            return tz_id;
        }

        public int getLocaltime_epoch() {
            return localtime_epoch;
        }

        public String getLocaltime() {
            return localtime;
        }
    }

    public class Current{
        int last_updated_epoch;
        String last_updated;
        float temp_c;
        float temp_f;
        short is_day;
        Condition condition;
        float wind_mph;
        float wind_kph;
        short wind_degree;
        String wind_dir;
        int pressure_mb;
        float pressure_in;
        int precip_mm;
        short precip_in;
        short humidity;
        short cloud;
        short feelslike_c;
        short feelslike_f;
        short vis_km;
        short vis_miles;

        public Current(int last_updated_epoch, String last_updated, float temp_c, float temp_f, short is_day, Condition condition,
                       float wind_mph, float wind_kph, short wind_degree, String wind_dir, int pressure_mb, float pressure_in, int precip_mm,
                       short precip_in, short humidity, short cloud, short feelslike_c, short feelslike_f, short vis_km, short vis_miles) {
            this.last_updated_epoch = last_updated_epoch;
            this.last_updated = last_updated;
            this.temp_c = temp_c;
            this.temp_f = temp_f;
            this.is_day = is_day;
            this.condition = condition;
            this.wind_mph = wind_mph;
            this.wind_kph = wind_kph;
            this.wind_degree = wind_degree;
            this.wind_dir = wind_dir;
            this.pressure_mb = pressure_mb;
            this.pressure_in = pressure_in;
            this.precip_mm = precip_mm;
            this.precip_in = precip_in;
            this.humidity = humidity;
            this.cloud = cloud;
            this.feelslike_c = feelslike_c;
            this.feelslike_f = feelslike_f;
            this.vis_km = vis_km;
            this.vis_miles = vis_miles;
        }

        public class Condition{
            String text;
            String icon;
            float code;

            public Condition(String text, String icon, float code) {
                this.text = text;
                this.icon = icon;
                this.code = code;
            }
    }


    }



}
