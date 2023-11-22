package com.example.dsa.NewCode.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SortKSortedArray {

    public static int[] sort(int[] arr, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int j = 0;
        for (int i = 0; i < arr.length; i++) {

            queue.add(arr[i]);

            if (queue.size() > k) {
                arr[j++] = queue.remove();
            }
        }

        while (!queue.isEmpty()) {
            arr[j++] = queue.remove();
        }

        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{6, 5, 2, 3, 8, 9, 10}, 3)));
    }
}
