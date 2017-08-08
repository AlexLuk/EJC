package task_11.process_files_in_threads;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderThread extends Thread {
    private FileReader fileReader;

    public FileReaderThread(String fileName) throws FileNotFoundException {
        try {
            fileReader = new FileReader(fileName);
        }finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        super.run();
        try {
            System.out.println(fileReader.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
