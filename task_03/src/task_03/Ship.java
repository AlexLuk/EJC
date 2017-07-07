package task_03;

import sun.security.provider.SHA;

import java.util.ArrayList;

public class Ship {
    private boolean isDestroed = false;

    public int getSize() {
        return size;
    }

    private int size=0;

    public ArrayList<Cell> getShipCells() {
        return shipCells;
    }

    private  ArrayList<Cell> shipCells;

    public Ship(int size) {
        this.size = size;
        shipCells=new ArrayList<Cell>(size);
    }

    public boolean addCell(Cell cell){
        shipCells.add(cell);
        return true;
    }

    public boolean clearShipCells(){
        shipCells.clear();
        return true;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "isDestroed=" + isDestroed +
                ", size=" + size +
                ", shipCells=" + shipCells +
                '}';
    }
}
