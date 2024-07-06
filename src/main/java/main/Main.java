package main;

import java.time.LocalDateTime;
import java.time.LocalTime;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

//////// HBOX //////////////////////////////////////////////////////////////////////////////////////////////////////////

        // HBox Layout Wrapper Enumerations
        Pos HBOX_ALIGNMENT = Pos.CENTER_LEFT; //
        double HBOX_NODE_SPACING = 1.0;
        double HBOX_MIN_WIDTH = 1200;
        double HBOX_MAX_WIDTH = 1200;
        double HBOX_MIN_HEIGHT = 200;
        double HBOX_MAX_HEIGHT = 200;
        Insets HBOX_PADDING = new Insets(0.0);

        // Instantiate HBox Layout Wrapper Node
        HBox hbox = new HBox();

        // Configure Spacing between Child Nodes to 1.0 Pixels
        hbox.setSpacing(HBOX_NODE_SPACING);

        // Configure Alignment Between Child Nodes to Left Center
        hbox.setAlignment(HBOX_ALIGNMENT);

        // Configure Minimum Width of HBox Layout Wrapper
        hbox.setMinWidth(HBOX_MIN_WIDTH);

        // Configure Maximum Width of HBox Layout Wrapper
        hbox.setMaxWidth(HBOX_MAX_WIDTH);

        // Configure Minimum Height of HBox Layout Wrapper
        hbox.setMinHeight(HBOX_MIN_HEIGHT);

        // Configure Maximum Height of HBox Layout Wrapper
        hbox.setMaxHeight(HBOX_MAX_HEIGHT);

        // Configure Padding of HBox Layout Wrapper
        hbox.setPadding(HBOX_PADDING);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


//////// BorderPane ////////////////////////////////////////////////////////////////////////////////////////////////////

        // BorderPane Layout Wrapper Enumerations
        double BORDER_PANE_MIN_WIDTH = 120;
        double BORDER_PANE_MAX_WIDTH = 120;
        double BORDER_PANE_PREF_WIDTH = 120;
        double BORDER_PANE_MIN_HEIGHT = 200;
        double BORDER_PANE_MAX_HEIGHT = 200;
        double BORDER_PANE_PREF_HEIGHT = 200;
        Insets BORDER_PANE_INSETS = new Insets(0.0);

        // Instantiate BorderPane Layout Wrapper Node
        BorderPane borderPane = new BorderPane();

        // Configure Minimum Width of Border Pane Layout Wrapper
        borderPane.setMinWidth(BORDER_PANE_MIN_WIDTH);

        // Configure Maximum Width of BorderPane Layout Wrapper
        borderPane.setMaxWidth(BORDER_PANE_MAX_WIDTH);

        // Configure Preferred Width of BorderPane Layout Wrapper
        borderPane.setPrefWidth(BORDER_PANE_PREF_WIDTH);

        // Configure Minimum Height of BorderPane Layout Wrapper
        borderPane.setMinHeight(BORDER_PANE_MIN_HEIGHT);

        // Configure Maximum Height of BorderPane Layout Wrapper
        borderPane.setMaxHeight(BORDER_PANE_MAX_HEIGHT);

        // Configure Preferred Height of BorderPane Layout Wrapper
        borderPane.setPrefHeight(BORDER_PANE_PREF_HEIGHT);

        // Configure Minimum Height of BorderPane Layout Wrapper
        borderPane.setMinHeight(BORDER_PANE_MIN_HEIGHT);

        // Configure Maximum Height of BorderPane Layout Wrapper
        borderPane.setMaxHeight(BORDER_PANE_MAX_HEIGHT);

        // Configure Padding Height & Width of BorderPane Wrapper
        borderPane.setPadding(BORDER_PANE_INSETS);

        // Configure Background Color of BorderPane Layout Wrappers
        int red = 50;
        int green = 50;
        int blue = 50;
        Color rgb = Color.rgb(red, green, blue);
        BackgroundFill backgroundFill = new BackgroundFill(rgb, null, null);
        Background background = new Background(backgroundFill);
        borderPane.setBackground(background);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



