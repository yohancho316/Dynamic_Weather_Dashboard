package model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.http.HttpClient;

public class ObjectMapperSingleton {

    private static ObjectMapper objectMapper;

    // Object Mapper Constructor Method
    private ObjectMapperSingleton() {
        // Instantiate Jackson ObjectMapper (Primary Jackson Class Node / Used to Serialize & Deserialize)
        // Creates an ObjectMapper instance for converting JSON to Java objects and vice versa.
        this.objectMapper = new ObjectMapper();
    }

    // Object Mapper Getter Method
    public static ObjectMapper getObjectMapper() {
        if(objectMapper == null) {
            synchronized (ObjectMapperSingleton.class) {
                if(objectMapper == null) {
                    objectMapper = new ObjectMapper();
                }
            }
        }
        return objectMapper;
    }

}
