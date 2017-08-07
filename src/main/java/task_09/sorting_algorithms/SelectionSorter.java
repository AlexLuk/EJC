package task_09.sorting_algorithms;

public class SelectionSorter extends Sorter {
    /**
     * Get the input array, copy and sort it using Selection sort algorithm, then return sorted array
     * Work correctly only with not-negative integer values
     *
     * @param inputArray - the array of integers for sorting
     * @return - sorted representation of input array
     */
    public static Integer[] selectionSort(Integer[] inputArray) {
        Integer[] resultArray = new Integer[inputArray.length];
        copyArray(inputArray, resultArray);
        if (inputArray.length <= 1) {
            return resultArray;
        }
        int currentSortedIndex = 0;
        while (currentSortedIndex < resultArray.length) {
            int currentIndex = currentSortedIndex;
            while (currentIndex < resultArray.length) {
                if (resultArray[currentIndex] < resultArray[currentSortedIndex]) {
                    swapElements(resultArray, currentIndex, currentSortedIndex);
                }
                currentIndex++;
            }
            currentSortedIndex++;
        }
        return resultArray;
    }
}
