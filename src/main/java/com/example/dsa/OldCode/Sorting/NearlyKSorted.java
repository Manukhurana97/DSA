package OldCode.Sorting;

import java.util.Arrays;
import java.util.PriorityQueue;

public class NearlyKSorted {

    static void kSorted(int[] arr, int n, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(); // HashSet
        for (int i = 0; i <= k; i++)
            queue.add(arr[i]);
        int index = 0;
        for (int i = k + 1; i < n; i++) {
            arr[index++] = queue.poll();
            queue.add(arr[i]);
        }
        while (!queue.isEmpty())
            arr[index++] = queue.poll();
    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 2, 8, 10, 9};
        kSorted(arr, arr.length, 3);
        System.out.println(Arrays.toString(arr));
    }
}
