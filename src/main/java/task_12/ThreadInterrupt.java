package task_12;

public class ThreadInterrupt {

    public static void main(String[] args) {

        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 5000; i++) {
                    System.err.println("Hello from thread " + i);
                    if (isInterrupted()) {
                        System.err.println("Is interrupted");
                        break;
                    }
                }
            }
        };

        thread.start();
        try {
            Thread.sleep(2);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finish");
    }
}
