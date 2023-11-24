package com.example.dsa.NewCode.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class connectRopesToMinimiseTheCost {

    public static int getCost(int[] arr) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());


        for (int i : arr) {
            queue.add(i);

            if (queue.size() >= 2) queue.add((queue.remove() + queue.remove()));
        }

        return queue.isEmpty() ? 0 : queue.remove();
    }

    public static void main(String[] args) {
        System.out.println(getCost(new int[]{1, 2, 3, 4, 5}));
    }
}
