package task_07.sorting_algorithms;

public class InsertionSorter extends Sorter {
    private static int sorterVariant;

    /**
     * Select wariant of insertion sort realisation
     *
     * @param sorterVariant - realisation index 1 - 3, default - 1
     */
    public static void setSorterVariant(int sorterVariant) {
        InsertionSorter.sorterVariant = sorterVariant;
    }

    /**
     * /**Get the input array, copy and sort it using insertion sort algorithm, then return sorted array
     *
     * @param inputArray - the array of integers for sorting
     * @return - sorted representation of input array
     */
    public static Integer[] insertionSort(Integer[] inputArray) {
        Integer[] resultArray = new Integer[inputArray.length];
        copyArray(inputArray, resultArray);
        if (inputArray.length <= 1) {
            return resultArray;
        }
        switch (sorterVariant) {
            case 1:
                sort1(resultArray);
                break;
            case 2:
                sort2(resultArray);
                break;
            case 3:
                sort3(resultArray);
                break;
            default:
                sort1(resultArray);
        }
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
