public class FlyNoWings implements FlyBehavior {
    @Override
    public int fly() {
        System.out.println("I can't fly");
        return 0;
    }
}
