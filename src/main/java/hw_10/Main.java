package hw_10;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bstRandom = new BinarySearchTree();
        BinarySearchTree bstIncreasing = new BinarySearchTree();

        int n = 300000;

        long startTime = System.currentTimeMillis();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int value = random.nextInt(10000);
            bstRandom.insert(value);
        }
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Вставка элементов в случайном порядке: " + duration + " ms");

        long startTime2 = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            bstIncreasing.insert(i);
        }
        long endTime2 = System.currentTimeMillis();
        long duration2 = endTime2 - startTime2;
        System.out.println("Вставка элементов в возрастающем порядке: " + duration2 + " ms");

        int m = n / 10;
        long startTime3 = System.currentTimeMillis();
        for (int i = 0; i < m; i++) {
            int value = random.nextInt(100000);
            bstRandom.search(value);
        }
        long endTime3 = System.currentTimeMillis();
        long duration3 = endTime3 - startTime3;
        System.out.println("Поиск элементов в массиве случайных элементов: " + duration3 + " ms");

        long startTime4 = System.currentTimeMillis();
        for (int i = 0; i < m; i++) {
            bstIncreasing.search(i);
        }
        long endTime4 = System.currentTimeMillis();
        long duration4 = endTime4 - startTime4;
        System.out.println("Поиск элементов в массиве упорядоченных элементов: " + duration4 + " ms");

        long startTime5 = System.currentTimeMillis();
        for (int i = 0; i < m; i++) {
            int value = random.nextInt(100000);
            bstRandom.remove(value);
        }
        long endTime5 = System.currentTimeMillis();
        long duration5 = endTime5 - startTime5;
        System.out.println("Удаление элементов в массиве случайных элементов: " + duration5 + " ms");

        long startTime6 = System.currentTimeMillis();
        for (int i = 0; i < m; i++) {
            bstIncreasing.remove(i);
        }
        long endTime6 = System.currentTimeMillis();
        long duration6 = endTime6 - startTime6;
        System.out.println("Удаление элементов в массиве упорядоченных элементов: " + duration6 + " ms");
    }
}
