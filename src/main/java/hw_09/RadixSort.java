package hw_09;

public class RadixSort implements AbstractSort {

    @Override
    public void sort(int[] arr) {
        int n = arr.length;

        if (n == 0) {
            return;
        }

        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        for (int exp = 1; max / exp > 0; exp *= 10) {

            int[] count = new int[10];

            for (int j : arr) {
                count[(j / exp) % 10]++;
            }

            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }

            int[] temp = new int[n];

            for (int i = n - 1; i >= 0; i--) {
                int digit = (arr[i] / exp) % 10;
                temp[count[digit] - 1] = arr[i];
                count[digit]--;
            }

            for (int i = 0; i < n; i++) {
                arr[i] = temp[i];
            }
        }
    }

    @Override
    public String toString() {
        return "RadixSort";
    }
}
