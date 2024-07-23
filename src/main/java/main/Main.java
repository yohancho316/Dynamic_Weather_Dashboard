package main;

import com.fasterxml.jackson.core.type.TypeReference;
import factory.implementations.ForecastFactoryImplementation;
import factory.implementations.CurrentForecastFactoryImplementation;
import factory.implementations.WrapperFactoryImplementation;
import factory.implementations.MenuFactoryImplementation;
import model.ApiKeyReader;
import model.GeocodingResponse;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;


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

        // API End Points
        String baseURL = "https://api.openweathermap.org/geo/1.0/direct";  // Base URL for the geocoding API endpoint.
        String cityName = "Los Angeles";  // Name of the city to query.
        String encodedCityName = URLEncoder.encode(cityName, StandardCharsets.UTF_8);  // Encodes the city name to ensure it is URL-safe (e.g., spaces are replaced with %20).
        int response_limit = 1;  // Limit for the number of results to return from the API.
        String geocodeEndPoint = String.format("%s?q=%s&limit=%s&appid=%s", baseURL, encodedCityName, response_limit, apiKey);  // Constructs the full URL for the API request by formatting the base URL with query parameters.

        // Instantiate HTTPS Request Node
        HttpRequest geocodeRequest = HttpRequest.newBuilder()
                .uri(URI.create(geocodeEndPoint))  // Creates a URI from the endpoint URL.
                .GET()  // Specifies the HTTP method as GET.
                .build();  // Builds the HttpRequest object.

        // Instantiate Jackson ObjectMapper (Primary Jackson Class Node / Used to Serialize & Deserialize)
        ObjectMapper objectMapper = new ObjectMapper();  // Creates an ObjectMapper instance for converting JSON to Java objects and vice versa.

        List<GeocodingResponse> geocodingResponses = null;  // Initializes a list to hold the deserialized geocoding response objects.

        try {
            HttpResponse<String> response = httpClient.send(geocodeRequest, HttpResponse.BodyHandlers.ofString());  // Sends the HTTP request and retrieves the response body as a String.
            String responseBody = response.body();  // Extracts the response body from the HttpResponse.

            // Deserialize the JSON response into a list of GeocodingResponse objects.
            geocodingResponses = objectMapper.readValue(responseBody,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, GeocodingResponse.class));

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
