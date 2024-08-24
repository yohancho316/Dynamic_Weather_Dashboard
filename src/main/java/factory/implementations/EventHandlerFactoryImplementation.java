package factory.implementations;

import factory.interfaces.EventHandlerFactory;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import model.Model;
import view.View;

public class EventHandlerFactoryImplementation implements EventHandlerFactory {

    // Class Fields
    private Model model;
    private View view;

    // Model Getter Method
    public Model getModel() {
        return this.model;
    }

    // Model Setter Method
    public void setModel(Model model) {
        if(model == null) throw new NullPointerException("Model cannot be null");
        this.model = model;
    }

    // View Getter Method
    public View getView() {
        return this.view;
    }

    // View Setter Method
    public void setView(View view) {
        if(view == null) throw new NullPointerException("View cannot be null");
        this.view = view;
    }

    // Event Handler Factory Implementation Constructor
    public EventHandlerFactoryImplementation(Model model, View view) {
        if(model == null || view == null) throw new NullPointerException("Model and View cannot be null");
        this.model = model;
        this.view = view;
    }

    // Search Event Handler Object Factory Concrete Definition
    @Override
    public EventHandler<MouseEvent> createSearchEventHandler() {

        // Instantiate EventHandler Object. Handles MouseEvent Types
        EventHandler<MouseEvent> searchEventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        };

        // Return Event Handler Object Reference
        return searchEventHandler;
    }
}
