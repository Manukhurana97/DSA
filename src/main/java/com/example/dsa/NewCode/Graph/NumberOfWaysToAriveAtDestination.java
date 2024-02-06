package com.example.dsa.NewCode.Graph;

import java.util.*;

public class NumberOfWaysToAriveAtDestination {

    static class Node {
        int point;
        int weights;

        Node(int point, int weights) {
            this.point = point;
            this.weights = weights;
        }
    }

    private static int countPaths(int n, int[][] input) {

        List<List<Node>> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(new ArrayList<>());

        for (var i : input) {
            list.get(i[0]).add(new Node(i[1], i[2]));
            list.get(i[1]).add(new Node(i[2], i[2]));
        }

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing(nn -> nn.weights));
        queue.add(new Node(0, 0));

        int[] distance = new int[n];
        int[] ways = new int[n];
        Arrays.fill(distance, 0, n, Integer.MAX_VALUE);
        distance[0] = 0;
        ways[0] = 1;

        while (!queue.isEmpty()) {
            var current = queue.poll();

            for (var neighbours : list.get(current.point)) {
                int npoint = neighbours.point;
                int nweight = neighbours.weights;

                // if reaching the node first time
                if (distance[npoint] > current.weights + nweight) {
                    distance[npoint] = current.weights + nweight;
                    queue.add(new Node(npoint, current.weights + nweight));
                    ways[npoint] = ways[current.point];

                } else if (distance[npoint] == current.weights + nweight) {
                    ways[npoint] = (ways[npoint] + ways[current.point]) % 1000000007;
                }
            }
        }

        return (ways[n - 1] == 0) ? -1 : ways[n - 1] % 1000000007;
    }

    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();

        // Edges: (source, destination, weight)
        int[][] arr = { { 0, 6, 7 }, { 0, 1, 2 }, { 1, 2, 3 } };

        System.out.println(countPaths(7, input));
    }

}