//////// Image & ImageView /////////////////////////////////////////////////////////////////////////////////////////////

        // Configure Image Size & Position
        double IMAGE_WIDTH = 75.0;
        double IMAGE_HEIGHT = 75.0;
        boolean IMAGE_ORIGINAL_RATIO = false;
        boolean IMAGE_SMOOTHING_ALGORITHM = true;

        // Instantiate Image Node w/ URL Loading
        Image image = new Image(getClass().getResourceAsStream("/hurricane_weather_tornado_storm.png"),
                IMAGE_WIDTH, IMAGE_HEIGHT, IMAGE_ORIGINAL_RATIO, IMAGE_SMOOTHING_ALGORITHM);

        // Check for Image Loading Failure
        if(image.isError()) {
            throw new IllegalArgumentException("Image URL Loading Failure: Incorrect URL");
        }

        // Instantiate ImageView Node
        ImageView imageView = new ImageView(image);

        // Wrap the ImageView in a Pane
        Pane imagePane = new Pane(imageView);
        imagePane.setMinWidth(120); // assuming the width of the top region
        imagePane.setMinHeight(100); // assuming the height of the top region

        // Center the ImageView within the Pane
        imageView.setLayoutX((imagePane.getMinWidth() - IMAGE_WIDTH) / 2);
        imageView.setLayoutY((imagePane.getMinHeight() - IMAGE_HEIGHT) / 2);

        // Configure ImageView Width & Height
        imageView.setFitWidth(IMAGE_WIDTH);
        imageView.setFitHeight(IMAGE_HEIGHT);

        // Add the ImageView to the Border Pane
        borderPane.setTop(imagePane);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




//////// Label /////////////////////////////////////////////////////////////////////////////////////////////////////////

        // Instantiate LocalTime Node
        LocalTime currentTime = LocalTime.now();

        // Instantiate LocalDateTime Node
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Convert LocalTime & LocalDateTime to Strings
        String time = new String(String.valueOf(currentTime.getHour()));
        String dateTime = new String(String.valueOf(currentDateTime.getDayOfMonth()));

        System.out.println("Time: " + time);
        System.out.println("Date: " + dateTime);

        // Label Font Configurations
        Font TIME_FONT = Font.font("Arial", 15.0);
        Font DATE_FONT = Font.font("Arial", 15.0);
        Color DATE_TIME_FONT_COLOR = Color.WHITE;

        // Instantiate Time Label Node
        Label timeLabel = new Label(time);

        // Instantiate Date Label Node
        Label dateLabel = new Label(dateTime);

        // Configure Time & Date Label Font Style
        timeLabel.setFont(TIME_FONT);
        dateLabel.setFont(DATE_FONT);

        // Configure Time & Date Label Font Color
        timeLabel.setTextFill(DATE_TIME_FONT_COLOR);
        dateLabel.setTextFill(DATE_TIME_FONT_COLOR);

        // Configure Time & Date Label Alignment
        timeLabel.setAlignment(Pos.CENTER);
        dateLabel.setAlignment(Pos.CENTER);

        // VBox Configuration Variables
        Pos VBOX_ALIGNMENT = Pos.CENTER;
        double VBOX_NODE_SPACING = 10.0;
        double VBOX_PREF_WIDTH = 120.0;
        double VBOX_MIN_WIDTH = 120.0;
        double VBOX_MAX_WIDTH = 120.0;
        double VBOX_PREF_HEIGHT = 100.0;
        double VBOX_MIN_HEIGHT = 100.0;
        double VBOX_MAX_HEIGHT = 100.0;
        double INSETS_TOP_BOTTOM = 45.0;
        double INSETS_LEFT_RIGHT = 35.0;
        Insets VBOX_PADDING = new Insets(INSETS_TOP_BOTTOM, INSETS_LEFT_RIGHT, INSETS_TOP_BOTTOM, INSETS_LEFT_RIGHT);

        // Instantiate VBox Layout Wrapper
        VBox vbox = new VBox();

        // Configure VBox Layout Wrapper Height
        vbox.setPrefHeight(VBOX_PREF_HEIGHT);
        vbox.setMinHeight(VBOX_MIN_HEIGHT);
        vbox.setMaxHeight(VBOX_MAX_HEIGHT);

        // Configure VBox Layout Wrapper Width
        vbox.setPrefWidth(VBOX_PREF_WIDTH);
        vbox.setMinWidth(VBOX_MIN_WIDTH);
        vbox.setMaxWidth(VBOX_MAX_WIDTH);

        // Configure VBox Spacing
        vbox.setSpacing(VBOX_NODE_SPACING);

        // Configure VBox Alignment
        vbox.setAlignment(VBOX_ALIGNMENT);

        // Configure VBox Padding
        vbox.setPadding(VBOX_PADDING);

        // Add Time Label to VBox
        vbox.getChildren().addAll(timeLabel, dateLabel);

        // Add VBox Layout Wrapper within BorderPane Layout Wrapper
        borderPane.setCenter(vbox);



////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Add BorderPane Layout Nodes within HBox Layout Wrapper
        hbox.getChildren().add(borderPane);

