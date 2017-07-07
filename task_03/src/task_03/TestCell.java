package task_03;

public class TestCell {
    public static void main(String[] args) {
        Cell cell1 = new Cell(Cell.CellValue.DAMAGE,1);
        Cell cell2 = new Cell(Cell.CellValue.DAMAGE,2);
        Cell cell3 = new Cell(Cell.CellValue.DAMAGE,1);
        System.out.println(cell1.equals(cell2)+" "+cell2.hashCode());
        System.out.println(cell1.equals(cell3)+" "+cell1.hashCode());
    }
}
