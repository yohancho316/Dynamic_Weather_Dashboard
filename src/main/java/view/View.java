package view;

import factory.implementations.CurrentForecastFactoryImplementation;
import factory.implementations.ForecastFactoryImplementation;
import factory.implementations.WrapperFactoryImplementation;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class View {

    // View Class Members
    private static final String SUNRISE_IMAGE_PATH = "/icons8-sunrise-24.png";
    private static final String SUNSET_IMAGE_PATH = "/icons8-sunset-24.png";
    private ForecastFactoryImplementation future_factory; //
    private CurrentForecastFactoryImplementation current_factory; //
    private WrapperFactoryImplementation wrapper_factory; //
    private List<BorderPane> borderPaneList; //
    private HBox pane_hbox; //
    private Pane main_image_pane; //
    private Label temperature_label; //
    private Label status_label; //
    private VBox main_temp_status_vbox; //
    private StackPane sunrise_stackpane; //
    private StackPane sunset_stackpane; //
    private Label sunrise_label; //
    private Label sunset_label; //
    private HBox sunrise_hbox; //
    private HBox sunset_hbox; //
    private VBox sunrise_sunset_vbox;
    private HBox current_weather_hbox;
    private VBox weather_ui_vbox;

    // Future Factory Getter Method
    public ForecastFactoryImplementation getFutureFactory() {
        return this.future_factory;
    }

    // Current Factory Getter Method
    public CurrentForecastFactoryImplementation getCurrentFactory() {
        return this.current_factory;
    }

    // Wrapper Factory Getter Method
    public WrapperFactoryImplementation getWrapperFactory() {
        return this.wrapper_factory;
    }

    // BorderPane Collection Getter Method
    public List<BorderPane> getBorderPaneList() {
        return this.borderPaneList;
    }

    // Border Pane HBox Getter Method
    public HBox getBorderPaneHBox() {
        return this.pane_hbox;
    }

    // Main Image Pane Getter Method
    public Pane getMainImagePane() {
        return this.main_image_pane;
    }

    // Current Temperature Label Getter Method
    public Label getTemperatureLabel() {
        return this.temperature_label;
    }

    // Current Status Label Getter Method
    public Label getStatusLabel() {
        return this.status_label;
    }

    // Temperature & Status VBox Getter Method
    public VBox getTempStatusVBox() {
        return this.main_temp_status_vbox;
    }

    // Sunrise StackPane Getter Method
    public StackPane getSunriseStackPane() {
        return this.sunrise_stackpane;
    }

    // Sunset StackPane Getter Method
    public StackPane getSunsetStackPane() { return this.sunset_stackpane; }

    // Sunrise Label Getter Method
    public Label getSunriseLabel() { return this.sunrise_label; }

    // Sunset Label Getter Method
    public Label getSunsetLabel() { return this.sunset_label; }

    // Sunrise HBox Getter Method
    public HBox getSunriseHBox() { return this.sunrise_hbox; }

    // Sunset HBox Getter Method
    public HBox getSunsetHBox() { return this.sunset_hbox; }

    // Sunrise & Sunset VBox Getter Method
    public VBox getSunriseSunsetVBox() {
        return this.sunrise_sunset_vbox;
    }

    // Weather UI VBox Getter Method
    public VBox getWeatherUIVBox() {
        return this.weather_ui_vbox;
    }


    public View(ForecastFactoryImplementation future_factory,
                CurrentForecastFactoryImplementation current_factory,
                WrapperFactoryImplementation wrapper_factory,
                List<String> pane_image_collection,
                List<LocalDateTime> pane_date_collection,
                List<LocalTime> pane_time_collection,
                String main_image,
                String main_temp,
                String main_status,
                String sunrise_time,
                String sunset_time) {

        // Instantiate Forecast Factory Node
        this.instantiateForecastFactory(future_factory);

        // Instantiate Current Forecast Factory Node
        this.instantiateCurrentFactory(current_factory);

        // Instantiate Wrapper Factory Node
        this.instantiateWrapperFactory(wrapper_factory);

        // Instantiate BorderPane Collection
        this.instantiateBorderPaneList();

        // Populate BorderPane Collection
        this.populateBorderPaneList(pane_image_collection, pane_date_collection, pane_time_collection);

        // Instantiate Pane HBox Wrapper
        this.instantiatePaneHBox();

        // Instantiate Main Image Pane
        this.instantiateMainPane(main_image);

        // Instantiate Temperature Label
        this.instantiateTemperatureLabel(main_temp);

        // Instantiate Status Label
        this.instantiateStatusLabel(main_status);

        // Instantiate Main Temp Status VBox
        this.instantiateMainTempStatusVBox();

        // Instantiate Sunrise StackPane Wrapper
        this.instantiateSunrisePane();

        // Instantiate Sunset StackPane Wrapper
        this.instantiateSunsetPane();

        // Instantiate Sunrise Label
        this.instantiateSunriseLabel(sunrise_time);

        // Instantiate Sunset Label
        this.instantiateSunsetLabel(sunset_time);

        // Instantiate Sunrise HBox Wrapper
        this.instantiateSunriseHBox();

        // Instantiate Sunset HBox Wrapper
        this.instantiateSunsetHBox();

        // Instantiate Sunrise & Sunset VBox Wrapper
        this.instantiateSunriseSunsetVBox();

        // Instantiate Current Weather HBox Wrapper
        this.instantiateCurrentWeatherHBox();

        // Instantiate Weather UI VBox Wrapper
        this.instantiateWeatherVBox();
    }

    // Instantiate Future Factory Method
    public void instantiateForecastFactory(ForecastFactoryImplementation future_factory) {
        if(future_factory == null) throw new NullPointerException("Forecast Factory parameters cannot be null");
        this.future_factory = future_factory;
    }

    // Instantiate Current Factory Method
    public void instantiateCurrentFactory(CurrentForecastFactoryImplementation current_factory) {
        if(current_factory == null) throw new NullPointerException("Current Factory cannot be null");
        this.current_factory = current_factory;
    }

    // Instantiate Wrapper Factory Method
    public void instantiateWrapperFactory(WrapperFactoryImplementation wrapper_factory) {
        if(wrapper_factory == null) throw new NullPointerException("Wrapper Factory cannot be null");
        this.wrapper_factory = wrapper_factory;
    }

    // Instantiate Border Pane List Method
    public void instantiateBorderPaneList() {
        this.borderPaneList = new ArrayList<BorderPane>();
    }

    // Populate Border Pane List Method
    public void populateBorderPaneList(List<String> pane_image_collection, List<LocalDateTime> pane_date_collection, List<LocalTime> pane_time_collection) {

        // Check For Null Parameters
        if(pane_image_collection == null || pane_date_collection == null || pane_time_collection == null) {
            throw new NullPointerException("Populate Border Pane List Parameters cannot be null");
        }

        // Check for Empty Collections
        if(pane_image_collection.isEmpty() || pane_date_collection.isEmpty() || pane_time_collection.isEmpty()) {
            throw new IllegalArgumentException("Populate BOrder Pane List Parameter Collections cannot be empty");
        }

        for(int i = 0; i < 10; i++) {

            // Instantiate Border Pane Image
            Pane image_pane = this.instantiatePaneImage(pane_image_collection.get(i));

            // Instantiate Future Time Label
            Label date_label = this.instantiateDateLabel(pane_date_collection.get(i));

            // Instantiate Future Date Label
            Label time_label = this.instantiateTimeLabel(pane_time_collection.get(i));

            // Instantiate Date/Time VBox Wrapper
            VBox date_time_vbox = this.instantiate_date_time_vbox(date_label, time_label);

            // Instantiate Future BorderPane Wrapper
            BorderPane future_pane = this.instantiateFuturePane(image_pane, date_time_vbox);

            // Add BorderPane inside BorderPane List
            this.borderPaneList.add(future_pane);
        }
    }

    // Instantiate BorderPane Image Method
    public Pane instantiatePaneImage(String icon_path) {
        if(icon_path == null) throw new NullPointerException("Icon Path cannot be null");
        else if(icon_path.isEmpty()) throw new IllegalArgumentException("Icon Path cannot be empty");
        return future_factory.createImagePane(icon_path);
    }

    // Instantiate Date Label Method
    public Label instantiateDateLabel(LocalDateTime currentDateTime) {
        if(currentDateTime == null) throw new NullPointerException("Current Date Time cannot be null");
        else if(currentDateTime.isBefore(currentDateTime.minusDays(1))) throw new IllegalArgumentException("Current Date Time must be current day");
        return this.future_factory.createDateLabel(currentDateTime);
    }

    // Instantiate Time Label Method
    public Label instantiateTimeLabel(LocalTime currentTime) {
        if(currentTime == null) throw new NullPointerException("Current Time cannot be null");
        return this.future_factory.createTimeLabel(currentTime);
    }

    // Instantiate Date/Time VBox Wrapper Method
    public VBox instantiate_date_time_vbox(Label date, Label time) {
        if(date == null || time == null) throw new NullPointerException("Date & Label cannot be null");
        else if(date.getText().isEmpty() || time.getText().isEmpty()) throw new IllegalArgumentException("Date & Time cannot be empty");
        return this.future_factory.createVBoxLayout(time, date);
    }

    // Instantiate Future BorderPane Method
    public BorderPane instantiateFuturePane(Pane imagePane, VBox vbox) {
        if(imagePane == null || vbox == null) throw new NullPointerException("Image Pane & VBox cannot be null");
        return this.future_factory.createBorderPane(imagePane, vbox);
    }

    // Instantiate Pane HBox Wrapper Method
    public void instantiatePaneHBox() {
        this.pane_hbox = this.future_factory.createHBox(this.borderPaneList);
    }

    // Instantiate Main Image Pane Method
    public void instantiateMainPane(String image_path) {
        if(image_path == null) throw new NullPointerException("Main Image Path cannot be null");
        else if(image_path.isEmpty()) throw new IllegalArgumentException("Main Image Path cannot be empty");
        this.main_image_pane = this.current_factory.createCurrentImagePane(image_path);
    }

    // Instantiate Temperature Label Method
    public void instantiateTemperatureLabel(String main_temp) {
        if(main_temp == null) throw new NullPointerException("Main Temperature cannot be null");
        else if(main_temp.isEmpty()) throw new IllegalArgumentException("Main Temperature cannot be empty");
        this.temperature_label = this.current_factory.createTempLabel(main_temp);
    }

    // Instantiate Status Label Method
    public void instantiateStatusLabel(String main_status) {
        if(main_status == null) throw new NullPointerException("Main Status cannot be null");
        else if(main_status.isEmpty()) throw new IllegalArgumentException("Main Status cannot be empty");
        this.status_label = this.current_factory.createStatusLabel(main_status);
    }

    // Instantiate Main Temp & Status VBox Method
    public void instantiateMainTempStatusVBox() {
        this.main_temp_status_vbox = this.current_factory.createCurrentWeatherVBox(this.temperature_label, this.status_label);
    }

    // Instantiate Sunrise StackPane Method
    public void instantiateSunrisePane() {
        this.sunrise_stackpane = this.current_factory.createSunriseStackPane(this.SUNRISE_IMAGE_PATH);
    }

    // Instantiate Sunset StackPane Method
    public void instantiateSunsetPane() {
        this.sunset_stackpane = this.current_factory.createSunsetStackPane(this.SUNSET_IMAGE_PATH);
    }

    // Instantiate Sunrise Label Method
    public void instantiateSunriseLabel(String sunrise_time) {
        if(sunrise_time == null) throw new NullPointerException("Sunrise Time cannot be null");
        else if(sunrise_time == null) throw new IllegalArgumentException("Sunrise Time cannot be empty");
        this.sunrise_label = this.current_factory.createSunriseLabel(sunrise_time);
    }

    // Instantiate Sunset Label Method
    public void instantiateSunsetLabel(String sunset_time) {
        if(sunset_time == null) throw new NullPointerException("Sunset Time cannot be null");
        else if(sunset_time.isEmpty()) throw new IllegalArgumentException("Sunset Time cannot be empty");
        this.sunset_label = this.current_factory.createSunriseLabel(sunset_time);
    }

    // Instantiate Sunrise HBox Wrapper Method
    public void instantiateSunriseHBox() {
        if(this.sunrise_stackpane == null || this.sunrise_label == null) throw new NullPointerException("Sunrise StackPane & Label cannot be null");
        this.sunrise_hbox = this.current_factory.createSunriseHBox(this.sunrise_stackpane, this.sunrise_label);
    }

    // Instantiate Sunset HBox Wrapper Method
    public void instantiateSunsetHBox() {
        if(this.sunset_stackpane == null || this.sunset_label == null) throw new NullPointerException("Sunset StackPane & Label cannot be null");
        this.sunset_hbox = this.current_factory.createSunsetHBox(this.sunset_stackpane, this.sunset_label);
    }

    // Instantiate Sunrise & Sunset VBox Wrapper Method
    public void instantiateSunriseSunsetVBox() {
        if(this.sunrise_hbox == null || this.sunset_hbox == null) throw new NullPointerException("Sunrise & Sunset HBox Wrappers cannot be null");
        this.sunrise_sunset_vbox = this.current_factory.createSunVBox(this.sunrise_hbox, this.sunset_hbox);
    }

    // Instantiate Current Weather HBox Wrapper
    public void instantiateCurrentWeatherHBox() {
        if(this.main_image_pane == null || this.main_temp_status_vbox == null || this.sunrise_sunset_vbox == null) {
            throw new NullPointerException("Main Image Pane & Main Temp Status VBox & Sunrise Sunset VBox cannot be null");
        }
        this.current_weather_hbox = this.current_factory.createCurrentUIHBox(this.main_image_pane, this.main_temp_status_vbox, this.sunrise_sunset_vbox);
    }

    // Instantiate Weather UI VBox Wrapper
    public void instantiateWeatherVBox() {
        if(this.pane_hbox == null || this.current_weather_hbox == null) throw new NullPointerException("Pane & Current Weather HBox cannot be null");
        else if(this.wrapper_factory == null) throw new NullPointerException("Wrapper Factory cannot be null");
        this.weather_ui_vbox = this.wrapper_factory.createUIVBox(this.current_weather_hbox, this.pane_hbox);
    }

}
