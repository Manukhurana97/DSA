package com.example.dsa.NewCode.Arrays3;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle14 {

    public static int getElementFromTriangle(int r, int c) {
        /* (r-1)C(c-1) */

        int rowFactorial = 1;
        int colFactorial = 1;
        int row_colFactorial = 1;


//        for (int i = 1; i <= r; i++) rowFactorial *= i;
//        for (int i = 1; i <= c; i++) colFactorial *= i;
//        for (int i = 1; i <= (r - c); i++) row_colFactorial *= i;
//
//
//        return rowFactorial / (colFactorial * row_colFactorial);


        for (int i = r; i > (r - c); i--) {
            rowFactorial *= i;
            rowFactorial /= colFactorial++;
        }

        return rowFactorial;
    }


    public static int getRowFromTriangle(int r) {
        int ans = 1;

        List<Integer> lst = new ArrayList<>();
        lst.add(ans);

        for (int i = 1; i < r - 1; i++) {
            ans = (ans * (r - i)) / i;
            lst.add(ans);
        }
        lst.add(1);


        System.out.println(lst);
        return ans;
    }


    public static void main(String[] args) {
//        System.out.println(getElementFromTriangle(5, 3));
//        System.out.println(getElementFromTriangle(7, 2));
//        System.out.println(getElementFromTriangle(10, 3));

        System.out.println(getRowFromTriangle(6));
    }
}
