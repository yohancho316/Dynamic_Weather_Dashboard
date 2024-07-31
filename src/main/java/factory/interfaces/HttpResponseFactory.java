package factory.interfaces;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public interface HttpResponseFactory {

    // Geocode HTTP Response Object Factory Method Signature
    public HttpResponse<Object> createGeocodeResponse(HttpRequest GEOCODE_REQUEST);

    // Current Forecast HTTP Response Object Factory Method Signature
    public HttpResponse<Object> createCurrentResponse(HttpRequest CURRENT_REQUEST);

    // Future Forecast HTTP Response Object Factory Method Signature
    public HttpResponse<Object> createFutureResponse(HttpRequest FUTURE_REQUEST);

}
