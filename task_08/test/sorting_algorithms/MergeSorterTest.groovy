package sorting_algorithms

import org.junit.Test;

class MergeSorterTest extends GroovyTestCase {
    @Test
    void testMergeWithSort(){
        Integer[] testArray1 = [1, 2, 3, 5];
        Integer[] testArray2 = [4, 7, 9, 12];
        Integer[] testSortedArray = [1, 2, 3, 4, 5, 7, 9, 12];
        assertArrayEquals(testSortedArray, MergeSorter.mergeWithSort(testArray1,testArray2));

        testArray1 = [1];
        testArray2 = [4];
        testSortedArray = [1, 4];
        assertArrayEquals(testSortedArray, MergeSorter.mergeWithSort(testArray1,testArray2));
    }


    @Test
    void testMergeSort() {
        Integer[] testArray = [4, 3, 2, 1];
        Integer[] testSortedArray = [1, 2, 3, 4];
        assertArrayEquals(testSortedArray, MergeSorter.mergeSort(testArray));

        testArray = [1];
        testSortedArray = [1];
        assertArrayEquals(testSortedArray, MergeSorter.mergeSort(testArray));

        testArray = [];
        testSortedArray = [];
        assertArrayEquals(testSortedArray, MergeSorter.mergeSort(testArray));

        testArray = [1, 2, 3, 4];
        testSortedArray = [1, 2, 3, 4];
        assertArrayEquals(testSortedArray, MergeSorter.mergeSort(testArray));

        testArray = [-2, -1, -4, -3];
        testSortedArray = [-4, -3, -2, -1];
        assertArrayEquals(testSortedArray, MergeSorter.mergeSort(testArray));

        testArray = [-1, 2, 3, -4];
        testSortedArray = [-4, -1, 2, 3];
        assertArrayEquals(testSortedArray, MergeSorter.mergeSort(testArray));
    }
}
