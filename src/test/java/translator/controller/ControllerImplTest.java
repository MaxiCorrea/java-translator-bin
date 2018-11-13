package translator.controller;

import org.junit.Before;
import org.junit.Test;
import translator.model.Translator;
import translator.view.View;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ControllerImplTest implements View {

    private static boolean openMethodCalled;
    private static String inputText;
    private static String resultDisplayed;
    private static Translator model = new Translator();
    private ControllerImpl controller;

    @Before
    public void setUp() {
        openMethodCalled = false;
        inputText = null;
        resultDisplayed = null;
        View view = this;
        controller = new ControllerImpl(model, view);
    }

    @Test
    public void translateToBinaryAction() throws Exception {
        inputText = "Java";
        String expected = "01001010 01100001 01110110 01100001";
        controller.translateToBinaryAction();
        assertEquals(expected, resultDisplayed);
    }

    @Test
    public void translateToASCIIAction() throws Exception {
        inputText = "01001010 01100001 01110110 01100001";
        String expected = "Java";
        controller.translateToASCIIAction();
        assertEquals(expected, resultDisplayed);
    }

    @Test
    public void start() throws Exception {
        assertFalse(openMethodCalled);
        controller.start();
        assertTrue(openMethodCalled);
    }

    @Override
    public void setController(Controller controller) {}

    @Override
    public String getText() {
        return inputText;
    }

    @Override
    public void showResult(String result) {
        resultDisplayed = result;
    }

    @Override
    public void open() {
        openMethodCalled = true;
        assertTrue(resultDisplayed.isEmpty());
    }
}