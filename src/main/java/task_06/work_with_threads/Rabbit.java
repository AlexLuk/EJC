package task_06.work_with_threads;

import java.io.IOException;

public class Rabbit{
    private static volatile boolean isEating = true;

    public static void main(String[] args) {
       new Rabbit.Feeding().start();
       new Rabbit.FeedStopper().start();
    }

    public static class Feeding extends Thread{
        @Override
        public void run() {
            System.err.println("Rabbit started eating");
            while (isEating){
                System.err.println("Rabbit is eating");
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.err.println("Rabbit was stopped");
        }
    }

    public static class FeedStopper extends Thread{
        @Override
        public void run() {
            System.err.println("You try to stop the rabbit");
            try {
                int stop = System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            isEating=false;
            System.err.println("You stopped him");
        }
    }


}
