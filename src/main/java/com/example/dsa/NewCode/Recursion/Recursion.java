package com.example.dsa.NewCode.Recursion;

public class Recursion {

    private int print(int n) {
        if (n == 0) return n;

        System.out.println("N ->" + n);

        return this.print(n - 1);
    }


    private int sum_of_n_natural_numbers(int n) {
        if (n == 1) return 1;

        return n + sum_of_n_natural_numbers(n - 1);
    }


    private int fibonarcci(int n) {
        if (n == 0) return 0;

        if (n == 1 || n == 2) return 1;

        return (fibonarcci(n - 1) + fibonarcci(n - 2));

    }


    private int factor(int n) {
        if (n == 1) return 1;

        System.out.println(n);

        return n * factor(n - 1);
    }


    private int power(int a, int b) {
        if (b == 1) return a;

        return a * power(a, b - 1);
    }


    private int waysInMatrix(int n, int m) {
        if (n == 1 || m == 1) return 1;

        return (waysInMatrix(n - 1, m) + waysInMatrix(n, m - 1));
    }


    private int josephusProblem(int n, int k) {
        if (n == 1) return n;

        System.out.println(n);

        return ((josephusProblem(n - 1, k) + k) % n);
    }


    private boolean palindromeCheck(int pos, String p) {
        if (p.length() == 1 || p.length() / 2 <= pos) return true;
        if (p.charAt(pos) != p.charAt(p.length() - (pos + 1))) return false;

        return palindromeCheck(pos + 1, p);
    }

    private boolean palindrome(String p) {
        return palindromeCheck(0, p);
    }


    private void powerSetOfString(String s, int i, String c) {
        if (i == s.length()) {
            System.out.println(c);
            return;
        }

        powerSetOfString(s, i + 1, c + s.charAt(i));
        powerSetOfString(s, i + 1, c);
    }

    private void powerSetOfString(String s) {

        powerSetOfString(s, 0, "");

    }

    private String swap(String s, int l, int r) {
        char[] ch = s.toCharArray();
        var temp = ch[l];
        ch[l] = ch[r];
        ch[r] = temp;

        return new String(ch);
    }

    private void allPermutation(String s, int l, int r) {

        if (l == r) {
            System.out.println(s);
            return;
        }

        for (int i = l; i <= r; i++) {
            s = swap(s, i, l);
            allPermutation(s, l + 1, r);
            s = swap(s, l, i);

        }
    }

    private void allPermutation(String s) {
        allPermutation(s, 0, s.length() - 1);
    }


    private boolean checkQueenPositionValidRow(int row, int size, int[][] arr) {
        for (int i = 0; i < size; i++) if (arr[row][i] == 1) return false;
        return true;
    }

    private boolean checkQueenPositionValidCol(int col, int size, int[][] arr) {
        for (int i = 0; i < size; i++) if (arr[i][col] == 1) return false;
        return true;
    }

    private boolean checkQueenPositionValidDig(int row, int col, int size, int[][] arr) {

        for (int i = 1; i < size; i++) if ((row - i) >= 0 && (col - i) >= 0 && arr[row - i][col - i] == 1) return false;
        for (int i = 1; i < size; i++)
            if ((row + i) < size && (col + i) < size && arr[row + i][col + i] == 1) return false;
        for (int i = 1; i < size; i++)
            if ((row - i) >= 0 && (col + i) < size && arr[row - i][col + i] == 1) return false;
        for (int i = 1; i < size; i++)
            if ((row + i) < size && (col - i) >= 0 && arr[row + i][col - i] == 1) return false;
        return true;
    }

    private boolean checkQueenPos(int r, int c, int size, int[][] arr) {

        return this.checkQueenPositionValidRow(r, size, arr) && this.checkQueenPositionValidCol(c, size, arr) && checkQueenPositionValidDig(r, c, size, arr);
    }

    private boolean nQueen(int size, int c, int[][] arr) {
        if (c >= size) return true;


        for (int r = 0; r < size; r++) {
            if (checkQueenPos(r, c, size, arr)) {
                arr[r][c] = 1;
                if (nQueen(size, c + 1, arr)) {
                    return true;
                }
                arr[r][c] = 0;
            }
        }

        return false;
    }

    private void nQueen(int size) {

        var data = new int[size][size];
        nQueen(size, 0, data);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }


    private boolean checkSudokuData(int arr[][], int row, int col, int num) {

        for (int i = 0; i < 9; i++) {
            if (arr[row][i] == num || arr[i][col] == num) {
                return false;
            }
        }

        int nr = 3 * (row / 3);
        int nc = 3 * (col / 3);
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (arr[nr + i][nc + j] == num) return false;


        return true;
    }

    private boolean sudoku(int arr[][]) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (arr[r][c] == 0) {
                    for (int i = 1; i <= 9; i++) {
                        if (checkSudokuData(arr, r, c, i)) {
                            arr[r][c] = i;
                            if (sudoku(arr)) return true;

                            arr[r][c] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private void sudoku() {
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
        sudoku(arr);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }


    /**
     * (x! + y) -> !5+2 -> 15+2 -> 17
     */
    private int func1(int x, int y) {
        if (x == 0) return y;

        return func1(x - 1, x + y);
    }


    private void printStar(int s) {
        if (s == 0) return;

        printStar(s - 1);

        for (int i = 0; i < s; i++)
            System.out.print("*");
        System.out.println();
    }


    private void func2(int n, int limit) {
        if (limit == 0 || n == 0) return;
        if (n > limit ) return;

        System.out.print(String.format("%d ", n));
        func2(n*2, limit);
        System.out.print(String.format("%d ", n));
    }



    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        /**
         * var a = recursion.print(5);
         * var b = recursion.sum_of_n_natural_numbers(5);
         *  for(int i=0;i<10;i++) {
         *  var c = recursion.fibonarcci(i);
         *  }
         *  var d = recursion.factor(5);
         *  var e = recursion.power(3, 4);
         *  var f = recursion.waysInMatrix(3, 3);
         *  var g = recursion.josephusProblem(5, 3);
         *  var h = recursion.palindrome("raccars");
         *  recursion.powerSetOfString("abc");
         *  recursion.allPermutation("abc");
         *  recursion.nQueen(4);
         *  recursion.sudoku();
         *  var i = recursion.func1(5, 2);
         *  recursion.printStar(5);
         */

        recursion.func2(2, 100);

    }
}