//////// Current Weather Icon //////////////////////////////////////////////////////////////////////////////////////////

        // Current Weather Icon Properties
        int CURRENT_WEATHER_ICON_RED = 44;
        int CURRENT_WEATHER_ICON_GREEN = 103;
        int CURRENT_WEATHER_ICON_BLUE = 108;
        double CURRENT_WEATHER_ICON_WIDTH = 230.0;
        double CURRENT_WEATHER_IMAGE_PANE_WIDTH = 230.0;
        double CURRENT_WEATHER_ICON_HEIGHT = 200.0;
        double CURRENT_WEATHER_IMAGE_PANE_HEIGHT = 200.0;
        boolean CURRENT_WEATHER_ICON_ORIGINAL_RATIO = false;
        boolean CURRENT_WEATHER_IMAGE_SMOOTHING_ALGORITHM = true;
        String current_weather_icon_path ="/1530377_moon_night_weather_foggy_fog.png";

        // Instantiate Current Weather Icon Image Node
        Image current_weather_image = new Image(getClass().getResourceAsStream(current_weather_icon_path),
                CURRENT_WEATHER_ICON_WIDTH,
                CURRENT_WEATHER_ICON_HEIGHT,
                CURRENT_WEATHER_ICON_ORIGINAL_RATIO,
                CURRENT_WEATHER_IMAGE_SMOOTHING_ALGORITHM);

        // Check for Current Weather Image Loading Failure
        if(current_weather_image.isError()) {
            throw new IllegalArgumentException("Current Weather Image URL Loading Failure: Incorrect URL");
        }

        // Instantiate ImageView Node
        ImageView currentWeatherImageView = new ImageView(current_weather_image);

        // Wrap the ImageView in a Pane
        Pane currentWeatherImagePane = new Pane(currentWeatherImageView);

        // Configure ImageView Width & Height
        currentWeatherImageView.setFitWidth(CURRENT_WEATHER_ICON_WIDTH);
        currentWeatherImageView.setFitHeight(CURRENT_WEATHER_ICON_HEIGHT);

        // Configure Width of Current Weather Image Pane
        currentWeatherImagePane.setMinWidth(CURRENT_WEATHER_IMAGE_PANE_WIDTH);
        currentWeatherImagePane.setMaxWidth(CURRENT_WEATHER_IMAGE_PANE_WIDTH);
        currentWeatherImagePane.setPrefWidth(CURRENT_WEATHER_IMAGE_PANE_WIDTH);

        // Configure Height of Current Weather Image Pane
        currentWeatherImagePane.setMinHeight(CURRENT_WEATHER_IMAGE_PANE_HEIGHT);
        currentWeatherImagePane.setMaxHeight(CURRENT_WEATHER_IMAGE_PANE_WIDTH);
        currentWeatherImagePane.setPrefHeight(CURRENT_WEATHER_IMAGE_PANE_HEIGHT);

        // Configure Padding of Current Weather Image Pane
        currentWeatherImagePane.setPadding(Insets.EMPTY);

        // Center the ImageView within the Pane
        currentWeatherImagePane.setLayoutX((currentWeatherImagePane.getMinWidth() - currentWeatherImageView.getFitWidth()) / 2.0);
        currentWeatherImagePane.setLayoutY((currentWeatherImagePane.getMinHeight() - currentWeatherImageView.getFitHeight()) / 2.0);

        // Instantiate RGB Color for Current Weather Image Pane Background
        Color currentWeatherRGB = Color.rgb(CURRENT_WEATHER_ICON_RED, CURRENT_WEATHER_ICON_GREEN, CURRENT_WEATHER_ICON_BLUE);

        // Configure Background of ImageView
        BackgroundFill currentWeatherBackgroundFill = new BackgroundFill(currentWeatherRGB, null, null);
        Background currentWeatherBackground = new Background(currentWeatherBackgroundFill);
        currentWeatherImagePane.setBackground(currentWeatherBackground);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



