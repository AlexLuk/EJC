package task_08.sorting_algorithms;

public class BinarySearcher {

    /**
     * Search for specific value in the array, using binary search algorithm
     *
     * @param inputArray    - the array of integer values for search
     * @param elementToFind - the value to be found in array
     * @return - the index of the elementToFind, -1 if the value was not found in array
     */
    public static int binarySearch(Integer[] inputArray, int elementToFind) {
        if (inputArray == null) {
            return -1;
        }
        return binarySearch(inputArray, elementToFind, 0, inputArray.length - 1);
    }

    private static int binarySearch(Integer[] inputArray, int elementToFind, int startIndex, int endIndex) {
        int elementIndex = -1;
        if (startIndex > endIndex) {
            return elementIndex;
        } else {
            int middleIndex = (startIndex + endIndex) / 2;
            if (inputArray[middleIndex] == elementToFind) {
                return middleIndex;
            }
            if (inputArray[middleIndex] > elementToFind) {
                return binarySearch(inputArray, elementToFind, startIndex, middleIndex - 1);
            } else {
                return binarySearch(inputArray, elementToFind, middleIndex + 1, endIndex);
            }
        }
    }
}
