package com.example.dsa.NewCode.Recursion2;

public class SudokuSolver9 {


    private boolean sudokuCheck(int[][] arr, int r, int c, int e) {

        for (int i = 0; i < 9; i++) {
            if (arr[i][r] == e || arr[c][i] == e) {
                return false;
            }
        }

        c = 3 * (c / 3);
        r = 3 * (r / 3);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[c + i][r + j] == e) return false;
            }
        }

        return true;
    }


    private boolean sudoku(int[][] arr) {
        for (int c = 0; c < 9; c++) {
            for (int r = 0; r < 9; r++) {
                if (arr[c][r] == 0) {
                    for (int i = 1; i <= 9; i++) {
                        if (sudokuCheck(arr, r, c, i)) {
                            arr[c][r] = i;
                            if (sudoku(arr)) {
                                return true;
                            }
                            arr[c][r] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        SudokuSolver9 sudokuSolver9 = new SudokuSolver9();

        int[][] arr = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        sudokuSolver9.sudoku(arr);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }


}
