package main;

import factory.implementations.*;
import model.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import view.View;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Instantiate Model Class
        Model model = new Model();

        // Instantiate Current Forecast Factory Node
        CurrentForecastFactoryImplementation currentFactory = new CurrentForecastFactoryImplementation();

        // Instantiate Future Forecast Factory Node
        ForecastFactoryImplementation futureFactory = new ForecastFactoryImplementation();

        // Instantiate Wrapper Factory Node
        WrapperFactoryImplementation wrapperFactory = new WrapperFactoryImplementation();

        // Instantiate Menu Factory Node
        MenuFactoryImplementation menuFactory = new MenuFactoryImplementation();

        // Instantiate Current Time & Current Date Nodes
        LocalDateTime current_date = LocalDateTime.now();
        LocalTime current_time = LocalTime.now();

        // Instantiate View Node
        View view = new View(futureFactory,
                             currentFactory,
                             wrapperFactory,
                             menuFactory,
                             model.getForecastIconPathList(),
                             model.getForecastTempList(),
                             model.getForecastDateList(),
                             model.getForecastTimeList(),
                             WeatherIconMapper.getIcon(model.getCurrentID()),
                             model.getCurrentTemp(),
                             model.getCurrentStatus(),
                             model.getSunriseTime(),
                             model.getSunsetTime(),
                             current_date,
                             current_time);

        // Instantiate Scene
        Scene scene = new Scene(view.getWeatherUIVBox());

        // Set Scene on Primary Stage & Show Stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
