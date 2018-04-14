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

    @Override
    public String toString() {
        return "\nCurrentWeatherApixu{" +
                "location:" + location.toString() +"\n" +
                ", current:" + current.toString() +"\n" +
                '}';
    }

    public Location getLocation() {
        return location;
    }

    public Current getCurrent() {
        return current;
    }

    public class Location{
        String name;
        String region;
        String country;
        float lat;
        float lon;
        String tz_id;
        double localtime_epoch;
        String localtime;


        public Location(String name, String region, String country, float lat, float lon, String tz_id, double localtime_epoch, String localtime) {
            this.name = name;
            this.region = region;
            this.country = country;
            this.lat = lat;
            this.lon = lon;
            this.tz_id = tz_id;
            this.localtime_epoch = localtime_epoch;
            this.localtime = localtime;
        }

        @Override
        public String toString() {
            return "\nLocation{" +
                    "name='" + name + '\'' +"\n" +
                    ", region='" + region + '\'' +"\n" +
                    ", country='" + country + '\'' +"\n" +
                    ", lat=" + lat +"\n" +
                    ", lon=" + lon +"\n" +
                    ", tz_id='" + tz_id + '\'' +"\n" +
                    ", localtime_epoch=" + localtime_epoch +"\n" +
                    ", localtime='" + localtime + '\'' +"\n" +
                    '}';
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

        public double getLocaltime_epoch() {
            return localtime_epoch;
        }

        public String getLocaltime() {
            return localtime;
        }
    }

    public class Current{
        double last_updated_epoch;
        String last_updated;
        float temp_c;
        float temp_f;
        float is_day;
        Condition condition;
        float wind_mph;
        float wind_kph;
        short wind_degree;
        String wind_dir;
        float pressure_mb;
        float pressure_in;
        float precip_mm;
        float precip_in;
        float humidity;
        float cloud;
        float feelslike_c;
        float feelslike_f;
        float vis_km;
        float vis_miles;


        public Current(double last_updated_epoch, String last_updated, float temp_c, float temp_f, float is_day, Condition condition, float wind_mph, float wind_kph, short wind_degree, String wind_dir, float pressure_mb, float pressure_in, float precip_mm, float precip_in, float humidity, float cloud, float feelslike_c, float feelslike_f, float vis_km, float vis_miles) {
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

        @Override
        public String toString() {
            return "\nCurrent{" +
                    "last_updated_epoch=" + last_updated_epoch + "\n" +
                    ", last_updated='" + last_updated + '\'' +"\n" +
                    ", temp_c=" + temp_c +"\n" +
                    ", temp_f=" + temp_f +"\n" +
                    ", is_day=" + is_day +"\n" +
                    ", condition=" + condition +"\n" +
                    ", wind_mph=" + wind_mph +"\n" +
                    ", wind_kph=" + wind_kph +"\n" +
                    ", wind_degree=" + wind_degree +"\n" +
                    ", wind_dir='" + wind_dir + '\'' +"\n" +
                    ", pressure_mb=" + pressure_mb +"\n" +
                    ", pressure_in=" + pressure_in +"\n" +
                    ", precip_mm=" + precip_mm +"\n" +
                    ", precip_in=" + precip_in +"\n" +
                    ", humidity=" + humidity +"\n" +
                    ", cloud=" + cloud +"\n" +
                    ", feelslike_c=" + feelslike_c +"\n" +
                    ", feelslike_f=" + feelslike_f +"\n" +
                    ", vis_km=" + vis_km +"\n" +
                    ", vis_miles=" + vis_miles +"\n" +
                    '}';
        }

        public double getLast_updated_epoch() {
            return last_updated_epoch;
        }

        public String getLast_updated() {
            return last_updated;
        }

        public float getTemp_c() {
            return temp_c;
        }

        public float getTemp_f() {
            return temp_f;
        }

        public float getIs_day() {
            return is_day;
        }

        public Condition getCondition() {
            return condition;
        }

        public float getWind_mph() {
            return wind_mph;
        }

        public float getWind_kph() {
            return wind_kph;
        }

        public short getWind_degree() {
            return wind_degree;
        }

        public String getWind_dir() {
            return wind_dir;
        }

        public float getPressure_mb() {
            return pressure_mb;
        }

        public float getPressure_in() {
            return pressure_in;
        }

        public float getPrecip_mm() {
            return precip_mm;
        }

        public float getPrecip_in() {
            return precip_in;
        }

        public float getHumidity() {
            return humidity;
        }

        public float getCloud() {
            return cloud;
        }

        public float getFeelslike_c() {
            return feelslike_c;
        }

        public float getFeelslike_f() {
            return feelslike_f;
        }

        public float getVis_km() {
            return vis_km;
        }

        public float getVis_miles() {
            return vis_miles;
        }
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

            @Override
            public String toString() {
                return "\nCondition{" +"\n" +
                        "text='" + text + '\'' +"\n" +
                        ", icon='" + icon + '\'' +"\n" +
                        ", code=" + code +"\n" +
                        '}';
            }

            public String getText() {
                return text;
            }

            public String getIcon() {
                return icon;
            }

            public float getCode() {
                return code;
            }
        }


}



