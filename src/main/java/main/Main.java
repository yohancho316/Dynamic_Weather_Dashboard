package main;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

//////// HBOX //////////////////////////////////////////////////////////////////////////////////////////////////////////

        // HBox Layout Wrapper Enumerations
        Pos HBOX_ALIGNMENT = Pos.CENTER_LEFT;
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



//////// Image /////////////////////////////////////////////////////////////////////////////////////////////////////////

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
        imagePane.setMinWidth(100); // assuming the width of the top region
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
