package sorting_algorithms;

public class MergeSorter extends Sorter{
    public static Integer[] mergeSort(Integer[] inputArray){
        Integer[] resultArray = new Integer[inputArray.length];
        copyArray(inputArray, resultArray);
        return resultArray;
    }
}
