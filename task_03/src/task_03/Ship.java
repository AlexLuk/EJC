package task_03;

import sun.security.provider.SHA;

import java.util.ArrayList;

public class Ship {
    private boolean isDestroed = false;
    private int liveCellsCounter=0;

    public int getSize() {
        return size;
    }

    public boolean addDamage(){
        if (!isDestroed){
            liveCellsCounter--;
            if (liveCellsCounter==0){
                isDestroed=true;
                return true;
            }
            return  false;
        } else{
            return false;
        }
    }

    private int size=0;

    public ArrayList<Cell> getShipCells() {
        return shipCells;
    }

    private  ArrayList<Cell> shipCells;

    public Ship(int size) {
        this.size = size;
        shipCells=new ArrayList<Cell>(size);
        liveCellsCounter=size;
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
                ", size=" + size +
                ", shipCells=" + shipCells +
                '}';
    }
}
