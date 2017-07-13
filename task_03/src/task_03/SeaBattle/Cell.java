package task_03.SeaBattle;

public class Cell {
    private int testNum;
    private CellValue value;
    private Ship shipPointer;

    public Cell(CellValue cellValue, int testNum) {
        this.value = cellValue;
        this.setTestNum(testNum);
    }

    public CellValue getValue() {
        return value;
    }

    public void setValue(CellValue value) {
        this.value = value;
    }

    protected Ship getShipPointer() {
        return shipPointer;
    }

    protected void setShipPointer(Ship shipPointer) {
        this.shipPointer = shipPointer;
    }

    @Override
    public String toString() {
        return String.valueOf(getTestNum());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        return getTestNum() == cell.getTestNum();
    }

    @Override
    public int hashCode() {
        return getTestNum();
    }

    public int getTestNum() {
        return testNum;
    }

    private void setTestNum(int testNum) {
        this.testNum = testNum;
    }

    public enum CellValue {EMPTY, SHIP, DAMAGE, SHOT}
}
