package factory.implementations;

import factory.interfaces.ForecastFactory;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class ForecastFactoryImplementation implements ForecastFactory {
    @Override
    public HBox createHBox(List<BorderPane> borderPaneList) {
        return null;
    }

    @Override
    public BorderPane createBorderPane(Pane imagePane, VBox vbox) {

        // Check if Image Pane & VBox are Null
        if(imagePane.equals(null) || vbox.equals(null)) throw new NullPointerException("Image Pane & VBox cannot be null");

        // Instantiate BorderPane Layout Wrapper Node
        BorderPane borderPane = new BorderPane();

        // Configure Minimum Width of Border Pane Layout Wrapper
        borderPane.setMinWidth(this.BORDER_PANE_MIN_WIDTH);

        // Configure Maximum Width of BorderPane Layout Wrapper
        borderPane.setMaxWidth(this.BORDER_PANE_MAX_WIDTH);

        // Configure Preferred Width of BorderPane Layout Wrapper
        borderPane.setPrefWidth(this.BORDER_PANE_PREF_WIDTH);

        // Configure Minimum Height of BorderPane Layout Wrapper
        borderPane.setMinHeight(this.BORDER_PANE_MIN_HEIGHT);

        // Configure Maximum Height of BorderPane Layout Wrapper
        borderPane.setMaxHeight(this.BORDER_PANE_MAX_HEIGHT);

        // Configure Preferred Height of BorderPane Layout Wrapper
        borderPane.setPrefHeight(this.BORDER_PANE_PREF_HEIGHT);

        // Configure Minimum Height of BorderPane Layout Wrapper
        borderPane.setMinHeight(this.BORDER_PANE_MIN_HEIGHT);

        // Configure Maximum Height of BorderPane Layout Wrapper
        borderPane.setMaxHeight(this.BORDER_PANE_MAX_HEIGHT);

        // Configure Padding Height & Width of BorderPane Wrapper
        borderPane.setPadding(this.BORDER_PANE_INSETS);

        // Set Background for BorderPane Wrapper
        BackgroundFill backgroundFill = new BackgroundFill(rgb, null, null);
        Background background = new Background(backgroundFill);
        borderPane.setBackground(background);

        // Add the ImageView to the Border Pane
        borderPane.setTop(imagePane);

        // Add VBox Layout Wrapper within BorderPane Layout Wrapper
        borderPane.setCenter(vbox);

        return borderPane;
    }

    @Override
    public Pane createImagePane(String weather_icon_path) {

        // Check if Weather Icon URL is Null or Empty
        if(weather_icon_path.isEmpty() || weather_icon_path.equals(null)) throw new IllegalArgumentException("Weather Icon Path cannot be null or empty");

        // Instantiate Image Node w/ URL Loading
        Image image = new Image(getClass().getResourceAsStream(weather_icon_path),
                                this.IMAGE_WIDTH,
                                this.IMAGE_HEIGHT,
                                this.IMAGE_ORIGINAL_RATIO,
                                this.IMAGE_SMOOTHING_ALGORITHM);

        // Check for Image Loading Failure
        if(image.isError()) {
            throw new IllegalArgumentException("Image URL Loading Failure: Incorrect URL");
        }

        // Instantiate ImageView Node
        ImageView imageView = new ImageView(image);

        // Wrap the ImageView in a Pane
        Pane imagePane = new Pane(imageView);
        
        // Configure Width of Image Pane
        imagePane.setMinWidth(this.IMAGE_PANE_WIDTH);
        
        // Configure Height of Image Pane
        imagePane.setMinHeight(this.IMAGE_PANE_HEIGHT);

        // Center the ImageView within the Pane
        imageView.setLayoutX((imagePane.getMinWidth() - this.IMAGE_WIDTH) / 2);
        imageView.setLayoutY((imagePane.getMinHeight() - this.IMAGE_HEIGHT) / 2);

        // Configure ImageView Width & Height
        imageView.setFitWidth(this.IMAGE_WIDTH);
        imageView.setFitHeight(this.IMAGE_HEIGHT);

        // Return Image Pane Node
        return imagePane;
    }

    @Override
    public Label createTimeLabel(LocalTime currentTime) {

        // Check if Current Time is Null
        if(currentTime.equals(null)) throw new NullPointerException("Current Time cannot be null");

        // Get Current Hour as String
        String time = new String(String.valueOf(currentTime.getHour()));

        // Instantiate Time Label Node
        Label timeLabel = new Label(time);

        // Configure Time Label Font Style
        timeLabel.setFont(this.TIME_FONT);

        // Configure Time Label Font Color
        timeLabel.setTextFill(DATE_TIME_FONT_COLOR);

        // Configure Time Label Alignment
        timeLabel.setAlignment(this.TIME_LABEL_ALIGNMENT);

        // Return Time Label Node
        return timeLabel;
    }

    @Override
    public Label createDateLabel(LocalDateTime currentDateTime) {

        // Check if Current Time is Null
        if(currentDateTime.equals(null)) throw new NullPointerException("Current Date cannot be null");

        // Get Current Date as String
        String dateTime = new String(String.valueOf(currentDateTime.getDayOfMonth()));

        // Instantiate Date Label Node
        Label dateLabel = new Label(dateTime);

        // Configure Date Label Font Style
        dateLabel.setFont(this.DATE_FONT);

        // Configure Date Label Font Color
        dateLabel.setTextFill(this.DATE_TIME_FONT_COLOR);

        // Configure Date Label Alignment
        dateLabel.setAlignment(this.DATE_LABEL_ALIGNMENT);

        // Return Date Label Node
        return dateLabel;
    }

    @Override
    public VBox createVBoxLayout(Label timeLabel, Label dateLabel) {

        // Check if Time || Date Label is Null
        if(timeLabel.equals(null) || dateLabel.equals(null)) throw new NullPointerException("Time & Date Label cannot be null");

        // Instantiate VBox Layout Wrapper Node
        VBox vbox = new VBox();

        // Configure VBox Layout Wrapper Height
        vbox.setPrefHeight(this.VBOX_PREF_HEIGHT);
        vbox.setMinHeight(this.VBOX_MIN_HEIGHT);
        vbox.setMaxHeight(this.VBOX_MAX_HEIGHT);

        // Configure VBox Layout Wrapper Width
        vbox.setPrefWidth(this.VBOX_PREF_WIDTH);
        vbox.setMinWidth(this.VBOX_MIN_WIDTH);
        vbox.setMaxWidth(this.VBOX_MAX_WIDTH);

        // Configure VBox Spacing
        vbox.setSpacing(this.VBOX_NODE_SPACING);

        // Configure VBox Alignment
        vbox.setAlignment(this.VBOX_ALIGNMENT);

        // Configure VBox Padding
        vbox.setPadding(this.VBOX_PADDING);

        // Add Time Label to VBox
        vbox.getChildren().addAll(timeLabel, dateLabel);

        // Return VBox Layout Wrapper Node
        return vbox;
    }
}
