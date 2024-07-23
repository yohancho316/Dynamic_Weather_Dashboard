module cupofcode.dynamic_weather_dashboard {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.annotation;

    opens main to javafx.fxml;
    opens model to com.fasterxml.jackson.databind;

    exports main;
}
