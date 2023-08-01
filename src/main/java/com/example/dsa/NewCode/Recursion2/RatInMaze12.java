package com.example.dsa.NewCode.Recursion2;


/*
 * lexical graphical order : order string by char
 * eg: aab< abb
 *
 * approach for lexical graphical order : Down -> Left -> Right ->Up
 * */

public class RatInMaze12 {


    private void solveMaze(int[][] arr, boolean[][] flag, int r, int c, String path) {
        if (r == arr.length - 1 && c == arr.length - 1) {
            System.out.println(path);
            return;
        }


        if (c + 1 < arr.length && !flag[c + 1][r] && arr[c + 1][r] == 1) {
            flag[c][r] = true;
            solveMaze(arr, flag, r, c + 1, path + "D");
            flag[c][r] = false;
        }
        if (r - 1 >= 0 && !flag[c][r - 1] && arr[c][r - 1] == 1) {
            flag[c][r] = true;
            solveMaze(arr, flag, r - 1, c, path + "L");
            flag[c][r] = false;
        }
        if (r + 1 < arr.length && !flag[c][r + 1] && arr[c][r + 1] == 1) {
            flag[r][c] = true;
            solveMaze(arr, flag, r + 1, c, path + "R");
            flag[r][c] = false;
        }
        if (c - 1 >= 0 && !flag[c - 1][r] && arr[c - 1][r] == 1) {
            flag[r][c] = true;
            solveMaze(arr, flag, r, c - 1, path + "U");
            flag[r][c] = false;
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