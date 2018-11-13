package translator.model;

import static java.lang.Integer.toBinaryString;
import static java.lang.Integer.parseInt;

public class Translator {

    private static final char ONE = '1';
    private static final char ZERO = '0';

    public String translateToBinary(String text) {
        StringBuilder result = new StringBuilder();
        for (char character : text.toCharArray()) {
            String binStr = toBinaryString(character);
            result.append(fillWithZeros(binStr)).append(" ");
        }
        return result.toString().trim();
    }

    String fillWithZeros(String str) {
        if (str.length() < 8) {
            StringBuilder zeros = new StringBuilder();
            for (int i = str.length(); i < 8; ++i) {
                zeros.append('0');
            }
            return zeros.append(str).toString();
        }
        return str;
    }

    public String translateToASCII(String text) {
        StringBuilder result = new StringBuilder();
        text = removeInvalidCharacters(text);
        for (int i = 0; i < text.length() / 8; ++i) {
            String substring = text.substring(8 * i, (i + 1) * 8);
            result.append((char) parseInt(substring, 2));
        }
        return result.toString().trim();
    }

    String removeInvalidCharacters(String text) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (isZeroOrOne(c)) {
                result.append(c);
            }
        }
        return result.toString();
    }

    private boolean isZeroOrOne(char c) {
        return (c == ZERO) || (c == ONE);
    }

}
