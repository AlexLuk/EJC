import java.util.ArrayList;

public class DucksTestDrive {
    public static void main(String[] args) {
        ArrayList<Duck> ducks = new ArrayList<>();
        ducks.add(new RedHeadDuck());
        ducks.add(new RubberDuck());
        for (Duck duck:ducks) {
            duck.display();
            duck.performFly();
        }
    }
}
