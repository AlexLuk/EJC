package task_11.process_files_in_threads;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class ReportFilesGenerator {
    private final static String SITE_NAMES_FILE = "Sites.txt";
    private final static String USER_NAMES_FILE = "Names.txt";
    private final static String REPORT_NAME_TEMPLATE = "report";
    private final static String REPORT_HEADER = "id,url,time,user\r\n";
    private final static int MIN_VISIT_DURATION = 4_000;
    private final static int MAX_VISIT_DURATION = 100_000;
    private static final int VISIT_DURATION_INTERVAL = MAX_VISIT_DURATION - MIN_VISIT_DURATION;

    private final static int MIN_REPORT_LENGTH = 10;
    private final static int MAX_REPORT_LENGTH = 20;
    private String filesFolder = "src/main/resources/task_11";
    private String filesExtension = ".csv";
    private int numOfFiles = 20;
    private ArrayList<String> userNames;
    private ArrayList<String> siteNames;

    public ReportFilesGenerator(String filesFolder, String filesExtension, int numOfFiles) {
        this();
        this.filesFolder = filesFolder;
        this.filesExtension = filesExtension;
        this.numOfFiles = numOfFiles;
    }

    public ReportFilesGenerator() {
        userNames = new ArrayList<>();
        siteNames = new ArrayList<>();
    }

    public ReportFilesGenerator(int numOfFiles) {
        this();
        this.numOfFiles = numOfFiles;
    }

    public int generateFiles() {
        int generatedFilesCounter = 0;
        Random randomizer = new Random();
        loadConfigurationFile(filesFolder + "/" + USER_NAMES_FILE, userNames);
        loadConfigurationFile(filesFolder + "/" + SITE_NAMES_FILE, siteNames);
        while (generatedFilesCounter<numOfFiles) {
            File file = new File(filesFolder + "/" + REPORT_NAME_TEMPLATE + generatedFilesCounter + filesExtension);
            try {
                try (FileWriter fileWriter = new FileWriter(file)) {
                    int numOfReportEntries = randomizer.nextInt(MAX_REPORT_LENGTH - MIN_REPORT_LENGTH) + MIN_REPORT_LENGTH;
                    fileWriter.write(REPORT_HEADER);
                    for (int entryCounter = 0; entryCounter < numOfReportEntries; entryCounter++) {
                        StringBuilder entryString = getEntryString(randomizer, entryCounter);
                        fileWriter.write(entryString.toString());
                    }
                    fileWriter.flush();
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            generatedFilesCounter++;
        }
        return generatedFilesCounter;
    }

    private StringBuilder getEntryString(Random randomizer, int entryCounter) {
        String currentEntrySiteName;
        String currentEntryUserName;
        int currentEntryVisitTime;
        StringBuilder entryString = new StringBuilder();
        entryString.append(String.valueOf(entryCounter)).append(",");

        currentEntrySiteName = siteNames.get(randomizer.nextInt(siteNames.size()));
        entryString.append(currentEntrySiteName).append(",");

        currentEntryVisitTime = randomizer.nextInt(VISIT_DURATION_INTERVAL) + MIN_VISIT_DURATION;
        entryString.append(currentEntryVisitTime).append(",");

        currentEntryUserName = userNames.get(randomizer.nextInt(userNames.size()));
        entryString.append(currentEntryUserName).append("\r\n");
        return entryString;
    }

    private void loadConfigurationFile(String fileName, ArrayList<String> configList) {
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
                        configList.add(stringBuilder.toString());
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
