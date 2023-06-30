package OldCode.Heap;

import java.util.PriorityQueue;

public class ConnectRopeToMinCost {

    static void minCost(int[] arr, int n) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(); // min queue
        for (int i : arr)
            queue.add(i);


        int sum = 0, total = 0;


        // 1 2 3 4 5
        // 1+2 :: 3 3 4 5 -> sum=3
        // 3+3 :: 4 5 6 -> sum = 9
        // 4+5+:: 6 9 -> sum = 18
        // 15+18 -> sum=33
        // total = 3+9+18+15:: 33

        while (queue.size() > 1) {
            int f = queue.poll();
            int s = queue.poll();
            sum = f + s;
            total += sum;
            queue.add(sum);
        }

        System.out.println("cost " + total);

    }

    public static void main(String[] args) {
        int[] arr = {4,2,3,6};
        minCost(arr, arr.length);


    }
}
