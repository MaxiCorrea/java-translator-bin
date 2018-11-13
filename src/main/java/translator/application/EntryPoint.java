package translator.application;

import translator.controller.Controller;
import translator.controller.ControllerImpl;
import translator.model.Translator;
import translator.view.View;
import translator.view.console.ConsoleView;
import translator.view.swing.SwingView;

public class EntryPoint {
    public static void main(String[] args) {
        Translator translator = new Translator();
        View view = selectViewFromCommandLine(args);
        Controller controller = new ControllerImpl(translator, view);
        controller.start();
    }

    private static View selectViewFromCommandLine(String... args) {
        if(args.length > 0 ) {
            String arg = args[0];
            if(arg.equals("-c")) {
                return new ConsoleView();
            }
            if(arg.equals("-s")) {
                return new SwingView();
            }
        }
        return new SwingView();
    }

}
