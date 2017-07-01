import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DucksTestDrive {
    public static void main(String[] args) {
        ArrayList<Duck> ducks = new ArrayList<>();
        int playerMoney = 500;
        Scanner playerInputScanner = new Scanner(System.in);

        gameCycle(ducks, playerMoney, playerInputScanner);

        System.out.println("You lost all your money. You are looser!");
    }

    private static void gameCycle(ArrayList<Duck> ducks, int playerMoney, Scanner playerInputScanner) {
        int choosenDuckIndex=0;
        addDucksInRace(ducks);
        while (playerMoney > 99) {
            boolean isPlayerInputAcceptable=false;
            while(!isPlayerInputAcceptable) {
                System.out.println("Please choose your duck number from 1 to " + ducks.size() + " :");
                String userInputString=playerInputScanner.nextLine();
                try{
                    choosenDuckIndex = Integer.valueOf(userInputString);
                    if(choosenDuckIndex<1 || choosenDuckIndex>ducks.size()){
                        System.out.println("Wrong index");
                    }else{
                        isPlayerInputAcceptable=true;
                    }
                }catch (NumberFormatException e){
                    System.out.println("Invalid number format");
                }

            }
            choosenDuckIndex = choosenDuckIndex - 1;
            playerMoney -= 100;
            moveDucksToStart(ducks);
            flyRace(ducks);
            ArrayList<Integer> winnerDuckIndexes = getWinnerIndexes(ducks);
            System.out.print("Winner is ducks number(s) ");
            for (Integer duckIndex : winnerDuckIndexes) {
                System.out.print((duckIndex.intValue() + 1) + " ");
            }
            System.out.println();
            if (winnerDuckIndexes.contains(Integer.valueOf(choosenDuckIndex))) {
                playerMoney += 200;
                System.out.println("You were right! Get your 200$) Now you have " + playerMoney);
            } else {
                System.out.println("You were wrong(( You have lost 100$  Now you have " + playerMoney);
            }
            System.out.println("---------------------------------------------");
        }
    }

    private static void moveDucksToStart(ArrayList<Duck> ducks) {
        for (Duck duck : ducks) {
            duck.moveDuckToStart();
        }
    }

    private static void flyRace(ArrayList<Duck> ducks) {
        for (int i = 0; i <= 9; i++) {
//            System.out.println("----------Second " + (i + 1) + " ----------");
            for (Duck duck : ducks) {
                duck.display();
                duck.performFly();
//                System.out.println("Now my position is " + duck.getPositionOnTrack());
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

    private static ArrayList<Integer> getWinnerIndexes(ArrayList<Duck> ducks) {
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
}
