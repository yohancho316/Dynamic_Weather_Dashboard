package factory.implementations;

import factory.interfaces.MenuFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class MenuFactoryImplementation implements MenuFactory {

    // Menu HBox Object Factory Concrete Definition
    @Override
    public HBox createMenuHBox(StackPane menuStackPane, ComboBox<Object> comboBox) {

        // Check for Null Parameters
        if(menuStackPane == null || comboBox == null) throw new NullPointerException("Menu StackPane & ComboBox cannot be null");

        // Instantiate Menu HBox Wrapper
        HBox menuHBox = new HBox();

        // Configure Menu HBox Width
        menuHBox.setMinWidth(this.MENU_WIDTH);
        menuHBox.setMaxWidth(this.MENU_WIDTH);
        menuHBox.setPrefWidth(this.MENU_WIDTH);

        // Configure Menu HBox Height
        menuHBox.setMinHeight(this.MENU_HEIGHT);
        menuHBox.setMaxHeight(this.MENU_HEIGHT);
        menuHBox.setPrefHeight(this.MENU_HEIGHT);

        // Configure HBox Properties
        menuHBox.setSpacing(this.MENU_SPACING);
        menuHBox.setAlignment(this.MENU_ALIGNMENT_POSITION);
        menuHBox.setPadding(this.MENU_PADDING);

        // Configure Background of ImageView
        BackgroundFill menuBackgroundFill = new BackgroundFill(this.MENU_RGB, null, null);
        Background menuBackground = new Background(menuBackgroundFill);
        menuHBox.setBackground(menuBackground);

        // Return Menu HBox Reference
        return menuHBox;
    }

    // Search HBox Object Factory Concrete Definition
    @Override
    public HBox createSearchHBox(TextField textField, StackPane magnifyStackPane) {

        // Check for Null Parameters
        if(textField == null || magnifyStackPane == null) throw new NullPointerException("Text Field & Magnify StackPane cannot be null");

        // Instantiate Search HBox Wrapper
        HBox search_hbox = new HBox();

        // Configure Search HBox Width
        search_hbox.setMinWidth(this.SEARCH_WIDTH);
        search_hbox.setMaxWidth(this.SEARCH_WIDTH);
        search_hbox.setPrefWidth(this.SEARCH_WIDTH);

        // Configure Search HBox Height
        search_hbox.setMinHeight(this.SEARCH_HEIGHT);
        search_hbox.setMaxHeight(this.SEARCH_HEIGHT);
        search_hbox.setPrefHeight(this.SEARCH_HEIGHT);

        // Configure Search HBox Properties
        search_hbox.setSpacing(this.SEARCH_SPACING);
        search_hbox.setAlignment(this.SEARCH_ALIGNMENT_POSITION);
        search_hbox.setPadding(this.SEARCH_PADDING);

        // Configure Background of Search HBox
        BackgroundFill searchBackgroundFill = new BackgroundFill(this.SEARCH_RGB, null, null);
        Background searchBackground = new Background(searchBackgroundFill);
        search_hbox.setBackground(searchBackground);

        // Add TextField & StackPane Node to HBox Wrapper
        search_hbox.getChildren().addAll(textField, magnifyStackPane);

        // Return Search HBox Reference
        return search_hbox;
    }

    // Menu Icon StackPane Object Factory Concrete Definition
    @Override
    public StackPane createMenuStackPane() {

        // Instantiate Menu Icon Image Node
        Image menu_image = new Image(getClass().getResourceAsStream(this.MENU_IMAGE_PATH),
                this.MENU_ICON_WIDTH,
                this.MENU_ICON_HEIGHT,
                this.MENU_ICON_RATIO,
                this.MENU_ICON_SMOOTHING);

        // Check for Menu Icon Loading Failure
        if(menu_image.isError()) {
            throw new IllegalArgumentException("Menu Image URL Loading Failure: Incorrect URL");
        }

        // Instantiate ImageView Node
        ImageView menuImageView = new ImageView(menu_image);

        // Configure ImageView Node
        menuImageView.setFitWidth(MENU_ICON_WIDTH);
        menuImageView.setFitHeight(MENU_ICON_HEIGHT);

        // Wrap the ImageView in a StackPane
        StackPane menuStackPane = new StackPane(menuImageView);

        // Configure Menu Stack Pane
        menuStackPane.setPrefSize(MENU_ICON_WIDTH, MENU_ICON_HEIGHT);
        menuStackPane.setPadding(MENU_ICON_PADDING);
        menuStackPane.setAlignment(MENU_ICON_ALIGNMENT_POSITION);

        // Configure Background of ImageView
        BackgroundFill menuBackgroundFill = new BackgroundFill(this.MENU_RGB, null, null);
        Background menuBackground = new Background(menuBackgroundFill);
        menuStackPane.setBackground(menuBackground);

        // Return Menu StackPane Reference
        return menuStackPane;
    }

    // Search TextField Object Factory Concrete Definition
    @Override
    public TextField createSearchTextField() {

        // Instantiate TextField Control Node
        TextField searchField = new TextField();

        // Prompt User to Enter Name of City
        searchField.setPromptText(this.TEXT_FIELD_PROMPT);

        // Configure Text Field Width
        searchField.setMinWidth(this.TEXT_FIELD_WIDTH);
        searchField.setMaxWidth(this.TEXT_FIELD_WIDTH);
        searchField.setPrefWidth(this.TEXT_FIELD_WIDTH);

        // Configure Text Field Height
        searchField.setMinHeight(this.TEXT_FIELD_HEIGHT);
        searchField.setMaxHeight(this.TEXT_FIELD_HEIGHT);
        searchField.setPrefHeight(this.TEXT_FIELD_HEIGHT);

        // Configure City Text Field Node
        searchField.setAlignment(this.TEXT_FIELD_ALIGNMENT);
        searchField.setEditable(this.TEXT_FIELD_EDITABLE);
        searchField.setPadding(this.TEXT_FIELD_PADDING);

        // Configure Background of City Text Field
        BackgroundFill textFieldBackgroundFill = new BackgroundFill(this.TEXT_FIELD_RGB, null, null);
        Background textFieldBackground = new Background(textFieldBackgroundFill);
        searchField.setBackground(textFieldBackground);

        // Return Search Text Field Reference
        return searchField;
    }

    // Magnify Icon StackPane Object Factory Concrete Definition
    @Override
    public StackPane createMagnifyStackPane() {

        // Instantiate Menu Icon Image Node
        Image magnify_image = new Image(getClass().getResourceAsStream(this.MAGNIFY_ICON_PATH),
                this.MAGNIFY_ICON_WIDTH,
                this.MAGNIFY_ICON_HEIGHT,
                this.MAGNIFY_ICON_RATIO,
                this.MAGNIFY_ICON_SMOOTHING);

        // Check for Menu Icon Loading Failure
        if(magnify_image.isError()) {
            throw new IllegalArgumentException("Magnify Image URL Loading Failure: Incorrect URL");
        }

        // Instantiate ImageView Node
        ImageView magnifyImageView = new ImageView(magnify_image);

        // Configure ImageView Node
        magnifyImageView.setFitWidth(this.MAGNIFY_ICON_WIDTH);
        magnifyImageView.setFitHeight(this.MAGNIFY_ICON_HEIGHT);

        // Wrap the ImageView in a StackPane
        StackPane magnifyStackPane = new StackPane(magnifyImageView);

        // Configure Menu Stack Pane
        magnifyStackPane.setPrefSize(this.MAGNIFY_ICON_WIDTH, this.MAGNIFY_ICON_HEIGHT);
        magnifyStackPane.setPadding(this.MAGNIFY_ICON_PADDING);
        magnifyStackPane.setAlignment(this.MAGNIFY_ICON_ALIGNMENT_POSITION);

        // Configure Background of Search HBox
        BackgroundFill magnifyBackgroundFill = new BackgroundFill(this.MAGNIFY_RGB, null, null);
        Background magnifyBackground = new Background(magnifyBackgroundFill);
        magnifyStackPane.setBackground(magnifyBackground);

        // Return Magnify Icon StackPane Reference
        return magnifyStackPane;
    }

    // City Label Object Factory Concrete Definition
    @Override
    public Label createCityLabel(String city_str) {

        // Check Parameter isn't Null
        if(city_str == null) throw new NullPointerException("City String cannot be null");

        // Check Parameter isn't Empty
        else if(city_str.isEmpty()) throw new IllegalArgumentException("City String cannot be empty");

        // Instantiate City Label
        Label city_label = new Label();

        // Pass Text to City Label
        city_label.setText(city_str);

        // Configure Width of City Label
        city_label.setMinWidth(this.CITY_LABEL_WIDTH);
        city_label.setMaxWidth(this.CITY_LABEL_WIDTH);
        city_label.setPrefWidth(this.CITY_LABEL_WIDTH);

        // Configure Height of City Label
        city_label.setMinHeight(this.CITY_LABEL_HEIGHT);
        city_label.setMaxHeight(this.CITY_LABEL_HEIGHT);
        city_label.setPrefHeight(this.CITY_LABEL_HEIGHT);

        // Configure City Label
        city_label.setAlignment(this.CITY_LABEL_ALIGNMENT_POSITION);
        city_label.setPadding(this.CITY_LABEL_PADDING);

        // Configure Background of Search HBox
        BackgroundFill cityFieldBackgroundFill = new BackgroundFill(this.CITY_FIELD_RGB, null, null);
        Background cityFieldBackground = new Background(cityFieldBackgroundFill);
        city_label.setBackground(cityFieldBackground);

        // Return City Label Reference
        return city_label;
    }

    // ObservableList Object Factory Concrete Definition
    @Override
    public ObservableList<Object> createObservableList(HBox searchHBox) {

        // Check for Null Parameters
        if(searchHBox == null) throw new NullPointerException("HBox cannot be null");

        // Instantiate ObservableList Collection
        ObservableList<Object> observableList = FXCollections.observableArrayList();

        // Add HBox within ObservableList
        observableList.addAll(searchHBox);

        // Return ObservableList Reference
        return observableList;
    }

    // ComboBox Object Factory Concrete Definition
    @Override
    public ComboBox createComboBox(ObservableList<Object> observableList) {

        // Check for Null Parameters
        if(observableList == null) throw new NullPointerException("Observable List cannot be null");

        // Instantiate a ComboBox that Stores Generic Object Type Nodes
        ComboBox<Object> menuComboBox = new ComboBox<Object>();

        // Configure the Menu ComboBox Prompt
        menuComboBox.setPromptText("Search for a City");

        // Populate ComboBox Options w/ ObservableList Members
        menuComboBox.setItems(observableList);

        // Configure Width of ComboBox
        menuComboBox.setMinWidth(this.COMBOBOX_WIDTH);
        menuComboBox.setMaxWidth(this.COMBOBOX_WIDTH);
        menuComboBox.setPrefWidth(this.COMBOBOX_WIDTH);

        // Configure Height of ComboBox
        menuComboBox.setMinHeight(this.COMBOBOX_HEIGHT);
        menuComboBox.setMaxHeight(this.COMBOBOX_HEIGHT);
        menuComboBox.setPrefHeight(this.COMBOBOX_HEIGHT);

        // Return ComboBox Node Reference
        return menuComboBox;
    }

}
