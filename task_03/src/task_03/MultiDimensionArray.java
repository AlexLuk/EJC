package task_03;

import java.util.ArrayList;
import java.util.Random;

public class MultiDimensionArray {
    private static final int MAX_SHIP_ADD_TRY = 500;
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
            if (!addShip(ships.get(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean addShip(Ship ship) {
        boolean shipAdded = false;
        int shipAddTry = 0;
        do {
            int shipLengthCounter = ship.getSize();
            // exit condition if error
            shipAddTry++;
            if (shipAddTry > MAX_SHIP_ADD_TRY) {
                System.out.println(ship + " was not added");
                System.out.println(shipAddTry);
                return false;
            }
            //clear ship sells
            ship.clearShipCells();
            //get start coords;
            int[] shipCoord = new int[numOfDimensions];
            //get axis
            int shipAxis = new Random().nextInt(numOfDimensions);
            //get direction
            int direction = 1 - new Random().nextInt(2);
            for (int i = 0; i < numOfDimensions; i++) {
                shipCoord[i] = new Random().nextInt(size);
            }
            //get start cell
            Cell shipCell = null;
            //get cell by coords
            shipCell = getCellByCoords(shipCoord);
            //check for cell validity

            if (shipCell.getValue() == Cell.CellValue.EMPTY) {
                boolean isNeighborCellsEmpty = true;
                ArrayList<int[]> neighborCellCoords = getNeighborCellsCoords(null, getCellCoordsByIndex(shipCell.testNum), 0);
                ArrayList<Cell> neighborCells = getNeighborCells(neighborCellCoords, ship.getShipCells());
                for (Cell cell : neighborCells) {
                    if (cell.getValue() != Cell.CellValue.EMPTY) {
                        isNeighborCellsEmpty = false;
                        break;
                    }
                }
                if (isNeighborCellsEmpty) {
                    ship.addCell(shipCell);
                    shipLengthCounter--;
                    //next shipCell coords
                    if (shipLengthCounter == 0) {
                        shipAdded = true;
                        for (Cell cell : ship.getShipCells()) {
                            cell.setShipPointer(ship);
                            shipCell.setValue(Cell.CellValue.SHIP);
                        }
                        System.out.println(shipAddTry);
                    } else {
                        //return to get cell by coords
                        shipCoord[shipAxis] = shipCoord[shipAxis] + direction;
                    }

                } else {
                    continue;
                }
            } else {
                continue;
            }
        } while (!shipAdded);

        //markNeighborCells(ship);

        return true;
    }

    private void markNeighborCells(Ship ship) {
        ArrayList<Cell> shipCells = ship.getShipCells();
        ArrayList<Cell> neighborCells;
        for (Cell shipCell : shipCells) {
            ArrayList<int[]> neighborCellCoords = getNeighborCellsCoords(null, getCellCoordsByIndex(shipCell.testNum), 0);
            neighborCells = getNeighborCells(neighborCellCoords, shipCells);
            for (Cell neighborCell : neighborCells) {
                neighborCell.setValue(Cell.CellValue.SHOT);
            }
        }
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
        if (cellIngex > -1) {
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
     * @param
     * @return
     */
    public ArrayList<Cell> getNeighborCells(ArrayList<int[]> neighborCellsCoords, ArrayList<Cell> excludeCell) {
        ArrayList<Cell> neighborCells = new ArrayList();
        for (int[] coords : neighborCellsCoords) {
            if (doesCellExist(coords)) {
                Cell cellToAdd = getCellByCoords(coords);
                boolean isCellInExcluded = isCellInExcluded(excludeCell, cellToAdd);
                if (cellToAdd != null && !isCellInExcluded) neighborCells.add(cellToAdd);
            }
        }
        return neighborCells;
    }

    public ArrayList<int[]> getNeighborCellsCoords(ArrayList<int[]> neighborCoords, int[] coords, int coordsNum) {
        if (neighborCoords == null) neighborCoords = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int tempCoord;
            tempCoord = coords[coordsNum];
            coords[coordsNum] = coords[coordsNum] + i - 1;
            if (coordsNum < numOfDimensions - 1) {
                getNeighborCellsCoords(neighborCoords, coords, coordsNum + 1);
            }
            if (coordsNum != 0) neighborCoords.add(coords.clone());
            coords[coordsNum] = tempCoord;
        }
        return neighborCoords;
    }

    public int[] getCellCoordsByIndex(int cellNum) {
        int[] coords = new int[numOfDimensions];
        int dimPow = 0;
        for (int i = 0; i < numOfDimensions; i++) {
            dimPow = (int) Math.pow(size, numOfDimensions - i - 1);
            coords[numOfDimensions - i - 1] = cellNum / dimPow;
            cellNum = cellNum - dimPow * coords[numOfDimensions - i - 1];
        }
        return coords;

    }

    private boolean isCellInExcluded(ArrayList<Cell> excludeCell, Cell cellToAdd) {
        boolean isCellInExcluded = false;
        for (Cell cell : excludeCell) {
            if (cellToAdd.equals(cell)) {
                isCellInExcluded = true;
                break;
            }
        }
        return isCellInExcluded;
    }
}
