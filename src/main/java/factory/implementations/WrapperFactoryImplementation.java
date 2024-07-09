package factory.implementations;

import factory.interfaces.WrapperFactory;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class WrapperFactoryImplementation implements WrapperFactory {

    @Override
    public VBox createUIVBox(HBox forecast_hbox, HBox current_hbox) {

        // Check if Forecast or Current HBox is Null
        if(forecast_hbox.equals(null) || current_hbox.equals(null)) throw new NullPointerException("Forecast or Current HBox cannot be null");

        // Instantiate VBox UI Layout Wrapper Node
        VBox vbox = new VBox();

        // Configure VBox Layout Wrapper Width
        vbox.setPrefWidth(this.UI_VBOX_WIDTH);

        // Configure VBox Layout Wrapper Height
        vbox.setPrefHeight(this.UI_VBOX_HEIGHT);

        // Configure VBox Spacing
        vbox.setSpacing(this.UI_VBOX_SPACING);

        // Configure VBox Alignment
        vbox.setAlignment(this.UI_VBOX_ALIGNMENT);

        // Configure VBox Padding
        vbox.setPadding(this.UI_VBOX_PADDING);

        // Add Forecast & Current HBox within UI VBox Wrapper
        vbox.getChildren().addAll(forecast_hbox, current_hbox);

        // Return VBox Layout Wrapper Node
        return vbox;
    }
}
