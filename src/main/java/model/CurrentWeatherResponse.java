package model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrentWeatherResponse {

    @JsonProperty("coord")
    private Coord coordinates;

    @JsonProperty("weather")
    private List<Weather> weather;

    @JsonProperty("base")
    private String base;

    @JsonProperty("main")
    private Main main;

    @JsonProperty("visibility")
    private double visibility;

    @JsonProperty("wind")
    private Wind wind;

    @JsonProperty("clouds")
    private Clouds clouds;

    @JsonProperty("dt")
    private double timeOfDataCalculation;

    @JsonProperty("sys")
    private Sys sys;

    @JsonProperty("timezone")
    private int timezone;

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String cityName;

    @JsonProperty("cod")
    private int cityCode;

    // Coordinates Getter Method
    public Coord getCoordinates() {
        return this.coordinates;
    }

    // Coordinates Setter Method
    public void setCoordinates(Coord coordintes) {
        if(coordintes == null) throw new NullPointerException("Coordinates cannot be null");
        this.coordinates = coordintes;
    }

    // Weather Getter Method
    public List<Weather> getWeather() {
        return this.weather;
    }

    // Weather Setter Method
    public void setWeather(List<Weather> weather) {
        if (weather == null) throw new NullPointerException("Weather cannot be null");
        this.weather = weather;
    }

    // Base Getter Method
    public String getBase() {
        return this.base;
    }

    // Base Setter Method
    public void setBase(String base) {
        if (base == null) throw new NullPointerException("Base cannot be null");
        if (base.isEmpty()) throw new IllegalArgumentException("Base cannot be empty");
        this.base = base;
    }

    // Main Getter Method
    public Main getMain() {
        return this.main;
    }

    // Main Setter Method
    public void setMain(Main main) {
        if (main == null) throw new NullPointerException("Main cannot be null");
        this.main = main;
    }

    // Visibility Getter Method
    public double getVisibility() {
        return this.visibility;
    }

    // Visibility Setter Method
    public void setVisibility(double visibility) {
        this.visibility = visibility;
    }

    // Wind Getter Method
    public Wind getWind() {
        return this.wind;
    }

    // Wind Setter Method
    public void setWind(Wind wind) {
        if (wind == null) throw new NullPointerException("Wind cannot be null");
        this.wind = wind;
    }

    // Clouds Getter Method
    public Clouds getClouds() {
        return this.clouds;
    }

    // Clouds Setter Method
    public void setClouds(Clouds clouds) {
        if (clouds == null) throw new NullPointerException("Clouds cannot be null");
        this.clouds = clouds;
    }

    // TimeOfDataCalculation Getter Method
    public double getTimeOfDataCalculation() {
        return this.timeOfDataCalculation;
    }

    // TimeOfDataCalculation Setter Method
    public void setTimeOfDataCalculation(double timeOfDataCalculation) {
        this.timeOfDataCalculation = timeOfDataCalculation;
    }

    // Sys Getter Method
    public Sys getSys() {
        return this.sys;
    }

    // Sys Setter Method
    public void setSys(Sys sys) {
        if (sys == null) throw new NullPointerException("Sys cannot be null");
        this.sys = sys;
    }

    // Timezone Getter Method
    public int getTimezone() {
        return this.timezone;
    }

    // Timezone Setter Method
    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    // Id Getter Method
    public int getId() {
        return this.id;
    }

    // Id Setter Method
    public void setId(int id) {
        this.id = id;
    }

    // CityName Getter Method
    public String getCityName() {
        return this.cityName;
    }

    // CityName Setter Method
    public void setCityName(String cityName) {
        if (cityName == null) throw new NullPointerException("City name cannot be null");
        if (cityName.isEmpty()) throw new IllegalArgumentException("City Name cannot be empty");
        this.cityName = cityName;
    }

    // CityCode Getter Method
    public int getCityCode() {
        return this.cityCode;
    }

    // CityCode Setter Method
    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

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

    // Nested Static Main Class
    public static class Main {

        @JsonProperty("temp")
        private double currentTemperature;

        @JsonProperty("feels_like")
        private double feels_like;

        @JsonProperty("temp_min")
        private double temp_min;

        @JsonProperty("temp_max")
        private double temp_max;

        @JsonProperty("pressure")
        private double pressure;

        @JsonProperty("humidity")
        private double humidity;

        @JsonProperty("sea_level")
        private double sea_level;

        @JsonProperty("grnd_level")
        private double grnd_level;

        // Current Temperature Getter Method
        public double getCurrentTemperature() {
            return this. currentTemperature;
        }

        // Current Temperature Setter Method
        public void setCurrentTemperature(double currentTemperature) {
            this.currentTemperature = currentTemperature;
        }

        // Feels Like Temperature Getter Method
        public double getFeelsLikeTemperature() {
            return this.feels_like;
        }

        // Feels Like Temperature Setter Method
        public void setFeelsLikeTemperature(double feels_like) {
            this.feels_like = feels_like;
        }

        // Min Temp Getter Method
        public double getMinTemp() {
            return this.temp_min;
        }

        // Min Temp Setter Method
        public void setMinTemp(double temp_min) {
            this.temp_min = temp_min;
        }

        // Max Temp Getter Method
        public double getMaxTemp() {
            return this.temp_max;
        }

        // Max Temp Setter Method
        public void setMaxTemp(double temp_max) {
            this.temp_max = temp_max;
        }

        // Pressure Getter Method
        public double getPressure() {
            return this.pressure;
        }

        // Pressure Setter Method
        public void setPressure(double pressure) {
            this.pressure = pressure;
        }

        // Humidity Getter Method
        public double getHumidity() {
            return this.humidity;
        }

        // Humidity Setter Method
        public void setHumidity(double humidity) {
            this.humidity = humidity;
        }

        // Sea Level Getter Method
        public double getSeaLevel() {
            return this.sea_level;
        }

        // Sea Level Setter Method
        public void setSeaLevel(double sea_level) {
            this.sea_level = sea_level;
        }

        // Ground Level Getter Method
        public double getGroundLevel() {
            return this.grnd_level;
        }

        // Ground Level Setter Method
        public void setGroundLevel(double grnd_level) {
            this.grnd_level = grnd_level;
        }


    }

    // Nested Static Wind Class
    public static class Wind {

        @JsonProperty("speed")
        private double speed;

        @JsonProperty("deg")
        private double degree;

        // Speed Getter Method
        public double getSpeed() {
            return this.speed;
        }

        // Speed Setter Method
        public void setSpeed(double speed) {
            this.speed = speed;
        }

        // Degrees Getter Method
        public double getDegree() {
            return this.degree;
        }

        // Degrees Setter Method
        public void setDegree(double degree) {
            this.degree = degree;
        }
    }

    // Nested Static Cloud Class
    public static class Clouds {

        @JsonProperty("all")
        private double all;

        // All Getter Method
        public double getAll() {
            return this.all;
        }

        // All Setter Method
        public void setAll(double all) {
            this.all = all;
        }
    }

    // Nested StaticSys Class
    public static class Sys {

        @JsonProperty("type")
        private int type;

        @JsonProperty("id")
        private int id;

        @JsonProperty("country")
        private String country;

        @JsonProperty("sunrise") // UTC Time
        private int sunriseTime;

        @JsonProperty("sunset") // UTC Time
        private int sunsetTime;

        // Type Getter Method
        public int getType() {
            return type;
        }

        // Type Setter Method
        public void setType(int type) {
            this.type = type;
        }

        // ID Getter Method
        public int getID() {
            return this.id;
        }

        // ID Setter Method
        public void setID(int id) {
            this.id = id;
        }

        // Country Getter Method
        public String getCountry() {
            return this.country;
        }

        // Country Setter Method
        public void setCountry(String country) {
            this.country = country;
        }

        // Sunrise Time Getter Method
        public int getSunriseTime() {
            return this.sunriseTime;
        }

        // Sunrise Time Setter Method
        public void setSunriseTime(int sunriseTime) {
            this.sunriseTime = sunriseTime;
        }

        // Sunset Time Getter Method
        public int getSunsetTime() {
            return this.sunsetTime;
        }

        // SUnset Time Setter Method
        // Sunrise Time Setter Method
        public void setSunsetTime(int sunsetTime) {
            this.sunsetTime = sunsetTime;
        }

    }

}
