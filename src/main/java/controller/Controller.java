package controller;
import model.Model;
import view.View;

public class Controller {

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

    public Controller(Model model, View view) {
        if(model == null || view == null) throw new NullPointerException("Model and View cannot be null");
        this.model = model;
        this.view = view;
    }


}
