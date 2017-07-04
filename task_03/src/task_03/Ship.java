package task_03;

import sun.security.provider.SHA;

import java.util.ArrayList;

public class Ship {
    private boolean isDestroed = false;

    public int getSize() {
        return size;
    }

    private int size=0;
    private  ArrayList<Cell> shipCells;

    public Ship(int size) {
        this.size = size;
        shipCells=new ArrayList<Cell>(size);
    }
}
