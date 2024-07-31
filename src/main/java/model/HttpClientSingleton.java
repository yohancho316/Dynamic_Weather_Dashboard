package model;

import java.net.http.HttpClient;

public class HttpClientSingleton {

    private static HttpClient httpClient;

    // Private Constructor Method
    private HttpClientSingleton() {
        // Instantiate HttpClient Node (used to send requests)
        this.httpClient = HttpClient.newHttpClient();  // Creates an instance of HttpClient for sending HTTP requests.
    }

    // Http Client Getter Method
    public static HttpClient getHttpClient() {
        if(httpClient == null) {
            synchronized (HttpClientSingleton.class) {
                if(httpClient == null) {
                    httpClient = HttpClient.newHttpClient();
                }
            }
        }
        return httpClient;
    }

}
