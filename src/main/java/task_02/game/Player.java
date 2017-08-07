package task_02.game;

public class Player {
    private int money = 0;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    void Player() {
        money = 500;
    }

    void Player(int money) {
        this.money = money;
    }

}
