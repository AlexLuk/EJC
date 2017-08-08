package task_11.process_files_in_threads;

import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.Arrays;
import java.util.ResourceBundle;

public class Main {
    //10 csv files with data about user(name - string) url (address - string) time (period - miliseconds) id - long
    //id url time user
    //work all files in separate threads
    //process final data summ data by user, url
    //output to result.csv
    public static void main(String[] args) {
        //load list of files in folder
        //create <=10 FileReaderThread
        //start reading eachFileLineByLine
        //parse readed line to array of Entries (name, site, time)
        //add enties to outer list
        //process data from outer list to result list
        //write output list
        String filename = "src/main/resources/test.txt";
        File file = new File(filename);
        try {
            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write("Hello world!");
                fileWriter.flush();
                fileWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileReader fileReader = new FileReader(file);
            int character =0;
            try {
                while ((character = fileReader.read())!=-1){
                    System.out.print((char)character);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        File folderName = new File("src/main/resources/");
        String fileExtension = ".csv";
       File[] files = folderName.listFiles(new FilenameFilter() {
           @Override
           public boolean accept(File dir, String name) {
               return name.toLowerCase().endsWith(fileExtension);
           }
       });
        System.out.println(Arrays.toString(files));

        ReportFilesGenerator reportFilesGenerator = new ReportFilesGenerator();
        reportFilesGenerator.generateFiles();


    }
}
