package sorting_algorithms

import org.junit.Test

class InsertionSorterTest extends GroovyTestCase {

    @Test
    void testInsertionSort() {
        Integer[] testArray = [4, 3, 2, 1];
        Integer[] testSortedArray = [1, 2, 3, 4];
        assertArrayEquals(testSortedArray, InsertionSorter.insertionSort(testArray));

        testArray = [1];
        testSortedArray = [1];
        assertArrayEquals(testSortedArray, InsertionSorter.insertionSort(testArray));

        testArray = [];
        testSortedArray = [];
        assertArrayEquals(testSortedArray, InsertionSorter.insertionSort(testArray));

        testArray = [1, 2, 3, 4];
        testSortedArray = [1, 2, 3, 4];
        assertArrayEquals(testSortedArray, InsertionSorter.insertionSort(testArray));

        testArray = [-2, -1, -4, -3];
        testSortedArray = [-4, -3, -2, -1];
        assertArrayEquals(testSortedArray, InsertionSorter.insertionSort(testArray));

        testArray = [-1, 2, 3, -4];
        testSortedArray = [-4, -1, 2, 3];
        assertArrayEquals(testSortedArray, InsertionSorter.insertionSort(testArray));
    }
}
