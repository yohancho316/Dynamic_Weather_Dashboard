package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

// Represents the response from the OpenWeatherMap geocoding API.
 // This class is used to deserialize JSON data into a Java object.
public class GeocodingResponse {

     @JsonProperty("name")
     private String city;

     @JsonProperty("country")
     private String country;

     @JsonProperty("state")
     private String state;

     @JsonProperty("lat")
     private double latitude;

     @JsonProperty("lon")
     private double longitude;

     @JsonProperty("local_names")
     private Map<String, String> localNames;  // Map to store local names in different languages

     // City Name Getter Method
     public String getCity() {
         return this.city;
     }

     // City Name Setter Method
     public void setCity(String city) {
         if(city == null) throw new NullPointerException("City cannot be null");
         else if(city.isEmpty()) throw new IllegalArgumentException("City cannot be empty");
         this.city = city;
     }

     // Country Getter Method
     public String getCountry() {
         return this.country;
     }

     // Country Setter Method
     public void setCountry(String country) {
         if(country == null) throw new NullPointerException("Country cannot be null");
         else if(country.isEmpty()) throw new IllegalArgumentException("Country cannot be empty");
         this.country = country;
     }

     // State Getter Method
     public String getState() {
         return this.state;
     }

     // State Setter Method
     public void setState(String state) {
         if(state == null) throw new NullPointerException("State cannot be null");
         else if(state.isEmpty()) throw new IllegalArgumentException("State cannot be empty");
         this.state = state;
     }

     // Latitude Getter Method
     public double getLatitude() {
         return this.latitude;
     }

     // Latitude Setter Method
     public void setLatitude(double latitude) {
        if(latitude > 90.0 || latitude < -90) throw new IllegalArgumentException("Latitude must be within bounds of [-90,90]");
         this.latitude = latitude;
     }

     // Longitude Getter Method
     public double getLongitude() {
         return this.longitude;
     }

     // Latitude Setter Method
     public void setLongitude(double longitude) {
         if(longitude > 180.0 || longitude < -180) throw new IllegalArgumentException("Longitude must be within bounds of [-180,180]");
         this.longitude = longitude;
     }

     // City Names Getter Method
     public Map<String, String> getLocalNames() {
         return localNames;
     }

     // City Names Setter Method
     public void setLocalNames(Map<String, String> localNames) {
         this.localNames = localNames;
     }

}
