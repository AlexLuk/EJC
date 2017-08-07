package task_07.sorting_algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuickSorterTest {
    @Test
    public void quickSort() throws Exception {
        Integer[] testArray = new Integer[] {1, 2, 33, 2, 21, 128, 4, 3, 2, 1};
        Integer[] testSortedArray = InsertionSorter.insertionSort(testArray);
        assertArrayEquals(testSortedArray, QuickSorter.quickSort(testArray));

        testArray = new Integer[] {1};
        testSortedArray = new Integer[] {1};
        assertArrayEquals(testSortedArray, QuickSorter.quickSort(testArray));

        testArray = new Integer[] {};
        testSortedArray = new Integer[] {};
        assertArrayEquals(testSortedArray, QuickSorter.quickSort(testArray));

        testArray = new Integer[] {1, 2, 3, 4};
        testSortedArray = new Integer[] {1, 2, 3, 4};
        assertArrayEquals(testSortedArray, QuickSorter.quickSort(testArray));

        testArray = new Integer[] {-2, -1, -4, -3};
        testSortedArray = new Integer[] {-4, -3, -2, -1};
        assertArrayEquals(testSortedArray, QuickSorter.quickSort(testArray));

        testArray = new Integer[] {-1, 2, 3, -4};
        testSortedArray = new Integer[] {-4, -1, 2, 3};
        assertArrayEquals(testSortedArray, QuickSorter.quickSort(testArray));
    }

}