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

    // Current Weather Icon Image Pane Wrapper Object Factory Concrete Definition
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


    // Sunset Icon StackPane Object Factory Concrete Definition
    @Override
    public StackPane createSunsetStackPane(String sunset_image_path) {

        // Check if Sunset Image Path is Null or Empty
        if(sunset_image_path.isEmpty() || sunset_image_path.equals(null)) throw new IllegalArgumentException("Sunset Image Path cannot be empty or Null");

        // Instantiate Image Node w/ URL Loading
        Image sunsetIcon = new Image(getClass().getResourceAsStream(sunset_image_path),
                this.SET_IMAGE_WIDTH, 
                this.SET_IMAGE_HEIGHT, 
                this.SET_IMAGE_ORIGINAL_RATIO, 
                this.SET_IMAGE_SMOOTHING_ALGORITHM);

        // Check for Image Loading Failure
        if(sunsetIcon.isError()) {
            throw new IllegalArgumentException("Image URL Loading Failure: Incorrect URL");
        }

        // Instantiate ImageView Node
        ImageView setImageView = new ImageView(sunsetIcon);

        // Configure Width & Height of ImageView
        setImageView.setFitWidth(this.SET_IMAGE_WIDTH);
        setImageView.setFitHeight(this.SET_IMAGE_HEIGHT);

        // Wrap the ImageView in a Pane
        StackPane setImagePane = new StackPane(setImageView);

        // Configure Sunset Image Pane Height & Width
        setImagePane.setPrefSize(this.SET_IMAGE_WIDTH, this.SET_IMAGE_HEIGHT);

        // Return Sunset Icon Stack Pane Node
        return setImagePane;
    }

    // Sunrise Icon StackPane Object Factory Concrete Definition
    public StackPane createSunriseStackPane(String sunrise_image_path) {

        // Check if Sunrise Image Path is Null or Empty
        if(sunrise_image_path.isEmpty() || sunrise_image_path.equals(null)) throw new IllegalArgumentException("Sunrise Image Path cannot be empty or Null");

        // Instantiate Image Node w/ URL Loading
        Image sunriseIcon = new Image(getClass().getResourceAsStream(sunrise_image_path),
                this.RISE_IMAGE_WIDTH,
                this.RISE_IMAGE_HEIGHT,
                this.RISE_IMAGE_ORIGINAL_RATIO,
                this.RISE_IMAGE_SMOOTHING_ALGORITHM);

        // Check for Image Loading Failure
        if(sunriseIcon.isError()) {
            throw new IllegalArgumentException("Image URL Loading Failure: Incorrect URL");
        }

        // Instantiate ImageView Node
        ImageView riseImageView = new ImageView(sunriseIcon);

        // Configure Width & Height of ImageView
        riseImageView.setFitWidth(this.RISE_IMAGE_WIDTH);
        riseImageView.setFitHeight(this.RISE_IMAGE_HEIGHT);

        // Wrap the ImageView in a Pane
        StackPane riseImagePane = new StackPane(riseImageView);

        // Configure Sunrise Image Pane Height & Width
        riseImagePane.setPrefSize(this.RISE_IMAGE_WIDTH, this.RISE_IMAGE_HEIGHT);

        // Return Sunrise Image Pane Node
        return riseImagePane;
    }

    // Sunset HBox Wrapper Object Factory Concrete Definition
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


    // Current Weather VBox Layout Object Factory Concrete Definition
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

    // Sunset & Sunrise VBox Object Factory Concrete Definition
    @Override
    public VBox createSunVBox(HBox sunsetHBox, HBox sunriseHBox) {

        // Check if Sunset HBox || Sunrise HBox is Null
        if(sunsetHBox.equals(null) || sunriseHBox.equals(null)) throw new NullPointerException("Sunset HBox & Sunrise HBox cannot be null");

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
        sunVBox.getChildren().addAll(sunsetHBox, sunriseHBox);

        // Return VBox Layout Wrapper Node
        return sunVBox;
    }

    // Temperature Label Object Factory Concrete Definition
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

    // Weather Status Label Object Factory Concrete Definition
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

    // Sunrise Label Object Factory Concrete Definition
    public Label createSunriseLabel(String sunriseStr) {

        // Check if Sunrise String is Empty
        if(sunriseStr.isEmpty()) throw new IllegalArgumentException("Sunrise String cannot be empty");
        // Check if Sunrise String is Null
        else if(sunriseStr.equals(null)) throw new NullPointerException("Sunrise String cannot be null");

        // Instantiate Sunrise Label
        Label riseLabel = new Label(sunriseStr);

        // Configure Sunrise Label Node
        riseLabel.setFont(this.SUNRISE_FONT);
        riseLabel.setTextFill(this.SUNRISE_FONT_COLOR);
        riseLabel.setAlignment(this.SUNRISE_LABEL_POS);

        // Configure Sunrise Label Width
        riseLabel.setPrefWidth(this.RISE_LABEL_HEIGHT);
        riseLabel.setMinWidth(this.RISE_LABEL_HEIGHT);
        riseLabel.setMaxWidth(this.RISE_LABEL_HEIGHT);

        // Configure Sunrise Label Height
        riseLabel.setPrefHeight(this.RISE_LABEL_HEIGHT);
        riseLabel.setMinHeight(this.RISE_LABEL_HEIGHT);
        riseLabel.setMaxHeight(this.RISE_LABEL_HEIGHT);

        // Return Sunrise Label Node
        return riseLabel;
    }

    // Sunset Label Object Factory Concrete Definition
    @Override
    public Label createSunsetLabel(String sunsetStr) {

        // Check if Sunset String is Empty
        if(sunsetStr.isEmpty()) throw new IllegalArgumentException("Sunset String cannot be empty");
        // CHeck if Sunset String is Null
        else if(sunsetStr.equals(null)) throw new NullPointerException("Sunset String cannot be null");

        // Instantiate Set Label Node
        Label sunsetLabel = new Label(sunsetStr);

        // Configure Set Label Node
        sunsetLabel.setFont(this.SUNSET_FONT);
        sunsetLabel.setTextFill(this.SUNSET_FONT_COLOR);
        sunsetLabel.setAlignment(this.SUNSET_LABEL_POS);

        // Configure Sunset Label Width
        sunsetLabel.setPrefWidth(this.SET_LABEL_WIDTH);
        sunsetLabel.setMinWidth(this.SET_LABEL_WIDTH);
        sunsetLabel.setMaxWidth(this.SET_LABEL_WIDTH);

        // Configure Sunset Label Height
        sunsetLabel.setPrefHeight(this.SET_LABEL_HEIGHT);
        sunsetLabel.setMinHeight(this.SET_LABEL_HEIGHT);
        sunsetLabel.setMaxHeight(this.SET_LABEL_HEIGHT);

        // Return Sunset Label Node
        return sunsetLabel;
    }

}
