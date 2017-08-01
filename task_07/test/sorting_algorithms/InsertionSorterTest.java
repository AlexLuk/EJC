package sorting_algorithms;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class InsertionSorterTest {
    @Test
    public void insertionSort() throws Exception {
        Integer[] testArray = new Integer[]{4, 3, 2, 1};
        Integer[] testSortedArray = new Integer[]{1, 2, 3, 4};
        InsertionSorter.setSorterVariant(1);
        assertArrayEquals(testSortedArray, InsertionSorter.insertionSort(testArray));

        testArray = new Integer[]{1};
        testSortedArray = new Integer[]{1};
        assertArrayEquals(testSortedArray, InsertionSorter.insertionSort(testArray));

        testArray = new Integer[]{};
        testSortedArray = new Integer[]{};
        assertArrayEquals(testSortedArray, InsertionSorter.insertionSort(testArray));

        testArray = new Integer[]{1, 2, 3, 4};
        testSortedArray = new Integer[]{1, 2, 3, 4};
        assertArrayEquals(testSortedArray, InsertionSorter.insertionSort(testArray));

        testArray = new Integer[]{-2, -1, -4, -3};
        testSortedArray = new Integer[]{-4, -3, -2, -1};
        assertArrayEquals(testSortedArray, InsertionSorter.insertionSort(testArray));

        testArray = new Integer[]{-1, 2, 3, -4};
        testSortedArray = new Integer[]{-4, -1, 2, 3};
        assertArrayEquals(testSortedArray, InsertionSorter.insertionSort(testArray));
    }

}