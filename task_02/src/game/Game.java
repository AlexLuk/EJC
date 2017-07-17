package game;

import ducks.Duck;
import ducks.RedHeadDuck;
import ducks.RubberDuck;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    private ConsoleHelper consoleHelper = new ConsoleHelper();
    private Player player = new Player();
    private ArrayList<Duck> ducks = new ArrayList<>();


    public boolean setupGame() {
        addDucksInRace(ducks, 5);
        player.setMoney(500);
        consoleHelper.welcomeMessage(player.getMoney());
        return true;
    }

    public boolean runGame() {
        gameCycle(player);
        consoleHelper.looserMessage();
        return true;
    }

    private void addDucksInRace(ArrayList<Duck> ducks, int numOfDucks) {
        int randomDuckChooser = new Random().nextInt(1);
        for (int i = 0; i < numOfDucks; i++) {
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

    private ArrayList<Integer> getWinnerIndexes(ArrayList<Duck> ducks) {
        int maxDistance = 0;
        ArrayList<Integer> winnerDuckIndexes = new ArrayList<Integer>();
        for (int i = 0; i < ducks.size(); i++) {
            int duckPosition = ducks.get(i).getPositionOnTrack();

            if (duckPosition > maxDistance) {
                maxDistance = duckPosition;
                winnerDuckIndexes.clear();
                winnerDuckIndexes.add(Integer.valueOf(i));
            } else if (duckPosition == maxDistance) {
                winnerDuckIndexes.add(Integer.valueOf(i));
            }
        }
        return winnerDuckIndexes;
    }

    private void flyRace(ArrayList<Duck> ducks) {
        for (int i = 0; i <= 9; i++) {
            for (Duck duck : ducks) {
                duck.performFly();
            }
        }
    }

    private void moveDucksToStart(ArrayList<Duck> ducks) {
        for (Duck duck : ducks) {
            duck.moveDuckToStart();
        }
    }

    private void gameCycle(Player player) {
        int chosenDuckIndex = 0;
        while (player.getMoney() > 99) {
            chosenDuckIndex = consoleHelper.getChoosenDuckIndex(ducks.size()) - 1;
            player.setMoney(player.getMoney() - 100);
            moveDucksToStart(ducks);
            flyRace(ducks);
            ArrayList<Integer> winnerDuckIndexes = getWinnerIndexes(ducks);
            consoleHelper.printWinnerDucksNumbers(winnerDuckIndexes);

            if (winnerDuckIndexes.contains(Integer.valueOf(chosenDuckIndex))) {
                player.setMoney(player.getMoney() + 200);
                consoleHelper.winBidMessage(player.getMoney());
            } else {
                consoleHelper.looseBidMessage(player.getMoney());
            }
            consoleHelper.raceSeparator();
        }
    }


}
