package sorting_algorithms;

public class InsertionSorter extends Sorter {
    public static Integer[] insertionSort(Integer[] inputArray) {
        Integer[] resultArray = new Integer[inputArray.length];
        copyArray(inputArray, resultArray);
        sort3(resultArray);
        return resultArray;
    }

    private static void sort1(Integer[] resultArray) {
        for (int j = 1; j < resultArray.length; j++) {
            int elementToSort = resultArray[j];
            int i = j - 1;
            while (i > -1 && resultArray[i] > elementToSort) {
                resultArray[i + 1] = resultArray[i];
                i--;
            }
            resultArray[i + 1] = elementToSort;
        }
    }

    private static void sort2(Integer[] resultArray) {
        for (int j = 0; j < resultArray.length; j++) {
            int elementForCheck = resultArray[j];
            int i = j;
            while (j > 0 && resultArray[j - 1] > elementForCheck) {
                resultArray[j] = resultArray[j - 1];
                j--;
            }
            resultArray[j] = elementForCheck;
        }
    }

    private static void sort3(Integer[] resultArray) {
        for (int i = 0; i < resultArray.length; i++) {
            int j = i;
            while (j > 0 && resultArray[j] < resultArray[j - 1]) {
                swapElements(resultArray, j, j - 1);
                j--;
            }
        }
    }
}