//////// Current Weather Temperature & Status Label ////////////////////////////////////////////////////////////////////

        // Current Weather Temperature VBox Layout Properties
        double TEMP_VBOX_WIDTH = 485.0;
        double TEMP_VBOX_HEIGHT = 200.0;

        // Current Weather Label Properties
        // double CURRENT_WEATHER_TEMPERATURE_LABEL_WIDTH  = 970.0;
        int CURRENT_RED = 44;
        int CURRENT_GREEN = 44;
        int CURRENT_BLUE = 44;
        double TEMP_LABEL_WIDTH = 485.0;
        double TEMP_LABEL_HEIGHT = 100.0;
        Font TEMP_LABEL_FONT = Font.font("Arial", 15.0);
        Font TEMP_STATUS_FONT = Font.font("Arial", 15.0);
        Color TEMP_FONT_COLOR = Color.WHITE;
        Color TEMP_STATUS_FONT_COLOR = Color.WHITE;
        String TEMP_STR = "113 °F";
        String TEMP_STATUS_STR = "scorching hot";

        // Instantiate RGB Color for Current Weather Image Pane Background
        Color currentTempRGB = Color.rgb(CURRENT_RED, CURRENT_GREEN, CURRENT_BLUE);

        // Configure Background of ImageView
        BackgroundFill tempBackgroundFill = new BackgroundFill(currentTempRGB, null, null);
        Background tempBackground = new Background(tempBackgroundFill);

        // Instantiate VBox Layout Wrapper
        VBox tempVBox = new VBox();
        tempVBox.setPrefSize(TEMP_VBOX_WIDTH, TEMP_VBOX_HEIGHT);
        tempVBox.setBackground(tempBackground);
        tempVBox.setAlignment(Pos.CENTER);

        // Instantiate Temperature Label Node
        Label tempLabel = new Label(TEMP_STR);

        // Configure Temperature Label Node Style
        tempLabel.setFont(TEMP_LABEL_FONT);
        tempLabel.setTextFill(TEMP_FONT_COLOR);
        tempLabel.setAlignment(Pos.TOP_LEFT);

        // Configure Temperature Label Width
        tempLabel.setPrefWidth(TEMP_LABEL_HEIGHT);
        tempLabel.setMinWidth(TEMP_LABEL_WIDTH);
        tempLabel.setMaxWidth(TEMP_LABEL_WIDTH);

        // Configure Temperature Label Height
        tempLabel.setPrefHeight(TEMP_LABEL_WIDTH);
        tempLabel.setMinHeight(TEMP_LABEL_HEIGHT);
        tempLabel.setMaxHeight(TEMP_LABEL_HEIGHT);

        // Instantiate Current Weather Status Label Node
        Label tempStatusLabel = new Label(TEMP_STATUS_STR);

        // Configure Temperature Status Label
        tempStatusLabel.setFont(TEMP_STATUS_FONT);
        tempStatusLabel.setTextFill(TEMP_STATUS_FONT_COLOR);
        tempStatusLabel.setAlignment(Pos.TOP_LEFT);

        // Configure Temperature Status Width
        tempStatusLabel.setPrefWidth(TEMP_LABEL_HEIGHT);
        tempStatusLabel.setMinWidth(TEMP_LABEL_WIDTH);
        tempStatusLabel.setMaxWidth(TEMP_LABEL_WIDTH);

        // Configure Temperature Status Height
        tempStatusLabel.setPrefHeight(TEMP_LABEL_WIDTH);
        tempStatusLabel.setMinHeight(TEMP_LABEL_HEIGHT);
        tempStatusLabel.setMaxHeight(TEMP_LABEL_HEIGHT);

        // Add Temp & Status Label Nodes in Temp VBox
        tempVBox.getChildren().addAll(tempStatusLabel, tempLabel);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



