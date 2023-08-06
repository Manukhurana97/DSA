package com.example.dsa.NewCode.Arrays3;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix12 {

    public static List<Integer> spiralMatrix(int[][] arr) {

        List<Integer> result = new ArrayList<>();

        if (arr == null || arr.length == 0 || arr[0].length == 0) {
            return result;
        }

        int col = arr.length;
        int row = arr[0].length;
        int left = 0, right = row - 1, bottom = col - 1, top = 0;

        while (left <= right && top <= bottom) {

            for (int i = left; i <= right; i++) result.add(arr[top][i]);
            top += 1;

            for (int i = top; i <= bottom; i++) result.add(arr[i][right]);
            right -= 1;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) result.add(arr[bottom][i]);
                bottom -= 1;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) result.add(arr[i][left]);
                left += 1;
            }

        }

        return result;
    }

    public static void main(String[] args) {
//        int[][] arr = {
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12}};

//        int[][] arr = {{1,2}, {3,4}};
        int[][] arr = {{2, 5, 8}, {4, 0, -1}};

        var result = spiralMatrix(arr);
        System.out.println(result);
    }
}
