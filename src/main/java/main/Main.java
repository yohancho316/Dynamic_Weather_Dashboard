package main;

import factory.implementations.ForecastFactoryImplementation;
import factory.implementations.CurrentForecastFactoryImplementation;
import factory.implementations.WrapperFactoryImplementation;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import view.View;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        // Instantiate Current Forecast Factory Node
        CurrentForecastFactoryImplementation currentFactory = new CurrentForecastFactoryImplementation();

        // Instantiate Future Forecast Factory Node
        ForecastFactoryImplementation futureFactory = new ForecastFactoryImplementation();

        // Instantiate Wrapper Factory Node
        WrapperFactoryImplementation wrapperFactory = new WrapperFactoryImplementation();


        LocalDateTime current_date = LocalDateTime.now();
        LocalTime current_time = LocalTime.now();

        List<String> pane_image_collection = new ArrayList<String>();
        List<LocalDateTime> pane_date_collection = new ArrayList<LocalDateTime>();
        List<LocalTime> pane_time_collection = new ArrayList<LocalTime>();

        String image_path = "/hurricane_weather_tornado_storm.png";
        String main_temp = "58";
        String main_status = "overcast clouds";
        String sunrise_time = "6:12 AM";
        String sunset_time = "8:00 PM";

        for(int i = 0; i < 10; i++) {
            pane_image_collection.add(image_path);
            pane_date_collection.add(current_date);
            pane_time_collection.add(current_time);
            current_date = current_date.plusHours(2);
            current_time = current_time.plusHours(2);
        }

        ForecastFactoryImplementation future_factory = new ForecastFactoryImplementation();
        CurrentForecastFactoryImplementation current_factory = new CurrentForecastFactoryImplementation();
        WrapperFactoryImplementation wrapper_factory = new WrapperFactoryImplementation();

        View view = new View(futureFactory,
                             currentFactory,
                             wrapperFactory,
                             pane_image_collection,
                             pane_date_collection,
                             pane_time_collection,
                             image_path,
                             main_temp,
                             main_status,
                             sunrise_time,
                             sunset_time);









///////// MENU HBOX ////////////////////////////////////////////////////////////////////////////////////////////////////

        // Menu HBox Properties
        int MENU_RED = 66;
        int MENU_GREEN = 114;
        int MENU_BLUE = 119;
        double MENU_WIDTH = 1200.0;
        double MENU_HEIGHT = 100.0;
        double MENU_SPACING = 0.0;
        Pos MENU_ALIGNMENT_POSITION = Pos.CENTER_LEFT;
        Insets MENU_PADDING = new Insets(0.0);

        // Instantiate Menu HBox Wrapper
        HBox menu_hbox = new HBox();

        // Configure Menu HBox Width
        menu_hbox.setMinWidth(MENU_WIDTH);
        menu_hbox.setMaxWidth(MENU_WIDTH);
        menu_hbox.setPrefWidth(MENU_WIDTH);

        // Configure Menu HBox Height
        menu_hbox.setMinHeight(MENU_HEIGHT);
        menu_hbox.setMaxHeight(MENU_HEIGHT);
        menu_hbox.setPrefHeight(MENU_HEIGHT);

        // Configure HBox Properties
        menu_hbox.setSpacing(MENU_SPACING);
        menu_hbox.setAlignment(MENU_ALIGNMENT_POSITION);
        menu_hbox.setPadding(MENU_PADDING);

        // Instantiate RGB Color for Menu HBox Background
        Color menuRGB = Color.rgb(MENU_RED, MENU_GREEN, MENU_BLUE);

        // Configure Background of ImageView
        BackgroundFill menuBackgroundFill = new BackgroundFill(menuRGB, null, null);
        Background menuBackground = new Background(menuBackgroundFill);
        menu_hbox.setBackground(menuBackground);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


