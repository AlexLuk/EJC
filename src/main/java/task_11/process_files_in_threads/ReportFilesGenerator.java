package task_11.process_files_in_threads;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class is designed to generate random report files
 */
public class ReportFilesGenerator {
    private String filesFolder = ResourceHolder.RESOURCE_FOLDER_PATH;
    private String filesExtension = ResourceHolder.FILE_EXTENSION;
    private int numOfFiles = ResourceHolder.NUM_OF_REPORT_FILES;
    private ArrayList<String> userNames;
    private ArrayList<String> siteNames;
    private Random randomiser;

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

    /**
     * Method is designed to generate random files based on values from settings files
     *
     * @return - generated files counter
     */
    public int generateFiles() {
        int generatedFilesCounter = 0;
        randomiser = new Random();

        String generatorSettingsFolder = filesFolder + "/" + ResourceHolder.GENERATOR_FOLDER + "/";
        loadConfigurationFile(generatorSettingsFolder + ResourceHolder.USER_NAMES_FILE, userNames);
        loadConfigurationFile(generatorSettingsFolder + ResourceHolder.SITE_NAMES_FILE, siteNames);

        while (generatedFilesCounter < numOfFiles) {
            File file = new File(filesFolder + "/"
                    + ResourceHolder.REPORT_NAME_TEMPLATE
                    + generatedFilesCounter
                    + filesExtension);

            try (FileWriter fileWriter = new FileWriter(file)) {
                int numOfReportEntries = randomiser.nextInt(ResourceHolder.MAX_REPORT_LENGTH
                        - ResourceHolder.MIN_REPORT_LENGTH) + ResourceHolder.MIN_REPORT_LENGTH;
                fileWriter.write(ResourceHolder.REPORT_HEADER);

                for (int entryCounter = 0; entryCounter < numOfReportEntries; entryCounter++) {
                    StringBuilder entryString = generateEntryString(entryCounter);
                    fileWriter.write(entryString.toString());
                }

                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            generatedFilesCounter++;
        }
        return generatedFilesCounter;
    }

    /**
     * Method is designed to generate valid id - url - user - id strings for random reports
     *
     * @param entryCounter - current entry number
     * @return - entry string prepared for import to report file
     */
    private StringBuilder generateEntryString(int entryCounter) {
        String currentEntrySiteName;
        String currentEntryUserName;
        int currentEntryVisitTime;
        StringBuilder entryString = new StringBuilder();
        entryString.append(String.valueOf(entryCounter)).append(",");

        currentEntrySiteName = siteNames.get(randomiser.nextInt(siteNames.size()));
        entryString.append(currentEntrySiteName).append(",");

        currentEntryVisitTime = randomiser.nextInt(ResourceHolder.VISIT_DURATION_INTERVAL) + ResourceHolder.MIN_VISIT_DURATION;
        entryString.append(currentEntryVisitTime).append(",");

        currentEntryUserName = userNames.get(randomiser.nextInt(userNames.size()));
        entryString.append(currentEntryUserName).append("\r\n");
        return entryString;
    }

    /**
     * Method is designed to load configuration file with list of values for report generation
     *
     * @param fileName   - name of file to be loaded
     * @param configList - name of configuration list to be filled
     */
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
