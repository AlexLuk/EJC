package task_03;

import sun.awt.SunHints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class MultTest {
    public static void main(String[] args) {
        //public MultiDimensionArray(int size, int numOfDimensions) {
        MultiDimensionArray multiDimensionArray = new MultiDimensionArray(4, 2);
        ArrayList<Ship> ships=new ArrayList<>();
        ships.add(new Ship(2));
        ships.add(new Ship(1));
        ships.add(new Ship(1));
        int i = 1;
        int[] coords = {i, i};
//        ArrayList<Cell> exCells = new ArrayList<>();
//        exCells.add(new Cell(Cell.CellValue.EMPTY,5));
//        exCells.add(new Cell(Cell.CellValue.EMPTY,7));
        multiDimensionArray.addShips(ships);
//        ArrayList<int[]> neighborCoords=multiDimensionArray.getNeighborCellsCoords(null,coords,0);
//        HashSet hs = new HashSet<int[]>();
//        hs.addAll(neighborCoords);
//        neighborCoords.clear();
//        neighborCoords.addAll(hs);
//        for (int j = 0; j < neighborCoords.size(); j++) {
//            System.out.println(Arrays.toString(neighborCoords.get(j)));
//        }
//        Cell cell = multiDimensionArray.getCellByCoords(coords);
//        Cell.CellValue cellValue = multiDimensionArray.getCellByCoords(coords).getValue();
//        System.out.println("cooords " + i);
//        System.out.println(multiDimensionArray.getCellByCoords(coords));
//        System.out.println(multiDimensionArray.getNeighborCells(coords,exCells));
        multiDimensionArray.printField();

//        for (int i = 0; i < 4; i++) {
//            int[] coords = {i,i};
//            System.out.println("cooords "+i);
//            System.out.println(multiDimensionArray.getCellByCoords(coords));
//            System.out.println(multiDimensionArray.getNeighborCells(coords));
//        }
    }
}
