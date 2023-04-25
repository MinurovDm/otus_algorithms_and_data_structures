package hw08;

import java.util.List;
import java.util.Random;


public class Main {

    public static void main(String[] args) {
        testSortSpeed(List.of(new QuickSort(), new MergeSort()));
    }

    private static void testSortSpeed(List<AbstractSort> abstractSorts) {
        int[] sizes = {100, 1000, 10000, 100000, 1000000};
        Random random = new Random();

        for (int size : sizes) {
            int[] arr = new int[size];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = random.nextInt(size);
            }

            for (AbstractSort abstractSort: abstractSorts) {
                long startTime = System.currentTimeMillis();

                abstractSort.sort(arr, 0, arr.length - 1);

                long endTime = System.currentTimeMillis();

                long elapsedTime = endTime - startTime;

                System.out.println("Время выполнения сортировки методом `"
                        + abstractSort + "` на массиве размером " + size + ": " + elapsedTime + " миллисекунд.");
            }
            System.out.println(" ");
        }
    }
}
