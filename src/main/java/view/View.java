package view;

import factory.implementations.CurrentForecastFactoryImplementation;
import factory.implementations.ForecastFactoryImplementation;
import factory.implementations.WrapperFactoryImplementation;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class View {

    // Private & Static & Final Members


    // View Class Members
    private HBox forecastHBox;
    private Label currentTempLabel;
    private Label currentStatusLabel;
    private Label sunriseLabel;
    private Label sunsetLabel;
    private List<BorderPane> forecastPaneCollection;
    private Pane currentIconPane;
    private VBox sunriseSunsetVBox;

    // Forecast HBox Getter
    public HBox getForecastHBox() {
        return this.forecastHBox;
    }

    // Current Weather Temperature Label Getter
    public Label getCurrentTempLabel() {
        return this.currentTempLabel;
    }

    // Current Weather Status Label Getter
    public Label getCurrentStatusLabel() {
        return this.currentStatusLabel;
    }

    // Sunrise Label Getter
    public Label getSunriseLabel() {
        return this.sunriseLabel;
    }

    // Sunset Label Getter
    public Label getSunsetLabel() {
        return this.sunsetLabel;
    }

    // Forecast BorderPane Collection Getter
    public List<BorderPane> getForecastPaneCollection() {
        return this.forecastPaneCollection;
    }

    // Current Weather Icon Pane Getter
    public Pane getCurrentIconPane() {
        return this.currentIconPane;
    }

    // Sunrise Sunset VBox Wrapper Getter
    public VBox getSunriseSunsetVBox() {
        return this.sunriseSunsetVBox;
    }

    // Forecast HBox Wrapper Setter
    public void setForecastHBox(HBox forecastHBox) {
        if(forecastHBox.equals(null)) throw new NullPointerException("Forecast HBox cannot be null");
        this.forecastHBox = forecastHBox;
    }

    // Current Weather Temperature Label Setter
    public void setCurrentTempLabel(Label currentTempLabel) {
        if(currentTempLabel.equals(null)) throw new NullPointerException("Current Temp Label cannot be null");
        this.currentTempLabel = currentTempLabel;
    }

    // Current Weather Status Label Setter
    public void setCurrentStatusLabel(Label currentStatusLabel) {
        if(currentStatusLabel.equals(null)) throw new NullPointerException("Current Status Label cannot be null");
        this.currentStatusLabel = currentStatusLabel;
    }

    // Sunrise Label Setter
    public void setSunriseLabel(Label sunriseLabel) {
        if(sunriseLabel.equals(null)) throw new NullPointerException("Sunrise Label cannot be null");
        this.sunriseLabel = sunriseLabel;
    }

    // Sunset Label Setter
    public void setSunsetLabel(Label sunsetLabel) {
        if(sunsetLabel.equals(null)) throw new NullPointerException("sunset Label cannot be null");
        this.sunsetLabel = sunsetLabel;
    }

    // Forecast BorderPane Collection Setter
    public void setForecastPaneCollection(List<BorderPane> forecastPaneCollection) {
        if(forecastPaneCollection.equals(null) || forecastPaneCollection.isEmpty()) throw new NullPointerException("Forecast BorderPane Collection cannot be null");
        this.forecastPaneCollection = forecastPaneCollection;
    }

    // Current Weather Icon Pane Setter
    public void setCurrentIconPane(Pane currentIconPane) {
        if(currentIconPane.equals(null)) throw new NullPointerException("Current Icon Pane cannot be null");
        this.currentIconPane = currentIconPane;
    }

    // Sunrise Sunset VBox Wrapper Setter
    public void setSunriseSunsetVBox(VBox sunriseSunsetVBox) {
        if(sunriseSunsetVBox.equals(null)) throw new NullPointerException("Sunrise Sunset VBox cannot be null");
        this.sunriseSunsetVBox = sunriseSunsetVBox;
    }


    // View Constructor Method
    public View(ForecastFactoryImplementation forecastFactory,
                CurrentForecastFactoryImplementation currentFactory,
                WrapperFactoryImplementation wrapperFactory,
                LocalTime currentTime,
                LocalDateTime currentDateTime,
                List<String> forecastIconsCollection,
                String currentForecastIconPath,
                String currentTemp,
                String currentStatus,
                String sunriseTime,
                String sunsetTime) {

        // Instantiate Forecast Pane ArrayList Collection
        for(int i = 0; i < 10; i++) {
            // Instantiate Time Label
            Label timeLabel = forecastFactory.createTimeLabel(currentTime.now());

            // Instantiate Date Label
            Label dateLabel = forecastFactory.createDateLabel(currentDateTime.now());

            // Increment Hours by 2
            currentTime = currentTime.plusHours(2);
            currentDateTime = currentDateTime.plusHours(2);

            // Instantiate VBox Wrapper
            VBox forecastVBox = forecastFactory.createVBoxLayout(timeLabel, dateLabel);

            // Instantiate Forecast Icon Pane Node
            Pane forecastIconPane = forecastFactory.createImagePane(forecastIconsCollection.get(i));

            // Instantiate BorderPane Node
            BorderPane pane = forecastFactory.createBorderPane(forecastIconPane, forecastVBox);

            // Add BorderPane Node within forecastPaneCollection
            this.getForecastPaneCollection().add(pane);
        }

        // Instantiate Forecast HBox Layout Wrapper Node
        this.setForecastHBox(forecastFactory.createHBox(this.getForecastPaneCollection()));

        // Instantiate Current Forecast Icon Pane Wrapper
        this.setCurrentIconPane(currentFactory.createCurrentImagePane(currentForecastIconPath));

        // Instantiate Current Forecast Temperature Label
        this.setCurrentTempLabel(currentFactory.createTempLabel(currentTemp));

        // Instantiate Current Forecast Status Label
        this.setCurrentStatusLabel(currentFactory.createStatusLabel(currentStatus));

        // Instantiate Sunrise Time Label
        this.setSunriseLabel(currentFactory.createSunriseLabel(sunriseTime));

        // Instantiate Sunset Time Label
        this.setSunsetLabel(currentFactory.createSunsetLabel(sunsetTime));

        // Instantiate Sunrise StackPane Wrapper

        // Instantiate Sunset StackPane Wrapper

    }

}
