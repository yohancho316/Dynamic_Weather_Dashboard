package factory.implementations;

import factory.interfaces.CurrentForecastFactory;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
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
}
