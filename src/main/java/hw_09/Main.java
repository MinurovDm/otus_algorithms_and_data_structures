package hw_09;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<AbstractSort> sortList = List.of(new BucketSort(), new RadixSort(), new CountingSort());

        Random random = new Random();
        int[][] arrays = {
                random.ints(100, 0, 1000).toArray(),
                random.ints(1000, 0, 1000).toArray(),
                random.ints(10000, 0, 1000).toArray(),
                random.ints(100000, 0, 1000).toArray(),
                random.ints(1000000, 0, 1000).toArray()
        };

        long startTime, elapsedTime;
        for (int[] arr : arrays) {
            for (AbstractSort abstractSort : sortList) {
                startTime = System.currentTimeMillis();
                abstractSort.sort(arr);
                elapsedTime = System.currentTimeMillis() - startTime;
                System.out.printf("%s for array of size %d took %d ms%n", abstractSort, arr.length, elapsedTime);
            }
        }
    }
}

