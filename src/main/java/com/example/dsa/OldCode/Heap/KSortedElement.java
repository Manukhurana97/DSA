package OldCode.Heap;

import java.util.PriorityQueue;

public class KSortedElement {

    static void sort(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < k; i++)
            queue.add(arr[i]);

        for (int i = k ; i < arr.length; i++) {
            System.out.print(queue.poll() + " ");
            queue.add(arr[i]);
        }

        while (!queue.isEmpty())
            System.out.print(queue.poll()+" ");
    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 2, 8, 10, 9};
        sort(arr, 4);

    }
}
