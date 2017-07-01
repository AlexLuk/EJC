public class RubberDuck extends Duck {
    public RubberDuck() {
        setFlyBehavior(new FlyNoWings());
    }

    @Override
    public void display() {
//        System.out.println("I'm from"+getClass().toString());
    }
}
