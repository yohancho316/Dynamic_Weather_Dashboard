package model;

import factory.implementations.HttpRequestFactoryImplementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import factory.implementations.HttpResponseFactoryImplementation;

import java.io.IOException;
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
    private List<GeocodingResponse> geocodeResponseList;


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

    // GeocodeResponse Collection Getter Method
    public List<GeocodingResponse> getGeocodeResponseList() {
        return this.geocodeResponseList;
    }

    // Geocode Http Request Getter Method
    public HttpRequest getGeocodeRequest() { return this.geocodeRequest; }

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

    // Geocode HttpRequest  Setter Method
    public void setGeocodeRequest(HttpRequest geocodeRequest) {
        if(geocodeRequest == null) throw new NullPointerException("Geocode HTTPS Request cannot be null");
        this.geocodeRequest = geocodeRequest;
    }

    // GeocodeResponse Collection Setter Method
    public void getGeocodingResponseList(List<GeocodingResponse> geocodeResponseList) {
        if(geocodeResponseList == null) throw new NullPointerException("Geocode Response Collection cannot be null");
        this.geocodeResponseList = geocodeResponseList;
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

        // Instantiate Geocode Http Response Collection
        this.geocodeResponseList = this.fillGeocodeResponseCollection(this.geocodeResponse);

        // Print Geocode Http Response Body
        this.printGeocodeHttpResponseBody();

        

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

    // Fill Geocode Response Collection
    public List<GeocodingResponse> fillGeocodeResponseCollection(HttpResponse geocodeResponse) {
        if(geocodeResponse == null) throw new NullPointerException("Geocode HttpResponse cannot be null");
        List<GeocodingResponse> tempList = null;

        try {
            tempList = this.objectMapper.readValue(geocodeResponse.body().toString(),
                    this.objectMapper.getTypeFactory().constructCollectionType(List.class, GeocodingResponse.class));
        } catch(IOException e) {
            e.printStackTrace();
        }

        return tempList;
    }

    // Print Geocode HttpResponse Body
    public void printGeocodeHttpResponseBody() {
        // Check if the response list is not empty and process the first result.
        if (!this.geocodeResponseList.isEmpty()) {
            GeocodingResponse responseObject = geocodeResponseList.get(0);  // Retrieves the first GeocodingResponse object from the list.
            System.out.println("\n\nPRINTING GEOCODE GET RESPONSE PROPERTIES");
            System.out.println("Latitude: " + responseObject.getLatitude());  // Prints the latitude of the city.
            System.out.println("Longitude: " + responseObject.getLongitude());  // Prints the longitude of the city.
            System.out.println("Name: " + responseObject.getCity());  // Prints the name of the city.
            System.out.println("Country: " + responseObject.getCountry());  // Prints the country code of the city.
        } else {
            System.out.println("No results found.");  // Prints a message if no results were returned from the API.
        }
    }

}
