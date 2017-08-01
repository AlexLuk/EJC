package sorting_algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearcherTest {
    @Test
    public void binarySearch() throws Exception {
        Integer[] testArray = {1, 2, 3, 4};
        assertEquals(1, BinarySearcher.binarySearch(testArray, 2));

        testArray = new Integer[]{2, 2, 2, 2};
        assertEquals(1, BinarySearcher.binarySearch(testArray, 2));

        testArray = new Integer[]{};
        assertEquals(-1, BinarySearcher.binarySearch(testArray, 2));

        testArray = new Integer[]{1, 1, 1, 1};
        assertEquals(-1, BinarySearcher.binarySearch(testArray, 2));

        testArray = new Integer[]{2};
        assertEquals(0, BinarySearcher.binarySearch(testArray, 2));

        testArray = null;
        assertEquals(-1, BinarySearcher.binarySearch(testArray, 2));
    }

}