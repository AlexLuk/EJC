package WorkWithStrings

import org.junit.Test


class MainTest extends groovy.util.GroovyTestCase {

    @Test
    void testGetMaxSymbolSequence() {
        println toString();
        Main main = new Main();
        int count = 4;
        String testString = "aaaa";
        println "Count = " + count + " testString = " + testString;
        assertEquals(count, main.getMaxSymbolSequence(testString));

        count = 7;
        testString = "bbbbbbbaaaaa";
        println "Count = " + count + " testString = " + testString;
        assertEquals(count, main.getMaxSymbolSequence(testString));

        count = 3;
        testString = "bbaabbccc";
        println "Count = " + count + " testString = " + testString;
        assertEquals(count, main.getMaxSymbolSequence(testString));

        count = 1;
        testString = "abababababab";
        println "Count = " + count + " testString = " + testString;
        assertEquals(count, main.getMaxSymbolSequence(testString));

        count = 0;
        testString = "000000011213134";
        println "Count = " + count + " testString = " + testString;
        assertEquals(count, main.getMaxSymbolSequence(testString));

        count = 4;
        testString = "aaa000bb00bb00cccc";
        println "Count = " + count + " testString = " + testString;
        assertEquals(count, main.getMaxSymbolSequence(testString));

        count = 0;
        testString = new String();
        println "Count = " + count + " testString = " + testString;
        assertEquals(count, main.getMaxSymbolSequence(testString));

        count = 0;
        testString = null;
        println "Count = " + count + " testString = " + testString;
        assertEquals(count, main.getMaxSymbolSequence(testString));
    }

    @Test
    void testCountUniqueSymbols() {
        println toString();
        Main main = new Main();
        int count = 1;
        String testString = "aaaa";
        println "Count = " + count + " testString = " + testString;
        assertEquals(count, main.countUniqueSymbols(testString));

        count = 4;
        testString = "abcd";
        println "Count = " + count + " testString = " + testString;
        assertEquals(count, main.countUniqueSymbols(testString));

        count = 1;
        testString = "aa11aa";
        println "Count = " + count + " testString = " + testString;
        assertEquals(count, main.countUniqueSymbols(testString));

        count = 2;
        testString = "aa11qa";
        println "Count = " + count + " testString = " + testString;
        assertEquals(count, main.countUniqueSymbols(testString));

        count = 2;
        testString = "abab";
        println "Count = " + count + " testString = " + testString;
        assertEquals(count, main.countUniqueSymbols(testString));

        count = 0;
        testString = new String();
        println "Count = " + count + " testString = " + testString;
        assertEquals(count, main.countUniqueSymbols(testString));

        count = 0;
        testString = null;
        println "Count = " + count + " testString = " + testString;
        assertEquals(count, main.countUniqueSymbols(testString));


    }
}
