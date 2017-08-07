package task_07.sorting_algorithms;

public class QuickSorter extends Sorter {
    /**
     * /**Get the input array, copy and sort it using quick sort algorithm, then return sorted array
     *
     * @param inputArray - the array of integers for sorting
     * @return - sorted representation of input array
     */
    public static Integer[] quickSort(Integer[] inputArray) {
        Integer[] resultArray = new Integer[inputArray.length];
        copyArray(inputArray, resultArray);
        if (inputArray.length <= 1) {
            return resultArray;
        }
        quickSort(resultArray, 0, resultArray.length - 1);
        return resultArray;
    }

    /**
     * Recursive part of quickSort algorithm.
     *
     * @param inputArray - array to be sorted
     * @param startIndex - index of left side of sorted area
     * @param endIndex   - index of right side of sorted area
     */
    private static void quickSort(Integer[] inputArray, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int keyElement = inputArray[startIndex + (endIndex - startIndex) / 2];
            int keyIndex = partition(inputArray, startIndex, endIndex, keyElement);
            quickSort(inputArray, startIndex, keyIndex - 1);
            quickSort(inputArray, keyIndex, endIndex);
        }
    }

    /**
     * Method to rearrange element in array so, that elements smaller then key element go to the left of it,
     * and elements greater than key element go to right of it
     *
     * @param inputArray - array to be sorted
     * @param startIndex - index of left side of sorted area
     * @param endIndex   - index of right side of sorted area
     * @param keyElement - element around which all other will be rearranged
     * @return
     */
    private static int partition(Integer[] inputArray, int startIndex, int endIndex, int keyElement) {
        while (startIndex <= endIndex) {
            while (inputArray[startIndex] < keyElement) {
                startIndex++;
            }
            while (inputArray[endIndex] > keyElement) {
                endIndex--;
            }
            if (startIndex <= endIndex) {
                swapElements(inputArray, startIndex, endIndex);
                startIndex++;
                endIndex--;
            }
        }
        return startIndex;
    }
}
