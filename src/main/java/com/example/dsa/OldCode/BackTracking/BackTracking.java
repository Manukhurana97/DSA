package OldCode.BackTracking;


public class BackTracking {

/**
 * N Queens Problem Chess (Using back tracking)
 * Problem: We have a 4*4 chess board (for simplicity), we want to place the queens in such a way that it does not
 * place in same line (row & column or diagonal)
 *  eg: 0 1 0 0
 *      0 0 0 1
 *      1 0 0 0
 *      0 0 1 0
 *  (No queens are same line)
 * */

    public static boolean isQueenSafe(int[][] arr, int row, int col){

        // check row
        for (int i = 0;i < arr.length; i++) {
            if (arr[i][col] == 1) return false;
        }

//        // check col
//        for (int i = 0; i < arr[row].length; i++) {
//            if (arr[row][i] == 1) return false;
//        }

        // check left diagonal
        //up
        for (int i = 0; i < arr.length; i++)
            if((row-i-1)>=0 && (col-i-1)>=0) {
                if (arr[row - i-1][col - i - 1] == 1) return false;
            }
        // down
        for (int i = 0; i < arr.length; i++) {
            if ((row + i) < arr.length && (col + i) < arr.length) {
                if (arr[row + i][col + i] == 1) return false;
            }
        }

        // check right diagonal
        // up
        for (int i = 0; i < arr.length; i++)
            if((row-i-1)>=0  && (col + i + 1) < arr.length)
                if(arr[row-i-1][col + i + 1] == 1) return false;
        // down
        for (int i = 0; i < arr.length; i++)
            if((row + i) < arr.length && (col-i)>=0)
                if(arr[row+i][col-i] == 1) return false;



        return true;
    }

    public static boolean nQueens(int[][] arr, int row) {
        if (row == arr.length) {
            printBoard(arr);
            return true;
        } // we have reached the end + 1 on row on the chess board with all queen place in the correct position.

        for (int col = 0; col < arr.length; col++) {  // it will check for each col
            if (isQueenSafe(arr, row, col)) { // if it is safe to place the queen in colth place.
                arr[row][col] = 1; // if safe, will set the value to 1
                if(nQueens(arr, row+1)){  // if everything go well till this point we will recurse and move to row+1;
                    return true; // is everything go well we will return true , when moving from row n to 0 (reverse in recursion)
                }    // if the function face any issue with the queen place/ place is unsafe then we change the value
                // of current queen position back to 0, and we will back track with nQueen method to current row-1 and continue from col + 1 in for loop
                arr[row][col] = 0; // resetting queen place. back to 0.
            }
        }
        return false; // is fail.
    }

    public static boolean nQueens(int[][] arr){
        return nQueens(arr, 0);
    }

    public static boolean nQueens(int size){
        int[][] arr = new int[size][size];
        return nQueens(arr, 0);
    }

    public static void printBoard(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }


// ---------------------------------------------------------------------------------------------------------------------

    /**
     *  Sudoku problem
     *
     */

    public static boolean correctvalue(int[][] arr, int row, int col, int n){

        // validate row : if element present or not
        // validate col :  : if element present or not
        // validate 3*3 ,matrix: if element present or not

        for (int i = 0; i < arr.length; i++) if (arr[row][i] == n) return false;

        for (int[] ints : arr) if (ints[col] == n) return false;

        int sqrt = (int) Math.sqrt(arr.length);
        int smallBoxRow = row - row % sqrt; // getting the start row of the small element
        int smallBoxCol = col - col % sqrt; // getting the start col of the small element

        for (int r = smallBoxRow; r < smallBoxRow + sqrt; r++)
        {
            for (int d = smallBoxCol; d < smallBoxCol + sqrt; d++)
            {
                if (arr[r][d] == n)
                {
                    return false;
                }
            }
        }


        return true;
    }


    public static boolean sudoko(int[][] arr, int n){

        int row=-1, col=-1;
        boolean isEmpty = true;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==0){
                    row=i;
                    col=j;
                    isEmpty=false;
                    break;
                }
            }
            if(!isEmpty) break;
        }


        if(isEmpty) { // solved
            printBoard(arr);
            return true;
        }


        for (int num = 1; num <= arr.length; num ++){  // trying all number from 1 to 9 in place of 0
            if(correctvalue(arr, row, col, num)) { // check the number if safe to place
                arr[row][col] = num;
                if (sudoko(arr, n))
                    return true;
                arr[row][col] = 0;
            }
        }
        return false;
    }



    public static void main(String[] args) {
//        System.out.println(nQueens(4));

        int[][] grid = { {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0} };


        sudoko(grid, grid.length);


    }



}
