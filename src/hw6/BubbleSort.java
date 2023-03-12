package hw6;

import java.util.Arrays;

public class BubbleSort implements SortAlgorithm {
    @Override
    public void sort(int[] arr) {
        int n = arr.length - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j);
                }
            }
        }
    }

    private void swap(int[] arr, int j) {
        // swap arr[j] and arr[j+1]
        int temp = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = temp;
    }
}