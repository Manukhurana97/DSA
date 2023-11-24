package com.example.dsa.NewCode.Heap;

import java.util.*;

public class TopKFrequentElement {

    class Node {
        int data;
        int count;

        Node(int data, int count) {
            this.data = data;
            this.count = count;
        }
    }

    public int[] getElement(int[] arr, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : arr) map.put(i, map.getOrDefault(i, 0) + 1);


        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing((Node node) -> node.count));
        for (Map.Entry<Integer, Integer> k_v : map.entrySet()) {

            queue.add(new Node(k_v.getKey(), k_v.getValue()));

            if (queue.size() > k) {
                queue.remove();
            }
        }


        int j = 0;
        int[] result = new int[k];
        while (!queue.isEmpty()) {
            result[j++] = queue.remove().data;
        }
        return result;

    }

    public static void main(String[] args) {
        TopKFrequentElement topKFrequentElement = new TopKFrequentElement();
        System.out.println(Arrays.toString(topKFrequentElement.getElement(new int[]{1, 1, 1, 3, 2, 4, 4}, 2)));
    }
}
