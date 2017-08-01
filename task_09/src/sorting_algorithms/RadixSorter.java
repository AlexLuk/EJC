package sorting_algorithms;

import java.util.Arrays;

public class RadixSorter extends Sorter {
    /**
     * Get the input array, copy and sort it using Radix sort algorithm, then return sorted array
     * Work correctly only with not-negative integer values
     *
     * @param inputArray - the array of integers for sorting
     * @return - sorted representation of input array
     */
    public static Integer[] radixSort(Integer[] inputArray) {
        Integer[] resultArray = new Integer[inputArray.length];
        copyArray(inputArray, resultArray);
        if (inputArray.length <= 1) {
            return resultArray;
        }
        int maxDigit = getNumberOfDigits(getMaxValue(inputArray));
        copyArray(inputArray, resultArray);
        int currentDigit = 1;
        while (currentDigit <= maxDigit) {
            int[] digitsCounters = new int[10];
            countDigitsByTypes(resultArray, currentDigit, digitsCounters);
            System.out.println(Arrays.toString(digitsCounters));
            sumDigits(digitsCounters);
            resultArray = getValuesInOrder(resultArray, currentDigit, digitsCounters);
            currentDigit++;
        }
        return resultArray;
    }

    private static Integer[] getValuesInOrder(Integer[] resultArray, int currentDigit, int[] digitsCounters) {
        Integer[] tempResultArray = new Integer[resultArray.length];
        for (int i = resultArray.length - 1; i >= 0; i--) {
            int currentDigitCounter = getNumberOnExactDigit(resultArray[i], currentDigit);
            digitsCounters[currentDigitCounter]--;
            tempResultArray[digitsCounters[currentDigitCounter]] = resultArray[i];
        }
        resultArray = tempResultArray;
        return resultArray;
    }

    /**
     * Return number, standing on exact digit starting from left
     *
     * @param inputValue   - value on what we perform digit search
     * @param digitToCheck - digit number in value, that should be returned. Count start from 1
     * @return - number, standing on exact digit
     */
    static int getNumberOnExactDigit(int inputValue, int digitToCheck) {
        int number = inputValue;
        while (digitToCheck > 1) {
            number = number / 10;
            digitToCheck--;
        }
        number = number % 10;
        return number;
    }

    private static void sumDigits(int[] digitsCounters) {
        for (int i = 1; i < digitsCounters.length; i++) {
            digitsCounters[i] += digitsCounters[i - 1];
        }
    }

    private static void countDigitsByTypes(Integer[] resultArray, int currentDigit, int[] digitsCounters) {
        for (int i = 0; i < resultArray.length; i++) {
            digitsCounters[getNumberOnExactDigit(resultArray[i], currentDigit)]++;
        }
    }

    /**
     * Return number of digits in inputValue
     *
     * @param inputValue - value on that we count number of digits
     * @return - number of digits
     */
    static int getNumberOfDigits(int inputValue) {
        int currentDigit = 10;
        int numOfDigits = 1;
        while (inputValue / currentDigit >= 1) {
            currentDigit *= 10;
            numOfDigits++;
        }
        return numOfDigits;
    }

    /**
     * Return maximum value in the array
     *
     * @param inputArray - array to be searched for max value
     * @return
     */
    static int getMaxValue(Integer[] inputArray) {
        int maxValue = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] > maxValue) {
                maxValue = inputArray[i];
            }
        }
        return maxValue;
    }
}
