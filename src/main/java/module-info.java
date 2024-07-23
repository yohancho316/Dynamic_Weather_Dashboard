module cupofcode.dynamic_weather_dashboard {
        requires javafx.controls;
        requires javafx.fxml;
    requires java.net.http;

    opens main to javafx.fxml;
        exports main;
}
