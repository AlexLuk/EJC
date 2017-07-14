package WorkWithStrings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Main arraysTask = new Main();
        System.out.println(arraysTask.getMaxSameSymbols("qqqqqqew111111111111eefvs"));
        System.out.println(arraysTask.countUniqueSymbols("abababababab"));
    }

    private int getMaxSameSymbols(String inputString) {
        int maxCounter = 0;
        inputString=inputString.replaceAll("\\d+","");
        ArrayList<UniqueSymbolCounter> uniqueSymbolsArray = getUniqueSymbolCounters(inputString);

        for (int i = 0; i < uniqueSymbolsArray.size(); i++) {
            int uniqueSymbolsItemCounter = uniqueSymbolsArray.get(i).getCounter();
            if (uniqueSymbolsItemCounter > maxCounter) {
                maxCounter = uniqueSymbolsItemCounter;
            }
        }
        return maxCounter;
    }

    int countUniqueSymbols(String inputString){
        ArrayList<UniqueSymbolCounter> uniqueSymbolCounters = getUniqueSymbolCounters(inputString);
        HashSet reallyUniqueSymbols=new HashSet();
        reallyUniqueSymbols.addAll(uniqueSymbolCounters);
        return reallyUniqueSymbols.size();
    }

    private ArrayList<UniqueSymbolCounter> getUniqueSymbolCounters(String inputString) {
        char[] symbols = inputString.toCharArray();
        ArrayList<UniqueSymbolCounter> uniqueSymbolsArray = new ArrayList<>();
        for (char symbol : symbols) {
            if (uniqueSymbolsArray.size() == 0) {
                uniqueSymbolsArray.add(new UniqueSymbolCounter(symbol, 1));
            } else {
                for (UniqueSymbolCounter uniqueSymbolsItem : uniqueSymbolsArray) {
                    if (uniqueSymbolsItem.getSymbol() == symbol) {
                        uniqueSymbolsItem.increaseCounter();
                        break;
                    } else {
                        uniqueSymbolsArray.add(new UniqueSymbolCounter(symbol, 1));
                        break;
                    }
                }
            }
        }
        return uniqueSymbolsArray;
    }

}


