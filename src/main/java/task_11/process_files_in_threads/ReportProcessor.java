package task_11.process_files_in_threads;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class ReportProcessor {
    private int threadsCounter = 0;

    synchronized void decreaseThreadCounter() {
        threadsCounter--;
    }

    void reportProcessing() {
        File folderName = new File(ResourceHolder.RESOURCE_FOLDER_PATH);
        String fileExtension = ResourceHolder.FILE_EXTENSION;
        File[] files = folderName.listFiles((dir, name) -> name.toLowerCase().endsWith(fileExtension));
        FileReaderThread fileReaderThread;
        EntriesHolder reportCreator = new EntriesHolder();
        int filesToProcess = files.length;
        int currentFileIndex = 0;
        while (currentFileIndex < filesToProcess) {
            if (threadsCounter < ResourceHolder.MAX_NUM_OF_THREADS) {
                try {
                    fileReaderThread = new FileReaderThread(files[currentFileIndex].toString(), reportCreator, this);
                    fileReaderThread.run();
                    System.out.println(files[currentFileIndex].toString());
                    currentFileIndex++;
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        generateFinalReport(reportCreator);
    }

    private void generateFinalReport(EntriesHolder entriesHolder) {
        File reportFile = new File(ResourceHolder.RESULT_FOLDER_PATH + ResourceHolder.REPORT_FILE_NAME + ResourceHolder.FILE_EXTENSION);
        try {
            FileWriter fileWriter = new FileWriter(reportFile);
            UserSiteWrapper[] keys = entriesHolder.keySet().toArray(new UserSiteWrapper[entriesHolder.keySet().size()]);
            Arrays.sort(keys);
            fileWriter.write(ResourceHolder.REPORT_FILE_HEADER);
            for (UserSiteWrapper key : keys) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(key.getUserName());
                stringBuilder.append(ResourceHolder.COLUMN_SEPARATOR);
                stringBuilder.append(key.getSiteName());
                stringBuilder.append(ResourceHolder.COLUMN_SEPARATOR);
                stringBuilder.append(entriesHolder.get(key));
                stringBuilder.append(ResourceHolder.LINE_ENDING);
                fileWriter.write(stringBuilder.toString());
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
