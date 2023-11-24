package com.example.dsa.NewCode.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointFromOrigin {


    class Node {
        int x;
        int y;
        double dist;

        Node(int x, int y, double dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public int[][] getClosestPoint(int[][] arr, int[] origin, int k) {

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing((Node node) -> node.dist).reversed());

        for (int[] i : arr) {
            double dist = Math.sqrt(Math.pow(i[0] - origin[0], 2) + Math.pow(i[1] - origin[1], 2));
            queue.add(new Node(i[0], i[1], dist));

            while (queue.size() > k) {
                queue.remove();
            }
        }

        int j = 0;
        int[][] result = new int[k][2];
        while (!queue.isEmpty()) {
            var node = queue.remove();
            result[j][0] = node.x;
            result[j][1] = node.y;
            j++;
        }


        return result;
    }

    public int[][] getClosestPoint1(int[][] arr, int[] origin, int k) {

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingDouble(p -> -calculateEucledeanDistance(p, origin)));


        for (int[] i : arr) {
            queue.add(i);
            if (queue.size() > k) queue.remove();
        }

        int j = k-1;
        int[][] result = new int[k][2];
        while (!queue.isEmpty()) {
            result[j--] = queue.remove();
        }


        return result;
    }

    public double calculateEucledeanDistance(int[] point, int[] origin) {
        return Math.sqrt(Math.pow(point[0] - origin[0], 2) + Math.pow(point[1] - origin[1], 2));
    }

    public static void main(String[] args) {
        KClosestPointFromOrigin kClosestPointFromOrigin = new KClosestPointFromOrigin();

        int[][] arr = {{1, 3}, {2, -2}, {5, 8}, {0, 1}};
        arr = kClosestPointFromOrigin.getClosestPoint1(arr, new int[]{0, 0}, 2);
        for (int[] i : arr) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
