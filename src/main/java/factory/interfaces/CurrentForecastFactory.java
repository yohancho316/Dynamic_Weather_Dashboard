package factory.interfaces;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public interface CurrentForecastFactory {

    // Configuration Properties (Properties are Implicitly Public, Static and Final)
    int CURRENT_WEATHER_ICON_RED = 44;
    int CURRENT_WEATHER_ICON_GREEN = 103;
    int CURRENT_WEATHER_ICON_BLUE = 108;
    int TEMP_VBOX_RED = 44;
    int TEMP_VBOX_GREEN = 44;
    int TEMP_VBOX_BLUE = 44;
    double CURRENT_WEATHER_ICON_WIDTH = 230.0;
    double CURRENT_WEATHER_IMAGE_PANE_WIDTH = 230.0;
    double CURRENT_WEATHER_ICON_HEIGHT = 200.0;
    double CURRENT_WEATHER_IMAGE_PANE_HEIGHT = 200.0;
    double TEMP_VBOX_WIDTH = 485.0;
    double TEMP_VBOX_HEIGHT = 200.0;
    double TEMP_LABEL_WIDTH = 485.0;
    double TEMP_LABEL_HEIGHT = 100.0;
    boolean CURRENT_WEATHER_ICON_ORIGINAL_RATIO = false;
    boolean CURRENT_WEATHER_IMAGE_SMOOTHING_ALGORITHM = true;
    String TEMP_NOTATION = " °F";
    Font TEMP_FONT = Font.font("Arial", 15.0);
    Font STATUS_FONT = Font.font("Arial", 15.0);
    Color TEMP_FONT_COLOR = Color.WHITE;
    Color STATUS_FONT_COLOR = Color.WHITE;
    Pos TEMP_ALIGNMENT = Pos.TOP_LEFT;


    // Pane Layout Wrapper Object Factory Method
    Pane createCurrentImagePane(String current_image_path);

    // Weather Temperature & Status VBox Object Factory Method
    VBox createCurrentWeatherVBox(Label temperatureLabel, Label statusLabel);

    // Weather Temperature Label Object Factory Method
    Label createWeatherLabel(String temperature_str);

}
