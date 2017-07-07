package task_03;

public class Cell {
    public CellValue getValue() {
        return value;
    }

    public int testNum;

    private CellValue value;
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

        if (testNum != cell.testNum) return false;
        if (value != cell.value) return false;
        return shipPointer != null ? shipPointer.equals(cell.shipPointer) : cell.shipPointer == null;
    }

    @Override
    public int hashCode() {
        int result = testNum;
        result = 31 * result + value.hashCode();
        result = 31 * result + (shipPointer != null ? shipPointer.hashCode() : 0);
        return result;
    }


    public enum CellValue {EMPTY, SHIP, DAMAGE, SHOT}
}
