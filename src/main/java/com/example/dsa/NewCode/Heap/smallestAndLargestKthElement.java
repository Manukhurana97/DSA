package com.example.dsa.NewCode.Heap;

import java.util.*;

public class smallestAndLargestKthElement {

    public static int getKthElement(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(arr.length, Collections.reverseOrder());

        for (int i : arr) {
            queue.add(i);
            

            if (queue.size() > k) {
                queue.remove();
            }
        }

        return queue.peek();
    }

    public static List<Integer> getKLargestElements(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(arr.length);

        for (int i : arr) {
            queue.add(i);


            if (queue.size() > k) {
                queue.remove();
            }
        }

        return new ArrayList<>(queue);
    }

    public static void main(String[] args) {
        System.out.println(getKthElement(new int[]{5, 7, 4, 3, 9, 10}, 3));
        System.out.println(getKLargestElements(new int[]{5, 7, 4, 3, 9, 10}, 3));
    }

}
