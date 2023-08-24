package com.example.dsa.NewCode.Arrays3;

import java.util.ArrayList;
import java.util.List;

public class SetMatrixZeroes11 {

    static class place {
        int col;
        int row;

        public place(int col, int row) {
            this.row = row;
            this.col = col;
        }
    }

    private static void makeZero(int col, int row, int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) matrix[col][i] = 0;
        for (int i = 0; i < matrix.length; i++) matrix[i][row] = 0;
    }

    /**
     * O(m*n)+O(m*n)*O(m*n)
     * O(m*n)
     */
    private static void setZeroes(int[][] matrix) {

        if (matrix.length == 0) return;

        List<place> lst = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                if (matrix[i][j] == 0) lst.add(new place(i, j));


        for (var element : lst) makeZero(element.col, element.row, matrix);
    }

    /**
     * O(n)+O(m+n)+O(n)
     * O(m+n)
     */
    private static void setZeroes1(int[][] matrix) {
        int col0 = 1, col = matrix[0].length, row = matrix.length;

        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) col0 = 0;
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }


        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col0 == 0) matrix[i][0] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1, 1},
                {1, 0, 0, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1}};
//        int[][] matrix  = {{1,1,1}, {1,0,1}, {1,1,1}};
//        int[][] matrix = {
//                {0, 1, 2, 0},
//                {3, 4, 5, 2},
//                {1, 3, 1, 5}};
        setZeroes1(matrix);


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
