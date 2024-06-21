package main;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

//////// HBOX ////////////////////////////////////////////////////

        // HBox Layout Wrapper Enumerations
        Pos HBOX_ALIGNMENT = Pos.CENTER_LEFT;
        double HBOX_NODE_SPACING = 1.0;
        double HBOX_MIN_WIDTH = 1200;
        double HBOX_MAX_WIDTH = 1200;
        double HBOX_MIN_HEIGHT = 200;
        double HBOX_MAX_HEIGHT = 200;
        Insets HBOX_PADDING = new Insets(0.0);

        // HBox Configurations
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

////////////////////////////////////////////////////////////////////////


//////// BorderPane ////////////////////////////////////////////////////

        // HBox Layout Wrapper Enumerations
        










        BorderPane pane = new BorderPane();
        Button btn = new Button("Hello World");
        pane.setCenter(btn);
        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
