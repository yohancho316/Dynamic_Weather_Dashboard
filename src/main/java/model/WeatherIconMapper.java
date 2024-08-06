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

        // Few Clouds Day Icon
        ICON_MAP.put("02d.png", "weather_clouds_fog_foggy.png");

        // Scatter Clouds Day Icon
        ICON_MAP.put("03d.png", "");



    }


}
