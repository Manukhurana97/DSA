package com.example.dsa.NewCode.Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class kClosestElement {

    static class Node {
        int data;
        int index;

        public Node(int data, int index) {
            this.data = data;
            this.index = index;
        }
    }

    public int[] getElements(int[] arr, int k, int x) {

        PriorityQueue<Node> queue = new PriorityQueue<>(arr.length, Comparator.comparing((Node node) -> node.data).reversed());

        for (int i = 0; i < arr.length; i++) {
            queue.add(new Node(Math.abs(arr[i] - x), i));
            if (queue.size() > k) queue.remove();
        }

        int j = 0;
        int[] result = new int[k];
        while (!queue.isEmpty()) result[j++] = arr[queue.remove().index];

        return result;

    }

    public static void main(String[] args) {
        kClosestElement closestElement = new kClosestElement();
        System.out.println(Arrays.toString(closestElement.getElements(new int[]{5, 6, 7, 8, 9}, 3, 7)));
    }
}
