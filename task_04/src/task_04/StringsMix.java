package task_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringsMix {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line = bufferedReader.readLine();
            System.out.println(getOddString(line));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String testInpString = " 0    1232 1 0";
        testInpString = testInpString.replaceAll(" ", "");
        System.out.println(testInpString);
        System.out.println(reverseString(testInpString));
        System.out.println(testInpString.equals(reverseString(testInpString)));
    }

    static String getOddString(String inputString) {
        char[] inputStrToChar = inputString.toCharArray();
        StringBuilder outputString = new StringBuilder();
        for (int i = 0; i < inputString.length(); i++) {
            if (i % 2 != 1) {
                outputString.append(inputStrToChar[i]);
            }
        }
        return outputString.toString();
    }

    static String reverseString(String inputString) {
        String outputString = "";
        char[] inputStrToChar = inputString.toCharArray();
        int charArrayLength = inputStrToChar.length;
        char[] outputChar = new char[charArrayLength];
        for (int i = 0; i < inputStrToChar.length; i++) {
            outputChar[charArrayLength - i - 1] = inputStrToChar[i];
        }
        outputString = String.valueOf(outputChar);
        return outputString;
    }
}
