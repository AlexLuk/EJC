package sorting_algorithms;

import groovy.util.GroovyTestCase;
import org.junit.Test;


public class SelectionSorterTest extends GroovyTestCase {
    @Test
    public void testSelectionSort() {
        Integer[] testArray = {4, 3, 2, 1};
        Integer[] testSortedArray = {1, 2, 3, 4};
        assertArrayEquals(testSortedArray, SelectionSorter.selectionSort(testArray));

        testArray = new Integer[]{1};
        testSortedArray = new Integer[]{1};
        assertArrayEquals(testSortedArray, SelectionSorter.selectionSort(testArray));

        testArray = new Integer[]{};
        testSortedArray = new Integer[]{};
        assertArrayEquals(testSortedArray, SelectionSorter.selectionSort(testArray));

        testArray = new Integer[]{1, 2, 3, 4};
        testSortedArray = new Integer[]{1, 2, 3, 4};
        assertArrayEquals(testSortedArray, SelectionSorter.selectionSort(testArray));

        testArray = new Integer[]{-2, -1, -4, -3};
        testSortedArray = new Integer[]{-4, -3, -2, -1};
        assertArrayEquals(testSortedArray, SelectionSorter.selectionSort(testArray));

        testArray = new Integer[]{-1, 2, 3, -4};
        testSortedArray = new Integer[]{-4, -1, 2, 3};
        assertArrayEquals(testSortedArray, SelectionSorter.selectionSort(testArray));
    }
}

    
