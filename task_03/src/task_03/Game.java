package task_03;

import java.util.ArrayList;
import java.util.Arrays;

public class Game {
    private static final int[] SHIPS_BY_SIZE={4,3,2,1};
    //private static final int[] SHIPS_BY_SIZE={4};
    private MultiDimensionArray field;
    private ConsoleHelper consoleHelper;
    private Player player;
    private int dimensions;
    private int fieldSize;
    private ArrayList<Ship> ships;

    public Game(int dimensions, int fieldSize) {
        this.dimensions = dimensions;
        this.fieldSize = fieldSize;
    }

    boolean setupGame() {
        field = new MultiDimensionArray(fieldSize,dimensions);
        ships = new ArrayList<Ship>();
        initializeShips();
        field.addShips(ships);
        System.out.println("ships after add");
        printShips();
        consoleHelper = new ConsoleHelper(field.getNumOfDimensions(),field.getSize());
        player = new Player();
        return true;
    }

    private boolean initializeShips() {
        for (int i = 0; i < SHIPS_BY_SIZE.length; i++) {
            for (int j = 0; j < SHIPS_BY_SIZE[i]; j++) {
                ships.add(new Ship(i));
            }
        }
        return true;
    }

    private void printShips(){
        for (Ship ship : ships){
            System.out.println(ship);
        }
    }

    boolean runGame() {
        field.printField();
        return true;
    }

}
