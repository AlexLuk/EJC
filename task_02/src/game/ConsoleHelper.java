package game;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 */
public class ConsoleHelper {
    private Scanner playerInputScanner = new Scanner(System.in);

    public void welcomeMessage(int playerMoney) {
        System.out.println("Greeting! You are taking part in Duck Race");
        System.out.println("You have " + playerMoney + "$");
        System.out.println("Please make your bid");
    }

    public void looserMessage() {
        System.out.println("You lost all your money. You are looser!");
    }

    public int getChoosenDuckIndex(int numOfDucks) {
        boolean isPlayerInputAcceptable = false;
        int choosenDuckIndex = 1;
        while (!isPlayerInputAcceptable) {
            System.out.println("Please choose your duck number from 1 to " + numOfDucks + " :");
            String userInputString = playerInputScanner.nextLine();
            try {
                choosenDuckIndex = Integer.valueOf(userInputString);
                if (choosenDuckIndex < 1 || choosenDuckIndex > numOfDucks) {
                    System.out.println("Wrong index");
                } else {
                    isPlayerInputAcceptable = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format");
            }
        }
        return choosenDuckIndex;
    }

    public void printWinnerDucksNumbers(ArrayList<Integer> winnerDuckIndexes) {
        System.out.print("Winner is ducks number(s) ");
        for (Integer duckIndex : winnerDuckIndexes) {
            System.out.print((duckIndex.intValue() + 1) + " ");
        }
        System.out.println();
    }

    public void looseBidMessage(int playerMoney) {
        System.out.println("You were wrong(( You have lost 100$  Now you have " + playerMoney);
    }

    public void winBidMessage(int playerMoney) {
        System.out.println("You were right! Get your 200$) Now you have " + playerMoney);
    }

    public void raceSeparator() {
        System.out.println("---------------------------------------------");
    }
}
