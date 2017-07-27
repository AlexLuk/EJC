package sorting_algorithms;

public class BubbleSorter extends Sorter{
    public static Integer[] bubbleSort(Integer[] inputArray) {
        Integer[] resultArray = new Integer[inputArray.length];
        copyArray(inputArray, resultArray);
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < resultArray.length - 1; i++) {
                int currentElement = resultArray[i];
                int nextElement = resultArray[i + 1];
                if (currentElement > nextElement) {
                    swapElements(resultArray,i,i+1);
                    isSorted = false;
                }
            }
        }
        return resultArray;
    }
}
