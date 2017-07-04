package task_03;

public class Cell {
    public CellValue getValue() {
        return value;
    }

    private CellValue value;
    private Ship shipPointer;

    public Cell(CellValue cellValue) {
        this.value =cellValue;
    }

    public enum CellValue {EMPTY, SHIP, DAMAGE, SHOT}
}
