package com.example.dsa.NewCode.Heap;

import java.util.*;

public class SingleThreadedCPU {

    class Node {
        int enqueueTime;
        int processingTime;
        int index;

        Node(int enqueueTime, int processingTime, int index) {
            this.enqueueTime = enqueueTime;
            this.processingTime = processingTime;
            this.index = index;
        }
    }

    public int[] getOrder(int[][] tasks) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing((Node node) -> node.enqueueTime).reversed());
        for (int i = 0; i < tasks.length; i++) queue.add(new Node(tasks[i][0], tasks[i][1], i));

        PriorityQueue<Node> queue1 = new PriorityQueue<>(Comparator.comparing((Node node) -> node.processingTime));

        int[] result = new int[tasks.length];

        int i = 0,j=0, time = 0;
        while (!queue.isEmpty() || !queue1.isEmpty()) {
            while (!queue.isEmpty() && time >= queue.peek().enqueueTime) {
                queue1.add(queue.remove());
                i++;
            }

            if (queue1.isEmpty()) {
                Node node = queue.peek();
                time += node.enqueueTime;
            } else {
                Node node = queue1.remove();
                time += node.processingTime;
                result[j++] = node.index;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SingleThreadedCPU singleThreadedCPU = new SingleThreadedCPU();
        int[][] arr = {{19, 13},{16, 9},{21, 10},{32, 25},{37, 4},{49, 24},{2, 15},{38, 41},{37, 34},{33, 6},{45, 4},{18, 18},{46, 39},{12, 24}};

        System.out.println(Arrays.toString(singleThreadedCPU.getOrder(arr)));
    }
}
