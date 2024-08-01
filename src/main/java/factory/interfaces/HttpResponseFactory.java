package factory.interfaces;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public interface HttpResponseFactory {

    // Geocode HTTP Response Object Factory Method Signature
    public HttpResponse<String> createGeocodeResponse(HttpRequest GEOCODE_REQUEST, HttpClient HTTP_CLIENT);

    // Current Forecast HTTP Response Object Factory Method Signature
    public HttpResponse<String> createCurrentResponse(HttpRequest CURRENT_REQUEST, HttpClient HTTP_CLIENT);

    // Future Forecast HTTP Response Object Factory Method Signature
    public HttpResponse<String> createFutureResponse(HttpRequest FUTURE_REQUEST, HttpClient HTTP_CLIENT);

}
