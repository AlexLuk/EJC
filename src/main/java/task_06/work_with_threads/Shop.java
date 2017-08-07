package task_06.work_with_threads;

public class Shop {
    private  int salami = 10;
    private  String shopName;

    public Shop(String shopName) {
        this.shopName = shopName;
    }

    // using - synchronized - we suspend all other threads from working with this method;
    public synchronized boolean buySalami(String buyer){
        if( salami>0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            salami--;
            System.out.println(buyer + " bought salami #"+salami + " in shop "+ shopName);
            return true;
        }else{
            System.out.println(buyer + " tried to buy"+  " in shop "+ shopName + ", but salami is out of stock");
            return false;
        }
    }
}
