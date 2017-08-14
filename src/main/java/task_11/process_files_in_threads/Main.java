package task_11.process_files_in_threads;

import java.util.Calendar;

public class Main {

    /**
     * Class is designed to start our application
     *
     * @param args
     */
    public static void main(String[] args) {

//        ReportFilesGenerator reportFilesGenerator = new ReportFilesGenerator(ResourceHolder.NUM_OF_FILES);
//        reportFilesGenerator.generateFiles();

        for (int i = 1; i < 5; i++) {
            ResourceHolder.MAX_NUM_OF_THREADS = i;
            long startTime = Calendar.getInstance().getTimeInMillis();
            ReportProcessor reportProcessor = new ReportProcessor();
            reportProcessor.reportProcessing();
            System.out.println(ResourceHolder.MAX_NUM_OF_THREADS + " time worked " + (Calendar.getInstance().getTimeInMillis() - startTime));
        }
    }

}
