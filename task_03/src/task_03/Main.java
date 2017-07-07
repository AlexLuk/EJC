package task_03;

public class Main {
    private final static int DIMENSIONS =2;
    private final static int FIELD_SIZE =3;


    public static void main(String[] args) {
        Game seaBattle = new Game(DIMENSIONS, FIELD_SIZE);
        seaBattle.setupGame();
        seaBattle.runGame();
    }


}
