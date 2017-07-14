package WorkWithStrings;

class UniqueSymbolCounter {
    private char symbol;
    private int counter;

    UniqueSymbolCounter(char symbol, int counter) {
        this.symbol = symbol;
        this.counter = counter;
    }

    char getSymbol() {
        return symbol;
    }

    int getCounter() {
        return counter;
    }


    void increaseCounter() {
        counter++;
    }
}