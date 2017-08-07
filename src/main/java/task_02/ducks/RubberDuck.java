package task_02.ducks;

import task_02.fly.FlyNoWings;

public class RubberDuck extends Duck {
    public RubberDuck() {
        setFlyBehavior(new FlyNoWings());
    }

    @Override
    public void display() {
        System.out.println("I'm from" + getClass().toString());
    }
}
