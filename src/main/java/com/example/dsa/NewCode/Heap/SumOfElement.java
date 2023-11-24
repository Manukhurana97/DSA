package com.example.dsa.NewCode.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SumOfElement {

    public static int getSum(int[] arr, int x1, int x2) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i : arr) queue.add(i);

        int j = arr.length, sum = 0;

        while (!queue.isEmpty() && j > x1) {

            var val = queue.remove();
            if (j < x2) {
                sum += val;
            }
            j--;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(getSum(new int[]{1, 3, 12, 5, 15, 11}, 3, 6));
    }
}
