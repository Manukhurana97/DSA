package com.example.dsa.NewCode.Recursion2;


/*
 * lexical graphical order : order string by char
 * eg: aab< abb
 *
 * approach for lexical graphical order : Down -> Left -> Right ->Up
 * */

public class RatInMaze12 {


    private void solveMaze(int[][] arr, boolean[][] flag, int col, int row, String path) {
        if (col == arr.length - 1 && row == arr.length - 1) {
            System.out.println(path);
            return;
        }


        if (row + 1 < arr.length && !flag[row + 1][col] && arr[row + 1][col] == 1) {
            flag[row][col] = true;
            solveMaze(arr, flag, col, row + 1, path + "D");
            flag[row][col] = false;
        }
        if (col - 1 >= 0 && !flag[row][col - 1] && arr[row][col - 1] == 1) {
            flag[row][col] = true;
            solveMaze(arr, flag, col - 1, row, path + "L");
            flag[row][col] = false;
        }
        if (col + 1 < arr.length && !flag[row][col + 1] && arr[row][col + 1] == 1) {
            flag[col][row] = true;
            solveMaze(arr, flag, col + 1, row, path + "R");
            flag[col][row] = false;
        }
        if (row - 1 >= 0 && !flag[row - 1][col] && arr[row - 1][col] == 1) {
            flag[col][row] = true;
            solveMaze(arr, flag, col, row - 1, path + "U");
            flag[col][row] = false;
        }


    }

    private void solveMaze(int[][] arr) {
        boolean[][] flag = new boolean[arr.length][arr.length];
        String path = "";
        solveMaze(arr, flag, 0, 0, path);
        System.out.println(path);


    }

    public static void main(String[] args) {
        RatInMaze12 ratInMaze12 = new RatInMaze12();

        int maze[][] = {{1, 0, 0, 0}, {1, 1, 0, 1}, {0, 1, 0, 0}, {1, 1, 1, 1}};

        ratInMaze12.solveMaze(maze);

    }
}
//1 0 0 0
//1 1 0 1
//0 1 0 0
//1 1 1 1