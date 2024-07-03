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




//////// Label ////////////////////////////////////////////////////////////////////////////////////////////////////

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












        primaryStage.setScene(new Scene(hbox));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
