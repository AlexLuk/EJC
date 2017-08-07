package task_07.sorting_algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class SorterTest {
    @Test
    public void arrayToString() throws Exception {
        Integer[] testArray = new Integer[1];
        testArray[0] = 1;
        String testArrayToString = "1 ";
        assertEquals(testArrayToString, Sorter.arrayToString(testArray));

        testArray = new Integer[]{1, 2, 3};
        testArrayToString = "1 2 3 ";
        assertEquals(testArrayToString, Sorter.arrayToString(testArray));

        testArray = new Integer[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        testArrayToString = "1 1 1 1 1 1 1 1 1 1 \n1 1 ";
        assertEquals(testArrayToString, Sorter.arrayToString(testArray));
    }

    @Test
    public void copyArray() throws Exception {
        Integer[] testArray = new Integer[]{4, 3, 2, 1};
        Integer[] copyArray = new Integer[testArray.length];
        Sorter.copyArray(testArray, copyArray);
        assertArrayEquals(copyArray, testArray);

        testArray = new Integer[]{};
        copyArray = new Integer[testArray.length];
        Sorter.copyArray(testArray, copyArray);
        assertArrayEquals(copyArray, testArray);

        testArray = new Integer[]{1};
        copyArray = new Integer[testArray.length];
        Sorter.copyArray(testArray, copyArray);
        assertArrayEquals(copyArray, testArray);
    }

    @Test
    public void swapElements() throws Exception {
        Integer[] testArray = new Integer[]{4, 3, 2, 1};
        Integer[] testSwappedArray = new Integer[]{3, 4, 2, 1};
        Sorter.swapElements(testArray, 0, 1);
        assertArrayEquals(testSwappedArray, testArray);

        testArray = new Integer[]{};
        testSwappedArray = new Integer[]{};
        Sorter.swapElements(testArray, 0, 0);
        assertArrayEquals(testSwappedArray, testArray);

        testArray = new Integer[]{1};
        testSwappedArray = new Integer[]{1};
        Sorter.swapElements(testArray, 2, 3);
        assertArrayEquals(testSwappedArray, testArray);

        testArray = new Integer[]{4, 3, 2, 1};
        testSwappedArray = new Integer[]{3, 4, 2, 1};
        Sorter.swapElements(testArray, 0, 1);
        assertArrayEquals(testSwappedArray, testArray);
    }

}