package task_03;

import task_03.SeaBattle.Game;

public class Main {
    private final static int DIMENSIONS = 2;
    private final static int FIELD_SIZE = 2;


    public static void main(String[] args) {
        Game seaBattle = new Game(DIMENSIONS, FIELD_SIZE);
        seaBattle.setupGame();
        seaBattle.runGame();
    }


}
