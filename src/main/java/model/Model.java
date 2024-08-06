package model;

import com.fasterxml.jackson.core.JsonProcessingException;
import factory.implementations.HttpRequestFactoryImplementation;
import com.fasterxml.jackson.databind.ObjectMapper;
import factory.implementations.HttpResponseFactoryImplementation;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class Model {

    // Model Class Fields
    private static String DEFAULT_CITY = "Los Angeles";
    private static String API_KEY = ApiKeyReader.getKey();
    private boolean start_flag = true;
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
    private FutureForecastResponse futureResponseBody;


    // View Data Fields
    private String currentTemp = "";
    private String currentStatus = "";
    private String currentID = "";
    private String sunriseTime = "";
    private String sunsetTime = "";
    private List<String> forecastTimeList = new ArrayList<String>();
    private List<String> forecastTempList = new ArrayList<String>();
    private List<String> forecastIDList = new ArrayList<String>();


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

    // Future Forecast Http Response Body Getter Method
    public FutureForecastResponse getFutureResponseBody() { return this.futureResponseBody; }

    // Current Temp Getter Method
    public String getCurrentTime() { return this.currentTemp; }

    // Current Status Getter Method
    public String getCurrentStatus() { return this.currentStatus; }

    // Current Weather Icon ID Getter Method
    public String getCurrentID() { return this.currentID; }

    // Sunrise Time Getter Method
    public String getSunriseTime() { return this.sunriseTime; }

    // Sunset Time Getter Method
    public String getSunsetTime() { return this.sunsetTime; }

    // Forecast Time List Getter Method
    public List<String> getForecastTimeList() { return this.forecastTimeList; }

    // Forecast Temp List Getter Method
    public List<String> getForecastTempList() { return this.forecastTempList; }

    // Forecast Status ID List Getter Method
    public List<String> getForecastIDList() { return this.forecastIDList; }

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

    // Future Forecast Http Response Body Setter Method
    public void setFutureResponseBody(FutureForecastResponse futureResponseBody) {
        if(futureResponseBody == null) throw new NullPointerException("Future Forecast Http Response Body cannot be null");
        this.futureResponseBody = futureResponseBody;
    }

    // Current Temp Setter Method
    public void setCurrentTemp(String currentTemp) {
        if(currentTemp == null) throw new NullPointerException("Current Weather Temp cannot be null");
        this.currentTemp = currentTemp;
    }


    // Current Status Setter Method
    public void setCurrentStatus(String currentStatus) {
        if(currentStatus == null) throw new NullPointerException("Current Weather Status cannot be null");
        this.currentStatus = currentStatus;
    }

    // Sunrise Time Setter Method
    public void setSunriseTime(String sunriseTime) {
        if(sunriseTime == null) throw new NullPointerException("Sunrise Time cannot be null");
        this.sunriseTime = sunriseTime;
    }

    // Sunset Time Setter Method
    public void setSunsetTime(String sunsetTime) {
        if(sunsetTime == null) throw new NullPointerException("Sunset Time cannot be null");
        this.sunsetTime = sunsetTime;
    }

    // Forecast Time List Setter Method
    public void setForecastTimeList(List<String> forecastTimeList) {
        if(forecastTimeList == null) throw new NullPointerException("Forecast Time List cannot be null");
        this.forecastTimeList = forecastTimeList;
    }

    // Forecast Temp List Setter Method
    public void setForecastTempList(List<String> forecastTempList) {
        if(forecastTempList == null) throw new NullPointerException("Forecast Temp List cannot be null");
        this.forecastTempList = forecastTempList;
    }

    // Forecast Status ID List Setter Method
    public void setForecastIDList(List<String> forecastIDList) {
        if(forecastIDList == null) throw new NullPointerException("Forecast ID List cannot be null");
        this.forecastIDList = forecastIDList;
    }

    // Current Weather Icon ID Getter Method
    public void setCurrentID(String currentID) {
        if(currentID == null) throw new NullPointerException("Current Weather Icon ID cannot be null");
        this.currentID = currentID;
    }

    // Model Class Constructor Method
    public Model() {

        // Execute upon First Start
        if(this.start_flag) {
            this.initializeApp();
            this.start_flag = false;
        }

    }

    // First Start App Initialization
    public void initializeApp() {

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
        this.futureResponseBody = this.createFutureHttpResponseBody();

        // Print Future Weather Forecast Http Response Body
        this.printFutureHttpResponseBody();

        // Load View Data Fields
        this.generateViewFields();

        // Print View Related Data
        this.printViewDataFields();

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

    // Create Future Http Response Body
    public FutureForecastResponse createFutureHttpResponseBody() {
        FutureForecastResponse futureForecastResponse = null;
        try {
            futureForecastResponse = this.objectMapper.readValue(this.futureResponse.body().toString(), FutureForecastResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return futureForecastResponse;
    }

    // Generate View Data Fields
    public void generateViewFields() {

        // Check for Null Conditions
        if(this.currentResponseBody == null) throw new NullPointerException("Current Response Body cannot be null");
        if(this.currentResponseBody.getMain() == null) throw new NullPointerException("Current Response Body - Main cannot be null");
        if(this.currentResponseBody.getWeather() == null) throw new NullPointerException("Current Response Body - Weather Cannot be null");
        if(this.currentResponseBody.getSys() == null) throw new NullPointerException("Current Response Body - SYS cannot be null");


        // Retrieve Current Temperature in Degrees
        this.currentTemp = String.valueOf(this.currentResponseBody.getMain().getCurrentTemperature());

        // Retrieve Current Weather Forecast Description
        this.currentStatus = String.valueOf(this.currentResponseBody.getWeather().get(0).getCurrentWeatherDescription());

        // Retrieve Current Weather Icon ID
        this.currentID = String.valueOf(this.currentResponseBody.getWeather().get(0).getIcon());

        // Retrieve Sunrise Time in PST
        this.sunriseTime = String.valueOf(this.convertUTC(this.currentResponseBody.getSys().getSunriseTime()));

        // Calculate Sunset Time in PST
        this.sunsetTime = String.valueOf(this.convertUTC(this.currentResponseBody.getSys().getSunsetTime()));

        // Generate Future Forecast Time List
        this.generateForecastTimeList();

        // Generate Future Forecast Temp List
        this.generateForecastTempList();

        // Generate Forecast ID List
        this.generateForecastIDList();

    }

    // Convert UTC to PST
    public String convertUTC(int utc) {

        Instant utcInstant = Instant.ofEpochSecond(utc);

        // Convert UTC to ZonedDateTime in the desired time zone (PST)
        ZonedDateTime zonedDateTime = utcInstant.atZone(ZoneId.of("America/Los_Angeles"));

        // Format the ZonedDateTime to a human-readable string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH");

        // Extract hour
        int hour = zonedDateTime.getHour();
        String period = (hour >= 12) ? "P.M" : "A.M";

        // Convert to 12-hour format
        hour = (hour > 12) ? hour - 12 : hour;
        hour = (hour == 0) ? 12 : hour;

        return hour + " " + period;
    }

    // Generate Forecast Time List
    public void generateForecastTimeList() {

        if(this.futureResponseBody.getList() == null) throw new NullPointerException("Future Forecast Time List cannot be null");
        if(this.futureResponseBody.getList().isEmpty()) throw new IllegalArgumentException("Future Forecast Time List cannot be empty");
        if(this.futureResponseBody.getList().size() < 10) throw new IllegalArgumentException("Future Forecast Time List must be >= 10");

        for(int i = 0; i < 10; i++) {
            this.forecastTimeList.add(String.valueOf(this.convertUTC(this.futureResponseBody.getList().get(i).getTimeOfDataForecast())));
        }
    }

    // Generate Forecast Temperature List
    public void generateForecastTempList() {

        if(this.futureResponseBody.getList() == null) throw new NullPointerException("Future Forecast Temp List cannot be null");
        if(this.futureResponseBody.getList().isEmpty()) throw new IllegalArgumentException("Future Forecast Time List cannot be empty");
        if(this.futureResponseBody.getList().size() < 10) throw new IllegalArgumentException("Future Forecast Time List must be >= 10");

        for(int i = 0; i < 10; i++) {
            this.forecastTempList.add(String.valueOf(this.futureResponseBody.getList().get(i).getMain().getCurrentTemperature()));
        }
    }

    // Generate Forecast ID List
    public void generateForecastIDList() {
        if(this.futureResponseBody.getList() == null) throw new NullPointerException("Future Forecast Response Body cannot be null");
        if(this.futureResponseBody.getList().get(0) == null) throw new NullPointerException("Future Forecast Response Body Element cannot be null");
        if(this.futureResponseBody.getList().get(0).getWeather() == null) throw new NullPointerException("Future Forecast Response Body Weather Member cannot be null");
        if(this.futureResponseBody.getList().get(0).getWeather().get(0) == null) throw new NullPointerException("Weather cannot be null");

        for(int i = 0; i < 10; i++) {
            this.forecastIDList.add(String.valueOf(this.futureResponseBody.getList().get(i).getWeather().get(0).getIcon()));
        }
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
            System.out.println("Latitude: " + this.currentResponseBody.getCoordinates().getLatitude());
            System.out.println("Weather ID: " + this.currentResponseBody.getWeather().get(0).getID());
            System.out.println("Main: " + this.currentResponseBody.getWeather().get(0).getMain());
            System.out.println("Weather Description: " + this.currentResponseBody.getWeather().get(0).getCurrentWeatherDescription());
            System.out.println("Icon: " + this.currentResponseBody.getWeather().get(0).getIcon());
            System.out.println("Base: " + this.currentResponseBody.getBase());
            System.out.println("Current Temp: " + this.currentResponseBody.getMain().getCurrentTemperature());
            System.out.println("Temperature Feels Like: " + this.currentResponseBody.getMain().getFeelsLikeTemperature());
            System.out.println("Max Temp: " + this.currentResponseBody.getMain().getMaxTemp());
            System.out.println("Min Temp: " + this.currentResponseBody.getMain().getMinTemp());
            System.out.println("Pressure: " + this.currentResponseBody.getMain().getPressure());
            System.out.println("Humidity: " + this.currentResponseBody.getMain().getHumidity());
            System.out.println("Sea Level: " + this.currentResponseBody.getMain().getSeaLevel());
            System.out.println("Ground Level: " + this.currentResponseBody.getMain().getGroundLevel());
            System.out.println("Visibility: " + this.currentResponseBody.getVisibility());
            System.out.println("Wind Speed: " + this.currentResponseBody.getWind().getSpeed());
            System.out.println("Wind Degree: " + this.currentResponseBody.getWind().getDegree());
            System.out.println("Cloud Level: " + this.currentResponseBody.getClouds().getAll());
            System.out.println("Time of Data Collection: " + this.currentResponseBody.getTimeOfDataCalculation());
            System.out.println("Internal Type: " + this.currentResponseBody.getSys().getType());
            System.out.println("Internal ID: " + this.currentResponseBody.getSys().getID());
            System.out.println("Country Code: " + this.currentResponseBody.getSys().getCountry());
            System.out.println("Sunrise Time (UTC): " + this.currentResponseBody.getSys().getSunriseTime());
            System.out.println("Sunset Time (UTC): " + this.currentResponseBody.getSys().getSunriseTime());
            System.out.println("Timezone (UTC): " + this.currentResponseBody.getTimezone());
            System.out.println("City ID: " + this.currentResponseBody.getCityName());
        }
    }

    // Print Future HttpResponseBody
    public void printFutureHttpResponseBody() {
        if(this.futureResponseBody != null) {
            System.out.println("\n\n\nFUTURE WEATHER FORECAST DATA:");
            System.out.println("cod (internal parameter): " + futureResponseBody.getCod());
            System.out.println("Message (internal parameter): " + futureResponseBody.getMessage());
            System.out.println("# of Timestamps Returned in Response: " + futureResponseBody.getTimestampReturnCount());
            System.out.println("Total List Items: " + futureResponseBody.getList().size());
            System.out.println("ListItem # 1 Time of Data Forecasted in UTC: " + futureResponseBody.getList().get(0).getTimeOfDataForecast());
            System.out.println("ListItem # 1 Main Temperature: " + futureResponseBody.getList().get(0).getMain().getCurrentTemperature());
        }
    }

    public void printViewDataFields() {
        System.out.println("\n\n\nView Data Fields:");
        System.out.println("Current Temp: " + this.currentTemp);
        System.out.println("Current Temp Status: " + this.currentStatus);
        System.out.println("Current Weather Icon ID: " + this.currentID);
        System.out.println("Sunrise Time: " + this.sunriseTime);
        System.out.println("Sunset Time: " + this.sunsetTime);
        System.out.println("\nFuture Forecast Time Periods: ");
        for(String time : this.forecastTimeList) System.out.println(time);
        System.out.println("\nFuture Forecast Temps: ");
        for(String temp : this.forecastTempList) System.out.println(temp);
        System.out.println("\nFuture Forecast Icon ID: ");
        for(String id : this.forecastIDList) System.out.println(id);
    }


}
