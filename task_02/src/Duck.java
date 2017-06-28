public abstract class Duck {
    private FlyBehavior flyBehavior;

    public int getPositionOnTrack() {
        return positionOnTrack;
    }

    private int positionOnTrack=0;


    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void performFly(){
        positionOnTrack+=flyBehavior.fly();
    }

    public abstract void display();

}
