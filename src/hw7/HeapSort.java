package hw7;

import java.util.Arrays;

public class HeapSort {
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Построение max heap (изначально все элементы в массиве уже являются кучей)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Извлечение элементов из кучи
        for (int i = n - 1; i > 0; i--) {
            // Перемещение текущего корня в конец массива
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Перестроение max heap
            heapify(arr, i, 0);
        }
    }

    // Преобразование поддерева с корнем в заданном индексе в max heap
    public static void heapify(int[] arr, int n, int i) {
        int largest = i; // Инициализация наибольшего элемента как корня поддерева
        int l = 2 * i + 1; // Левый потомок корня
        int r = 2 * i + 2; // Правый потомок корня

        // Если левый потомок больше корня
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // Если правый потомок больше наибольшего элемента
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // Если наибольший элемент не является корнем
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Рекурсивно преобразовываем затронутое поддерево
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

