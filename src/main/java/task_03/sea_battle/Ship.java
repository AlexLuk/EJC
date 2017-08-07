package task_03.sea_battle;

import java.util.ArrayList;

public class Ship {
    private boolean isDestroed = false;
    private int liveCellsCounter = 0;
    private int size = 0;
    private ArrayList<Cell> shipCells;

    Ship(int size) {
        this.size = size;
        shipCells = new ArrayList<Cell>(size);
        liveCellsCounter = size;
    }

    int getSize() {
        return size;
    }

    boolean addDamage() {
        if (!isDestroed) {
            liveCellsCounter--;
            if (liveCellsCounter == 0) {
                isDestroed = true;
                return true;
            }
            return false;
        } else {
            return false;
        }
    }

    ArrayList<Cell> getShipCells() {
        return shipCells;
    }

    boolean addCell(Cell cell) {
        shipCells.add(cell);
        return true;
    }

    boolean clearShipCells() {
        shipCells.clear();
        return true;
    }

    @Override
    public String toString() {
        return "Ship{" +
                ", size=" + size +
                ", shipCells=" + shipCells +
                '}';
    }
}
