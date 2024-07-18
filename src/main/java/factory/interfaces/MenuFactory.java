package factory.interfaces;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public interface MenuFactory {

    // Configuration Properties (Properties are Implicitly Public, Static and Final)
    int CITY_LABEL_RED = 255;
    int CITY_LABEL_GREEN = 255;
    int CITY_LABEL_BLUE = 255;
    int MAGNIFY_RED = 2;
    int MAGNIFY_GREEN = 100;
    int MAGNIFY_BLUE = 230;
    int TEXT_FIELD_RED = 255;
    int TEXT_FIELD_GREEN = 255;
    int TEXT_FIELD_BLUE = 255;
    int SEARCH_RED = 255;
    int SEARCH_GREEN = 255;
    int SEARCH_BLUE = 255;
    int MENU_RED = 66;
    int MENU_GREEN = 114;
    int MENU_BLUE = 119;
    double CITY_LABEL_WIDTH = 320.0;
    double CITY_LABEL_HEIGHT = 40.0;
    double MAGNIFY_ICON_WIDTH = 40.0;
    double MAGNIFY_ICON_HEIGHT = 40.0;
    double TEXT_FIELD_WIDTH = 280.0;
    double TEXT_FIELD_HEIGHT = 40.0;
    double SEARCH_WIDTH = 320.0;
    double SEARCH_HEIGHT = 40.0;
    double SEARCH_SPACING = 55.0;
    double MENU_ICON_WIDTH = 30;
    double MENU_ICON_HEIGHT = 30;
    double MENU_WIDTH = 1200.0;
    double MENU_HEIGHT = 100.0;
    double MENU_SPACING = 10.0;
    boolean MAGNIFY_ICON_RATIO = true;
    boolean MAGNIFY_ICON_SMOOTHING = true;
    boolean TEXT_FIELD_EDITABLE = true;
    boolean MENU_ICON_RATIO = false;
    boolean MENU_ICON_SMOOTHING = true;
    String menu_image_path = "/icons8-menu-192.png";
    String MAGNIFY_ICON_PATH = "/icons8-search-480.png";
    String TEXT_FIELD_PROMPT = "Type City Name";
    Pos MAGNIFY_ICON_ALIGNMENT_POSITION = Pos.CENTER;
    Pos CITY_LABEL_ALIGNMENT_POSITION = Pos.CENTER_LEFT;
    Pos TEXT_FIELD_ALIGNMENT = Pos.CENTER;
    Pos SEARCH_ALIGNMENT_POSITION = Pos.CENTER;
    Pos MENU_ICON_ALIGNMENT_POSITION = Pos.CENTER;
    Pos MENU_ALIGNMENT_POSITION = Pos.CENTER_LEFT;
    Insets CITY_LABEL_PADDING = new Insets(0.0, 0.0, 0.0, 10.0);
    Insets MAGNIFY_ICON_PADDING = new Insets(0.0);
    Insets TEXT_FIELD_PADDING = new Insets(0.0);
    Insets SEARCH_PADDING = new Insets(0.0);
    Insets MENU_ICON_PADDING = new Insets(0.0);
    Insets MENU_PADDING = new Insets(0.0, 0.0, 0.0, 25.0);
    // Instantiate RGB Color for Menu HBox Background
    Color menuRGB = Color.rgb(MENU_RED, MENU_GREEN, MENU_BLUE);
    Color searchRGB = Color.rgb(SEARCH_RED, SEARCH_GREEN, SEARCH_BLUE);
    Color textFieldRGB = Color.rgb(TEXT_FIELD_RED, TEXT_FIELD_GREEN, TEXT_FIELD_BLUE);
    Color magnifyRGB = Color.rgb(MAGNIFY_RED, MAGNIFY_GREEN, MAGNIFY_BLUE);
    Color cityFieldRGB = Color.rgb(CITY_LABEL_RED, CITY_LABEL_GREEN, CITY_LABEL_BLUE);

    // Menu HBox Object Factory Method Signature
    HBox createMenuHBox(StackPane menuStackPane, ComboBox<Object> comboBox);

    // City Search HBox Object Factory Method Signature
    HBox createSearchHBox(TextField textField, StackPane magnifyStackPane);

    // Menu Icon Stack Pane Object Factory Method Signature
    StackPane createMenuStackPane();

    // Search Text Field Object Factory Method Signature
    TextField createSearchTextField();

    // Magnify Icon Stack Pane Object Factory Method Signature
    StackPane createMagnifyStackPane();

    // City Search Label Object Factory Method Signature
    Label createCityLabel(String city);

}
