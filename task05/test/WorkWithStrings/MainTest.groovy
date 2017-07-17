package WorkWithStrings

import org.junit.Test


class MainTest extends groovy.util.GroovyTestCase {

    @Test
    void testGetMaxSymbolSequence() {
        Main main = new Main();
        int count = 4;
        String testString = "aaaa";
        println "Count = "+count+ " testString = " + testString;
        assertEquals(count, main.getMaxSymbolSequence(testString));

        count = 5;
        testString = "bbbbaaaaa";
        println "Count = "+count+ " testString = " + testString;
        assertEquals(count, main.getMaxSymbolSequence(testString));

        count = 3;
        testString = "bbaabbccc";
        println "Count = "+count+ " testString = " + testString;
        assertEquals(count, main.getMaxSymbolSequence(testString));

        count = 1;
        testString = "abababababab";
        println "Count = "+count+ " testString = " + testString;
        assertEquals(count, main.getMaxSymbolSequence(testString));

        count = 0;
        testString = "000000011213134";
        println "Count = "+count+ " testString = " + testString;
        assertEquals(count, main.getMaxSymbolSequence(testString));

        count = 4;
        testString = "aaa000bb00bb00cccc";
        println "Count = "+count+ " testString = " + testString;
        assertEquals(count, main.getMaxSymbolSequence(testString));
    }
}
