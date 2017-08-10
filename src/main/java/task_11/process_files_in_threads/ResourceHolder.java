package task_11.process_files_in_threads;

public class ResourceHolder {
    //ReportProcessor settings
    static final String RESOURCE_FOLDER_PATH = "src\\main\\resources\\task_11\\";
    static final String RESULT_FOLDER_PATH = RESOURCE_FOLDER_PATH + "Result\\";
    static final String FILE_EXTENSION = ".csv";
    static final char COLUMN_SEPARATOR = ',';
    static final String LINE_ENDING = "\r\n";
    static final String REPORT_FILE_NAME = "final report";
    static final String REPORT_FILE_HEADER = "User Name,Site Name,Sum time duration ms.\r\n";
    static final int MAX_NUM_OF_THREADS = 10;

    //ReportFilesGenerator settings
    final static String GENERATOR_FOLDER = "generator_settings";
    final static String SITE_NAMES_FILE = "Sites.txt";
    final static String USER_NAMES_FILE = "Names.txt";
    final static String REPORT_NAME_TEMPLATE = "report";
    final static String REPORT_HEADER = "id,url,time,user\r\n";
    final static int NUM_OF_REPORT_FILES = 20;
    final static int MIN_VISIT_DURATION = 4_000;
    private final static int MAX_VISIT_DURATION = 100_000;
    static final int VISIT_DURATION_INTERVAL = MAX_VISIT_DURATION - MIN_VISIT_DURATION;
    final static int MIN_REPORT_LENGTH = 10;
    final static int MAX_REPORT_LENGTH = 20;

    //ReportFilesGenerator settings
    static final String ENTREE_SPLIT_REGEX = "[" + COLUMN_SEPARATOR + "]";
}