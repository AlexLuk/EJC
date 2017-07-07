package task_03;

import java.util.ArrayList;
import java.util.Random;

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

    public void printField() {
        for (int i = 0; i < cells.size(); i++) {
            if (i % size == 0) {
                System.out.println();
            } else {
                String printSymbol;
                switch (cells.get(i).getValue()) {
                    case SHOT:
                        printSymbol = "o";
                        break;
                    case EMPTY:
                        printSymbol = "?";
                        break;
                    case DAMAGE:
                        printSymbol = "#";
                        break;
                    default:
                        printSymbol = "?";
                }
                System.out.print(" " + printSymbol);
            }
        }
    }

    public boolean addShips(ArrayList<Ship> ships) {
        for (int i = 0; i < ships.size(); i++) {
            addShip(new Ship(i));
        }
        return true;
    }

    public boolean addShip(Ship ship) {
        boolean isAddedSuccesfully = false;
        int shipLength = ship.getSize();
        int[] startCoords = new int[numOfDimensions];
        int dimensionAxis = new Random().nextInt(numOfDimensions);
        int axisDirection = new Random().nextInt(1) - 2;
        ArrayList<Cell> shipCells = new ArrayList<>(shipLength);
        for (int i = 0; i < numOfDimensions; i++) {
            startCoords[i] = new Random().nextInt(size);
        }


        Cell cell = getCellByCoords(startCoords);
        if (cell != null && cell.getValue() == Cell.CellValue.EMPTY) {
            shipCells.add(cell);
        }


        int[] nextCoords = startCoords.clone();
        for (int i = 1; i < shipLength; i++) {
            nextCoords[dimensionAxis] += axisDirection;
            cell = getCellByCoords(nextCoords);
            if (cell != null && cell.getValue() == Cell.CellValue.EMPTY) {
                shipCells.add(cell);
            }
        }
        while (!isAddedSuccesfully) {

//            int startIndex = new Random().nextInt(numOfCells);
//            Cell.CellValue startCellValue = cells.get(startIndex).getValue();
//            if (startCellValue != Cell.CellValue.EMPTY) {
//                continue;
//            }
//            int direction = new Random().nextBoolean() ? -1 : 1;
//            boolean isHorisontal = new Random().nextBoolean();
//            if (isHorisontal) {
//
//            }
        }
        return true;
    }

    public int getSize() {
        return size;
    }

    public int getNumOfDimensions() {
        return numOfDimensions;
    }

    private void setupMultiDimensionArray() {
        numOfCells = (int) Math.pow(size, numOfDimensions);
        cells = new ArrayList<Cell>(numOfCells);
        Cell cell;
        for (int i = 0; i < numOfCells; i++) {
            cell = new Cell(Cell.CellValue.EMPTY,i);
            cells.add(cell);
        }
    }

    public boolean doesCellExist(int[] coords) {
        if (coords.length != numOfDimensions) {
            return false;
        }
        int minCoorsForDImension = 0;
        int maxCoordForDimension = size - 1;
        for (int i = minCoorsForDImension; i < coords.length; i++) {
            if (coords[i] < minCoorsForDImension || coords[i] > maxCoordForDimension) {
                return false;
            }
        }
        return true;
    }

    public Cell getCellByCoords(int[] coords) {
        int cellIngex = getCellIndexByCoords(coords);
        if (cellIngex > 0) {
            return cells.get(cellIngex);
        } else {
            return null;
        }
    }

    public int getCellIndexByCoords(int[] coords) {
        if (doesCellExist(coords)) {
            int cellIndex = 0;
            for (int i = 0; i < coords.length; i++) {
                cellIndex += coords[i] * (int) Math.pow(size, i);
            }
            return cellIndex;
        } else {
            return -1;
        }
    }

    /**
     * Function search for neighbor cells for cell by it's coords.
     * For now work correctly only for 2 dimension field.
     *
     * @param coords
     * @return
     */
    public ArrayList<Cell> getNeighborCells(int[] coords, Cell excludeCell) {
        ArrayList<Cell> neighborCells = new ArrayList();
        if (doesCellExist(coords)) {
            for (int i = 0; i < numOfDimensions; i++) {
                int[] tempCoords = coords.clone();
                int dimPlusCoord = coords[i] + 1;
                int dimMinusCoord = coords[i] - 1;
                Cell cellToAdd;

                tempCoords[i] = dimPlusCoord;
                cellToAdd = getCellByCoords(tempCoords);
                if (cellToAdd != null && !cellToAdd.equals(excludeCell)) neighborCells.add(getCellByCoords(tempCoords));

                tempCoords[i] = dimMinusCoord;
                cellToAdd = getCellByCoords(tempCoords);
                if (cellToAdd != null && !cellToAdd.equals(excludeCell)) neighborCells.add(getCellByCoords(tempCoords));
            }
            return neighborCells;
        } else {
            return null;
        }
    }
}
