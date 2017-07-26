package sorting_algorithms

import org.junit.Test


class SorterTest extends GroovyTestCase {

    @Test
    void testArrayToString() {
        Integer[] testArray = new Integer[1];
        testArray[0] = 1;
        String testArrayToString = "1 ";
        assertEquals(testArrayToString, Sorter.arrayToString(testArray))

        testArray = [1, 2, 3];
        testArrayToString = "1 2 3 ";
        assertEquals(testArrayToString, Sorter.arrayToString(testArray));

        testArray = [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1];
        testArrayToString = "1 1 1 1 1 1 1 1 1 1 \n1 1 ";
        assertEquals(testArrayToString, Sorter.arrayToString(testArray));
    }

    @Test
    void testSwapElements() {
        Integer[] testArray = [4, 3, 2, 1];
        Integer[] testSwappedArray = [3, 4, 2, 1];
        Sorter.swapElements(testArray, 0, 1);
        assertArrayEquals(testSwappedArray, testArray);

        testArray = [];
        testSwappedArray = [];
        Sorter.swapElements(testArray, 0, 0);
        assertArrayEquals(testSwappedArray, testArray);

        testArray = [1];
        testSwappedArray = [1];
        Sorter.swapElements(testArray, 2, 3);
        assertArrayEquals(testSwappedArray, testArray);

        testArray = [4, 3, 2, 1];
        testSwappedArray = [3, 4, 2, 1];
        Sorter.swapElements(testArray, 0, 1);
        assertArrayEquals(testSwappedArray, testArray);
    }

    @Test
    void testCopyArray() {
        Integer[] testArray = [4, 3, 2, 1];
        Integer[] copyArray = new Integer[testArray.length];
        Sorter.copyArray(testArray, copyArray);
        assertArrayEquals(copyArray, testArray);

        testArray = [];
        copyArray = new Integer[testArray.length];
        Sorter.copyArray(testArray, copyArray);
        assertArrayEquals(copyArray, testArray);

        testArray = [1];
        copyArray = new Integer[testArray.length];
        Sorter.copyArray(testArray, copyArray);
        assertArrayEquals(copyArray, testArray);
    }
}
