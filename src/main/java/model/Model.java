package model;

import com.fasterxml.jackson.core.JsonProcessingException;
import factory.implementations.HttpRequestFactoryImplementation;
import com.fasterxml.jackson.databind.ObjectMapper;
import factory.implementations.HttpResponseFactoryImplementation;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;


public class Model {

    // Model Class Fields
    private static String DEFAULT_CITY = "Los Angeles";
    private static String API_KEY = ApiKeyReader.getKey();
    private HttpClient httpClient;
    private ObjectMapper objectMapper;
    private HttpRequestFactoryImplementation httpRequestFactory;
    private HttpResponseFactoryImplementation httpResponseFactory;
    private HttpRequest geocodeRequest;
    private HttpResponse geocodeResponse;
    private GeocodingResponse geocodeResponseBody;
    private HttpRequest currentRequest;
    private HttpResponse currentResponse;
    private CurrentWeatherResponse currentResponseBody;
    private HttpRequest futureRequest;
    private HttpResponse futureResponse;

    // API Key Getter Method
    public String getKey() {
        return this.API_KEY;
    }

    // HttpClient Singleton Getter Method
    public HttpClient getHttpClient() {
        return this.httpClient;
    }

    // ObjectMapper Singleton Getter Method
    public ObjectMapper getObjectMapper() {
        return this.objectMapper;
    }

    // HttpRequest Object Factory Getter Method
    public HttpRequestFactoryImplementation getHttpRequestFactory() {
        return this.httpRequestFactory;
    }

    // HttpResponse Object Factory Getter Method
    public HttpResponseFactoryImplementation getHttpResponseFactory() { return this.httpResponseFactory; }

    // Geocode Http Request Getter Method
    public HttpRequest getGeocodeRequest() { return this.geocodeRequest; }

    // Gecode Http Response Getter Method
    public HttpResponse getGeocodeResponse() { return this.geocodeResponse; }

    // Current Forecast Http Request Getter Method
    public HttpRequest getCurrentRequest() { return this.currentRequest; }

    // Current Forecast Http Response Getter Method
    public HttpResponse getCurrentResponse() { return this.currentResponse; }

    // Geocode Response Body Getter Method
    public GeocodingResponse getGeocodeResponseBody() {
        return this.geocodeResponseBody;
    }

    // Current Weather Forecast Response Body Getter Method
    public CurrentWeatherResponse getCurrentWeatherResponseBody() {
        return this.currentResponseBody;
    }

    // Future Forecast Http Request Getter Method
    public HttpRequest getFutureRequest() { return this.futureRequest; }

    // Future Forecast Http Response Getter Method
    public HttpResponse getFutureResponse() { return this.futureResponse; }

    // API Key Setter Method
    public void setKey(String API_KEY) {
        if(API_KEY == null) throw new NullPointerException("API Key cannot be null");
        if(API_KEY.isEmpty()) throw new IllegalArgumentException("API Key cannot be empty");
        if(API_KEY.length() >= 33) throw new IllegalArgumentException("Open Weather API Key Character Length cannot exceed 32");
        this.API_KEY = API_KEY;
    }

    // HttpRequest Object Factory Setter Method
    public void setHttpRequestFactory(HttpRequestFactoryImplementation httpRequestFactory) {
        if (httpRequestFactory == null) throw new NullPointerException("Http Request Factory cannot be null");
        this.httpRequestFactory = httpRequestFactory;
    }

    // HttpRequest Object Factory Setter Method
    public void setHttpResponseFactory(HttpResponseFactoryImplementation httpResponseFactory) {
        if (httpResponseFactory == null) throw new NullPointerException("Http Response Factory cannot be null");
        this.httpResponseFactory = httpResponseFactory;
    }

    // Geocode HttpRequest Setter Method
    public void setGeocodeRequest(HttpRequest geocodeRequest) {
        if(geocodeRequest == null) throw new NullPointerException("Geocode HTTPS Request cannot be null");
        this.geocodeRequest = geocodeRequest;
    }

    // Geocode HttpResponse Setter Method
    public void setGeocodeResponse(HttpResponse geocodeResponse) {
        if(geocodeResponse == null) throw new NullPointerException("Geocode HttpResponse cannot be null");
        this.geocodeResponse = geocodeResponse;
    }

    // Current Forecast HTTP Request Setter Method
    public void setCurrentRequest(HttpRequest currentRequest) {
        if(currentRequest == null) throw new NullPointerException("Current request cannot be null");
        this.currentRequest = currentRequest;
    }

    // Current Forecast Http Response Setter Method
    public void setCurrentResponse(HttpResponse currentResponse) {
        if(currentResponse == null) throw new NullPointerException("Current response cannot be null");
        this.currentResponse = currentResponse;
    }

    // Geocoding Response Body Setter Method
    public void setGeocodeResponseBody(GeocodingResponse geocodeResponseBody) {
        if(geocodeResponseBody == null) throw new NullPointerException("Geocode Response Body cannot be null");
        this.geocodeResponseBody = geocodeResponseBody;
    }

