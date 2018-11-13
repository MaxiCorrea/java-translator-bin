package translator.view.console;

import java.util.Scanner;

class Reader {

    private Scanner scanner;

    Reader() {
        scanner = new Scanner(System.in);
        scanner.useDelimiter("[\n]");
    }

    int readInt() {
        return scanner.nextInt();
    }

    String readString() {
        return scanner.next();
    }

    void close() {
        scanner.close();
    }

}
