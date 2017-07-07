package task_strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class StringsMix {
    public static void main(String[] args) {
        String testString = "abcdefg";
        System.out.println(getOddString(testString));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line = bufferedReader.readLine();
            System.out.println(getOddString(line));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String getOddString(String inputString){
        char[] inputStrToChar = inputString.toCharArray();
        StringBuilder outputString = new StringBuilder();
        for (int i = 0; i < inputString.length(); i++) {
            if(i%2!=1){
                outputString.append(inputStrToChar[i]);
            }
        }
        return outputString.toString();
    }
}
