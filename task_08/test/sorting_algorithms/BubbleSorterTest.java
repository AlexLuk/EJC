package sorting_algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleSorterTest {
    @Test
    public void bubbleSort() throws Exception {
        Integer[] testArray = new Integer[]{4, 3, 2, 1};
        Integer[] testSortedArray = new Integer[]{1, 2, 3, 4};
        assertArrayEquals(testSortedArray, BubbleSorter.bubbleSort(testArray));

        testArray = new Integer[]{1};
        testSortedArray = new Integer[]{1};
        assertArrayEquals(testSortedArray, BubbleSorter.bubbleSort(testArray));

        testArray = new Integer[]{};
        testSortedArray = new Integer[]{};
        assertArrayEquals(testSortedArray, BubbleSorter.bubbleSort(testArray));

        testArray = new Integer[]{1, 2, 3, 4};
        testSortedArray = new Integer[]{1, 2, 3, 4};
        assertArrayEquals(testSortedArray, BubbleSorter.bubbleSort(testArray));

        testArray = new Integer[]{-2, -1, -4, -3};
        testSortedArray = new Integer[]{-4, -3, -2, -1};
        assertArrayEquals(testSortedArray, BubbleSorter.bubbleSort(testArray));

        testArray = new Integer[]{-1, 2, 3, -4};
        testSortedArray = new Integer[]{-4, -1, 2, 3};
        assertArrayEquals(testSortedArray, BubbleSorter.bubbleSort(testArray));
    }

}