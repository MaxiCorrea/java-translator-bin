package translator.view;

import translator.controller.Controller;

public class ViewImpl implements View {

    private Controller controller;

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public void showResult(String result) {

    }

    @Override
    public void open() {

    }

}