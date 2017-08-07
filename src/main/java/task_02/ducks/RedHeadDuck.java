package task_02.ducks;

import task_02.fly.FlyWithWings;

public class RedHeadDuck extends Duck {
    public RedHeadDuck() {
        setFlyBehavior(new FlyWithWings());
    }

    @Override
    public void display() {
        System.out.println("I'm from" + getClass().toString());
    }
}

