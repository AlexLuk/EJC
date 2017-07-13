package task_03;

public class Cell {
    public CellValue getValue() {
        return value;
    }

    public int testNum;

    public void setValue(CellValue value) {
        this.value = value;
    }

    private CellValue value;

    public void setShipPointer(Ship shipPointer) {
        this.shipPointer = shipPointer;
    }

    public Ship getShipPointer() {
        return shipPointer;
    }

    private Ship shipPointer;

    public Cell(CellValue cellValue,int testNum) {
        this.value =cellValue;
        this.testNum = testNum;
    }

    @Override
    public String toString() {
//        String retunString;
//        switch (value) {
//            case SHOT:
//                retunString="o";
//                break;
//            case EMPTY:
//                retunString="?";
//                break;
//            case DAMAGE:
//                retunString="#";
//                break;
//            default:
//                retunString="?";
//        }
//        return retunString;
        return String.valueOf(testNum);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        return testNum == cell.testNum;
    }

    @Override
    public int hashCode() {
        return testNum;
    }

    public enum CellValue {EMPTY, SHIP, DAMAGE, SHOT}
}
