package factory.interfaces;

import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public interface ForecastFactory {

    // Configuration Properties (Properties are Implicitly Public, Static and Final)
    int red = 50;
    int green = 50;
    int blue = 50;

    double HBOX_NODE_SPACING = 1.0;
    double HBOX_MIN_WIDTH = 1200.0;
    double HBOX_MAX_WIDTH = 1200.0;
    double HBOX_MIN_HEIGHT = 200.0;
    double HBOX_MAX_HEIGHT = 200.0;

    double BORDER_PANE_MIN_WIDTH = 120.0;
    double BORDER_PANE_MAX_WIDTH = 120.0;
    double BORDER_PANE_PREF_WIDTH = 120.0;
    double BORDER_PANE_MIN_HEIGHT = 200.0;
    double BORDER_PANE_MAX_HEIGHT = 200.0;
    double BORDER_PANE_PREF_HEIGHT = 200.0;

    double IMAGE_PANE_WIDTH = 120.0;
    double IMAGE_PANE_HEIGHT = 100.0;

    double VBOX_NODE_SPACING = 10.0;
    double VBOX_PREF_WIDTH = 120.0;
    double VBOX_MIN_WIDTH = 120.0;
    double VBOX_MAX_WIDTH = 120.0;
    double VBOX_PREF_HEIGHT = 100.0;
    double VBOX_MIN_HEIGHT = 100.0;
    double VBOX_MAX_HEIGHT = 100.0;
    double INSETS_TOP_BOTTOM = 45.0;
    double INSETS_LEFT_RIGHT = 35.0;

    Insets HBOX_PADDING = new Insets(0.0);
    Insets BORDER_PANE_INSETS = new Insets(0.0);
    Insets VBOX_PADDING = new Insets(INSETS_TOP_BOTTOM, INSETS_LEFT_RIGHT, INSETS_TOP_BOTTOM, INSETS_LEFT_RIGHT);


    Pos HBOX_ALIGNMENT = Pos.CENTER_LEFT;
    Pos VBOX_ALIGNMENT = Pos.CENTER;
    Pos TIME_LABEL_ALIGNMENT = Pos.CENTER;
    Pos DATE_LABEL_ALIGNMENT = Pos.CENTER;

    // Forecast Icon Properties
    double IMAGE_WIDTH = 75.0;
    double IMAGE_HEIGHT = 75.0;
    boolean IMAGE_ORIGINAL_RATIO = false;
    boolean IMAGE_SMOOTHING_ALGORITHM = true;

    Font TIME_FONT = Font.font("Arial", 15.0);
    Font DATE_FONT = Font.font("Arial", 15.0);

    Color DATE_TIME_FONT_COLOR = Color.WHITE;
    Color rgb = Color.rgb(red, green, blue);

    // HBox Layout Wrapper Object Factory Method
    HBox createHBox(List<BorderPane> borderPaneList);

    // Border Pane Object Factory Method
    BorderPane createBorderPane(Pane imagePane, VBox vbox);

    // Image Pane Object Factory Method
    Pane createImagePane(String weather_icon_url);

    // Time Label Object Factory Method
    Label createTimeLabel(LocalTime currentTime);

    // Date Label Object Factory Method
    Label createDateLabel(LocalDateTime currentDate);

    // VBox Layout Wrapper Object Factory Method
    VBox createVBoxLayout(Label timeLabel, Label dateLabel);

}
