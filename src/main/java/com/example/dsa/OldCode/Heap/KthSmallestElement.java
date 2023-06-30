package OldCode.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElement {

    public static int getElement(int[] arr, int n, int k) {

        if (arr.length < k) return -1;


        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i : arr) {
            queue.add(i);

            if (queue.size() > k) queue.poll();
        }

        return queue.peek();

    }
}
