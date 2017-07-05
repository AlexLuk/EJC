package task_03;

import java.util.ArrayList;

public class MultiDimensionArray {
    private ArrayList<Cell> cells;
    private int size;
    private int numOfDimensions;
    private int numOfCells;

    public MultiDimensionArray(int size, int numOfDimensions) {
        this.size = size;
        this.numOfDimensions = numOfDimensions;
        setupMultiDimensionArray();
    }

    private void setupMultiDimensionArray() {
        numOfCells = (int) Math.pow(size, numOfDimensions);
        cells = new ArrayList<Cell>(numOfCells);
        for (int i = 0; i < numOfCells; i++) {
            cells.add(new Cell(Cell.CellValue.EMPTY));
        }
    }

    public boolean doesCellExist(int[] coords) {
        if (coords.length != numOfDimensions) {
            return false;
        }
        int minCoorsForDImension = 0;
        int maxCoordForDimension = size-1;
        for (int i = minCoorsForDImension; i < coords.length; i++) {
            if (coords[i] < minCoorsForDImension || coords[i] > maxCoordForDimension) {
                return false;
            }
        }
        return true;
    }

    public Cell getCellByCoords(int[] coords) {
        if (doesCellExist(coords)) {
            Cell cell;
            int cellIndex = 0;
            for (int i = 0; i < coords.length; i++) {
                cellIndex +=coords[i]*(int)Math.pow(size,i);
            }
            return cells.get(cellIndex);
        } else {
            return null;
        }
    }
}
