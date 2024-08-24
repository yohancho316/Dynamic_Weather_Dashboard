package factory.interfaces;
import model.Model;
import view.View;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public interface EventHandlerFactory {

    // Search Event Handler Object Factory Method Signature
    public EventHandler<MouseEvent> createSearchEventHandler();



}
