package sorting_algorithms;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class RadixSorterTest {
    @Test
    public void getNumberOnExactDigit() throws Exception {
        assertEquals(1, RadixSorter.getNumberOnExactDigit(1, 1));

        assertEquals(5, RadixSorter.getNumberOnExactDigit(5, 1));

        assertEquals(3, RadixSorter.getNumberOnExactDigit(30, 2));

        assertEquals(3, RadixSorter.getNumberOnExactDigit(33, 2));

        assertEquals(4, RadixSorter.getNumberOnExactDigit(543, 2));

        assertEquals(5, RadixSorter.getNumberOnExactDigit(542, 3));
    }

    @Test
    public void radixSort() throws Exception {
        Integer[] testArray = new Integer[]{110};
        Integer[] sortedArray = new Integer[]{110};
        assertArrayEquals(sortedArray, RadixSorter.radixSort(testArray));

        testArray = new Integer[]{1, 1, 1, 1, 1};
        sortedArray = new Integer[]{1, 1, 1, 1, 1};
        assertArrayEquals(sortedArray, RadixSorter.radixSort(testArray));

        testArray = new Integer[]{0, 0, 0, 0, 0};
        sortedArray = new Integer[]{0, 0, 0, 0, 0};
        assertArrayEquals(sortedArray, RadixSorter.radixSort(testArray));

        testArray = new Integer[]{55555555, 4, 3, 2, 0};
        sortedArray = new Integer[]{0, 2, 3, 4, 55555555};
        assertArrayEquals(sortedArray, RadixSorter.radixSort(testArray));

    }

    @Test
    public void getMaxDigit() throws Exception {
        assertEquals(1, RadixSorter.getNumberOfDigits(1));

        assertEquals(0, RadixSorter.getNumberOfDigits(1));

        assertEquals(2, RadixSorter.getNumberOfDigits(10));

        assertEquals(2, RadixSorter.getNumberOfDigits(12));

        assertEquals(3, RadixSorter.getNumberOfDigits(100));

        assertEquals(3, RadixSorter.getNumberOfDigits(102));
    }

    @Test
    public void getMaxValue() throws Exception {
        Integer[] testArray = new Integer[]{2, 3, 4, 128, 5};
        int maxElement = 128;
        assertEquals(maxElement, RadixSorter.getMaxValue(testArray));
    }

}