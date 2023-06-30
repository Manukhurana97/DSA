package OldCode.Heap;

import java.util.PriorityQueue;

public class SumOfElementBetween {

    static int sum(int arr[], int k1, int k2){
        int sum=0;

        if(k2<=k1) return -1;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i: arr){
            queue.add(i);
        }

        while(k1--!=0 && k2-- !=0 && !queue.isEmpty())
            queue.poll();

        while(--k2 !=0 && !queue.isEmpty())
            sum+=queue.poll();

        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 12, 5, 15, 11};
        int sum = sum(arr, 3, 6);
        System.out.println(sum);


    }
}
