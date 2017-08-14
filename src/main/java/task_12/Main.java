package task_12;

import java.util.Random;

public class Main {
    int money = 100;

    public static void main(String[] args) {
        Main bank = new Main();
        class ClientThread extends Thread {
            public ClientThread(String name) {
                super(name);
            }

            @Override
            public void run() {
                int sumToTake = 10;
                while (bank.getStateOfMoney() > 0) {
                    int sumWasTaken = bank.getMoney(sumToTake);
                    yield();
                    System.err.println(getName() + " took " + sumWasTaken + ". In bank left " + bank.getStateOfMoney());
                }
            }
        }
        ClientThread clientThread1 = new ClientThread("Alex");
        ClientThread clientThread2 = new ClientThread("Bob");
        ClientThread clientThread3 = new ClientThread("Mary");

        clientThread1.start();
        clientThread2.start();
        clientThread3.start();
    }

    private int getMoney(int amount) {
        synchronized (this) {
            if (getStateOfMoney() >= amount) {
                money -= amount;
                return amount;
            } else {
                return 0;
            }
        }
    }

    private int getStateOfMoney() {
        try {
            Thread.sleep(new Random(10).nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return money;
    }
}
