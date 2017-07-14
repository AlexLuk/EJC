package task_03.SeaBattle;

import java.io.IOException;
import java.util.ArrayList;

public class Game {
    private static final int[] SHIPS_BY_SIZE = {4, 3, 2, 1};
    private static final int MAX_INITIALIZE_TRY_COUNTER = 100;
    private static final boolean IS_CHEAT_MODE_ON = false;
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
    private boolean doesComputerWin = true;

    public Game(int dimensions, int fieldSize) {
        this.dimensions = dimensions;
        this.fieldSize = fieldSize;
        if (!setupGame()){
            consoleHelper.setupFailed();
        };
    }

    private boolean setupGame() {
        player = new Player();
        boolean isInitialized = false;
        int initializeTryCounter = 0;
        while (!isInitialized && initializeTryCounter < MAX_INITIALIZE_TRY_COUNTER) {
            field = new MultiDimensionArray(fieldSize, dimensions);
            ships = new ArrayList<>();
            isInitialized = initializeShips(ships, field);
            initializeTryCounter++;
        }
        if (!isInitialized) {
            return false;
        }
        isInitialized = false;
        initializeTryCounter = 0;
        while (!isInitialized && initializeTryCounter < MAX_INITIALIZE_TRY_COUNTER) {
            computerField = new MultiDimensionArray(fieldSize, dimensions);
            computerShips = new ArrayList<>();
            isInitialized = initializeShips(computerShips, computerField);
            initializeTryCounter++;
        }
        consoleHelper = new ConsoleHelper(field.getNumOfDimensions(), field.getSize());
        if (!isInitialized) {
            return false;
        } else {
            return true;
        }
    }

    private boolean initializeShips(ArrayList<Ship> ships, MultiDimensionArray field) {
        for (int i = 0; i < SHIPS_BY_SIZE.length; i++) {
            for (int j = 0; j < SHIPS_BY_SIZE[i]; j++) {
                ships.add(new Ship(i + 1));
            }
        }
        if (!field.addShips(ships)) {
            return false;
        }
        return true;
    }


    public boolean runGame() {
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
                        consoleHelper.playerMovePrint();
                        userInputCoords = consoleHelper.getCoordsInput();
                        isSuccessfullMatch = computerField.fire(userInputCoords);
                        computerField.printField(IS_CHEAT_MODE_ON);
                        if (computerField.areAllShipsDestroedChecker()) {
                            isGameRunning = false;
                            doesComputerWin = false;
                        }
                        isPlayerTurn = false;
                    }
                } else {
                    computerMovesCounter++;
                    while (isSuccessfullMatch && isGameRunning) {
                        //else computer
                        consoleHelper.computerMovePrint();
                        computerInputCoords = field.getRandomNotShootCoord();
                        isSuccessfullMatch = field.fire(computerInputCoords);
                        field.printField(IS_CHEAT_MODE_ON);
                        if (field.areAllShipsDestroedChecker()) {
                            isGameRunning = false;
                        }
                        isPlayerTurn = true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            consoleHelper.playerInputClose();
        }
        consoleHelper.winnerPrint(doesComputerWin, computerMovesCounter, playerMovesCounter);
        return true;
    }


}
