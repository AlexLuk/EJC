package task_03;

import java.util.ArrayList;
import java.util.Random;

public class Field {
    private int dimensions = 2;
    private ArrayList<Cell> cells;
    private int numOfCells;
    private int size = 10;

    public Field(int dimensions, int size) {
        this.dimensions = dimensions;
        this.size = size;
        numOfCells = (int) Math.pow(size, dimensions);
        cells = new ArrayList<Cell>(numOfCells);
        initializeField();
        printField();
    }

    public Field() {
    }

    private void initializeField() {
        for (int i = 0; i < numOfCells; i++) {
            cells.add(new Cell(Cell.CellValue.EMPTY));
        }
    }


    public void printField() {
        for (int i = 0; i < cells.size(); i++) {
            if (i % size == 0) {
                System.out.println();
            } else {
                String printSymbol;
                switch (cells.get(i).getValue()) {
                    case SHOT:
                        printSymbol="o";
                        break;
                    case EMPTY:
                        printSymbol="?";
                        break;
                    case DAMAGE:
                        printSymbol="#";
                        break;
                    default:
                        printSymbol="?";
                }
                System.out.print(" " + printSymbol);
            }
        }
    }

    public boolean addShip(Ship ship) {
        boolean isAddedSuccesfuly = false;
        int[] cellsIndexes = new int[ship.getSize()];
        while (!isAddedSuccesfuly) {
            int startIndex = new Random().nextInt(numOfCells);
            Cell.CellValue startCellValue = cells.get(startIndex).getValue();
            if (startCellValue != Cell.CellValue.EMPTY) {
                continue;
            }
            int direction = new Random().nextBoolean() ? -1 : 1;
            boolean isHorisontal = new Random().nextBoolean();
            if (isHorisontal) {

            }

        }
        boolean isNextAddSuccesfull = true;
        return true;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getDimensions() {
        return dimensions;
    }

    public void setDimensions(int dimensions) {
        this.dimensions = dimensions;
    }
}
