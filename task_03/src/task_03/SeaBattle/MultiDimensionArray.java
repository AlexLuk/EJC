package task_03.SeaBattle;

import java.util.ArrayList;
import java.util.Random;

class MultiDimensionArray {
    private static final int MAX_SHIP_ADD_TRY = 500;
    private static final String SHIP_SYMBOL = "S";
    private static final String EMPTY_SYMBOL = ".";
    private static final String SHOT_SYMBOL = "o";
    private static final String DAMAGE_SYMBOL = "#";
    private static final String DEFAULT_SYMBOL = "?";
    private static final String WAS_DESTROED = " was destroed";
    private static final String WAS_NOT_ADDED = " was not added";
    private ArrayList<Cell> cells;
    private int size;
    private int numOfDimensions;
    private int numOfCells;
    private int aliveShipCounter = 0;
    private boolean areAllShipsDestroed = false;

    MultiDimensionArray(int size, int numOfDimensions) {
        this.size = size;
        this.numOfDimensions = numOfDimensions;
        setupMultiDimensionArray();
    }

    boolean areAllShipsDestroedChecker() {
        return areAllShipsDestroed;
    }

    private void decreaseAliveShipCounter() {
        aliveShipCounter--;
        if (aliveShipCounter == 0) {
            areAllShipsDestroed = true;
        }
    }

    void printField(boolean isCheatMode) {
        String printSymbol;
        for (int i = 0; i < cells.size(); i++) {
            for (int j = 1; j < numOfDimensions + 1; j++) {
                if (i % Math.pow(size, j) == 0 && i != 0) {
                    System.out.println();
                }
            }
            printSymbol = getCellSymbol(isCheatMode, i);
            System.out.print(" " + printSymbol);
        }
        System.out.println();
        System.out.println();
    }

    private String getCellSymbol(boolean isCehatModeOn, int i) {
        String printSymbol;
        switch (cells.get(i).getValue()) {
            case SHIP:
                if (isCehatModeOn) {
                    printSymbol = SHIP_SYMBOL;
                } else {
                    printSymbol = EMPTY_SYMBOL;
                }
                break;
            case SHOT:
                printSymbol = SHOT_SYMBOL;
                break;
            case EMPTY:
                printSymbol = EMPTY_SYMBOL;
                break;
            case DAMAGE:
                printSymbol = DAMAGE_SYMBOL;
                break;
            default:
                printSymbol = DEFAULT_SYMBOL;
        }
        return printSymbol;
    }

    boolean addShips(ArrayList<Ship> ships) {
        for (Ship ship : ships) {
            if (!addShip(ship)) {
                return false;
            }
            aliveShipCounter++;
        }
        return true;
    }

    boolean addShip(Ship ship) {
        boolean shipAdded = false;
        int shipAddTry = 0;
        do {
            int shipLengthCounter = ship.getSize();
            // exit condition if error
            shipAddTry++;
            if (shipAddTry > MAX_SHIP_ADD_TRY) {
                System.out.println(ship + WAS_NOT_ADDED);
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
            int direction = new Random().nextBoolean() ? (-1) : 1;
            getRandomCoord(shipCoord);
            //get start cell
            Cell shipCell = null;
            //get cell by coords

            while (!shipAdded) {
                shipCell = getCellByCoords(shipCoord);
                //check for cell validity
                if (shipCell != null && shipCell.getValue() == Cell.CellValue.EMPTY) {
                    boolean isNeighborCellsEmpty = true;
                    ArrayList<int[]> neighborCellCoords = getNeighborCellsCoords(null, getCellCoordsByIndex(shipCell.getTestNum()), 0);
                    ArrayList<Cell> neighborCells = getNeighborCells(neighborCellCoords, ship.getShipCells());
                    isNeighborCellsEmpty = isNeighborCellsEmpty(isNeighborCellsEmpty, neighborCells);
                    if (isNeighborCellsEmpty) {
                        ship.addCell(shipCell);
                        shipLengthCounter--;
                        //next shipCell coords
                        if (shipLengthCounter == 0) {
                            shipAdded = true;
                            for (Cell cell : ship.getShipCells()) {
                                cell.setShipPointer(ship);
                                cell.setValue(Cell.CellValue.SHIP);
                            }
                        } else {
                            //return to get cell by coords
                            shipCoord[shipAxis] = shipCoord[shipAxis] + direction;
                        }
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        } while (!shipAdded);
        return true;
    }

    int[] getRandomNotShootCoord() {
        int[] cellCoord = new int[numOfDimensions];
        Cell.CellValue cellValue;
        do {
            getRandomCoord(cellCoord);
            cellValue = getCellByCoords(cellCoord).getValue();
        } while (cellValue != Cell.CellValue.EMPTY && cellValue != Cell.CellValue.SHIP);
        return cellCoord;
    }

    private void getRandomCoord(int[] shipCoord) {
        for (int i = 0; i < numOfDimensions; i++) {
            shipCoord[i] = new Random().nextInt(size);
        }
    }

    boolean fire(int[] cords) {
        Cell selectedCell;
        selectedCell = cells.get(getCellIndexByCoords(cords));
        switch (selectedCell.getValue()) {
            case SHIP:
                selectedCell.setValue(Cell.CellValue.DAMAGE);
                Ship curentShip = selectedCell.getShipPointer();
                if (curentShip.addDamage()) {
                    System.out.println(curentShip + WAS_DESTROED);
                    decreaseAliveShipCounter();
                    markNeighborCells(curentShip);
                }
                return true;
            case EMPTY:
                selectedCell.setValue(Cell.CellValue.SHOT);
                return false;
            default:
                return false;
        }
    }

    private boolean isNeighborCellsEmpty(boolean isNeighborCellsEmpty, ArrayList<Cell> neighborCells) {
        for (Cell cell : neighborCells) {
            if (cell.getValue() != Cell.CellValue.EMPTY) {
                isNeighborCellsEmpty = false;
                break;
            }
        }
        return isNeighborCellsEmpty;
    }

    private void markNeighborCells(Ship ship) {
        ArrayList<Cell> shipCells = ship.getShipCells();
        ArrayList<Cell> neighborCells;
        for (Cell shipCell : shipCells) {
            ArrayList<int[]> neighborCellCoords = getNeighborCellsCoords(null, getCellCoordsByIndex(shipCell.getTestNum()), 0);
            neighborCells = getNeighborCells(neighborCellCoords, shipCells);
            for (Cell neighborCell : neighborCells) {
                neighborCell.setValue(Cell.CellValue.SHOT);
            }
        }
    }

    int getSize() {
        return size;
    }

    int getNumOfDimensions() {
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

    private boolean doesCellExist(int[] coords) {
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

    private Cell getCellByCoords(int[] coords) {
        int cellIngex = getCellIndexByCoords(coords);
        if (cellIngex > -1) {
            return cells.get(cellIngex);
        } else {
            return null;
        }
    }

    private int getCellIndexByCoords(int[] coords) {
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

    private ArrayList<Cell> getNeighborCells(ArrayList<int[]> neighborCellsCoords, ArrayList<Cell> excludeCell) {
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

    private ArrayList<int[]> getNeighborCellsCoords(ArrayList<int[]> neighborCoords, int[] coords, int coordsNum) {
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

    private int[] getCellCoordsByIndex(int cellNum) {
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
