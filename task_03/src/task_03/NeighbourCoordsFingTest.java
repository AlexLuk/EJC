package task_03;

import java.util.ArrayList;
import java.util.Arrays;

public class NeighbourCoordsFingTest {
    public static void main(String[] args) {
        final int SIZE=3;
        final int DIMENSIONS=2;
        final int INDEX=1;
        int[] coords = new int[DIMENSIONS];
        for (int i = 0; i < DIMENSIONS; i++) {
            coords[i]=INDEX;
        }
        System.out.println("Current coords "+Arrays.toString(coords));
        MultiDimensionArray multiDimensionArray = new MultiDimensionArray(SIZE,DIMENSIONS);
        ArrayList<int[]> neigbourCoords =  multiDimensionArray.getNeighborCellsCoords(null,coords,0);
        System.out.println("Neighbour coords:");
        for (int[] neigbourCoord:neigbourCoords){
            System.out.println(Arrays.toString(neigbourCoord));
        }
    }
}
