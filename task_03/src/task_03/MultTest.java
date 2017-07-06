package task_03;

public class MultTest {
    public static void main(String[] args) {
        MultiDimensionArray multiDimensionArray = new MultiDimensionArray(2, 2);
        int i = 0;
        int[] coords = {i, i};
        System.out.println("cooords " + i);
        System.out.println(multiDimensionArray.getCellByCoords(coords));
        System.out.println(multiDimensionArray.getNeighborCells(coords));
        multiDimensionArray.printField();
//        for (int i = 0; i < 4; i++) {
//            int[] coords = {i,i};
//            System.out.println("cooords "+i);
//            System.out.println(multiDimensionArray.getCellByCoords(coords));
//            System.out.println(multiDimensionArray.getNeighborCells(coords));
//        }
    }
}
