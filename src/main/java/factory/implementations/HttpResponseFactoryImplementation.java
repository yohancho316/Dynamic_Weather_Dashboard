package factory.implementations;

import factory.interfaces.HttpResponseFactory;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpResponseFactoryImplementation implements HttpResponseFactory {

    // Geocoding HTTP Response Object Factory Concrete Definition
    @Override
    public HttpResponse<String> createGeocodeResponse(HttpRequest GEOCODE_REQUEST, HttpClient HTTP_CLIENT) {

        if(GEOCODE_REQUEST == null) throw new NullPointerException("HTTP Request cannot be null");
        if(HTTP_CLIENT == null) throw new NullPointerException("HTTP Client cannot be null");

        HttpResponse<String> response = null;

        try {

            // Sends the HTTP request and retrieves the response body as a String.
            response = HTTP_CLIENT.send(GEOCODE_REQUEST, HttpResponse.BodyHandlers.ofString());

        } catch (IOException | InterruptedException e) {
            // Handles exceptions by printing the stack trace if an error occurs during the request or deserialization
            e.printStackTrace();
        }

        return response;
    }

    // Current Forecast HTTP Response Object Factory Concrete Definition
    @Override
    public HttpResponse<String> createCurrentResponse(HttpRequest CURRENT_REQUEST, HttpClient HTTP_CLIENT) {

        if(CURRENT_REQUEST == null) throw new NullPointerException("HTTP Request cannot be null");
        if(HTTP_CLIENT == null) throw new NullPointerException("HTTP Client cannot be null");

        HttpResponse<String> response = null;

        try {

            // Sends the HTTP request and retrieves the response body as a String.
            response = HTTP_CLIENT.send(CURRENT_REQUEST, HttpResponse.BodyHandlers.ofString());

        } catch (IOException | InterruptedException e) {
            // Handles exceptions by printing the stack trace if an error occurs during the request or deserialization
            e.printStackTrace();
        }

        return response;
    }

    // Future Forecast HTTP Response Object Factory Concrete Definition
    @Override
    public HttpResponse<String> createFutureResponse(HttpRequest FUTURE_REQUEST, HttpClient HTTP_CLIENT) {

        if(FUTURE_REQUEST == null) throw new NullPointerException("HTTP Request cannot be null");
        if(HTTP_CLIENT == null) throw new NullPointerException("HTTP Client cannot be null");

        HttpResponse<String> response = null;

        try {

            // Sends the HTTP request and retrieves the response body as a String.
            response = HTTP_CLIENT.send(FUTURE_REQUEST, HttpResponse.BodyHandlers.ofString());

        } catch (IOException | InterruptedException e) {
            // Handles exceptions by printing the stack trace if an error occurs during the request or deserialization
            e.printStackTrace();
        }

        return response;
    }
}