///////// MENU ICON STACK PANE  ////////////////////////////////////////////////////////////////////////////////////////

        // Menu Icon Properties
        double MENU_ICON_WIDTH = 15;
        double MENU_ICON_HEIGHT = 30;
        boolean MENU_ICON_RATIO = false;
        boolean MENU_ICON_SMOOTHING = true;
        Insets MENU_ICON_PADDING = new Insets(0.0);
        Pos MENU_ICON_ALIGNMENT_POSITION = Pos.CENTER;

        String menu_image_path = "/icons8-menu-192.png";

        // Instantiate Menu Icon Image Node
        Image menu_image = new Image(getClass().getResourceAsStream(menu_image_path),
                MENU_ICON_WIDTH,
                MENU_ICON_HEIGHT,
                MENU_ICON_RATIO,
                MENU_ICON_SMOOTHING);

        // Check for Menu Icon Loading Failure
        if(menu_image.isError()) {
            throw new IllegalArgumentException("Menu Image URL Loading Failure: Incorrect URL");
        }

        // Instantiate ImageView Node
        ImageView menuImageView = new ImageView(menu_image);

        // Configure ImageView Node
        menuImageView.setFitWidth(MENU_ICON_WIDTH);
        menuImageView.setFitHeight(MENU_ICON_HEIGHT);

        // Wrap the ImageView in a StackPane
        StackPane menuStackPane = new StackPane(menuImageView);

        // Configure Menu Stack Pane
        menuStackPane.setPrefSize(MENU_ICON_WIDTH, MENU_ICON_HEIGHT);
        menuStackPane.setPadding(MENU_ICON_PADDING);
        menuStackPane.setAlignment(MENU_ICON_ALIGNMENT_POSITION);

        // Configure Menu Icon StackPane Background
        menuStackPane.setBackground(menuBackground);


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


///////// CITY SEARCH HBOX /////////////////////////////////////////////////////////////////////////////////////////////

        // City Search HBox Properties
        int SEARCH_RED = 255;
        int SEARCH_GREEN = 255;
        int SEARCH_BLUE = 255;
        double SEARCH_WIDTH = 330;
        double SEARCH_HEIGHT = 100.0;
        double SEARCH_SPACING = 0.0;
        Pos SEARCH_ALIGNMENT_POSITION = Pos.CENTER;
        Insets SEARCH_PADDING = new Insets(0.0);

        // Instantiate Search HBox Wrapper
        HBox search_hbox = new HBox();

        // Configure Menu HBox Width
        search_hbox.setMinWidth(SEARCH_WIDTH);
        search_hbox.setMaxWidth(SEARCH_WIDTH);
        search_hbox.setPrefWidth(SEARCH_WIDTH);

        // Configure Search HBox Height
        search_hbox.setMinHeight(SEARCH_HEIGHT);
        search_hbox.setMaxHeight(SEARCH_HEIGHT);
        search_hbox.setPrefHeight(SEARCH_HEIGHT);

        // Configure Search HBox Properties
        search_hbox.setSpacing(SEARCH_SPACING);
        search_hbox.setAlignment(SEARCH_ALIGNMENT_POSITION);
        search_hbox.setPadding(SEARCH_PADDING);

        // Instantiate RGB Color for Search HBox Background
        Color searchRGB = Color.rgb(SEARCH_RED, SEARCH_GREEN, SEARCH_BLUE);

        // Configure Background of Search HBox
        BackgroundFill searchBackgroundFill = new BackgroundFill(searchRGB, null, null);
        Background searchBackground = new Background(searchBackgroundFill);
        search_hbox.setBackground(searchBackground);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


///////// SEARCH TEXT FIELD NODE  //////////////////////////////////////////////////////////////////////////////////////

        // Search Text Field Properties
        String FIELD_PROMPT = "Type City Name";
        boolean FIELD_EDITABLE = true;
        Pos FIELD_ALIGNMENT = Pos.CENTER;
        
        // Instantiate TextField Control Node
        TextField searchField = new TextField();

        // Prompt User to Enter Name of City
        searchField.setPromptText(FIELD_PROMPT);

        // Configure City Text Field Node
        searchField.setAlignment(FIELD_ALIGNMENT);
        searchField.setEditable(FIELD_EDITABLE);





///////// COMBO BOX  ///////////////////////////////////////////////////////////////////////////////////////////////////

        // Instantiate Menu ComboBox Node
        ComboBox<Object> menuComboBox = new ComboBox<Object>();

        // Configure the Menu ComboBox Prompt
        menuComboBox.setPromptText("Search for a City");




////////////////////////////////////////////////////////////////////////////////////////////////////////////////




        // Instantiate ObservableSet FX Collection
        ObservableSet<String> cities = FXCollections.observableSet();

        // Add Los Angeles to ObservableList
        cities.add("Los Angeles");

        // Instantiate ComboBox Node
        ComboBox<Object> comboBox = new ComboBox<Object>();


        Scene scene = new Scene(null);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
