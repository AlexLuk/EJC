package WorkWithStrings;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Main arraysTask = new Main();
        System.out.println(arraysTask.getMaxSameSymbols("qqqqqqew111111111111eefvs"));
    }

    private int getMaxSameSymbols(String inputString) {
        int maxCounter = 0;
        inputString=inputString.replaceAll("\\d+","");
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

        for (int i = 0; i < uniqueSymbolsArray.size(); i++) {
            int uniqueSymbolsItemCounter = uniqueSymbolsArray.get(i).getCounter();
            if (uniqueSymbolsItemCounter > maxCounter) {
                maxCounter = uniqueSymbolsItemCounter;
            }
        }

        return maxCounter;
    }

}


