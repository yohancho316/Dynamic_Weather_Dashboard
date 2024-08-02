package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
public class FutureForecastResponse {

    @JsonProperty("cod")
    private String cod;

    @JsonProperty("message")
    private int message;

    @JsonProperty("cnt")
    private int timestamp_return_count;

    @JsonProperty("list")
    private List<ListItem> list = new ArrayList<ListItem>();

    @JsonProperty("city")
    private City city;

    // Need to Include More

    // Cod Getter Method
    public String getCod() {
        return this.cod;
    }

    // Cod Setter Method
    public void setCod(String cod) {
        this.cod = cod;
    }

    // Message Getter Method
    public int getMessage() {
        return this.message;
    }

    // Message Setter Method
    public void setMessage(int message) {
        this.message = message;
    }

    // Timestamp Return Count Getter Method
    public int getTimestampReturnCount() {
        return this.timestamp_return_count;
    }

    // Timestamp Return Count Getter Method
    public void setTimestampReturnCount(int timestamp_return_count) {
        this.timestamp_return_count = timestamp_return_count;
    }

    // List Getter Method
    public List<ListItem> getList() {
        return this.list;
    }

    // List Setter Method
    public void setList(List<ListItem> list) {
        if(list == null) throw new NullPointerException("List of ListItems cannot be null");
        this.list = list;
    }

    // City Getter Method
    public City getCity() {
        return this.city;
    }

    // City Setter Method
    public void setCity(City city) {
        this.city = city;
    }

    // Nested Static City Class
    public static class City {

        @JsonProperty("id")
        private int city_id;

        @JsonProperty("name")
        private String city_name;

        @JsonProperty("coord")
        private Coord coordinates = new Coord();

        @JsonProperty("country")
        private String country_code;

        @JsonProperty("population")
        private int population;

        @JsonProperty("timezone")
        private int timezone;

        @JsonProperty("sunrise")
        private int sunrise;

        @JsonProperty("sunset")
        private int sunset;

        // City ID Getter Method
        public int getCityID() {
            return this.city_id;
        }

        // City ID Setter Method
        public void setCityID(int city_id) {
            this.city_id = city_id;
        }

        // City Name Getter Method
        public String getCityName() {
            return this.city_name;
        }

        // City Name Setter Method
        public void setCityName(String city_name) {
            this.city_name = city_name;
        }

        // City Coordinates Getter Method
        public Coord getCoordinates() {
            return this.coordinates;
        }

        // City Coordinates Setter Method
        public void setCoordinates(Coord coordinates) {
            this.coordinates = coordinates;
        }

        // Country Code Getter Method
        public String getCountryCode() {
            return this.country_code;
        }

        // Country Code Setter Method
        public void setCountryCode(String country_code) {
            this.country_code = country_code;
        }

        // City Population Getter Method
        public int getCityPopulation() {
            return this.population;
        }

        // City Population Setter Method
        public void setCityPopulation(int population) {
            this.population = population;
        }

        // City Timezone Getter Method
        public int getCityTimeZone() {
            return this.timezone;
        }

        // City Timezone Setter Method
        public void setCityTimeZone(int timezone) {
            this.timezone = timezone;
        }

        // City Sunrise Getter Method
        public int getSunrise() {
            return this.sunrise;
        }

        // City Sunrise Setter Method
        public void setSunrise(int sunrise) {
            this.sunrise = sunrise;
        }

        // City Sunset Getter Method
        public int getSunset() {
            return this.sunset;
        }

        // City Sunset Setter Method
        public void setSunset(int sunset) {
            this.sunset = sunset;
        }

        public static class Coord {

            @JsonProperty("lat")
            private double city_latitude;

            @JsonProperty("lon")
            private double city_longitude;

            // Default Constructor
            public Coord() { }

            // City Latitude Getter Method
            public double getCityLatitude() {
                return this.city_latitude;
            }

            // City Latitude Setter Method
            public void setCityLatitude(double city_latitude) {
                this.city_latitude = city_latitude;
            }

            // City Longitude Getter Method
            public double getCityLongitude() {
                return this.city_longitude;
            }

            // City Longitude Setter Method
            public void setCityLongitude(double city_longitude) {
                this.city_longitude = city_longitude;
            }

        }

    }

    // Nested Static List Class
    public static class ListItem {

        @JsonProperty("dt")
        public int time_of_data_forecast;

        @JsonProperty("main")
        public Main main;

