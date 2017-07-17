package work_with_strings;

class SymbolCounter {
    private char symbol;
    private int counter;

    SymbolCounter(char symbol, int counter) {
        this.symbol = symbol;

        this.counter = counter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SymbolCounter that = (SymbolCounter) o;

        return symbol == that.symbol;
    }

    @Override
    public int hashCode() {
        return (int) symbol;
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