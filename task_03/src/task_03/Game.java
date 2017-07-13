package task_03;

import java.io.IOException;
import java.util.ArrayList;

public class Game {
    //    private static final int[] SHIPS_BY_SIZE = {4, 3, 2, 1};

    private static final int[] SHIPS_BY_SIZE = {1};
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
        initializeShips(ships, field);
        initializeShips(computerShips, computerField);
        player = new Player();
        return true;
    }

    private boolean initializeShips(ArrayList<Ship> ships, MultiDimensionArray field) {
        for (int i = 0; i < SHIPS_BY_SIZE.length; i++) {
            for (int j = 0; j < SHIPS_BY_SIZE[i]; j++) {
                ships.add(new Ship(i + 1));
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
        int[] userInputCoords;
        int[] computerInputCoords = new int[dimensions];
        try {
            while (isGameRunning) {
                isSuccessfullMatch = true;
                if (isPlayerTurn) {
                    playerMovesCounter++;
                    while (isSuccessfullMatch && isGameRunning) {
                        isSuccessfullMatch = false;
                        System.out.println();
                        System.out.println("Player turn");
                        userInputCoords = consoleHelper.getCoordsInput();
                        isSuccessfullMatch = computerField.fire(userInputCoords);
                        computerField.printField();
                        if (computerField.areAllShipsDestroedChecker()) {
                            isGameRunning = false;
                        }
                        isPlayerTurn = false;
                    }
                } else {
                    computerMovesCounter++;
                    while (isSuccessfullMatch && isGameRunning) {
                        isSuccessfullMatch = false;
                        //else computer
                        System.out.println();
                        System.out.println("Computer turn");
                        computerInputCoords = field.getRandomNotShootCoord();
                        isSuccessfullMatch = field.fire(computerInputCoords);
                        field.printField();
                        if (field.areAllShipsDestroedChecker()) {
                            isGameRunning = false;
                        }
                        isPlayerTurn = true;
                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        finally {
            consoleHelper.playerInputClose();
        }
        System.out.println("Computer move counter" + computerMovesCounter);
        System.out.println("Player move counter " + playerMovesCounter);
        return true;
    }

}
