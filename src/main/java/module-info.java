module cupofcode.dynamic_weather_dashboard {
        requires javafx.controls;
        requires javafx.fxml;

        opens main to javafx.fxml;
        exports main;
}
