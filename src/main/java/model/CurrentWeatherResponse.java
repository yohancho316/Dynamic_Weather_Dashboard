package model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrentWeatherResponse {

    @JsonProperty("coord")
    Coord coordinates;

    @JsonProperty("weather")
    List<Weather> weather; 

    // Nested Static Coord Class
    public static class Coord {

        @JsonProperty("lon")
        private double longitude;

        @JsonProperty("lat")
        private double latitude;

        // Longitude Getter Method
        public double getLongitude() {
            return this.longitude;
        }

        // Longitude Setter Method
        public void setLongitude(double longitude) {
            if(longitude > 180.0 || longitude < -180) throw new IllegalArgumentException("Longitude must be within bounds of [-180,180]");
            this.longitude = longitude;
        }

        // Latitude Getter Method
        public double getLatitude() {
            return this.latitude;
        }

        // Latitude Setter Method
        public void setLatitude(double latitude) {
            if(latitude > 90.0 || latitude < -90) throw new IllegalArgumentException("Latitude must be within bounds of [-90,90]");
            this.latitude = latitude;
        }



    }

    // Nested Static Weather Class
    public static class Weather {

        @JsonProperty("id")
        private int id;

        @JsonProperty("main")
        private String main;

        @JsonProperty("description")
        private String current_weather_description;

        @JsonProperty("icon")
        private String icon;

        // ID Getter Method
        public int getID() {
            return this.id;
        }

        // ID Setter Method
        public void setID(int id) {
            this.id = id;
        }

        // Main Getter Method
        public String getMain() {
            return this.main;
        }

        // Main Setter Method
        public void setMain(String main) {
            if(main == null) throw new NullPointerException("String Main cannot be null");
            if(main.isEmpty()) throw new IllegalArgumentException("String Main cannot be empty");
            this.main = main;
        }

        // Current Weather Description Getter Method
        public String getCurrentWeatherDescription() {
            return this.current_weather_description;
        }

        // Current Weather Description Setter Method
        public void setCurrentWeatherDescription(String current_weather_description) {
            if(current_weather_description == null) throw new NullPointerException("String current_weather_description cannot be null");
            if(current_weather_description.isEmpty()) throw new IllegalArgumentException("String current_weather_description cannot be empty");
            this.current_weather_description = current_weather_description;
        }

        // Icon Getter Method
        public String getIcon() {
            return this.icon;
        }

        // Icon Setter Method
        public void setIcon(String icon) {
            if(icon == null) throw new NullPointerException("String icon cannot be null");
            if(icon.isEmpty()) throw new IllegalArgumentException("String icon cannot be empty");
            this.icon = icon;
        }

    }




}
