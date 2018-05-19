package com.example.dunger.weatherappandroidclient.Models;

/**
 * Created by Dunger on 2018-05-19.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class GoogleAPIsGeocode {

    @SerializedName("results")
    @Expose
    private List<Result> results = null;
    @SerializedName("status")
    @Expose
    private String status;

    /**
     * No args constructor for use in serialization
     */
    public GoogleAPIsGeocode() {
    }

    /**
     * @param results
     * @param status
     */
    public GoogleAPIsGeocode(List<Result> results, String status) {
        super();
        this.results = results;
        this.status = status;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public class Result {

        @SerializedName("address_components")
        @Expose
        private List<AddressComponent> addressComponents = null;
        @SerializedName("formatted_address")
        @Expose
        private String formattedAddress;
        @SerializedName("geometry")
        @Expose
        private Geometry geometry;
        @SerializedName("place_id")
        @Expose
        private String placeId;
        @SerializedName("types")
        @Expose
        private List<String> types = null;

        /**
         * No args constructor for use in serialization
         */
        public Result() {
        }

        /**
         * @param placeId
         * @param formattedAddress
         * @param types
         * @param addressComponents
         * @param geometry
         */
        public Result(List<AddressComponent> addressComponents, String formattedAddress, Geometry geometry, String placeId, List<String> types) {
            super();
            this.addressComponents = addressComponents;
            this.formattedAddress = formattedAddress;
            this.geometry = geometry;
            this.placeId = placeId;
            this.types = types;
        }

        public List<AddressComponent> getAddressComponents() {
            return addressComponents;
        }

        public void setAddressComponents(List<AddressComponent> addressComponents) {
            this.addressComponents = addressComponents;
        }

        public String getFormattedAddress() {
            return formattedAddress;
        }

        public void setFormattedAddress(String formattedAddress) {
            this.formattedAddress = formattedAddress;
        }

        public Geometry getGeometry() {
            return geometry;
        }

        public void setGeometry(Geometry geometry) {
            this.geometry = geometry;
        }

        public String getPlaceId() {
            return placeId;
        }

        public void setPlaceId(String placeId) {
            this.placeId = placeId;
        }

        public List<String> getTypes() {
            return types;
        }

        public void setTypes(List<String> types) {
            this.types = types;
        }


        public class AddressComponent {

            @SerializedName("long_name")
            @Expose
            private String longName;
            @SerializedName("short_name")
            @Expose
            private String shortName;
            @SerializedName("types")
            @Expose
            private List<String> types = null;

            /**
             * No args constructor for use in serialization
             */
            public AddressComponent() {
            }

            /**
             * @param longName
             * @param types
             * @param shortName
             */
            public AddressComponent(String longName, String shortName, List<String> types) {
                super();
                this.longName = longName;
                this.shortName = shortName;
                this.types = types;
            }

            public String getLongName() {
                return longName;
            }

            public void setLongName(String longName) {
                this.longName = longName;
            }

            public String getShortName() {
                return shortName;
            }

            public void setShortName(String shortName) {
                this.shortName = shortName;
            }

            public List<String> getTypes() {
                return types;
            }

            public void setTypes(List<String> types) {
                this.types = types;
            }

        }


        public class Bounds {

            @SerializedName("northeast")
            @Expose
            private Northeast northeast;
            @SerializedName("southwest")
            @Expose
            private Southwest southwest;

            /**
             * No args constructor for use in serialization
             */
            public Bounds() {
            }

            /**
             * @param southwest
             * @param northeast
             */
            public Bounds(Northeast northeast, Southwest southwest) {
                super();
                this.northeast = northeast;
                this.southwest = southwest;
            }

            public Northeast getNortheast() {
                return northeast;
            }

            public void setNortheast(Northeast northeast) {
                this.northeast = northeast;
            }

            public Southwest getSouthwest() {
                return southwest;
            }

            public void setSouthwest(Southwest southwest) {
                this.southwest = southwest;
            }

        }


        public class Geometry {

            @SerializedName("bounds")
            @Expose
            private Bounds bounds;
            @SerializedName("location")
            @Expose
            private Location location;
            @SerializedName("location_type")
            @Expose
            private String locationType;
            @SerializedName("viewport")
            @Expose
            private Viewport viewport;

            /**
             * No args constructor for use in serialization
             */
            public Geometry() {
            }

            /**
             * @param bounds
             * @param viewport
             * @param location
             * @param locationType
             */
            public Geometry(Bounds bounds, Location location, String locationType, Viewport viewport) {
                super();
                this.bounds = bounds;
                this.location = location;
                this.locationType = locationType;
                this.viewport = viewport;
            }

            public Bounds getBounds() {
                return bounds;
            }

            public void setBounds(Bounds bounds) {
                this.bounds = bounds;
            }

            public Location getLocation() {
                return location;
            }

            public void setLocation(Location location) {
                this.location = location;
            }

            public String getLocationType() {
                return locationType;
            }

            public void setLocationType(String locationType) {
                this.locationType = locationType;
            }

            public Viewport getViewport() {
                return viewport;
            }

            public void setViewport(Viewport viewport) {
                this.viewport = viewport;
            }

        }


        public class Northeast {

            @SerializedName("lat")
            @Expose
            private Double lat;
            @SerializedName("lng")
            @Expose
            private Double lng;

            /**
             * No args constructor for use in serialization
             */
            public Northeast() {
            }

            /**
             * @param lng
             * @param lat
             */
            public Northeast(Double lat, Double lng) {
                super();
                this.lat = lat;
                this.lng = lng;
            }

            public Double getLat() {
                return lat;
            }

            public void setLat(Double lat) {
                this.lat = lat;
            }

            public Double getLng() {
                return lng;
            }

            public void setLng(Double lng) {
                this.lng = lng;
            }

        }


        public class Location {

            @SerializedName("lat")
            @Expose
            private Double lat;
            @SerializedName("lng")
            @Expose
            private Double lng;

            /**
             * No args constructor for use in serialization
             */
            public Location() {
            }

            /**
             * @param lng
             * @param lat
             */
            public Location(Double lat, Double lng) {
                super();
                this.lat = lat;
                this.lng = lng;
            }

            public Double getLat() {
                return lat;
            }

            public void setLat(Double lat) {
                this.lat = lat;
            }

            public Double getLng() {
                return lng;
            }

            public void setLng(Double lng) {
                this.lng = lng;
            }

        }


        public class Northeast_ {

            @SerializedName("lat")
            @Expose
            private Double lat;
            @SerializedName("lng")
            @Expose
            private Double lng;

            /**
             * No args constructor for use in serialization
             */
            public Northeast_() {
            }

            /**
             * @param lng
             * @param lat
             */
            public Northeast_(Double lat, Double lng) {
                super();
                this.lat = lat;
                this.lng = lng;
            }

            public Double getLat() {
                return lat;
            }

            public void setLat(Double lat) {
                this.lat = lat;
            }

            public Double getLng() {
                return lng;
            }

            public void setLng(Double lng) {
                this.lng = lng;
            }

        }


        public class Southwest {

            @SerializedName("lat")
            @Expose
            private Double lat;
            @SerializedName("lng")
            @Expose
            private Double lng;

            /**
             * No args constructor for use in serialization
             */
            public Southwest() {
            }

            /**
             * @param lng
             * @param lat
             */
            public Southwest(Double lat, Double lng) {
                super();
                this.lat = lat;
                this.lng = lng;
            }

            public Double getLat() {
                return lat;
            }

            public void setLat(Double lat) {
                this.lat = lat;
            }

            public Double getLng() {
                return lng;
            }

            public void setLng(Double lng) {
                this.lng = lng;
            }

        }


        public class Southwest_ {

            @SerializedName("lat")
            @Expose
            private Double lat;
            @SerializedName("lng")
            @Expose
            private Double lng;

            /**
             * No args constructor for use in serialization
             */
            public Southwest_() {
            }

            /**
             * @param lng
             * @param lat
             */
            public Southwest_(Double lat, Double lng) {
                super();
                this.lat = lat;
                this.lng = lng;
            }

            public Double getLat() {
                return lat;
            }

            public void setLat(Double lat) {
                this.lat = lat;
            }

            public Double getLng() {
                return lng;
            }

            public void setLng(Double lng) {
                this.lng = lng;
            }

        }

        public class Viewport {

            @SerializedName("northeast")
            @Expose
            private Northeast_ northeast;
            @SerializedName("southwest")
            @Expose
            private Southwest_ southwest;

            /**
             * No args constructor for use in serialization
             */
            public Viewport() {
            }

            /**
             * @param southwest
             * @param northeast
             */
            public Viewport(Northeast_ northeast, Southwest_ southwest) {
                super();
                this.northeast = northeast;
                this.southwest = southwest;
            }

            public Northeast_ getNortheast() {
                return northeast;
            }

            public void setNortheast(Northeast_ northeast) {
                this.northeast = northeast;
            }

            public Southwest_ getSouthwest() {
                return southwest;
            }

            public void setSouthwest(Southwest_ southwest) {
                this.southwest = southwest;
            }

        }
    }


}













