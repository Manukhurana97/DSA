package com.example.dsa.NewCode.Graph;

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

}
