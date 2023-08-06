package com.example.dsa.NewCode.Arrays3;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix12 {

    public static List<Integer> spiralMatrix(int[][] arr) {

        int col = arr.length;
        int row = arr[0].length;
        int upLeft = 0, upRight = row - 1, downRight = col - 1, downLeft = 0;
        List<Integer> result = new ArrayList<>();

        while (result.size() < row * col) {

            for (int i = upLeft; i <= upRight; i++) result.add(arr[upLeft][i]);
            upLeft += 1;

            for (int i = upLeft; i <= downRight; i++) result.add(arr[i][upRight]);
            upRight -= 1;

            for (int i = upRight; i >= downLeft; i--) result.add(arr[downRight][i]);
            downRight -= 1;

            for (int i = downRight; i >= upLeft; i--) result.add(arr[i][downLeft]);
            downLeft += 1;

        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};
        var result = spiralMatrix(arr);
        System.out.println(result);
    }
}
