package task_03;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    private static final int[] SHIPS_BY_SIZE = {4, 3, 2, 1};
    //private static final int[] SHIPS_BY_SIZE={4};
    private MultiDimensionArray field;
    private MultiDimensionArray computerField;
    private ConsoleHelper consoleHelper;
    private Player player;
    private int dimensions;
    private int fieldSize;
    private ArrayList<Ship> ships;
    private ArrayList<Ship> computerShips;
    private int playerMovesCounter = 0;
    private int computerMovesCounter = 0;

    public Game(int dimensions, int fieldSize) {
        this.dimensions = dimensions;
        this.fieldSize = fieldSize;
    }

    boolean setupGame() {
        //user and computer fields
        field = new MultiDimensionArray(fieldSize, dimensions);
        computerField = new MultiDimensionArray(fieldSize, dimensions);
        //user and computer ships
        ships = new ArrayList<Ship>();
        computerShips = new ArrayList<Ship>();
        //initialize console helper
        consoleHelper = new ConsoleHelper(field.getNumOfDimensions(), field.getSize());
        //initialize user and computer ships
        initializeShips(ships,field);
        initializeShips(computerShips,computerField);
        player = new Player();
        return true;
    }

    private boolean initializeShips(ArrayList<Ship> ships, MultiDimensionArray field) {
        for (int i = 0; i < SHIPS_BY_SIZE.length; i++) {
            for (int j = 0; j < SHIPS_BY_SIZE[i]; j++) {
                ships.add(new Ship(i));
            }
        }
        if (!field.addShips(ships)) {
            consoleHelper.setupFailed();
            return false;
        }
        return true;
    }

    private void printShips() {
        for (Ship ship : ships) {
            System.out.println(ship);
        }
    }

    boolean runGame() {
        boolean isGameRunning = true;
        boolean isPlayerTurn = true;
        boolean isSuccessfullMatch = true;
        ArrayList<Integer> userInputCoords;
        int[] computerInputCoords = new int[dimensions];
        while (isGameRunning) {
            isSuccessfullMatch = true;
            if (isPlayerTurn) {
                playerMovesCounter++;
                while (isSuccessfullMatch) {
                    isSuccessfullMatch = false;
                    System.out.println();
                    System.out.println("Player turn");
                    userInputCoords = consoleHelper.getCoordsInput();
                    //check field for matches
//                        if (field.checkFire(userInputCoords)) {
//                            isSuccessfullMatch = true;
//                        }
                    //mark field with match
                    //check game for end
//                        if (field.allShipsDestroed) {
//                            isGameRunning = false;
//                        }
                    isPlayerTurn = false;
                }
            } else {
                computerMovesCounter++;
                while (isSuccessfullMatch) {
                    isSuccessfullMatch = false;
                    //else computer
                    System.out.println();
                    System.out.println("Computer turn");
                    //gen computer input
                    for (int i = 0; i < dimensions; i++) {
                        computerInputCoords[i] = new Random().nextInt();
                    }
                    //check for field matches
                    //check for gme end
                    isPlayerTurn = true;
                }
            }

            field.printField();
        }
        return true;
    }

}
