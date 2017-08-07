package task_08.sorting_algorithms;

public class MergeSorter extends Sorter {

    /**
     * Get the input array, copy and sort it using merge sort algorithm, then return sorted array
     *
     * @param inputArray - the array of integers for sorting
     * @return - sorted representation of input array
     */
    public static Integer[] mergeSort(Integer[] inputArray) {
        Integer[] resultArray = new Integer[inputArray.length];
        copyArray(inputArray, resultArray);
        if (resultArray.length <= 1) {
            return resultArray;
        } else {
            int middleIndex = resultArray.length / 2;
            Integer[] leftPartArray = new Integer[middleIndex];
            Integer[] rightPartArray = new Integer[resultArray.length - middleIndex];
            for (int i = 0; i < middleIndex; i++) {
                leftPartArray[i] = resultArray[i];
            }
            int rightPartIndex = 0;
            for (int i = middleIndex; i < resultArray.length; i++) {
                rightPartArray[rightPartIndex] = resultArray[i];
                rightPartIndex++;
            }
            leftPartArray = mergeSort(leftPartArray);
            rightPartArray = mergeSort(rightPartArray);
            resultArray = mergeWithSort(leftPartArray, rightPartArray);
        }
        return resultArray;
    }


    /** Get two sorted arrays, and copy values from them to resultArray, in ascending order
     * @param leftPartArray - first sorted array
     * @param rightPartArray - second sorted array
     * @return - sorted merged array
     */
    public static Integer[] mergeWithSort(Integer[] leftPartArray, Integer[] rightPartArray) {
        Integer[] resultArray = new Integer[leftPartArray.length + rightPartArray.length];
        int leftArrayIndex = 0;
        int rightArrayIndex = 0;
        int resultArrayIndex = 0;
        while (leftArrayIndex < leftPartArray.length && rightArrayIndex < rightPartArray.length) {
            if (leftPartArray[leftArrayIndex] <= rightPartArray[rightArrayIndex]) {
                resultArray[resultArrayIndex] = leftPartArray[leftArrayIndex];
                leftArrayIndex++;
                resultArrayIndex++;
            } else {
                resultArray[resultArrayIndex] = rightPartArray[rightArrayIndex];
                rightArrayIndex++;
                resultArrayIndex++;
            }
        }

        while (leftArrayIndex < leftPartArray.length) {
            resultArray[resultArrayIndex] = leftPartArray[leftArrayIndex];
            resultArrayIndex++;
            leftArrayIndex++;
        }

        while (rightArrayIndex < rightPartArray.length) {
            resultArray[resultArrayIndex] = rightPartArray[rightArrayIndex];
            resultArrayIndex++;
            rightArrayIndex++;
        }
        return resultArray;
    }
}
