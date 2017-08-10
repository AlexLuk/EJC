package task_11.process_files_in_threads;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderThread extends Thread {
    public static final String WRONG_FORMAT_MESSAGE_PART1 = "Wrong line format in file: ";
    public static final String WRONG_FORMAT_MESSAGE_PART2 = " line: ";
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

    @Override
    public void run() {
        int symbol;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            boolean isHeaderLine = true;
            int lineCounter=1;
            while ((symbol = fileReader.read()) != -1) {
                if (symbol != '\n') {
                    if (symbol != '\r') {
                        stringBuilder.append((char) symbol);
                    }
                } else {
                    if (isHeaderLine) {
                        isHeaderLine = false;
                    } else {
                        parseString(stringBuilder.toString(),lineCounter);
                    }
                    lineCounter++;
                    stringBuilder = new StringBuilder();
                }
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        reportProcessor.decreaseThreadCounter();
    }

    void parseString(String inputString, int lineNumber) {
        String[] entryFields = inputString.split(ResourceHolder.ENTREE_SPLIT_REGEX);
        try {
            entriesHolder.put(new UserSiteWrapper(entryFields[3],
                            entryFields[1]),
                    Integer.valueOf(entryFields[2]));
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            System.err.println(WRONG_FORMAT_MESSAGE_PART1 + fileName + WRONG_FORMAT_MESSAGE_PART2 + lineNumber);
        }
    }
}
