package hw_09;

public class CountingSort implements AbstractSort {
    @Override
    public void sort(int[] arr) {
        int n = arr.length;

        if (n == 0) {
            return;
        }

        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
            } else if (arr[i] > max) {
                max = arr[i];
            }
        }

        int[] count = new int[max - min + 1];

        for (int j : arr) {
            count[j - min]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        int[] temp = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int equalCount = arr[i] - min;
            temp[count[equalCount] - 1] = arr[i];
            count[equalCount]--;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
    }

    @Override
    public String toString() {
        return "CountingSort";
    }
}
