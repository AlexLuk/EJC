package task_03;

public class TestConsoleHelper {
    public static void main(String[] args) {
        ConsoleHelper consoleHelper = new ConsoleHelper(3,6);
        consoleHelper.printGreeting();

        while (true){
            System.out.println(consoleHelper.getCoordsInput());
        }
    }
}