//////// Sunrise & Sunset Label ////////////////////////////////////////////////////////////////////////////////////////

        //////// Sunrise & Sunset VBox /////////////////////////////////////////////////////////////////////////////////

        // Sunrise & Sunset VBox Layout Properties
        int SUN_VBOX_RED = 44;
        int SUN_VBOX_GREEN = 44;
        int SUN_VBOX_BLUE =  44;
        double SUN_VBOX_WIDTH = 485.0;
        double SUN_VBOX_HEIGHT = 200.0;
        Pos SUN_VBOX_POS = Pos.CENTER;

        // Instantiate Sunrise & Sunset VBox Layout Wrapper
        VBox sunVBox = new VBox();

        // Configure Sunrise & Sunset VBox Width
        sunVBox.setMinWidth(SUN_VBOX_WIDTH);
        sunVBox.setMaxWidth(SUN_VBOX_WIDTH);
        sunVBox.setPrefWidth(SUN_VBOX_WIDTH);

        // Configure Sunrise & Sunset VBox Height
        sunVBox.setMinHeight(SUN_VBOX_HEIGHT);
        sunVBox.setMaxHeight(SUN_VBOX_HEIGHT);
        sunVBox.setPrefHeight(SUN_VBOX_HEIGHT);

        // Configure Sunrise & Sunset VBox Alignment
        sunVBox.setAlignment(SUN_VBOX_POS);

        // Configure Sunrise & Sunset VBox Background
        Color sunRGB = Color.rgb(SUN_VBOX_RED, SUN_VBOX_GREEN, SUN_VBOX_BLUE);
        BackgroundFill sunBackgroundFill = new BackgroundFill(sunRGB, null, null);
        Background sunBackground = new Background(sunBackgroundFill);
        sunVBox.setBackground(sunBackground);

        //////// Sunrise & Sunset HBox /////////////////////////////////////////////////////////////////////////////////

        // Sunrise & Sunset HBox Layout Properties
        int SUN_HBOX_RED = 44;
        int SUN_HBOX_GREEN = 44;
        int SUN_HBOX_BLUE =  44;
        double SUN_HBOX_WIDTH = 485.0;
        double SUN_HBOX_HEIGHT = 50.0;
        Pos SUN_HBOX_POS = Pos.CENTER;

        // Instantiate Sunrise & Sunset HBox Layout Wrapper
        HBox sunHBox = new HBox();

        // Configure Sunrise & Sunrise HBox Width
        sunHBox.setMinWidth(SUN_HBOX_WIDTH);
        sunHBox.setMaxWidth(SUN_HBOX_WIDTH);
        sunHBox.setPrefWidth(SUN_HBOX_WIDTH);

        // Configure Sunrise & Sunset HBox Height
        sunHBox.setMinHeight(SUN_HBOX_HEIGHT);
        sunHBox.setMaxHeight(SUN_HBOX_HEIGHT);
        sunHBox.setPrefHeight(SUN_HBOX_HEIGHT);

        // Configure Sunrise & Sunset HBox Alignment
        sunHBox.setAlignment(SUN_HBOX_POS);

        // Configure Sunrise & Sunset HBox Background
        Color sunriseRGB = Color.rgb(SUN_HBOX_RED, SUN_HBOX_GREEN, SUN_HBOX_BLUE);
        BackgroundFill sunHBoxBackgroundFill = new BackgroundFill(sunriseRGB, null, null);
        Background sunHBoxBackground = new Background(sunHBoxBackgroundFill);
        sunHBox.setBackground(sunHBoxBackground);

        //////// Sunrise & Sunset Icon /////////////////////////////////////////////////////////////////////////////////

        // 


        //////// Sunrise & Sunset Label ////////////////////////////////////////////////////////////////////////////////

        // Sunrise & Sunset Label Properties
        double RISE_LABEL_WIDTH = 485.0;
        double RISE_LABEL_HEIGHT = 100.0;
        double SET_LABEL_WIDTH = 485.0;
        double SET_LABEL_HEIGHT = 100.0;

        Font RISE_FONT = Font.font("Arial", 15.0);
        Color RISE_FONT_COLOR = Color.WHITE;

        Font SET_FONT = Font.font("Arial", 15.0);
        Color SET_FONT_COLOR = Color.WHITE;

        Pos RISE_POS = Pos.CENTER_LEFT;
        Pos SET_POS = Pos.CENTER_LEFT;

        String RISE_STR = "6:12 AM";
        String SET_STR = "8:34 PM";

        // Instantiate Sunrise Label Node
        Label riseLabel = new Label(RISE_STR);

        // Configure Sunrise Label Node
        riseLabel.setFont(RISE_FONT);
        riseLabel.setTextFill(RISE_FONT_COLOR);
        riseLabel.setAlignment(RISE_POS);

        // Configure Sunrise Label Width
        riseLabel.setPrefWidth(RISE_LABEL_WIDTH);
        riseLabel.setMinWidth(RISE_LABEL_WIDTH);
        riseLabel.setMaxWidth(RISE_LABEL_WIDTH);

        // Configure Sunrise Label Height
        riseLabel.setPrefHeight(RISE_LABEL_HEIGHT);
        riseLabel.setMinHeight(RISE_LABEL_HEIGHT);
        riseLabel.setMaxHeight(RISE_LABEL_HEIGHT);

        // Instantiate Set Label Node
        Label setLabel = new Label(SET_STR);

        // Configure Set Label Node
        setLabel.setFont(SET_FONT);
        setLabel.setTextFill(SET_FONT_COLOR);
        setLabel.setAlignment(SET_POS);

        // Configure Sunset Label Width
        setLabel.setPrefWidth(SET_LABEL_WIDTH);
        setLabel.setMinWidth(SET_LABEL_WIDTH);
        setLabel.setMaxWidth(SET_LABEL_WIDTH);

        // Configure Sunset Label Height
        setLabel.setPrefHeight(SET_LABEL_HEIGHT);
        setLabel.setMinHeight(SET_LABEL_HEIGHT);
        setLabel.setMaxHeight(SET_LABEL_HEIGHT);










////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        Scene scene = new Scene(tempVBox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
