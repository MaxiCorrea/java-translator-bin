package translator.view;

import translator.controller.Controller;

public interface View {

    void setController(Controller controller);

    String getText();

    void showResult(String result);

    void open();
}
