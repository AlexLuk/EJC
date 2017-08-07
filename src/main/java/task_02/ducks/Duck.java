package task_02.ducks;

import task_02.fly.FlyBehavior;

public abstract class Duck {
    private FlyBehavior flyBehavior;
    private int positionOnTrack = 0;

    public int getPositionOnTrack() {
        return positionOnTrack;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void performFly() {
        positionOnTrack += flyBehavior.fly();
    }

    public void moveDuckToStart() {
        positionOnTrack = 0;
    }

    public abstract void display();
}
