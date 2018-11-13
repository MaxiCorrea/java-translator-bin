package translator.view.console;

import translator.controller.Controller;
import translator.view.View;

public class ConsoleView implements View {

    private static final String TITLE_APP = "\tTranslation of Binary to Text\n";
    private static final String DEVELOPER = "Developer: Maximiliano Correa";
    private static final String EMAIL = "Email: jmaxicorrea@gmail.com";
    private static final String GITHUB = "Github: https://github.com/MaxiCorrea";
    private static final String ERR_MSG = "Invalid Option";
    private static final String READ_BIN_TITLE = "";
    private static final String READ_TEXT_TITLE = "";

    private Printer printer;
    private Reader reader;
    private Controller controller;
    private String inputText;
    private boolean running = true;

    public ConsoleView() {
        this(new Printer(), new Reader());
    }

    ConsoleView(Printer printer, Reader reader) {
        this.printer = printer;
        this.reader = reader;
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public String getText() {
        return inputText;
    }

    @Override
    public void showResult(String result) {
        printer.println(result);
    }

    @Override
    public void open() {
        printer.println(TITLE_APP);
        startLoop();
    }

    private void startLoop() {
        while(running) {
            showOperation();
            int option = reader.readInt();
            processOption(option);
        }
        closeApp();
    }

    private void closeApp() {
        printer.println("Exit");
        reader.close();
        printer.close();
        System.exit(0);
    }

    private void showOperation() {
        printer.println("\nSelect an option from the menu.");
        printer.println("1) Transform from text to binary.");
        printer.println("2) Transform from binary to text.");
        printer.println("3) About the Developer.");
        printer.println("4) Exit application.");
        printer.print(" ? -> ");
    }

    private void processOption(int option) {
        if(option == 4) {
            running = false;
            return;
        }
        if(option == 3) {
            showAbout();
            return;
        }
        if(option == 2) {
            inputText = read(READ_BIN_TITLE);
            controller.translateToASCIIAction();
            return;
        }
        if(option == 1) {
            inputText = read(READ_TEXT_TITLE);
            controller.translateToBinaryAction();
        } else {
            printer.printErr(ERR_MSG);
        }

    }

    private void showAbout() {
        printer.println(DEVELOPER);
        printer.println(EMAIL);
        printer.println(GITHUB);
    }

    private String read(String title) {
        printer.println(title);
        return reader.readString();
    }

}
