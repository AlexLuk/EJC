package task_11.process_files_in_threads;

public class Main {

    public static void main(String[] args) {

        ReportFilesGenerator reportFilesGenerator = new ReportFilesGenerator(15);
        reportFilesGenerator.generateFiles();

        ReportProcessor reportProcessor = new ReportProcessor();
        reportProcessor.reportProcessing();
    }

}
