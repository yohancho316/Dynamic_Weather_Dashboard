package factory.interfaces;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
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
    boolean CURRENT_WEATHER_ICON_ORIGINAL_RATIO = false;
    boolean CURRENT_WEATHER_IMAGE_SMOOTHING_ALGORITHM = true;

    // Pane Layout Wrapper Object Factory Method
    Pane createCurrentImagePane(String current_image_path);

    // Weather Temperature & Status VBox Object Factory Method
    VBox createCurrentWeatherVBox(Label temperatureLabel, Label statusLabel);

}
