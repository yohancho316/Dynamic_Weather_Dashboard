package view;

import factory.implementations.CurrentForecastFactoryImplementation;
import factory.implementations.ForecastFactoryImplementation;
import factory.implementations.MenuFactoryImplementation;
import factory.implementations.WrapperFactoryImplementation;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class View {

    // View Class Members
    private static final String SUNRISE_IMAGE_PATH = "/icons8-sunrise-24.png";
    private static final String SUNSET_IMAGE_PATH = "/icons8-sunset-24.png";
    private ForecastFactoryImplementation future_factory;
    private CurrentForecastFactoryImplementation current_factory;
    private WrapperFactoryImplementation wrapper_factory;
    private MenuFactoryImplementation menu_factory;
    private ComboBox<Object> search_combobox;
    private HBox pane_hbox;
    private HBox sunrise_hbox;
    private HBox sunset_hbox;
    private HBox menu_hbox;
    private Label sunrise_label;
    private Label sunset_label;
    private Label temperature_label;
    private Label status_label;
    private List<BorderPane> borderPaneList;
    private ObservableList<Object> observableList;
    private Pane main_image_pane;
    private StackPane menu_icon_stackpane;
    private StackPane magnify_icon_stackpane;
    private StackPane sunrise_stackpane;
    private StackPane sunset_stackpane;
    private TextField city_text_field;
    private HBox current_weather_hbox;
    private VBox sunrise_sunset_vbox;
    private HBox city_search_hbox;
    private VBox weather_ui_vbox;
    private VBox main_temp_status_vbox;

    // Future Factory Getter Method
    public ForecastFactoryImplementation getFutureFactory() {
        return this.future_factory;
    }

    // Future Factory Setter Method
    public void setFutureFactory(ForecastFactoryImplementation future_factory) {
        if(future_factory == null) throw new NullPointerException("Future Factory cannot be null");
        this.future_factory = future_factory;
    }

    // Current Factory Getter Method
    public CurrentForecastFactoryImplementation getCurrentFactory() {
        return this.current_factory;
    }

    // Current Factory Setter Method
    public void setCurrentFactory(CurrentForecastFactoryImplementation current_factory) {
        if(current_factory == null) throw new NullPointerException("Current Factory cannot be null");
        this.current_factory = current_factory;
    }

    // Wrapper Factory Getter Method
    public WrapperFactoryImplementation getWrapperFactory() {
        return this.wrapper_factory;
    }

    // Wrapper Factory Setter Method
    public void setWrapperFactory(WrapperFactoryImplementation wrapper_factory) {
        if(wrapper_factory == null) throw new NullPointerException("Wrapper Factory cannot be null");
        this.wrapper_factory = wrapper_factory;
    }

    // Menu Factory Getter Method
    public MenuFactoryImplementation getMenuFactory() {
        return this.menu_factory;
    }

    // Menu Factory Setter Method
    public void setMenuFactory(MenuFactoryImplementation menu_factory) {
        if(menu_factory == null) throw new NullPointerException("Menu Factory cannot be null");
        this.menu_factory = menu_factory;
    }

    // BorderPane Collection Getter Method
    public List<BorderPane> getBorderPaneList() {
        return this.borderPaneList;
    }

    // BorderPane Collection Setter Method
    public void setBorderPaneList(List<BorderPane> borderPaneList) {
        if(borderPaneList == null) throw new NullPointerException("Border Pane List cannot be null");
        else if(borderPaneList.isEmpty()) throw new IllegalArgumentException("Border Pane List cannot be empty");
        this.borderPaneList = borderPaneList;
    }

    // Border Pane HBox Getter Method
    public HBox getBorderPaneHBox() {
        return this.pane_hbox;
    }

    // Border Pane HBox Setter Method
    public void setBorderPaneHBox(HBox pane_Hbox) {
        if(pane_hbox == null) throw new NullPointerException("Pane HBox cannot be null");
        this.pane_hbox = pane_hbox;
    }

    // Main Image Pane Getter Method
    public Pane getMainImagePane() {
        return this.main_image_pane;
    }

    // Main Image Pane Setter Method
    public void setMainImagePane(Pane main_image_pane) {
        if(main_image_pane == null) throw new NullPointerException("Main Image Pane cannot be null");
        this.main_image_pane = main_image_pane;
    }

    // Current Temperature Label Getter Method
    public Label getTemperatureLabel() {
        return this.temperature_label;
    }

    // Current Temperature Label Setter Method
    public void setTemperatureLabel(Label temperature_label) {
        if(temperature_label == null) throw new NullPointerException("Temperature Label cannot be null");
        else if(temperature_label.getText().isEmpty()) throw new IllegalArgumentException("Temperature Label cannot be empty");
        this.temperature_label = temperature_label;
    }

    // Current Status Label Getter Method
    public Label getStatusLabel() {
        return this.status_label;
    }

    // Current Status Label Setter Method
    public void setStatusLabel(Label status_label) {
        if(status_label == null) throw new NullPointerException("Status Label cannot be null");
        else if(status_label.getText().isEmpty()) throw new IllegalArgumentException("Status Label cannot be empty");
        this.status_label = status_label;
    }

    // Temperature & Status VBox Getter Method
    public VBox getTempStatusVBox() {
        return this.main_temp_status_vbox;
    }

    // Temperature & Status VBox Setter Method
    public void setTempStatusVBox(VBox main_temp_status_vbox) {
        if(main_temp_status_vbox == null) throw new NullPointerException("Main Temp Status VBox cannot be null");
        this.main_temp_status_vbox = main_temp_status_vbox;
    }

    // Menu Icon StackPane Getter Method
    public StackPane getMenuIconStackPane() {
        return this.menu_icon_stackpane;
    }

    // Menu Icon StackPane Setter Method
    public void setMenuIconStackPane(StackPane menu_icon_stackpane) {
        if(menu_icon_stackpane == null) throw new NullPointerException("Menu Icon Stackpane cannot be null");
        this.menu_icon_stackpane = menu_icon_stackpane;
    }

    // Sunrise StackPane Getter Method
    public StackPane getSunriseStackPane() {
        return this.sunrise_stackpane;
    }

    // Sunrise StackPane Setter Method
    public void setSunriseStackPane(StackPane sunrise_stackpane) {
        if(sunrise_stackpane == null) throw new NullPointerException("Sunrise StackPane cannot be null");
        this.sunrise_stackpane = sunrise_stackpane;
    }

    // Sunset StackPane Getter Method
    public StackPane getSunsetStackPane() { return this.sunset_stackpane; }

    // Sunset StackPane Setter Method
    public void setSunsetStackPane(StackPane sunset_stackpane) {
        if(sunset_stackpane == null) throw new NullPointerException("Sunset StackPane cannot be null");
        this.sunset_stackpane = sunset_stackpane;
    }

    // Sunrise Label Getter Method
    public Label getSunriseLabel() { return this.sunrise_label; }

    // Sunrise Label Setter Method
    public void setSunriseLabel(Label sunrise_label) {
        if(sunrise_label == null) throw new NullPointerException("Sunrise Label cannot be null");
        else if(sunrise_label.getText().isEmpty()) throw new IllegalArgumentException("Sunrise Label cannot be empty");
        this.sunrise_label = sunrise_label;
    }

    // Sunset Label Getter Method
    public Label getSunsetLabel() { return this.sunset_label; }

    // Sunset Label Setter Method
    public void setSunsetLabel(Label sunset_label) {
        if(sunset_label == null) throw new NullPointerException("Sunset Label cannot be null");
        else if(sunset_label.getText().isEmpty()) throw new IllegalArgumentException("Sunset Label cannot be empty");
        this.sunset_label = sunset_label;
    }

    // Sunrise HBox Getter Method
    public HBox getSunriseHBox() { return this.sunrise_hbox; }

    // Sunrise HBox Setter Method
    public void setSunriseHBox(HBox sunrise_hbox) {
        if(sunrise_hbox == null) throw new NullPointerException("Sunrise HBox cannot be null");
        this.sunrise_hbox = sunrise_hbox;
    }

    // Sunset HBox Getter Method
    public HBox getSunsetHBox() { return this.sunset_hbox; }

    // Sunset HBox Setter Method
    public void setSunsetHBox(HBox sunset_hbox) {
        if(sunset_hbox == null) throw new NullPointerException("Sunset HBox cannot be null");
        this.sunset_hbox = sunset_hbox;
    }

    // Sunrise & Sunset VBox Getter Method
    public VBox getSunriseSunsetVBox() {
        return this.sunrise_sunset_vbox;
    }

    // Sunrise & Sunset VBox Setter Method
    public void setSunriseSunsetVBox(VBox sunrise_sunset_vbox) {
        if(sunrise_sunset_vbox == null) throw new NullPointerException("Sunrise Sunset VBox cannot be null");
        this.sunrise_sunset_vbox = sunrise_sunset_vbox;
    }

    // Weather UI VBox Getter Method
    public VBox getWeatherUIVBox() {
        return this.weather_ui_vbox;
    }

    // Weather UI VBox Setter Method
    public void setWeatherUIVBox(VBox weather_ui_vbox) {
        if(weather_ui_vbox == null) throw new NullPointerException("Weather UI VBox cannot be null");
        this.weather_ui_vbox = weather_ui_vbox;
    }

    // City Text Field Getter Method
    public TextField getCitySearchTextField() {
        return this.city_text_field;
    }

    // City Text Field Setter Method
    public void setCitySearchTextField(TextField city_text_field) {
        if(city_text_field == null) throw new NullPointerException("TextField cannot be null");
        this.city_text_field = city_text_field;
    }

    // Magnify Icon StackPane Getter Method
    public StackPane getMagnifyIconStackPane() {
        return this.magnify_icon_stackpane;
    }

    // Magnify Icon StackPane Setter Method
    public void setMagnifyIconStackPane(StackPane magnify_icon_stackpane) {
        if(magnify_icon_stackpane == null) throw new NullPointerException("Magnify Icon StackPane cannot be null");
        this.magnify_icon_stackpane = magnify_icon_stackpane;
    }

    // Menu ObservableList Getter Method
    public ObservableList<Object> getObservableList() {
        return this.observableList;
    }

    // Menu ObservableList Setter Method
    public void setObservableList(ObservableList<Object> observableList) {
        if(observableList == null) throw new NullPointerException("Observable List cannot be null");
        this.observableList = observableList;
    }

    // City Search HBox Getter Method
    public HBox getCitySearchHBox() {
        return this.city_search_hbox;
    }

    // City Search HBox Setter Method
    public void setCitySearchHBox(HBox city_search_hbox) {
        if(city_search_hbox == null) throw new NullPointerException("City Search HBox cannot be null");
        this.city_search_hbox = city_search_hbox;
    }

    // Search ComboBox Getter Method
    public ComboBox<Object> getSearchComboBox() {
        return this.search_combobox;
    }

    // Search ComboBox Setter Method
    public void setSearchComboBox(ComboBox<Object> search_combobox) {
        if(search_combobox == null) throw new NullPointerException("Search ComboBox cannot be null");
        this.search_combobox = search_combobox;
    }

    // Menu HBox Getter Method
    public HBox getMenuHBox() {
        return this.menu_hbox;
    }

    // Menu HBox Setter Method
    public void setMenuHBox(HBox menu_hbox) {
        if(menu_hbox == null) throw new NullPointerException("Menu HBox cannot be null");
        this.menu_hbox = menu_hbox;
    }

    public View(ForecastFactoryImplementation future_factory,
                CurrentForecastFactoryImplementation current_factory,
                WrapperFactoryImplementation wrapper_factory,
                MenuFactoryImplementation menu_factory,
                List<String> pane_image_collection,
                List<String> pane_temp_collection,
                List<String> pane_date_collection,
                List<String> pane_time_collection,
                String main_image,
                String main_temp,
                String main_status,
                String sunrise_time,
                String sunset_time,
                LocalDateTime currentDate,
                LocalTime currentTime) {

        // Instantiate Forecast Factory Node
        this.instantiateForecastFactory(future_factory);

        // Instantiate Current Forecast Factory Node
        this.instantiateCurrentFactory(current_factory);

        // Instantiate Wrapper Factory Node
        this.instantiateWrapperFactory(wrapper_factory);

        // Instantiate Menu Factory Node
        this.instantiateMenuFactory(menu_factory);

        // Instantiate Menu Icon StackPane Wrapper
        this.instantiateMenuStackPane();

        // Instantiate City Search TextField Control Node
        this.instantiateCitySearchTextField();

        // Instantiate Magnify Icon StackPane Wrapper
        this.instantiateMagnifyIconStackPane();

        // Instantiate City Search HBox Wrapper
        this.instantiateCitySearchHBox();

        // Instantiate Search ObservableList Collection
        this.instantiateCityObservableList();

        // Instantiate Search ComboBox Control Node-
        this.instantiateSearchComboBox();

        // Instantiate Menu HBox Wrapper
        this.instantiateMenuHBox();

        // Instantiate BorderPane Collection
        this.instantiateBorderPaneList();

        // Populate BorderPane Collection
        this.populateBorderPaneList(pane_image_collection, pane_temp_collection, pane_date_collection, pane_time_collection, currentDate, currentTime);

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

    // Instantiate Menu Factory Method
    public void instantiateMenuFactory(MenuFactoryImplementation menu_factory) {
        if(menu_factory == null) throw new NullPointerException("Menu Factory cannot be null");
        this.menu_factory = menu_factory;
    }

    // Instantiate Menu Icon StackPane Wrapper Method
    public void instantiateMenuStackPane() {
        this.menu_icon_stackpane = this.menu_factory.createMenuStackPane();
    }

    // Instantiate Border Pane List Method
    public void instantiateBorderPaneList() {
        this.borderPaneList = new ArrayList<BorderPane>();
    }

    // Populate Border Pane List Method
    public void populateBorderPaneList(List<String> pane_image_collection, List<String> pane_temp_collection, List<String> pane_date_collection, List<String> pane_time_collection, LocalDateTime currentDate, LocalTime currentTime) {

        // Check For Null Parameters
        if(pane_image_collection == null || pane_temp_collection == null || pane_date_collection == null || pane_time_collection == null) {
            throw new NullPointerException("Populate Border Pane List Parameters cannot be null");
        }

        // Check for Empty Collections
        if(pane_image_collection.isEmpty() || pane_temp_collection.isEmpty() || pane_date_collection.isEmpty() || pane_time_collection.isEmpty()) {
            throw new IllegalArgumentException("Populate Border Pane List Parameter Collections cannot be empty");
        }

        for(int i = 0; i < 10; i++) {

            // Instantiate Border Pane Image
            Pane image_pane = this.instantiatePaneImage(pane_image_collection.get(i));

            // Instantiate Future Temp Label
            Label temp_label = this.instantiateFutureTempLabel(pane_temp_collection.get(i));

            // Instantiate Future Time Label
            Label date_label = this.instantiateDateLabel(currentDate, pane_date_collection.get(i));

            // Instantiate Future Date Label
            Label time_label = this.instantiateTimeLabel(currentTime, pane_time_collection.get(i));

            // Instantiate Date/Time VBox Wrapper
            VBox date_time_vbox = this.instantiate_date_time_vbox(date_label, temp_label, time_label);

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

    // Instantiate Forecast Temperature Label Method
    public Label instantiateFutureTempLabel(String currentTemp) {
        if(currentTemp == null) throw new NullPointerException("Forecast Temp cannot be null");
        return future_factory.createTempLabel(currentTemp);
    }

    // Instantiate Date Label Method
    public Label instantiateDateLabel(LocalDateTime currentDateTime, String date) {
        if(currentDateTime == null) throw new NullPointerException("Current Date Time cannot be null");
        else if(currentDateTime.isBefore(currentDateTime.minusDays(1))) throw new IllegalArgumentException("Current Date Time must be current day");
        return this.future_factory.createDateLabel(date);
    }

    // Instantiate Time Label Method
    public Label instantiateTimeLabel(LocalTime currentTime, String time) {
        if(currentTime == null) throw new NullPointerException("Current Time cannot be null");
        if(time == null) throw new NullPointerException("Time cannot be null");
        if(time.isEmpty()) throw new IllegalArgumentException("Time cannot be empty");
        return this.future_factory.createTimeLabel(time);
    }

    // Instantiate Date/Time VBox Wrapper Method
    public VBox instantiate_date_time_vbox(Label date, Label temp, Label time) {
        if(temp == null || date == null || time == null) throw new NullPointerException("Date & Label cannot be null");
        else if(temp.getText().isEmpty() || date.getText().isEmpty() || time.getText().isEmpty()) throw new IllegalArgumentException("Temp & Date & Time cannot be empty");
        return this.future_factory.createVBoxLayout(temp, time, date);
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
        this.sunset_label = this.current_factory.createSunsetLabel(sunset_time);
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
        this.weather_ui_vbox = this.wrapper_factory.createUIVBox(this.menu_hbox, this.current_weather_hbox, this.pane_hbox);
    }

    // Instantiate City Search TextField Control Node
    public void instantiateCitySearchTextField() {
        this.city_text_field = this.menu_factory.createSearchTextField();
    }

    // Instantiate Magnify Icon StackPane Wrapper
    public void instantiateMagnifyIconStackPane() {
        this.magnify_icon_stackpane = this.menu_factory.createMagnifyStackPane();
    }

    // Instantiate City Search HBox Wrapper
    public void instantiateCitySearchHBox() {
        if(this.city_text_field == null || this.magnify_icon_stackpane == null) throw new NullPointerException("City TextField & Magnify Icon StackPane cannot be null");
        this.city_search_hbox = this.menu_factory.createSearchHBox(this.city_text_field, this.magnify_icon_stackpane);
    }

    // Instantiate City Search ObservableList Collection
    public void instantiateCityObservableList() {
        if(this.city_search_hbox == null) throw new NullPointerException("City Search HBox cannot be null");
        this.observableList = this.menu_factory.createObservableList(this.city_search_hbox);
    }

    // Instantiate City Search ComboBox Control Node
    public void instantiateSearchComboBox() {
        if(this.observableList == null) throw new NullPointerException("ObservableList cannot be null");
        else if(this.observableList.isEmpty()) throw new IllegalArgumentException("ObservableList cannot be empty");
        this.search_combobox = this.menu_factory.createComboBox(this.observableList);
    }

    // Instantiate Menu HBox Wrapper
    public void instantiateMenuHBox() {
        if(this.menu_icon_stackpane == null || this.search_combobox == null) throw new NullPointerException("Menu Icon StackPane & Search ComboBox cannnot be null");
        this.menu_hbox = this.menu_factory.createMenuHBox(this.menu_icon_stackpane, this.search_combobox);
    }

    // Instantiate City Label
    public Label instantiateCityLabel(String city) {
        if(city == null) throw new NullPointerException("String object cannot be null");
        else if(city.isEmpty()) throw new IllegalArgumentException("String object cannot be empty");
        return this.menu_factory.createCityLabel(city);
    }

}
