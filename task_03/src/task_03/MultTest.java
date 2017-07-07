package task_03;

import java.util.ArrayList;

public class MultTest {
    public static void main(String[] args) {
        MultiDimensionArray multiDimensionArray = new MultiDimensionArray(3, 2);
        int i = 0;
        int[] coords = {i, i};
        ArrayList<Cell> exCells = new ArrayList<>();
        exCells.add(new Cell(Cell.CellValue.EMPTY,5));
        exCells.add(new Cell(Cell.CellValue.EMPTY,7));
        Cell cell = multiDimensionArray.getCellByCoords(coords);
        Cell.CellValue cellValue = multiDimensionArray.getCellByCoords(coords).getValue();
        System.out.println("cooords " + i);
        System.out.println(multiDimensionArray.getCellByCoords(coords));
        System.out.println(multiDimensionArray.getNeighborCells(coords,exCells));
        multiDimensionArray.printField();
//        for (int i = 0; i < 4; i++) {
//            int[] coords = {i,i};
//            System.out.println("cooords "+i);
//            System.out.println(multiDimensionArray.getCellByCoords(coords));
//            System.out.println(multiDimensionArray.getNeighborCells(coords));
//        }
    }
}
