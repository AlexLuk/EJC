package task_03;

public class Cell {
    public CellValue getValue() {
        return value;
    }

    public String testNum;

    private CellValue value;
    private Ship shipPointer;

    public Cell(CellValue cellValue) {
        this.value =cellValue;
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
        return testNum;
    }

    public enum CellValue {EMPTY, SHIP, DAMAGE, SHOT}
}
