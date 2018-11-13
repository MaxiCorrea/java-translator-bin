package translator.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TranslatorTest {

    private Translator translator;

    @Before
    public void setUp() throws Exception {
        translator = new Translator();
    }

    @Test
    public void translateToBinary() throws Exception {
        String expected = "01001101 01100001 01111000 01101001";
        String asciiText = "Maxi";
        String actual = translator.translateToBinary(asciiText);
        assertEquals(expected, actual);
    }

    @Test
    public void removeInvalidCharacters() throws Exception {
        String original = "01001101 01100001 01111000 01101001";
        String expected = "01001101011000010111100001101001";
        String actual = translator.removeInvalidCharacters(original);
        assertEquals(expected, actual);
    }

    @Test
    public void translateToASCII() throws Exception {
        String expected = "Maxi";
        String binText = "01001101 01100001 01111000 01101001";
        String actual = translator.translateToASCII(binText);
        assertEquals(expected, actual);
    }

    @Test
    public void fillWithZeros() throws Exception {
        String original = "1001101";
        String expected = "01001101";
        String actual = translator.fillWithZeros(original);
        assertEquals(expected, actual);
    }

}