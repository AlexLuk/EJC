package task_03;

import java.util.ArrayList;
import java.util.Arrays;
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
            String printSymbol;
            if (i % size == 0) {
                System.out.println();
            }
            switch (cells.get(i).getValue()) {
                case SHIP:
                    printSymbol = "S";
                    break;
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
            //printSymbol = cells.get(i).testNum + "";
            System.out.print(" " + printSymbol);

        }
    }


    public boolean addShips(ArrayList<Ship> ships) {
        for (int i = 0; i < ships.size(); i++) {
            addShip(ships.get(i));
        }
        return true;
    }

    public boolean addShip(Ship ship) {
        //get start coords;
        int[] shipCoord = new int[numOfDimensions];
        //get axis
        int shipAxis = new Random().nextInt(numOfDimensions);
        //get direction
        int direction = 1 - new Random().nextInt(2);
        for (int i = 0; i < numOfDimensions; i++) {
            shipCoord[i] = new Random().nextInt(size-1);
        }
        //get start cell
        Cell shipCell = getCellByCoords(shipCoord);
        System.out.println(Arrays.toString(shipCoord));
        System.out.println(shipCell);
        //check for cell validity
        if (shipCell.getValue() == Cell.CellValue.EMPTY) {
            boolean isNeighborCellsEmpty = true;
            ArrayList<Cell> neighborCells = getNeighborCells(shipCoord, ship.getShipCells());
            for (Cell cell : neighborCells) {
                if (cell.getValue() != Cell.CellValue.EMPTY) {
                    isNeighborCellsEmpty = false;
                    break;
                }
            }
            if (isNeighborCellsEmpty) {
                ship.addCell(shipCell);
                //new ship coords
                shipCoord[shipAxis] = shipCoord[shipAxis] + direction;
            }
        }
        for (Cell cell: ship.getShipCells()){
            cell.setShipPointer(ship);
            cell.setValue(Cell.CellValue.SHIP);
        }
        //go to next start coords
        //clear ship cells

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
            cell = new Cell(Cell.CellValue.EMPTY, i);
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
        if (cellIngex >-1) {
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
    public ArrayList<Cell> getNeighborCells(int[] coords, ArrayList<Cell> excludeCell) {
        ArrayList<Cell> neighborCells = new ArrayList();
        if (doesCellExist(coords)) {
            for (int i = 0; i < 0; i++) {
//            for (int i = 0; i < numOfDimensions; i++) {
                int[] tempCoords = coords.clone();
                int dimPlusCoord = coords[i] + 1;
                int dimMinusCoord = coords[i] - 1;
                Cell cellToAdd;

                tempCoords[i] = dimPlusCoord;
                cellToAdd = getCellByCoords(tempCoords);
                boolean isCellInExcluded = isCellInExcluded(excludeCell, cellToAdd);
                if (cellToAdd != null && !isCellInExcluded) neighborCells.add(getCellByCoords(tempCoords));

                tempCoords[i] = dimMinusCoord;
                cellToAdd = getCellByCoords(tempCoords);
                isCellInExcluded = isCellInExcluded(excludeCell, cellToAdd);
                if (cellToAdd != null && !isCellInExcluded) neighborCells.add(getCellByCoords(tempCoords));
            }
            return neighborCells;
        } else {
            return null;
        }
    }

    private boolean isCellInExcluded(ArrayList<Cell> excludeCell, Cell cellToAdd) {
        boolean isCellInExcluded = false;
        for (Cell cell : excludeCell) {
            System.out.println(cell + " " + cellToAdd + cellToAdd.equals(excludeCell));
            if (cellToAdd.equals(cell)) {
                isCellInExcluded = true;
                break;
            }
        }
        return isCellInExcluded;
    }
}
