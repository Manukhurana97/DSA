package com.example.dsa.NewCode.Recursion2;

public class NQueens8 {


    private boolean checkQueenPositionRowAndCol(int[][] arr, int row, int col, int size) {

        for (int i = 0; i < size; i++) {
            if (arr[row][i] == 1 || arr[i][col] == 1) {
                return false;
            }
        }
        return true;
    }

    private boolean checkQueenPositionDiagonal(int[][] arr, int row, int col, int size) {
        for (int i = 0; i < size; i++) {
            if (row + i < size && col + i < size && arr[row + i][col + i] == 1) {
                return false;
            }
        }
        for (int i = 0; i < size; i++) {
            if (row - i >= 0 && col + i < size && arr[row - i][col + i] == 1) {
                return false;
            }
        }
        for (int i = 0; i < size; i++) {
            if (row + i < size && col - i >= 0 && arr[row + i][col - i] == 1) {
                return false;
            }
        }
        for (int i = 0; i < size; i++) {
            if (col - i >= 0 && row - i >= 0 && arr[row - i][col - i] == 1) {
                return false;
            }
        }


        return true;
    }

    private boolean checkQueenPosition(int[][] arr, int r, int c, int size) {
        var a = checkQueenPositionRowAndCol(arr, r, c, size);
        var b = checkQueenPositionDiagonal(arr, r, c, size);
        return a && b;
    }

    private boolean Nqueen(int[][] arr, int c, int size) {
        if (c == size) {
            return true;
        }

        for (int r = 0; r < size; r++) {
            if (checkQueenPosition(arr, r, c, size)) {
                arr[r][c] = 1;
                if (Nqueen(arr, c + 1, size)) {
                    return true;
                }
                arr[r][c] = 0;
            }
        }
        return false;
    }


    private int[][] Nqueen(int size) {
        int[][] arr = new int[size][size];
        Nqueen(arr, 0, size);
        return arr;
    }

    public static void main(String[] args) {
        NQueens8 queens = new NQueens8();
        int size = 4;
        var arr = queens.Nqueen(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
