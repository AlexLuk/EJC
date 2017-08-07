package task_07.sorting_algorithms;

public class Sorter {
    private static final int MAX_SYMBOLS_IN_LINE = 10;

    public static String arrayToString(Integer[] array) {
        String finalString = "";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (i != 0 && i % MAX_SYMBOLS_IN_LINE == 0) {
                stringBuilder.append("\n");
            }
            stringBuilder.append(array[i]);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    public static void copyArray(Integer[] inputArray, Integer[] resultArray) {
        for (int j = 0; j < inputArray.length; j++) {
            resultArray[j] = inputArray[j];
        }
    }

    public static void swapElements(Integer[] inputArray, int firstIndex, int secondIndex) {
        if (firstIndex < 0 || secondIndex < 0 || firstIndex >= inputArray.length || secondIndex >= inputArray.length) {
            return;
        }
        int tempElement = inputArray[firstIndex];
        inputArray[firstIndex] = inputArray[secondIndex];
        inputArray[secondIndex] = tempElement;
    }
}

