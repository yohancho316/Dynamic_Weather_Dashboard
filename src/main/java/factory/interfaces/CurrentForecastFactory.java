package factory.interfaces;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
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
    int SUN_VBOX_RED = 44;
    int SUN_VBOX_GREEN = 44;
    int SUN_VBOX_BLUE =  44;
    int SUN_HBOX_RED = 44;
    int SUN_HBOX_GREEN = 44;
    int SUN_HBOX_BLUE = 44;
    double CURRENT_WEATHER_ICON_WIDTH = 230.0;
    double CURRENT_WEATHER_IMAGE_PANE_WIDTH = 230.0;
    double CURRENT_WEATHER_ICON_HEIGHT = 200.0;
    double CURRENT_WEATHER_IMAGE_PANE_HEIGHT = 200.0;
    double TEMP_VBOX_WIDTH = 485.0;
    double TEMP_VBOX_HEIGHT = 200.0;
    double TEMP_LABEL_WIDTH = 485.0;
    double TEMP_LABEL_HEIGHT = 100.0;
    double STATUS_LABEL_WIDTH = 485.0;
    double STATUS_LABEL_HEIGHT = 100.0;
    double SUN_VBOX_WIDTH = 485.0;
    double SUN_VBOX_HEIGHT = 200.0;
    double SUN_HBOX_WIDTH  = 485.0;
    double SUN_HBOX_HEIGHT = 50.0;
    double SUN_HBOX_PADDING_TOP = 0.0;
    double SUN_HBOX_PADDING_RIGHT = 0.0;
    double SUN_HBOX_PADDING_BOTTOM = 0.0;
    double SUN_HBOX_PADDING_LEFT = 50.0;
    double SUN_HBOX_SPACING = 10.0;
    boolean CURRENT_WEATHER_ICON_ORIGINAL_RATIO = false;
    boolean CURRENT_WEATHER_IMAGE_SMOOTHING_ALGORITHM = true;
    String TEMP_NOTATION = " °F";
    Font TEMP_FONT = Font.font("Arial", 15.0);
    Font STATUS_FONT = Font.font("Arial", 15.0);
    Color TEMP_FONT_COLOR = Color.WHITE;
    Color STATUS_FONT_COLOR = Color.WHITE;
    Pos TEMP_ALIGNMENT = Pos.TOP_LEFT;
    Pos STATUS_ALIGNMENT = Pos.TOP_LEFT;
    Pos SUN_VBOX_ALIGNMENT = Pos.CENTER;
    Pos SUN_HBOX_POS = Pos.CENTER;

    // Weather Temperature Label Object Factory Method Signature
    Label createTempLabel(String temperature_str);

    // Weather Status Label Object Factory Method Signature
    Label createStatusLabel(String status_str);

    // Pane Layout Wrapper Object Factory Method Signature
    Pane createCurrentImagePane(String current_image_path);

    // Sunset HBox Object Factory Method Signature
    HBox createSunsetHBox(StackPane sunsetPane, Label sunsetLabel);

    // Weather Temperature & Status VBox Object Factory Method Signature
    VBox createCurrentWeatherVBox(Label temperatureLabel, Label statusLabel);

    // Sunrise & Sunset VBox Object Factory Method Signature
    VBox createSunVBox(HBox sunHbox);

}
