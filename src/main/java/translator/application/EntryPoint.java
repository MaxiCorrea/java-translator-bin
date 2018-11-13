package translator.application;

import translator.controller.ControllerImpl;
import translator.model.Translator;
import translator.view.ViewImpl;

public class EntryPoint {
    public static void main(String[] args) {
        Translator translator = new Translator();
        ViewImpl view = new ViewImpl();
        ControllerImpl controller = new ControllerImpl(translator, view);
        controller.start();
    }

}
