package task_11.process_files_in_threads;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class is designed to read file in separate thread
 */
public class FileReaderThread extends Thread {
    private FileReader fileReader;
    private EntriesHolder entriesHolder;
    private ReportProcessor reportProcessor;
    private String fileName;

    FileReaderThread(String fileName, EntriesHolder entriesHolder, ReportProcessor reportProcessor) throws FileNotFoundException {
        this.fileName = fileName;
        fileReader = new FileReader(fileName);
        this.entriesHolder = entriesHolder;
        this.reportProcessor = reportProcessor;
    }

    /**
     * Method is designed to read input file line after line
     * For each readed line method parseString is called
     * Before finishing thread it decreases thread counter in
     * reportProcessor
     */
    @Override
    public void run() {
        int symbol;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            boolean isHeaderLine = true;
            int lineCounter = 1;
            while ((symbol = fileReader.read()) != -1) {
                if (symbol != '\n') {
                    if (symbol != '\r') {
                        stringBuilder.append((char) symbol);
                    }
                } else {
                    if (isHeaderLine) {
                        isHeaderLine = false;
                    } else {
                        parseString(stringBuilder.toString(), lineCounter);
                    }
                    lineCounter++;
                    stringBuilder = new StringBuilder();
                }
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        reportProcessor.resumeThread();
    }

    /**
     * Method is designed to parse loaded string and save it as entry in {@link EntriesHolder}
     *
     * @param inputString - string loaded from file
     * @param lineNumber  - number loaded line in file
     */
    void parseString(String inputString, int lineNumber) {
        String[] entryFields = inputString.split(ResourceHolder.ENTREE_SPLIT_REGEX);
        try {
            entriesHolder.put(new UserSiteWrapper(entryFields[3],
                            entryFields[1]),
                    Integer.valueOf(entryFields[2]));
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            System.err.println(ResourceHolder.WRONG_FORMAT_MESSAGE_PART1 + fileName + ResourceHolder.WRONG_FORMAT_MESSAGE_PART2 + lineNumber);
        }
    }
}
