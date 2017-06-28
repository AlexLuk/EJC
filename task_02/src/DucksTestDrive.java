import java.util.ArrayList;
import java.util.Random;

public class DucksTestDrive {
    public static void main(String[] args) {
        ArrayList<Duck> ducks = new ArrayList<>();
        addDucksInRace(ducks);
        flyRace(ducks);
        System.out.println("---------------------------------------------");
        System.out.println("Winner is duck number " + getWinnerIndex(ducks) + 1);
    }

    private static void flyRace(ArrayList<Duck> ducks) {
        for (int i = 0; i <= 9; i++) {
            System.out.println("----------Second " + i + 1 + " ----------");
            for (Duck duck : ducks) {
                duck.display();
                duck.performFly();
                System.out.println("Now my position is " + duck.getPositionOnTrack());
            }
        }
    }

    private static void addDucksInRace(ArrayList<Duck> ducks) {
        int randomDuckChooser = new Random().nextInt(1);
        for (int i = 0; i < 5; i++) {
            switch (randomDuckChooser) {
                case 0:
                    ducks.add(new RedHeadDuck());
                    break;
                case 1:
                    ducks.add(new RubberDuck());
                    break;
            }
        }
    }

    private static int getWinnerIndex(ArrayList<Duck> ducks) {
        int maxDistance = 0;
        int duckIndex = 0;
        for (int i = 0; i < ducks.size(); i++) {
            int duckPosition = ducks.get(i).getPositionOnTrack();

            if (duckPosition > maxDistance) {
                maxDistance = duckPosition;
                duckIndex = i;
            }
        }
        return duckIndex;
    }
}
