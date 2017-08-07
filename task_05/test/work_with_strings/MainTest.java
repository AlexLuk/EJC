package work_with_strings;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void getMaxSymbolSequence() throws Exception {
        Main main = new Main();
        int count = 4;
        String testString = "aaaa";
        assertEquals(count, main.getMaxSymbolSequence(testString));

        count = 7;
        testString = "bbbbbbbaaaaa";
        assertEquals(count, main.getMaxSymbolSequence(testString));

        count = 3;
        testString = "bbaabbccc";
        assertEquals(count, main.getMaxSymbolSequence(testString));

        count = 1;
        testString = "abababababab";
        assertEquals(count, main.getMaxSymbolSequence(testString));

        count = 0;
        testString = "000000011213134";
        assertEquals(count, main.getMaxSymbolSequence(testString));

        count = 4;
        testString = "aaa000bb00bb00cccc";
        assertEquals(count, main.getMaxSymbolSequence(testString));

        count = 0;
        testString = new String();
        assertEquals(count, main.getMaxSymbolSequence(testString));

        count = 0;
        testString = null;
        assertEquals(count, main.getMaxSymbolSequence(testString));
    }

    @Test
    public void countUniqueSymbols() throws Exception {
        Main main = new Main();
        int count = 1;
        String testString = "aaaa";
        assertEquals(count, main.countUniqueSymbols(testString));

        count = 4;
        testString = "abcd";
        assertEquals(count, main.countUniqueSymbols(testString));

        count = 1;
        testString = "aa11aa";
        assertEquals(count, main.countUniqueSymbols(testString));

        count = 2;
        testString = "aa11qa";
        assertEquals(count, main.countUniqueSymbols(testString));

        count = 2;
        testString = "abab";
        assertEquals(count, main.countUniqueSymbols(testString));

        count = 0;
        testString = new String();
        assertEquals(count, main.countUniqueSymbols(testString));

        count = 0;
        testString = null;
        assertEquals(count, main.countUniqueSymbols(testString));
    }

}