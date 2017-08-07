package task_08.sorting_algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeSorterTest {
    @Test
    public void mergeSort() throws Exception {
        Integer[] testArray = new Integer[]{4, 3, 2, 1};
        Integer[] testSortedArray = new Integer[]{1, 2, 3, 4};
        assertArrayEquals(testSortedArray, MergeSorter.mergeSort(testArray));

        testArray = new Integer[]{1};
        testSortedArray = new Integer[]{1};
        assertArrayEquals(testSortedArray, MergeSorter.mergeSort(testArray));

        testArray = new Integer[]{};
        testSortedArray = new Integer[]{};
        assertArrayEquals(testSortedArray, MergeSorter.mergeSort(testArray));

        testArray = new Integer[]{1, 2, 3, 4};
        testSortedArray = new Integer[]{1, 2, 3, 4};
        assertArrayEquals(testSortedArray, MergeSorter.mergeSort(testArray));

        testArray = new Integer[]{-2, -1, -4, -3};
        testSortedArray = new Integer[]{-4, -3, -2, -1};
        assertArrayEquals(testSortedArray, MergeSorter.mergeSort(testArray));

        testArray = new Integer[]{-1, 2, 3, -4};
        testSortedArray = new Integer[]{-4, -1, 2, 3};
        assertArrayEquals(testSortedArray, MergeSorter.mergeSort(testArray));
    }

    @Test
    public void mergeWithSort() throws Exception {
        Integer[] testArray1 = new Integer[]{1, 2, 3, 5};
        Integer[] testArray2 = new Integer[]{4, 7, 9, 12};
        Integer[] testSortedArray = new Integer[]{1, 2, 3, 4, 5, 7, 9, 12};
        assertArrayEquals(testSortedArray, MergeSorter.mergeWithSort(testArray1,testArray2));

        testArray1 = new Integer[]{1};
        testArray2 = new Integer[]{4};
        testSortedArray = new Integer[]{1, 4};
        assertArrayEquals(testSortedArray, MergeSorter.mergeWithSort(testArray1,testArray2));
    }

}