package factory.implementations;

import factory.interfaces.MenuFactory;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
        BackgroundFill menuBackgroundFill = new BackgroundFill(this.menuRGB, null, null);
        Background menuBackground = new Background(menuBackgroundFill);
        menuHBox.setBackground(menuBackground);

        // Return Menu HBox Reference
        return menuHBox;
    }

    // Search HBox Object Factory Concrete Definition
    @Override
    public HBox createSearchHBox(TextField textField, StackPane magnifyStackPane) {

        // Check for Null Parameters

        return null;
    }

    // Menu Icon StackPane Object Factory Concrete Definition
    @Override
    public StackPane createMenuStackPane() {

        // Check for Null Parameters

        return null;
    }

    // Search TextField Object Factory Concrete Definition
    @Override
    public TextField createSearchTextField() {

        // Check for Null Parameters

        return null;
    }

    // Magnify Icon StackPane Object Factory Concrete Definition
    @Override
    public StackPane createMagnifyStackPane() {

        // Check for Null Parameters

        return null;
    }

    // City Label Object Factory Concrete Definition
    @Override
    public Label createCityLabel(String city) {

        // Check for Null Parameters

        return null;
    }
}
