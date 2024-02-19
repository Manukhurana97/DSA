package com.example.dsa.NewCode.Graph;

/* 
 * make all the nodes -1 to inf and i==i  to 0
 * take 3 for loop , i, j, k
 * if j->i && i -> k not inf
 *  update the distance of j-k> by math.max(j->k,  j->i + i->k);
 * make back all inf node to -1
 */
public class FloydWarshallAlgorithm {

    public void shortestDiatance(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == -1) {
                    arr[i][j] = Integer.MAX_VALUE;
                }
                if (i == j) {
                    arr[i][j] = 0;
                }
            }
        }

        /* relaxing fields */
        for (int k = 0; k < arr.length; k++) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][k] != Integer.MAX_VALUE && arr[k][j] == Integer.MAX_VALUE)
                        arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == Integer.MAX_VALUE) {
                    arr[i][j] = -1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                { 0, 3, -1, 7 },
                { 8, 0, 2, -1 },
                { 5, -1, 0, 1 },
                { -1, -1, -1, 0 }
        };

        FloydWarshallAlgorithm floydWarshall = new FloydWarshallAlgorithm();
        floydWarshall.shortestDiatance(graph);

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                System.out.print(graph[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
