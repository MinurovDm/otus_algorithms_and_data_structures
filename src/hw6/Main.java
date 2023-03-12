package hw6;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        testSort(new BubbleSort(), 100);
        testSort(new BubbleSort(),1_000);
        testSort(new BubbleSort(), 10_000);
        testSort(new BubbleSort(), 100_000);
        testSort(new InsertionSort(), 100);
        testSort(new InsertionSort(),1_000);
        testSort(new InsertionSort(), 10_000);
        testSort(new InsertionSort(), 100_000);
        testSort(new ShellSort(), 100);
        testSort(new ShellSort(),1_000);
        testSort(new ShellSort(), 10_000);
        testSort(new ShellSort(), 100_000);
    }

    public static void testSort(SortAlgorithm algorithm, int countNum) {
        int[] ints = randomArrayGenerator(countNum);
        long start = System.currentTimeMillis();
        algorithm.sort(ints);
        long end = System.currentTimeMillis();
        System.out.println(algorithm.getClass().getSimpleName() + ", " + countNum + " elem, time = " + (end - start) + " ms");
    }

    public static int[] randomArrayGenerator(int count) {
        int[] arr = new int[count];
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            arr[i] = random.nextInt(count);
        }
        return arr;
    }
}
