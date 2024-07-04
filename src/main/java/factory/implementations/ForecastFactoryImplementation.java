package factory.implementations;

import factory.interfaces.ForecastFactory;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
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
        return null;
    }

    @Override
    public Pane createImagePane(Image weather_icon) {
        return null;
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
