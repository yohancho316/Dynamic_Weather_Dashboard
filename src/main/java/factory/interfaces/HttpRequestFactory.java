package factory.interfaces;
import model.ApiKeyReader;

import java.net.http.HttpRequest;

public interface HttpRequestFactory {

    // Configuration Properties (Properties are Implicitly Public, Static and Final)
    String API_KEY = ApiKeyReader.getKey();
    String GEOCODE_BASE_URL = "https://api.openweathermap.org/geo/1.0/direct";
    String CURRENT_BASE_URL = "https://api.openweathermap.org/data/2.5/weather";
    String FUTURE_BASE_URL = "https://api.openweathermap.org/data/2.5/forecast";
    String GEOCODE_CITY_NAME = "Los Angeles";
    String GEOCODE_METRIC_SYSTEM = "imperial";
    String CURRENT_METRIC_SYSTEM = "imperial";
    String FUTURE_METRIC_SYSTEM = "imperial";
    int GEOCODE_RESPONSE_LIMIT = 1;

    // Geocode HTTP Request Object Factory Method Signature
    public HttpRequest createGeocodeRequest();

    // Current Forecast HTTP Request Object Factory Method Signature
    public HttpRequest createCurrentRequest();

    // Future Forecast HTTP Request Object Factory Method Signature
    public HttpRequest createFutureRequest();
    
}
