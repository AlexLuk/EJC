package WorkWithStrings;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Main arraysTask = new Main();
    }

    public int getMaxSymbolSequence(String inputString) {
        int maxSequenceCounter = 0;
        inputString = inputString.replaceAll("[0-9]", "");
        if(inputString.length()==0){
            return 0;
        }
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

        for (SymbolCounter symbolCounter:symbolCounters){
            int currentCounter = symbolCounter.getCounter();
            if(currentCounter>maxSequenceCounter) {
                maxSequenceCounter = currentCounter ;
            }
        }
        return maxSequenceCounter;
    }
}


