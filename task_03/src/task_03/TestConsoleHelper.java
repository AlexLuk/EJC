package task_03;

import java.util.ArrayList;

public class TestConsoleHelper {
    public static void main(String[] args) {
        ConsoleHelper consoleHelper = new ConsoleHelper(3,6);
        consoleHelper.printGreeting();
        ArrayList<Integer> coords = null;

        while (coords==null){
            System.out.println(coords = consoleHelper.getCoordsInput());

        }
    }
}
