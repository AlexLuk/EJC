package WorkWithStrings;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Main arraysTask = new Main();
    }

    public int getMaxSymbolSequence(String inputString) {
        int maxSequenceCounter = 0;
        if (inputString.length() == 0) {
            return 0;
        }

        ArrayList<SymbolCounter> symbolCounters = getSymbolCounters(inputString);

        for (SymbolCounter symbolCounter : symbolCounters) {
            int currentCounter = symbolCounter.getCounter();
            if (currentCounter > maxSequenceCounter) {
                maxSequenceCounter = currentCounter;
            }
        }
        return maxSequenceCounter;
    }

    @NotNull
    private ArrayList<SymbolCounter> getSymbolCounters(String inputString) {
        inputString = inputString.replaceAll("[0-9]", "");
        char[] inputChars = inputString.toCharArray();
        ArrayList<SymbolCounter> symbolCounters = new ArrayList<>();
        SymbolCounter currentSymbolCounter = null;
        for (int i = 0; i < inputChars.length; i++) {
            if (i == 0) {
                currentSymbolCounter = new SymbolCounter(inputChars[i], 1);
            } else {
                if (inputChars[i] == currentSymbolCounter.getSymbol()) {
                    currentSymbolCounter.increaseCounter();
                } else {
                    symbolCounters.add(currentSymbolCounter);
                    currentSymbolCounter = new SymbolCounter(inputChars[i], 1);
                }
            }
        }
        symbolCounters.add(currentSymbolCounter);
        return symbolCounters;
    }

    public int countUniqueSymbols(String inputString){
        ArrayList<SymbolCounter> uniqueSymbolCounters = getSymbolCounters(inputString);
        HashSet reallyUniqueSymbols=new HashSet();
        reallyUniqueSymbols.addAll(uniqueSymbolCounters);
        return reallyUniqueSymbols.size();
    }
}


