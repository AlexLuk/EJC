package task_03;

public class Main {
    private static int dimensions=2;
    private static int fieldSize=10;


    public static void main(String[] args) {
        Game seaBattle = new Game(dimensions,fieldSize);
        seaBattle.setupGame();
        seaBattle.runGame();
    }


}
