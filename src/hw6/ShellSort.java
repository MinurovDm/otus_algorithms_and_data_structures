package hw6;

public class ShellSort implements SortAlgorithm {
    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        int h = n / 2;
        while (h > 0) {
            for (int i = h; i < n; i++) {
                int temp = arr[i];
                int j = i;
                while (j >= h && arr[j - h] > temp) {
                    arr[j] = arr[j - h];
                    j -= h;
                }
                arr[j] = temp;
            }
            h /= 2;
        }
    }
}
