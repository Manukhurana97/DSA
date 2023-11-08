package com.example.dsa.NewCode.SlidingWIndow.StaticK;

import java.util.*;

public class MaxElementInSubarray {


    public static List<Integer> getMax(int[] arr, int k) {

        int i = 0, j = 0, n = arr.length, maxElement = Integer.MIN_VALUE;
        Deque<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        while (j < n) {

            int element = arr[j++];

            if (j - i > k) {
                if (!queue.isEmpty() && i==queue.getFirst()) queue.removeFirst();
                i++;
            }

            while(!queue.isEmpty() && arr[queue.peek()]<element) queue.removeLast();
            queue.add(j-1);

            if(j-i==k) result.add(arr[queue.peekFirst()]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 0, 7, 2, 9, 1};
        System.out.println(getMax(arr, 3));
        int[] arr1 = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(getMax(arr1, 3));
    }
}
