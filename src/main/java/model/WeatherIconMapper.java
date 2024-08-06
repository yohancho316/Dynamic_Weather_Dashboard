package model;

import java.util.Map;
import java.util.HashMap;

public class WeatherIconMapper {

    // Class Members
    public static final Map<String,String> ICON_MAP = new HashMap<String,String>();

    // Static Initialization Block
    static {

        // Clear Day Icon
        ICON_MAP.put("01d.png", "weather_sun_sunny_temperature.png");

        // Clear Night Icon
        ICON_MAP.put("01n.png", "weather_night_moon_moonlight.png");

        // Few Clouds Day Icon
        ICON_MAP.put("02d.png", "clouds_sun_sunny_weather.png");

        // Few Clouds Night Icon
        ICON_MAP.put("01n.png", "moon_weather_clouds_cloudy.png");

        // Scatter Clouds Day Icon
        ICON_MAP.put("03d.png", "cloudy_weather_clouds_cloud.png");

        // Scatter Night Icon
        ICON_MAP.put("01n.png", "wind_weather_cloudy_storm.png");

        // Broke Clouds Day Icon
        ICON_MAP.put("04d.png", "sunny_weather_clouds_storm.png");

        // Broke Clouds Night Icon
        ICON_MAP.put("01n.png", "wind_weather_cloudy_storm.png");

        // Light Shower Day Icon
        ICON_MAP.put("09d.png", "rain_cloud_drizzel_weather.png");

        // Light Shower Night Icon
        ICON_MAP.put("01n.png", "night_weather_clouds_storm_rain_moon.png");

        // Rainy Shower Day Icon
        ICON_MAP.put("10d.png", "rain_storm_shower_weather.png");

        // Rainy Night Icon
        ICON_MAP.put("01n.png", "night_weather_clouds_storm_rain_moon.png");

        // Stormy & Rainy Shower Day Icon
        ICON_MAP.put("11d.png", "storm_weather_thunder_clouds_rain.png");

        // Stormy & RainyNight Icon
        ICON_MAP.put("01n.png", "weather_rain_storm_night.png");

        // Snow Day Icon
        ICON_MAP.put("13d.png", "winter_snowflake_christmas_xmas_weather_snow.png");

        // Snow Night Icon
        ICON_MAP.put("01n.png", "winter_snow_clouds_weather.png");

        // Mist Day Icon
        ICON_MAP.put("50d.png", "windy_cloudy_storm_wind_weather.png");

        // Misty Night Icon
        ICON_MAP.put("01n.png", "windy_cloudy_storm_wind_weather");

    }

    // A static method to retrieve the icon filename based on the weather description
    public static String getIcon(String weatherIcon) {
        if(weatherIcon == null) throw new NullPointerException("Weather Icon cannot be null");
        if(ICON_MAP.isEmpty()) throw new IllegalArgumentException("Icon Mapper cannot be empty");
        if(!ICON_MAP.containsKey(weatherIcon)) throw new IllegalArgumentException("Weather Icon must be a key in the HashMap");
        return ICON_MAP.getOrDefault(weatherIcon, "weather_sun_sunny_temperature.png");
    }


}
