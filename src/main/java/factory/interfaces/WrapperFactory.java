package factory.interfaces;

import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public interface WrapperFactory {

    // UI Wrapper VBox Properties
    double UI_VBOX_WIDTH = 1200.0;
    double UI_VBOX_HEIGHT = 200.0;
    double UI_VBOX_SPACING = 0.0;
    Insets UI_VBOX_PADDING = new Insets(0.0, 0.0, 0.0, 0.0);
    Pos UI_VBOX_ALIGNMENT = Pos.CENTER;

    // UI VBox Layout Wrapper Object Factory Method Signature
    VBox createUIVBox(HBox forecast_hbox, HBox current_hbox);
}
