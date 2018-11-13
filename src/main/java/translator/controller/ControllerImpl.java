package translator.controller;

import translator.model.Translator;
import translator.view.View;

public class ControllerImpl implements Controller {

    private Translator model;
    private View view;

    public ControllerImpl(Translator model, View view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    @Override
    public void translateToBinaryAction() {
        String text = view.getText();
        String result = model.translateToBinary(text);
        view.showResult(result);
    }

    @Override
    public void translateToASCIIAction() {
        String text = view.getText();
        String result = model.translateToASCII(text);
        view.showResult(result);
    }

    @Override
    public void start() {
        view.showResult("");
        view.open();
    }

}
