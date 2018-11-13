package translator.application;

import translator.controller.ControllerImpl;
import translator.model.Translator;
import translator.view.swing.ViewSwing;

public class EntryPoint {
    public static void main(String[] args) {
        Translator translator = new Translator();
        ViewSwing view = new ViewSwing();
        ControllerImpl controller = new ControllerImpl(translator, view);
        controller.start();
    }

}
