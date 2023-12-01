package com.example.dsa.NewCode.GreedyApproach;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FractionalKnapsack {

    static class Node {
        int weight;
        int profit;

        public Node(int weight, int profit) {
            this.weight = weight;
            this.profit = profit;
        }
    }

    private static double getMaxValue(Node[] arr, int capacity) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt((Node node) -> node.profit/node.weight).reversed());

        Collections.addAll(queue, arr);

        double profit = 0;
        while (!queue.isEmpty() && capacity > 0) {
            var node = queue.poll();
            if (node.weight <= capacity) {
                profit += node.profit;
                capacity -= node.weight;
            } else if (capacity > 0) {
                profit += (double) (node.profit / node.weight) * capacity;
                capacity = 0;
            }
        }
        return profit;
    }



    public static void main(String[] args) {
        Node[] arr = {new Node(10, 60), new Node(20, 100), new Node(30, 120)};
        System.out.println(getMaxValue(arr, 50));
    }
}
