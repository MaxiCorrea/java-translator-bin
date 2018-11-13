package translator.view.console;

import java.io.PrintStream;

class Printer {

    private PrintStream printStream;
    private PrintStream printError;

    Printer() {
        printStream = new PrintStream(System.out);
        printError = new PrintStream(System.err);
    }

    void println(String str) {
        printStream.println(str);
    }

    void print(String str) {
        printStream.print(str);
    }

    void printErr(String errMessage) {
        printError.println(errMessage);
    }

    void close() {
        printStream.close();
        printError.close();
    }

}