    // Current Weather Forecast Response Body Setter Method
    public void setCurrentWeatherResponseBody(CurrentWeatherResponse currentResponseBody) {
        if(currentResponseBody == null) throw new NullPointerException("Current Weather Response body cannot be null");
        this.currentResponseBody = this.currentResponseBody;
    }

    // Future Forecast Http Request Setter Method
    public void setFutureRequest(HttpRequest futureRequest) {
        if(futureRequest == null) throw new NullPointerException("Future Forecast Http Request cannot be null");
        this.futureRequest = futureRequest;
    }

    // Future Forecast Http Response Setter Method
    public void setFutureResponse(HttpResponse futureResponse) {
        if(futureResponse == null) throw new NullPointerException("Future Forecast HttpResponse cannot be null");
        this.futureResponse = futureResponse;
    }

    // Model Class Constructor Method
    public Model() {

        // Instantiate HTTP Client Singleton Object
        this.httpClient = this.createHttpClient();

        // Instantiate Jackson ObjectMapper Singleton Object (Serialization / Deserialization)
        this.objectMapper = this.createObjectMapper();

        // Instantiate Http Request Object Factory
        this.httpRequestFactory = this.createHttpRequestFactory();

        // Instantiate Http Response Object Factory
        this.httpResponseFactory = this.createHttpResponseFactory();

        // Instantiate Gecode Http Request Object
        this.geocodeRequest = this.createGeocodeHttpRequest(null);

        // Instantiate Geocode Http Response Object
        this.geocodeResponse = this.createGeocodeHttpResponse();

        // Instantiate Geocode Http Response Body
        this.geocodeResponseBody = this.createGeocodingResponseBody();

        // Print Geocode Http Response Body
        this.printGeocodeHttpResponseBody();

        // Instantiate Current Forecast Http Request Object
        this.currentRequest = this.createCurrentHttpRequest(String.valueOf(this.geocodeResponseBody.getLatitude()), String.valueOf(this.geocodeResponseBody.getLongitude()));

        // Instantiate Current Forecast Http Response Object
        this.currentResponse = this.createCurrentHttpResponse();

        // Instantiate Current Forecast Http Response Body
        this.currentResponseBody = this.createCurrentHttpResponseBody();

        // Print Current Weather Forecast Http Response Body
        this.printCurrentHttpResponseBody();

        // Instantiate Future Forecast Http Request Object
        this.futureRequest = this.createFutureHttpRequest(String.valueOf(this.geocodeResponseBody.getLatitude()), String.valueOf(this.geocodeResponseBody.getLongitude()));

        // Instantiate Future Forecast Http Response Object
        this.futureResponse = this.createFutureHttpResponse();

        // Instantiate Future Forecast Http Response Body
        

    }

    // Create JDK Http Client Singleton Instance
    public HttpClient createHttpClient() {
        return HttpClientSingleton.getHttpClient();
    }

    // Create Object Mapper Singleton Instance
    public ObjectMapper createObjectMapper() {
        return ObjectMapperSingleton.getObjectMapper();
    }

    // Create HttpRequest Object Factory Instance
    public HttpRequestFactoryImplementation createHttpRequestFactory() {
        return new HttpRequestFactoryImplementation();
    }

    // Create HttpResponse Object Factory Instance
    public HttpResponseFactoryImplementation createHttpResponseFactory() {
        return new HttpResponseFactoryImplementation();
    }

    // Create Gecode HttpRequest Instance
    public HttpRequest createGeocodeHttpRequest(String city) {
        if(city != null && city.isEmpty()) throw new IllegalArgumentException("City cannot be empty");

        if(city != null) return this.httpRequestFactory.createGeocodeRequest(city);
        return this.httpRequestFactory.createGeocodeRequest(this.DEFAULT_CITY);
    }

    // Create Geocode HttpResponse Instance
    public HttpResponse createGeocodeHttpResponse() {
        return this.httpResponseFactory.createGeocodeResponse(this.geocodeRequest, this.httpClient);
    }

    // Create Geocode Http Response Body Instance
    public GeocodingResponse createGeocodingResponseBody() {
        List<GeocodingResponse> geocodingResponseList = null;
        GeocodingResponse geocodeResponseBody = null;
        try  {
            geocodingResponseList = objectMapper.readValue(this.geocodeResponse.body().toString(),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, GeocodingResponse.class));
            geocodeResponseBody = geocodingResponseList.get(0);
            // geocodeResponseBody = this.objectMapper.readValue(this.geocodeResponse.body().toString(), GeocodingResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return geocodeResponseBody;
    }

    // Create Current HttpRequest Instance
    public HttpRequest createCurrentHttpRequest(String latitude, String longitude) {
        if(latitude == null) throw new NullPointerException("Latitude cannot be null");
        if(longitude == null) throw new NullPointerException("Longitude cannot be null");
        if(latitude.isEmpty()) throw new IllegalArgumentException("Latitude cannot be empty");
        if(longitude.isEmpty()) throw new IllegalArgumentException("Longitude cannot be empty");
        return this.httpRequestFactory.createCurrentRequest(latitude,longitude);
    }

