package main;

import com.fasterxml.jackson.core.type.TypeReference;
import factory.implementations.ForecastFactoryImplementation;
import factory.implementations.CurrentForecastFactoryImplementation;
import factory.implementations.WrapperFactoryImplementation;
import factory.implementations.MenuFactoryImplementation;
import model.ApiKeyReader;
import model.CurrentWeatherResponse;
import model.GeocodingResponse;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;


import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import view.View;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {


///////// REST API INTERACTION /////////////////////////////////////////////////////////////////////////////////////////

        // Retrieve OpenWeatherMap API Key
        String apiKey = ApiKeyReader.getKey();  // Fetches the API key for authenticating requests to the OpenWeatherMap API.

        // Instantiate HttpClient Node (used to send requests)
        HttpClient httpClient = HttpClient.newHttpClient();  // Creates an instance of HttpClient for sending HTTP requests.

        // GeoCode API End Points
        String geocode_baseURL = "https://api.openweathermap.org/geo/1.0/direct";  // Base URL for the geocoding API endpoint.
        String geocode_cityName = "Los Angeles";  // Name of the city to query.
        String geocode_encodedCityName = URLEncoder.encode(geocode_cityName, StandardCharsets.UTF_8);  // Encodes the city name to ensure it is URL-safe (e.g., spaces are replaced with %20).
        int geocode_response_limit = 1;  // Limit for the number of results to return from the API.
        String geocodeEndPointURL = String.format("%s?q=%s&limit=%s&appid=%s", geocode_baseURL, geocode_encodedCityName, geocode_response_limit, apiKey);  // Constructs the full URL for the API request by formatting the base URL with query parameters.

        // Instantiate HTTPS Request Node
        HttpRequest geocodeRequest = HttpRequest.newBuilder()
                .uri(URI.create(geocodeEndPointURL))  // Creates a URI from the endpoint URL.
                .GET()  // Specifies the HTTP method as GET.
                .build();  // Builds the HttpRequest object.

        // Instantiate Jackson ObjectMapper (Primary Jackson Class Node / Used to Serialize & Deserialize)
        // Creates an ObjectMapper instance for converting JSON to Java objects and vice versa.
        ObjectMapper objectMapper = new ObjectMapper();

        // Initializes a list to hold the deserialized geocoding response objects.
        List<GeocodingResponse> geocodingResponses = null;

        try {

            // Sends the HTTP request and retrieves the response body as a String.
            HttpResponse<String> response = httpClient.send(geocodeRequest, HttpResponse.BodyHandlers.ofString());

            // HTTP Status Code
            int statusCode = response.statusCode();

            // Handle HTTP Success
            if(statusCode >= 200 && statusCode < 300) {

                // Extracts the response body from the HttpResponse
                String responseBody = response.body();

                // Deserialize the JSON response into a list of GeocodingResponse objects
                // Throws IOException
                geocodingResponses = objectMapper.readValue(responseBody,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, GeocodingResponse.class));

            }

            // Handle Client Error
            else if(statusCode >= 400 && statusCode < 500) {
                switch (statusCode) {
                    case 400:
                        System.out.println("Bad Request: Check the request parameters.");
                        break;
                    case 401:
                        System.out.println("Unauthorized: Check your API key.");
                        break;
                    case 403:
                        System.out.println("Forbidden: You do not have access to this resource.");
                        break;
                    case 404:
                        System.out.println("Not Found: The requested resource was not found.");
                        break;
                    default:
                        System.out.println("Client Error: " + statusCode);
                }
            }

            // Handle Server Error
            else if(statusCode >= 500) {
                switch (statusCode) {
                    case 500:
                        System.out.println("Internal Server Error: Try again later.");
                        break;
                    case 502:
                        System.out.println("Bad Gateway: The server is down or being upgraded.");
                        break;
                    case 503:
                        System.out.println("Service Unavailable: The server is overloaded or under maintenance.");
                        break;
                    default:
                        System.out.println("Server Error: " + statusCode);
                }
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();  // Handles exceptions by printing the stack trace if an error occurs during the request or deserialization.
        }

        // Check if the response list is not empty and process the first result.
        if (!geocodingResponses.isEmpty()) {
            GeocodingResponse responseObject = geocodingResponses.get(0);  // Retrieves the first GeocodingResponse object from the list.
            System.out.println("Latitude: " + responseObject.getLatitude());  // Prints the latitude of the city.
            System.out.println("Longitude: " + responseObject.getLongitude());  // Prints the longitude of the city.
            System.out.println("Name: " + responseObject.getCity());  // Prints the name of the city.
            System.out.println("Country: " + responseObject.getCountry());  // Prints the country code of the city.
        } else {
            System.out.println("No results found.");  // Prints a message if no results were returned from the API.
        }

        // Current Weather API End Points
        String current_baseURL = "https://api.openweathermap.org/data/2.5/weather";
        String current_metric_system = "imperial";

        // Latitude and Longitude from the geocoding response
        String current_latitude = String.valueOf(geocodingResponses.get(0).getLatitude());
        String current_longitude = String.valueOf(geocodingResponses.get(0).getLongitude());

        // Encode individual parameters
        String encoded_current_latitude = URLEncoder.encode(current_latitude, StandardCharsets.UTF_8);
        String encoded_current_longitude = URLEncoder.encode(current_longitude, StandardCharsets.UTF_8);
        String encoded_current_metric_system = URLEncoder.encode(current_metric_system, StandardCharsets.UTF_8);

        // Initializes a list to hold the deserialized geocoding response objects.
        CurrentWeatherResponse currentWeatherResponse = new CurrentWeatherResponse();


        // Constructs the full URL for the API request by formatting the base URL with query parameters
        String currentEndPointURL = String.format("%s?lat=%s&lon=%s&appid=%s&units=%s", current_baseURL,
                                                                             encoded_current_latitude,
                                                                             encoded_current_longitude,
                                                                             apiKey,
                                                                             encoded_current_metric_system);

        // Instantiate HTTPS Request Node
        HttpRequest currentWeatherRequest = HttpRequest.newBuilder()
                .uri(URI.create(currentEndPointURL))  // Creates a URI from the endpoint URL.
                .GET()  // Specifies the HTTP method as GET.
                .build();  // Builds the HttpRequest object.

        try {

            // Sends the HTTP request and retrieves the response body as a String.
            HttpResponse<String> response = httpClient.send(currentWeatherRequest, HttpResponse.BodyHandlers.ofString());

            // HTTP Status Code
            int statusCode = response.statusCode();

            // Handle HTTP Success
            if(statusCode >= 200 && statusCode < 300) {

                // Extracts the response body from the HttpResponse
                String responseBody = response.body();

                System.out.println("\n\nCurrent Weather Response Body:\n");
                System.out.println(responseBody);

                // Deserialize JSON to CurrentWeatherResponse Java Object
                currentWeatherResponse = objectMapper.readValue(responseBody, CurrentWeatherResponse.class);

            }

            // Handle Client Error
            else if(statusCode >= 400 && statusCode < 500) {
                switch (statusCode) {
                    case 400:
                        System.out.println("Bad Request: Check the request parameters.");
                        break;
                    case 401:
                        System.out.println("Unauthorized: Check your API key.");
                        break;
                    case 403:
                        System.out.println("Forbidden: You do not have access to this resource.");
                        break;
                    case 404:
                        System.out.println("Not Found: The requested resource was not found.");
                        break;
                    default:
                        System.out.println("Client Error: " + statusCode);
                }
            }

            // Handle Server Error
            else if(statusCode >= 500) {
                switch (statusCode) {
                    case 500:
                        System.out.println("Internal Server Error: Try again later.");
                        break;
                    case 502:
                        System.out.println("Bad Gateway: The server is down or being upgraded.");
                        break;
                    case 503:
                        System.out.println("Service Unavailable: The server is overloaded or under maintenance.");
                        break;
                    default:
                        System.out.println("Server Error: " + statusCode);
                }
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();  // Handles exceptions by printing the stack trace if an error occurs during the request or deserialization.
        }




////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // Instantiate Current Forecast Factory Node
        CurrentForecastFactoryImplementation currentFactory = new CurrentForecastFactoryImplementation();

        // Instantiate Future Forecast Factory Node
        ForecastFactoryImplementation futureFactory = new ForecastFactoryImplementation();

        // Instantiate Wrapper Factory Node
        WrapperFactoryImplementation wrapperFactory = new WrapperFactoryImplementation();

        // Instantiate Menu Factory Node
        MenuFactoryImplementation menuFactory = new MenuFactoryImplementation();

        LocalDateTime current_date = LocalDateTime.now();
        LocalTime current_time = LocalTime.now();

        List<String> pane_image_collection = new ArrayList<String>();
        List<LocalDateTime> pane_date_collection = new ArrayList<LocalDateTime>();
        List<LocalTime> pane_time_collection = new ArrayList<LocalTime>();

        String image_path = "/hurricane_weather_tornado_storm.png";
        String main_temp = "58";
        String main_status = "overcast clouds";
        String sunrise_time = "6:12 AM";
        String sunset_time = "8:00 PM";

        for(int i = 0; i < 10; i++) {
            pane_image_collection.add(image_path);
            pane_date_collection.add(current_date);
            pane_time_collection.add(current_time);
            current_date = current_date.plusHours(2);
            current_time = current_time.plusHours(2);
        }

        View view = new View(futureFactory,
                             currentFactory,
                             wrapperFactory,
                             menuFactory,
                             pane_image_collection,
                             pane_date_collection,
                             pane_time_collection,
                             image_path,
                             main_temp,
                             main_status,
                             sunrise_time,
                             sunset_time);


        Scene scene = new Scene(view.getWeatherUIVBox());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
