package task_03;

public class Main {
    private final static int DIMENSIONS =3;
    private final static int FIELD_SIZE =5;


    public static void main(String[] args) {
        Game seaBattle = new Game(DIMENSIONS, FIELD_SIZE);
        seaBattle.setupGame();
        seaBattle.runGame();
    }


}
