package task_03.SeaBattle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ConsoleHelper {
    private static final String GREETING_TEXT = "GREETING_TEXT";
    private static final String SETUP_FAILED = "Game setup failed";
    private static final String SHIP_CREATION_FAILED = "Ship creation failed";
    private static final String ASK_INPUT_TEXT1 = "Please input ";
    private static final String ASK_INPUT_TEXT2 = " values from 1 to ";
    private static final String DEFAULT_TEXT = "SOME DEFAULT TEXT";
    private static final String WRONG_NUMBER_FORMAT_TEXT = "Invalid number format";
    private static final String WRONG_DINENSIONS_NUMBER = "Wrong number of coordinats";
    private static final String WRONG_COORD_VALUE = "Wrong value of coordinats";
    private static final String VALIDATION_STRING = "0123456789 ";
    private static final int COORD_TO_INDEX = -1;
    private static final String COMPUTER_MOVE_COUNTER = "Computer move counter ";
    private static final String PLAYER_MOVE_COUNTER = "Player move counter ";
    private static final String IS_WINNER = " is winner";
    private static final String PLAYER = "Player";
    private static final String COMPUTER = "Computer";
    private static final String COMPUTER_TURN = "Computer turn";
    private static final String PLAYER_TURN = "Player turn";
    private BufferedReader playerInputScanner;
    private int dimensions;
    private int fieldSize;
    private int numOfCells;


    public ConsoleHelper(int dimensions, int fieldSize) {
        this.dimensions = dimensions;
        this.fieldSize = fieldSize;
        numOfCells = (int) Math.pow(fieldSize, dimensions);
    }

    /**
     * Check for unsufficient symbols in stringForCheck
     *
     * @param stringForCheck
     * @return True if all symbols are sufficient
     */
    private static boolean isSufficient(String stringForCheck) {
        char[] symbols = stringForCheck.toCharArray();
        for (char c : symbols) {
            if (VALIDATION_STRING.indexOf(c) == -1) return false;
        }
        return true;
    }

    public void playerInputClose() {
        try {
            playerInputScanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setupFailed() {
        printText(SETUP_FAILED);
    }

    void printGreeting() {
        printText(GREETING_TEXT);
    }

    /**
     * Get user input and parse it to coordinates. Validate number, format and value of coordinates.
     *
     * @return
     */
    public int[] getCoordsInput() throws IOException {
        ArrayList<Integer> coords = new ArrayList<Integer>();
        boolean isPlayerInputAcceptable = false;

        try {
            playerInputScanner = new BufferedReader(new InputStreamReader(System.in));
            while (!isPlayerInputAcceptable) {
                System.out.println(ASK_INPUT_TEXT1 + dimensions + ASK_INPUT_TEXT2 + (fieldSize));
                String userInputString = playerInputScanner.readLine();
                try {
                    coords = parseString(userInputString);
                    if (areDimensionsValid(coords)) {
                        if (areCoordsValid(coords)) {
                            isPlayerInputAcceptable = true;
                        } else {
                            System.out.println(WRONG_COORD_VALUE);
                        }
                    } else {
                        System.out.println(WRONG_DINENSIONS_NUMBER);
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println(WRONG_NUMBER_FORMAT_TEXT);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
//        } finally {
//            try {
//                playerInputScanner.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
        return coords.stream().mapToInt(i -> i).toArray();
    }

    private boolean areDimensionsValid(ArrayList<Integer> coords) {
        return coords.size() == dimensions;

    }

    private boolean areCoordsValid(ArrayList<Integer> coords) {
        for (Integer coord : coords) {
            if ((int) coord > fieldSize - 1 || coord < 0) {
                return false;
            }
        }
        return true;
    }

    private ArrayList<Integer> parseString(String s) {
        ArrayList<Integer> coords = new ArrayList<Integer>();
        s = s.replaceAll("\\s+", " ");

        if (!isSufficient(s)) {
            throw new NumberFormatException();
        }

        String[] items = s.split(" ");
        for (int i = 0; i < items.length; i++) {
            try {
                coords.add(Integer.parseInt(items[i]) + COORD_TO_INDEX);
            } catch (NumberFormatException nfe) {
                throw nfe;
            }
        }
        return coords;
    }

    private boolean printText(String text) {
        if (text != null && !text.trim().isEmpty()) {
            System.out.println(text);
            return true;
        } else {
            System.out.println(DEFAULT_TEXT);
            return false;
        }
    }

    public void winnerPrint(boolean doesComputerWin, int computerMovesCounter, int playerMovesCounter ) {
        System.out.println(doesComputerWin? COMPUTER : PLAYER + IS_WINNER);
        System.out.println(COMPUTER_MOVE_COUNTER + computerMovesCounter);
        System.out.println(PLAYER_MOVE_COUNTER + playerMovesCounter);
    }

    public void playerMovePrint() {
        System.out.println();
        System.out.println(PLAYER_TURN);
    }

    public void computerMovePrint() {
        System.out.println();
        System.out.println(COMPUTER_TURN);
    }
}