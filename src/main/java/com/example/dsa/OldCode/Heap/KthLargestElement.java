package OldCode.Heap;

import java.util.PriorityQueue;

public class KthLargestElement {

    public static int getElement(int[] arr, int n, int k) {
        if (arr.length < k) return -1;

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i : arr) {
            queue.add(i);
            if (queue.size() > k)
                queue.poll();
        }

        while (!queue.isEmpty())
            System.out.println(queue.poll());

        return 1;
    }

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 12, 15};
        getElement(arr, arr.length, 3);
    }
}
