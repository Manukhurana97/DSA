package com.example.dsa.NewCode.Graph;

public class CityWithSmallestNeighbours {

    /* find the max city wih minimum number of neighbours */
    private static int findTheCity(int n, int[][] edges, int thrashold) {

        int[][] distance = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        for (var node : edges) {
            distance[node[0]][node[1]] = node[2];
            distance[node[1]][node[0]] = node[2];
        }

        for (int i = 0; i < n; i++) {
            distance[i][i] = 0;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distance[i][k] != Integer.MAX_VALUE && distance[k][j] != Integer.MAX_VALUE)
                        distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }

        int cityNo = -1;
        int cityCount = n; // larger city with min neighbours

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                count += (distance[i][j] <= thrashold) ? 1 : 0;
            }

            if (cityCount >= count) {
                cityNo = i;
                cityCount = count;
            }
        }

        return cityNo;
    }

    public static void main(String[] args) {
        int[][] edges = {
                { 0, 1, 10 },
                { 0, 2, 20 },
                { 1, 3, 15 },
                { 2, 4, 25 },
                { 3, 4, 5 }
        };

        System.out.println(findTheCity(5, edges, 30));
    }

}
