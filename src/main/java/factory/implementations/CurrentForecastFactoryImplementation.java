package factory.implementations;

import factory.interfaces.CurrentForecastFactory;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class CurrentForecastFactoryImplementation implements CurrentForecastFactory {

    @Override
    public Pane createCurrentImagePane(String current_image_path) {

        // Check if Current Image Path is Null or Empty
        if(current_image_path.isEmpty() || current_image_path.equals(null)) throw new IllegalArgumentException("Current Image Path is null or empty");

        // Instantiate Current Weather Icon Image Node
        Image current_weather_image = new Image(getClass().getResourceAsStream(current_image_path),
                this.CURRENT_WEATHER_ICON_WIDTH,
                this.CURRENT_WEATHER_ICON_HEIGHT,
                this.CURRENT_WEATHER_ICON_ORIGINAL_RATIO,
                this.CURRENT_WEATHER_IMAGE_SMOOTHING_ALGORITHM);

        // Check for Current Weather Image Loading Failure
        if(current_weather_image.isError()) {
            throw new IllegalArgumentException("Current Weather Image URL Loading Failure: Incorrect URL");
        }

        // Instantiate ImageView Node
        ImageView currentWeatherImageView = new ImageView(current_weather_image);

        // Wrap the ImageView in a Pane
        Pane currentWeatherImagePane = new Pane(currentWeatherImageView);

        // Configure ImageView Width & Height
        currentWeatherImageView.setFitWidth(this.CURRENT_WEATHER_ICON_WIDTH);
        currentWeatherImageView.setFitHeight(this.CURRENT_WEATHER_ICON_HEIGHT);

        // Configure Width of Current Weather Image Pane
        currentWeatherImagePane.setMinWidth(this.CURRENT_WEATHER_IMAGE_PANE_WIDTH);
        currentWeatherImagePane.setMaxWidth(this.CURRENT_WEATHER_IMAGE_PANE_WIDTH);
        currentWeatherImagePane.setPrefWidth(this.CURRENT_WEATHER_IMAGE_PANE_WIDTH);

        // Configure Height of Current Weather Image Pane
        currentWeatherImagePane.setMinHeight(this.CURRENT_WEATHER_IMAGE_PANE_HEIGHT);
        currentWeatherImagePane.setMaxHeight(this.CURRENT_WEATHER_IMAGE_PANE_WIDTH);
        currentWeatherImagePane.setPrefHeight(this.CURRENT_WEATHER_IMAGE_PANE_HEIGHT);

        // Configure Padding of Current Weather Image Pane
        currentWeatherImagePane.setPadding(Insets.EMPTY);

        // Center the ImageView within the Pane
        currentWeatherImagePane.setLayoutX((currentWeatherImagePane.getMinWidth() - currentWeatherImageView.getFitWidth()) / 2.0);
        currentWeatherImagePane.setLayoutY((currentWeatherImagePane.getMinHeight() - currentWeatherImageView.getFitHeight()) / 2.0);

        // Instantiate RGB Color for Current Weather Image Pane Background
        Color currentWeatherRGB = Color.rgb(this.CURRENT_WEATHER_ICON_RED, this.CURRENT_WEATHER_ICON_GREEN, this.CURRENT_WEATHER_ICON_BLUE);

        // Configure Background of ImageView
        BackgroundFill currentWeatherBackgroundFill = new BackgroundFill(currentWeatherRGB, null, null);
        Background currentWeatherBackground = new Background(currentWeatherBackgroundFill);
        currentWeatherImagePane.setBackground(currentWeatherBackground);

        // Return the Current Weather Image Pane with the Current Weather Icon Image
        return currentWeatherImagePane;
    }

    @Override
    public HBox createSunsetHBox(StackPane sunsetPane, Label sunsetLabel) {

        // Check if Sunset Pane || Sunset Label is Null
        if(sunsetPane.equals(null) || sunsetLabel.equals(null)) throw new NullPointerException("Sunset Pane & Sunset Label cannot be null");

        // Instantiate Sunrise & Sunshine VBox Background
        Color hboxRGB = Color.rgb(this.SUN_HBOX_RED, this.SUN_HBOX_GREEN, this.SUN_HBOX_BLUE);

        // Instantiate Background & BackgroundFill Nodes
        BackgroundFill sunsetBackgroundFill = new BackgroundFill(hboxRGB, null, null);
        Background sunsetBackground = new Background(sunsetBackgroundFill);

        // Instantiate Sunset HBox Layout Wrapper
        HBox sunsetHBox = new HBox();

        // Configure Sunset HBox Width
        sunsetHBox.setMinWidth(this.SUN_HBOX_WIDTH);
        sunsetHBox.setMaxWidth(this.SUN_HBOX_WIDTH);
        sunsetHBox.setPrefWidth(this.SUN_HBOX_WIDTH);

        // Configure Sunset HBox Height
        sunsetHBox.setMinHeight(this.SUN_HBOX_HEIGHT);
        sunsetHBox.setMaxHeight(this.SUN_HBOX_HEIGHT);
        sunsetHBox.setPrefHeight(this.SUN_HBOX_HEIGHT);

        // Configure Sunset HBox Alignment
        sunsetHBox.setAlignment(this.SUN_HBOX_POS);

        // Configure Sunset HBox Padding & Spacing
        sunsetHBox.setPadding(new Insets(
                this.SUN_HBOX_PADDING_TOP,
                this.SUN_HBOX_PADDING_RIGHT,
                this.SUN_HBOX_PADDING_BOTTOM,
                this.SUN_HBOX_PADDING_LEFT));
        sunsetHBox.setSpacing(SUN_HBOX_SPACING);

        // Configure Background Color
        sunsetHBox.setBackground(sunsetBackground);

        // Add Sunset StackPane & Sunset Label within HBox Wrapper
        sunsetHBox.getChildren().addAll(sunsetPane, sunsetLabel);

        // Return Sun HBox Layout Wrapper Node
        return sunsetHBox;
    }

    @Override
    public HBox createSunriseHBox(StackPane sunrisePane, Label sunriseLabel) {

        // Check if Sunrise Pane || Sunrise Label is Null
        if(sunrisePane.equals(null) || sunriseLabel.equals(null)) throw new NullPointerException("Sunrise Pane & Sunrise Label cannot be null");

        // Instantiate Sunrise VBox Background
        Color hboxRGB = Color.rgb(this.SUN_HBOX_RED, this.SUN_HBOX_GREEN, this.SUN_HBOX_BLUE);

        // Instantiate Background & BackgroundFill Nodes
        BackgroundFill sunriseBackgroundFill = new BackgroundFill(hboxRGB, null, null);
        Background sunriseBackground = new Background(sunriseBackgroundFill);

        // Instantiate Sunrise HBox Layout Wrapper
        HBox sunriseHBox = new HBox();

        // Configure Sunset HBox Width
        sunriseHBox.setMinWidth(this.SUN_HBOX_WIDTH);
        sunriseHBox.setMaxWidth(this.SUN_HBOX_WIDTH);
        sunriseHBox.setPrefWidth(this.SUN_HBOX_WIDTH);

        // Configure Sunset HBox Height
        sunriseHBox.setMinHeight(this.SUN_HBOX_HEIGHT);
        sunriseHBox.setMaxHeight(this.SUN_HBOX_HEIGHT);
        sunriseHBox.setPrefHeight(this.SUN_HBOX_HEIGHT);

        // Configure Sunrise HBox Alignment
        sunriseHBox.setAlignment(this.SUN_HBOX_POS);

        // Configure Sunrise HBox Padding & Spacing
        sunriseHBox.setPadding(new Insets(
                this.SUN_HBOX_PADDING_TOP,
                this.SUN_HBOX_PADDING_RIGHT,
                this.SUN_HBOX_PADDING_BOTTOM,
                this.SUN_HBOX_PADDING_LEFT));
        sunriseHBox.setSpacing(SUN_HBOX_SPACING);

        // Configure Background Color
        sunriseHBox.setBackground(sunriseBackground);

        // Add Sunrise StackPane & Sunrise Label within HBox Wrapper
        sunriseHBox.getChildren().addAll(sunrisePane, sunriseLabel);

        // Return Sunrise HBox Layout Wrapper Node
        return sunriseHBox;
    }

    @Override
    public VBox createCurrentWeatherVBox(Label temperatureLabel, Label statusLabel) {

        // Check if Temperature || Status Label is Null
        if(temperatureLabel.equals(null) || statusLabel.equals(null)) throw new NullPointerException("Temperature & Status Label cannot be null");

        // Configure Wrapper Background
        Color tempRGB = Color.rgb(this.TEMP_VBOX_RED, this.TEMP_VBOX_GREEN, this.TEMP_VBOX_BLUE);
        BackgroundFill tempBackgroundFill = new BackgroundFill(tempRGB, null, null);
        Background tempBackground = new Background(tempBackgroundFill);

        // Instantiate VBox Layout Wrapper Node
        VBox tempVBox = new VBox();
        tempVBox.setPrefSize(this.TEMP_VBOX_WIDTH, this.TEMP_VBOX_HEIGHT);
        tempVBox.setBackground(tempBackground);
        tempVBox.setAlignment(Pos.CENTER);

        // Add Labels within Wrapper
        tempVBox.getChildren().addAll(statusLabel, temperatureLabel);

        // Return VBox Wrapper Node
        return tempVBox;
    }

    @Override
    public Label createTempLabel(String temperature_str) {

        // Check if Temperature String is Empty
        if(temperature_str.isEmpty()) throw new IllegalArgumentException("Temperature String cannot be empty");

        // Instantiate Temperature Label Node
        Label temperatureLabel = new Label(temperature_str + this.TEMP_NOTATION);

        // Configure Temperature Label Style
        temperatureLabel.setFont(this.TEMP_FONT);
        temperatureLabel.setTextFill(this.TEMP_FONT_COLOR);
        temperatureLabel.setAlignment(this.TEMP_ALIGNMENT);

        // Configure Temperature Label Width
        temperatureLabel.setPrefWidth(this.TEMP_LABEL_WIDTH);
        temperatureLabel.setMinWidth(this.TEMP_LABEL_WIDTH);
        temperatureLabel.setMaxWidth(this.TEMP_LABEL_WIDTH);

        // Configure Temperature Label Height
        temperatureLabel.setPrefHeight(this.TEMP_LABEL_HEIGHT);
        temperatureLabel.setMinHeight(this.TEMP_LABEL_HEIGHT);
        temperatureLabel.setMaxHeight(this.TEMP_LABEL_HEIGHT);

        // Return Temperature Label Node
        return temperatureLabel;
    }

    // Weather Status Label Object Factory Method
    public Label createStatusLabel(String status_str) {

        // Check if Status String is Empty
        if(status_str.isEmpty()) throw new IllegalArgumentException("Status string cannot be empty");

        // Instantiate Status Label Node
        Label statusLabel = new Label(status_str);

        // Configure Temperature Status Label
        statusLabel.setFont(this.STATUS_FONT);
        statusLabel.setTextFill(this.STATUS_FONT_COLOR);
        statusLabel.setAlignment(this.STATUS_ALIGNMENT);

        // Configure Temperature Status Width
        statusLabel.setPrefWidth(this.STATUS_LABEL_WIDTH);
        statusLabel.setMinWidth(this.STATUS_LABEL_WIDTH);
        statusLabel.setMaxWidth(this.STATUS_LABEL_WIDTH);

        // Configure Temperature Status Height
        statusLabel.setPrefHeight(this.STATUS_LABEL_HEIGHT);
        statusLabel.setMinHeight(this.STATUS_LABEL_HEIGHT);
        statusLabel.setMaxHeight(this.STATUS_LABEL_HEIGHT);

        // Return Status Label Node
        return statusLabel;
    };

    @Override
    public VBox createSunVBox(HBox sunHBox) {

        // Check if Sun HBox is Null
        if(sunHBox.equals(null)) throw new NullPointerException("Sun HBox cannot be null");

        // Instantiate Sunrise & Sunset VBox Background
        Color sunRGB = Color.rgb(this.SUN_VBOX_RED, this.SUN_VBOX_GREEN, this.SUN_VBOX_BLUE);

        // Configure Background of ImageView
        BackgroundFill sunBackgroundFill = new BackgroundFill(sunRGB, null, null);
        Background sunBackground = new Background(sunBackgroundFill);

        // Instantiate Sun HBox Layout Wrapper Node
        VBox sunVBox = new VBox();

        // Configure Sunrise & Sunset VBox Width
        sunVBox.setMinWidth(this.SUN_VBOX_WIDTH);
        sunVBox.setMaxWidth(this.SUN_VBOX_WIDTH);
        sunVBox.setPrefWidth(this.SUN_VBOX_WIDTH);

        // Configure Sunrise & Sunset VBox Height
        sunVBox.setMinHeight(this.SUN_VBOX_HEIGHT);
        sunVBox.setMaxHeight(this.SUN_VBOX_HEIGHT);
        sunVBox.setPrefHeight(this.SUN_VBOX_HEIGHT);

        // Configure Sunrise & Sunset VBox Alignment
        sunVBox.setAlignment(this.SUN_VBOX_ALIGNMENT);

        // Configure Sunrise & Sunset VBox Background
        sunVBox.setBackground(sunBackground);

        // Add Sun HBox within Wrapper
        sunVBox.getChildren().addAll(sunHBox);

        // Return VBox Layout Wrapper Node
        return sunVBox;
    }


}
