package hw_09;

import java.util.ArrayList;
import java.util.List;

public class BucketSort implements AbstractSort {
    @Override
    public void sort(int[] arr) {
        int n = arr.length;

        if (n == 0) {
            return;
        }

        int minValue = arr[0];
        int maxValue = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            } else if (arr[i] < minValue) {
                minValue = arr[i];
            }
        }

        int numBuckets = (maxValue - minValue) / 10 + 1;

        ArrayList<Integer>[] buckets = new ArrayList[numBuckets];
        for (int i = 0; i < numBuckets; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            int bucketIndex = (arr[i] - minValue) / 10;
            insertIntoBucket(buckets[bucketIndex], arr[i]);
        }

        int currentIndex = 0;
        for (int i = 0; i < numBuckets; i++) {
            List<Integer> bucket = buckets[i];
            for (Integer integer : bucket) {
                arr[currentIndex++] = integer;
            }
        }
    }

    private void insertIntoBucket(ArrayList<Integer> bucket, int element) {
        int i;
        for (i = bucket.size() - 2; i >= 0 && bucket.get(i) > element; i--) {
            bucket.set(i + 1, bucket.get(i));
        }
        if (bucket.isEmpty()) {
            bucket.add(0, element);
        } else {
            bucket.set(i + 1, element);
        }
    }

    @Override
    public String toString() {
        return "BucketSort";
    }
}
