package task_03;

public class Game {
    private static final int[] SHIPS_BY_SIZE={4,3,2,1};
    private Field field;
    private ConsoleHelper consoleHelper;
    private Player player;
    private int dimensions;
    private int fieldSize;

    public Game(int dimensions, int fieldSize) {
        this.dimensions = dimensions;
        this.fieldSize = fieldSize;
    }

    boolean setupGame() {
        field = new Field(dimensions,fieldSize);

        consoleHelper = new ConsoleHelper(field.getDimensions(),field.getSize());
        player = new Player();
        return true;
    }

    boolean runGame() {
        return true;
    }

}
