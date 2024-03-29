package com.example.dsa.NewCode.DP;

import java.util.Arrays;

/*  Recurrence:
1. Express index, base case 
2. explore all path
3. min max sum
 */

//  https://takeuforward.org/data-structure/minimum-maximum-falling-path-sum-dp-12/
public class MaxPathSumInMatrix {

    public int minFallingPathSum(int[][] matrix) {

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            min = Math.min(min, minFallingPathSumRecursion(0, i, matrix));
            // int[][] visited = new int[matrix.length][matrix[0].length];
            // min = Math.min(min, minFallingPathSumMemoization(0, i, matrix, visited));
        }

        return min;

        // return minFallingPathSumTabulation(matrix);
        // return minFallingPathSumSpaceOptimization(matrix);
    }

    // recursion: top down :: time - O(4n^2), space - O(2n^2)
    public int minFallingPathSumRecursion(int i, int j, int[][] matrix) {
        if (i > matrix.length - 1 || j > matrix.length - 1)
            return Integer.MAX_VALUE;
        if (i == matrix.length - 1)
            return matrix[i][j];

        int down = minFallingPathSumRecursion(i + 1, j, matrix);
        int leftDiag = (j > 0) ? minFallingPathSumRecursion(i + 1, j - 1, matrix) : Integer.MAX_VALUE;
        int rightDiag = (j < matrix[i].length - 1) ? minFallingPathSumRecursion(i + 1, j + 1, matrix)
                : Integer.MAX_VALUE;

        int currentSum = matrix[i][j] + Math.min(down, Math.min(leftDiag, rightDiag));

        return currentSum;
    }

    // recursion + memoization : top down :: time - O(4n), space - O(2n^2)
    public int minFallingPathSumMemoization(int i, int j, int[][] matrix, int[][] visited) {
        if (i > matrix.length - 1 || j > matrix.length - 1)
            return Integer.MAX_VALUE;
        if (i == matrix.length - 1)
            return matrix[i][j];

        if (visited[i][j] != 0)
            return visited[i][j];

        int down = minFallingPathSumMemoization(i + 1, j, matrix, visited);
        int leftDiag = (j > 0) ? minFallingPathSumMemoization(i + 1, j - 1, matrix, visited) : Integer.MAX_VALUE;
        int rightDiag = (j < matrix[i].length - 1) ? minFallingPathSumMemoization(i + 1, j + 1, matrix,
                visited) : Integer.MAX_VALUE;

        int currentSum = matrix[i][j] + Math.min(down, Math.min(leftDiag, rightDiag));

        visited[i][j] = currentSum;

        return currentSum;
    }

    // tabulation : bottom ui :: time - O(n), space - O(n^2)
    public int minFallingPathSumTabulation(int[][] matrix) {

        int[][] visited = new int[matrix.length][matrix[0].length];
        Arrays.fill(visited[0], Integer.MAX_VALUE);

        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == matrix.length - 1) {
                    visited[i][j] = matrix[i][j];
                } else {
                    int leftDiag = (j > 0) ? visited[i + 1][j - 1] : Integer.MAX_VALUE;
                    int rightDiag = (j < matrix[i].length - 1) ? visited[i + 1][j + 1] : Integer.MAX_VALUE;
                    visited[i][j] = matrix[i][j] + Math.min(visited[i + 1][j], Math.min(leftDiag, rightDiag));
                }
            }
        }

        int min = visited[0][0];
        for (int j = 1; j < matrix[0].length; j++) {
            min = Math.min(min, visited[0][j]);
        }

        return min;
    }

    // space optimization : bottom ui :: time - O(n), space - O(n)
    public int minFallingPathSumSpaceOptimization(int[][] matrix) {

        int[] visited = new int[matrix[0].length];
        Arrays.fill(visited, Integer.MAX_VALUE);
        for (int i = matrix.length - 1; i >= 0; i--) {
            int[] temp = new int[matrix[0].length];
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == matrix.length - 1) {
                    temp[j] = matrix[i][j];
                } else {
                    int leftDiag = (j > 0) ? visited[j - 1] : Integer.MAX_VALUE;
                    int rightDiag = (j < matrix[i].length - 1) ? visited[j + 1] : Integer.MAX_VALUE;
                    temp[j] = matrix[i][j] + Math.min(visited[j], Math.min(leftDiag, rightDiag));
                }
            }
            visited = temp;
        }

        int min = visited[0];
        for (int j = 1; j < matrix[0].length; j++) {
            min = Math.min(min, visited[j]);
        }

        return min;
    }

}
