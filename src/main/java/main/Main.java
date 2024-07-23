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
    public void start(Stage primaryStage) throws IOException, InterruptedException {


///////// REST API INTERACTION /////////////////////////////////////////////////////////////////////////////////////////

        // Retrieve OpenWeatherMap API Key
        String apiKey = ApiKeyReader.getKey();

        // Instantiate HttpClient Node (used to send requests)
        HttpClient httpClient = HttpClient.newHttpClient();

        // API End Points
        String baseURL = "https://api.openweathermap.org/geo/1.0/direct";
        String cityName = "Los Angeles";
        String encodedCityName = URLEncoder.encode(cityName, StandardCharsets.UTF_8);         // Method encode() returns an encoded version of the input string, where special characters (including spaces) are replaced with their URL-encoded equivalents.
        int response_limit = 1;
        String geocodeEndPoint = String.format("%s?q=%s&limit=%s&appid=%s",baseURL, encodedCityName, response_limit,apiKey);

        // Instantiate HTTPS Request Node
        HttpRequest geocodeRequest = HttpRequest.newBuilder()
                .uri(URI.create(geocodeEndPoint))
                .GET()
                .build();

        // Instantiate Jackson ObjectMapper (Primary Jackson Class Node / Used to Serialize & Deserialize)
        ObjectMapper objectMapper = new ObjectMapper();

        HttpResponse<String> response = httpClient.send(geocodeRequest, HttpResponse.BodyHandlers.ofString());
        String responseBody = response.body();

        List<GeocodingResponse> geocodingResponses = objectMapper.readValue(responseBody,
                objectMapper.getTypeFactory().constructCollectionType(List.class, GeocodingResponse.class));

// If you expect a single result, you might want to get the first item from the list
        if (!geocodingResponses.isEmpty()) {
            GeocodingResponse responseObject = geocodingResponses.get(0);
            System.out.println("Latitude: " + responseObject.getLatitude());
            System.out.println("Longitude: " + responseObject.getLongitude());
            System.out.println("Name: " + responseObject.getCity());
            System.out.println("Country: " + responseObject.getCountry());
        } else {
            System.out.println("No results found.");
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