        @JsonProperty("weather")
        private List<Weather> weather = new ArrayList<Weather>();

        @JsonProperty("clouds")
        private Clouds clouds;

        @JsonProperty("wind")
        private Wind wind;

        @JsonProperty("visibility")
        private double visibility;

        @JsonProperty("pop")
        private double probability_of_precipitation;

        @JsonProperty("rain")
        private Rain rain;

        @JsonProperty("sys")
        private Sys sys;

        @JsonProperty("dt_txt")
        private String time_of_data_forecasted;

        // Time of Data Forecast Getter Method
        public int getTimeOfDataForecast() {
            return time_of_data_forecast;
        }

        // Time of Data Forecast Setter Method
        public void setTimeOfDataForecast(int time_of_data_forecast) {
            this.time_of_data_forecast = time_of_data_forecast;
        }

        // Main Getter Method
        public Main getMain() {
            return main;
        }

        // Main Setter Method
        public void setMain(Main main) {
            this.main = main;
        }

        // Weather Collection Getter Method
        public List<Weather> getWeather() {
            return weather;
        }

        // Weather Collection Setter Method
        public void setWeather(List<Weather> weather) {
            this.weather = weather;
        }

        // Clouds Getter Method
        public Clouds getClouds() {
            return clouds;
        }

        // Clouds Setter Method
        public void setClouds(Clouds clouds) {
            this.clouds = clouds;
        }

        // Wind Getter Method
        public Wind getWind() {
            return wind;
        }

        // Wind Setter Method
        public void setWind(Wind wind) {
            this.wind = wind;
        }

        // Visibility Getter Method
        public double getVisibility() {
            return visibility;
        }

        // Visibility Setter Method
        public void setVisibility(double visibility) {
            this.visibility = visibility;
        }

        // Probability of Precipitation Getter Method
        public double getProbabilityOfPrecipitation() {
            return probability_of_precipitation;
        }

        // Probability of Precipitation Setter Method
        public void setProbabilityOfPrecipitation(double probability_of_precipitation) {
            this.probability_of_precipitation = probability_of_precipitation;
        }

        // Rain Getter Method
        public Rain getRain() {
            return rain;
        }

        // Rain Setter Method
        public void setRain(Rain rain) {
            this.rain = rain;
        }

        // Sys Getter Method
        public Sys getSys() {
            return sys;
        }

        // Sys Setter Method
        public void setSys(Sys sys) {
            this.sys = sys;
        }

        // Time of Data Forecasted at Moment Getter Method
        public String getTimeOfDataForecasted() {
            return time_of_data_forecasted;
        }

        // Time of Data Forecasted at Moment Setter Method
        public void setTimeOfDataForecasted(String time_of_data_forecasted) {
            this.time_of_data_forecasted = time_of_data_forecasted;
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

            @JsonProperty("sea_level")
            private double sea_level;

            @JsonProperty("grnd_level")
            private double grnd_level;

            @JsonProperty("humidity")
            private double humidity;

            @JsonProperty("temp_kf")
            private double temp_kf;

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

            // Humidity Getter Method
            public double getHumidity() {
                return this.humidity;
            }

            // Humidity Setter Method
            public void setHumidity(double humidity) {
                this.humidity = humidity;
            }

            // Temp KF Getter Method
            public double getTempKF() {
                return this.temp_kf;
            }

            // Temp KF Setter Method
            public void setTempKF(double temp_kf) {
                this.temp_kf = temp_kf;
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

        // Nested Static Wind Class
        public static class Wind {

            @JsonProperty("speed")
            private double speed;

            @JsonProperty("deg")
            private double degree;

            @JsonProperty("gust")
            private double gust;

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

            // Gust Getter Method
            public double getGust() {
                return this.gust;
            }

            // Gust Setter Method
            public void setGust(double gust) {
                this.gust = gust;
            }
        }

        // Nested Static Rain Class
        public static class Rain {

            @JsonProperty("3h")
            private double rain_volume;

            // Rain Volume Getter Method
            public double getRainVolume() {
                return this.rain_volume;
            }

            // Rain Volume Setter Method
            public void setRainVolume(double rain_volume) {
                this.rain_volume = rain_volume;
            }
        }

        // Nested Static Sys Class
        public static class Sys {

            @JsonProperty("pod")
            private String pod;

            // Probability of Day Getter Method
            public String getPod() {
                return this.pod;
            }

            // Probability of Day Setter Method
            public void setPod(String pod) {
                this.pod = pod;
            }
        }

    }

}
