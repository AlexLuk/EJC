import java.util.Random;

public class FlyWithWings implements FlyBehavior {

    private int flySpeed;

    @Override
    public int fly() {
        flySpeed = (10 + new Random().nextInt(90));
        if (new Random().nextBoolean()) {
            flySpeed = flySpeed >> 1;
        } else {
            flySpeed = flySpeed << 1;
        }
        System.out.println("I fly "+flySpeed);
        return flySpeed;
    }
}
