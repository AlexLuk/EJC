package work_with_threads;

public class Main {
    public static void main(String[] args) {
        Shop shopOne = new Shop("Salamari");
        Shop shopTwo = new Shop("Land of salami");
        Murzik murzik = new Murzik(shopOne, shopTwo, "Murzik");
        Murzik murzikSon = new Murzik(shopOne, shopTwo, "Murzik Junior");
        Murzik murzikOld = new Murzik(shopOne, shopTwo, "Murzik Old");
        murzik.start();
        murzikSon.start();
        murzikOld.start();
    }
}
