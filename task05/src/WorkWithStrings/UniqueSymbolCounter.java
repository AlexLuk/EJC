package WorkWithStrings;

class UniqueSymbolCounter {
    private char symbol;
    private int counter;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UniqueSymbolCounter that = (UniqueSymbolCounter) o;

        return symbol == that.symbol;
    }

    @Override
    public int hashCode() {
        return (int) symbol;
    }

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