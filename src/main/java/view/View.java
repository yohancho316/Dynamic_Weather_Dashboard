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

    // Layout Wrapper Nodes
    private HBox forecastHBox;

    // Forecast BorderPane Collection
    private List<BorderPane> forecastPaneCollection;

    // Forecast HBox Getter
    public HBox getForecastHBox() {
        return this.forecastHBox;
    }

    // Forecast BorderPane Collection Getter
    public List<BorderPane> getForecastPaneCollection() {
        return this.forecastPaneCollection;
    }

    // Forecast HBox Setter
    public void setForecastHBox(HBox forecastHBox) {
        if(forecastHBox.equals(null)) throw new NullPointerException("Forecast HBox cannot be null");
        this.forecastHBox = forecastHBox;
    }

    // Forecast BOrderPane Collection Setter
    public void setForecastPaneCollection(List<BorderPane> forecastPaneCollection) {
        if(forecastPaneCollection.equals(null) || forecastPaneCollection.isEmpty()) throw new NullPointerException("Forecast BorderPane Collection cannot be null");
        this.forecastPaneCollection = forecastPaneCollection;
    }


    // View Constructor Method
    public View(ForecastFactoryImplementation forecastFactory,
                CurrentForecastFactoryImplementation currentFactory,
                WrapperFactoryImplementation wrapperFactory,
                LocalTime currentTime,
                LocalDateTime currentDateTime,
                List<String> forecastIconsCollection) {

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
        HBox forecastHBox = forecastFactory.createHBox(this.getForecastPaneCollection());



    }

}
