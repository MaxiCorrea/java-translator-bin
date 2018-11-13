package translator.application;

import translator.controller.Controller;
import translator.controller.ControllerImpl;
import translator.model.Translator;
import translator.view.View;
import translator.view.swing.ViewSwing;

public class EntryPoint {
    public static void main(String[] args) {
        Translator translator = new Translator();
        View view = new ViewSwing();
        Controller controller = new ControllerImpl(translator, view);
        controller.start();
    }

}
