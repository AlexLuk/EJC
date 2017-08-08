package task_11.process_files_in_threads;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReportFilesGenerator {
    //rename constants!
    private final static String siteNamesFile = "Sites.txt";
    private final static String userNamesFile = "Names.txt";
    private final static int minVisitDuration = 4_000;
    private final static int maxVisitDuration = 100_000;
    private final static int minReportLength = 10;
    private final static int maxReportLength = 1000;
    private String filesFolder = "src/main/resources/task_11";
    private String filesExtension = ".csv";
    private int numOfFiles = 20;
    private ArrayList<String> userNames;
    private ArrayList<String> siteNames;


    public ReportFilesGenerator(String filesFolder, String filesExtension, int numOfFiles) {
        super();
        this.filesFolder = filesFolder;
        this.filesExtension = filesExtension;
        this.numOfFiles = numOfFiles;
    }

    public ReportFilesGenerator() {
        userNames = new ArrayList<>();
        siteNames = new ArrayList<>();
    }

    public int generateFiles() {
        int generatedFilesCounter = 0;
        loadNames(filesFolder + "/" + userNamesFile);
        return generatedFilesCounter;
    }

    private void loadNames(String fileName) {
        File file = new File(fileName);

        try {
            FileReader fileReader = new FileReader(file);
            int symbol;
            try {
                StringBuilder stringBuilder = new StringBuilder();
                while ((symbol = fileReader.read()) != -1) {
                    if (symbol != '\n') {
                        if (symbol != '\r') {
                            stringBuilder.append((char) symbol);
                        }
                    } else {
                        userNames.add(stringBuilder.toString());
                        stringBuilder = new StringBuilder();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
