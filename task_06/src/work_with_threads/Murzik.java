package work_with_threads;

import java.util.Random;

public class Murzik extends Thread {
    Shop shopOne;
    Shop shopTwo;
    String name;

    public Murzik(Shop shopOne, Shop shopTwo, String name) {
        this.shopOne = shopOne;
        this.shopTwo = shopTwo;
        this.name = name;
    }

    @Override
    public void run() {
        int buyFlagCounter = 0;
        while (buyFlagCounter < 5) {
            if (!buySalami()) {
                buyFlagCounter++;
            }
            try {
                sleep(new Random().nextInt(5));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean buySalami() {
        switch (new Random().nextInt(2)) {
            case 0:
                return shopOne.buySalami(name);
            case 1:
                return shopTwo.buySalami(name);
        }
        return false;
    }
}
