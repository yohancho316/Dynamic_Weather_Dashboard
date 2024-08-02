package factory.implementations;

import factory.interfaces.HttpRequestFactory;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;


public class HttpRequestFactoryImplementation implements HttpRequestFactory {

    // Geocoding Http Request Object Factory Concrete Definition
    @Override
    public HttpRequest createGeocodeRequest(String CITY_NAME) {

        if(CITY_NAME == null) throw new NullPointerException("City name cannot be null");
        if(CITY_NAME.isEmpty()) throw new IllegalArgumentException("City name cannot be empty");

        // Encodes the city name to ensure it is URL-safe (e.g., spaces are replaced with %20).
        String ENCODED_GEOCODE_CITY_NAME = URLEncoder.encode(CITY_NAME, StandardCharsets.UTF_8);

        // Constructs the full URL for the API request by formatting the base URL with query parameters.
        String GEOCODE_URL = String.format("%s?q=%s&limit=%s&appid=%s&units=%s", this.GEOCODE_BASE_URL,
                                                                                ENCODED_GEOCODE_CITY_NAME,
                                                                                this.GEOCODE_RESPONSE_LIMIT,
                                                                                this.API_KEY,
                                                                                this.GEOCODE_METRIC_SYSTEM);

        // Instantiate HTTPS Request Node
        return HttpRequest.newBuilder()
                .uri(URI.create(GEOCODE_URL))  // Creates a URI from the endpoint URL.
                .GET()  // Specifies the HTTP method as GET.
                .build();  // Builds the HttpRequest object.

    }

    // Current Forecast Http Request Object Factory Concrete Definition
    @Override
    public HttpRequest createCurrentRequest(String LATITUDE, String LONGITUDE) {

        if(LATITUDE == null) throw new NullPointerException("Latitude cannot be null");
        if(LATITUDE.isEmpty()) throw new IllegalArgumentException("City cannot be empty");

        if(LATITUDE == null) throw new NullPointerException("Longitude cannot be null");
        if(LATITUDE.isEmpty()) throw new IllegalArgumentException("Longitude cannot be empty");

        // Encoded Parameters
        String ENCODED_LATITUDE = URLEncoder.encode(LATITUDE, StandardCharsets.UTF_8);
        String ENCODED_LONGITUDE = URLEncoder.encode(LONGITUDE, StandardCharsets.UTF_8);
        String ENCODED_METRIC_SYSTEM = URLEncoder.encode(this.CURRENT_METRIC_SYSTEM, StandardCharsets.UTF_8);

        // Constructs the full URL for the API request by formatting the base URL with query parameters
        String CURRENT_URL = String.format("%s?lat=%s&lon=%s&appid=%s&units=%s", this.CURRENT_BASE_URL,
                                                                                        ENCODED_LATITUDE,
                                                                                        ENCODED_LONGITUDE,
                                                                                        this.API_KEY,
                                                                                        ENCODED_METRIC_SYSTEM);

        return HttpRequest.newBuilder()
                .uri(URI.create(CURRENT_URL))  // Creates a URI from the endpoint URL.
                .GET()  // Specifies the HTTP method as GET.
                .build();  // Builds the HttpRequest object.;
    }

    // Future Forecast Http Request Object Factory Concrete Definition
    @Override
    public HttpRequest createFutureRequest(String LATITUDE, String LONGITUDE) {

        if(LATITUDE == null) throw new NullPointerException("Latitude cannot be null");
        if(LATITUDE.isEmpty()) throw new IllegalArgumentException("City cannot be empty");

        if(LATITUDE == null) throw new NullPointerException("Longitude cannot be null");
        if(LATITUDE.isEmpty()) throw new IllegalArgumentException("Longitude cannot be empty");

        // Encoded Parameters
        String ENCODED_LATITUDE = URLEncoder.encode(LATITUDE, StandardCharsets.UTF_8);
        String ENCODED_LONGITUDE = URLEncoder.encode(LONGITUDE, StandardCharsets.UTF_8);
        String ENCODED_METRIC_SYSTEM = URLEncoder.encode(this.FUTURE_METRIC_SYSTEM, StandardCharsets.UTF_8);

        // Constructs the full URL for the API request by formatting the base URL with query parameters
        String FUTURE_URL = String.format("%s?lat=%s&lon=%s&appid=%s&units=%s",
                this.FUTURE_BASE_URL,
                ENCODED_LATITUDE,
                ENCODED_LONGITUDE,
                this.API_KEY,
                ENCODED_METRIC_SYSTEM);


        return HttpRequest.newBuilder()
                .uri(URI.create(FUTURE_URL))  // Creates a URI from the endpoint URL.
                .GET()  // Specifies the HTTP method as GET.
                .build();  // Builds the HttpRequest object.
    }

}