    // Create Current HttpResponse Instance
    public HttpResponse createCurrentHttpResponse() {
        return this.httpResponseFactory.createCurrentResponse(this.currentRequest, this.httpClient);
    }

    // Create Current Http Response Body
    public CurrentWeatherResponse createCurrentHttpResponseBody() {
        CurrentWeatherResponse currentWeatherResponseBody = null;
        try {
            currentWeatherResponseBody = this.objectMapper.readValue(this.currentResponse.body().toString(), CurrentWeatherResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return currentWeatherResponseBody;
    }

    // Create Future HttpRequest Instance
    public HttpRequest createFutureHttpRequest(String LATITUDE, String LONGITUDE) {
        if(LATITUDE == null) throw new NullPointerException("Latitude cannot be null");
        if(LONGITUDE == null) throw new NullPointerException("Longitude cannot be null");
        if(LATITUDE.isEmpty()) throw new IllegalArgumentException("Latitude cannot be empty");
        if(LONGITUDE.isEmpty()) throw new IllegalArgumentException("Longitude cannot be empty");
        return this.httpRequestFactory.createFutureRequest(LATITUDE, LONGITUDE);
    }

    // Create Future HttpResponse Instance
    public HttpResponse createFutureHttpResponse() {
        return this.httpResponseFactory.createFutureResponse(this.futureRequest, this.httpClient);
    }

    // Print Geocode HttpResponse Body
    public void printGeocodeHttpResponseBody() {
        // Check if the response list is not empty and process the first result.
        if (this.geocodeResponseBody != null) {
            System.out.println("\n\nPRINTING GEOCODE GET RESPONSE PROPERTIES");
            System.out.println("Latitude: " + geocodeResponseBody.getLatitude());  // Prints the latitude of the city.
            System.out.println("Longitude: " + geocodeResponseBody.getLongitude());  // Prints the longitude of the city.
            System.out.println("Name: " + geocodeResponseBody.getCity());  // Prints the name of the city.
            System.out.println("Country: " + geocodeResponseBody.getCountry());  // Prints the country code of the city.
        } else {
            System.out.println("No results found.");  // Prints a message if no results were returned from the API.
        }
    }

    // Print Current HttpResponse Body
    public void printCurrentHttpResponseBody() {
        if(this.currentResponseBody != null) {
            System.out.println("\n\n\nCurrent Weather KVP's:");
            System.out.println("Longitude: " + this.currentResponseBody.getCoordinates().getLongitude());
            System.out.println("Latitude: " + currentResponseBody.getCoordinates().getLatitude());
            System.out.println("Weather ID: " + currentResponseBody.getWeather().get(0).getID());
            System.out.println("Main: " + currentResponseBody.getWeather().get(0).getMain());
            System.out.println("Weather Description: " + currentResponseBody.getWeather().get(0).getCurrentWeatherDescription());
            System.out.println("Icon: " + currentResponseBody.getWeather().get(0).getIcon());
            System.out.println("Base: " + currentResponseBody.getBase());
            System.out.println("Current Temp: " + currentResponseBody.getMain().getCurrentTemperature());
            System.out.println("Temperature Feels Like: " + currentResponseBody.getMain().getFeelsLikeTemperature());
            System.out.println("Max Temp: " + currentResponseBody.getMain().getMaxTemp());
            System.out.println("Min Temp: " + currentResponseBody.getMain().getMinTemp());
            System.out.println("Pressure: " + currentResponseBody.getMain().getPressure());
            System.out.println("Humidity: " + currentResponseBody.getMain().getHumidity());
            System.out.println("Sea Level: " + currentResponseBody.getMain().getSeaLevel());
            System.out.println("Ground Level: " + currentResponseBody.getMain().getGroundLevel());
            System.out.println("Visibility: " + currentResponseBody.getVisibility());
            System.out.println("Wind Speed: " + currentResponseBody.getWind().getSpeed());
            System.out.println("Wind Degree: " + currentResponseBody.getWind().getDegree());
            System.out.println("Cloud Level: " + currentResponseBody.getClouds().getAll());
            System.out.println("Time of Data Collection: " + currentResponseBody.getTimeOfDataCalculation());
            System.out.println("Internal Type: " + currentResponseBody.getSys().getType());
            System.out.println("Internal ID: " + currentResponseBody.getSys().getID());
            System.out.println("Country Code: " + currentResponseBody.getSys().getCountry());
            System.out.println("Sunrise Time (UTC): " + currentResponseBody.getSys().getSunriseTime());
            System.out.println("Sunset Time (UTC): " + currentResponseBody.getSys().getSunriseTime());
            System.out.println("Timezone (UTC): " + currentResponseBody.getTimezone());
            System.out.println("City ID: " + currentResponseBody.getCityName());
        }
    }


}
