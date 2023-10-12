package com.example.dsa.NewCode.Stack_Queue;

import com.google.gson.Gson;

import java.util.Stack;

public class maxAreaOfRectangle {

    public static int getMaxAreaOfRectangle(int[][] arr) {
        int maxArea = 0;
        int[] hist = new int[arr[0].length];
        for (int j = 0; j < arr[0].length; j++) {
            for (int i = 0; i < arr[j].length; i++) {
                int value = arr[j][i];
                if (value == 0) hist[i] = 0;
                else hist[i] += value;
            }
            maxArea = Math.max(maxArea, getMaxAreaOfHistogram(hist));
        }

        return maxArea;
    }

    public static int getMaxAreaOfHistogram(int[] arr) {
        int maxArea = 0;
        int n = arr.length;

        Stack<Integer> stack = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 0; i < n; i++) {
            int value = arr[i];
            if (value != 0) {
                while (!stack.isEmpty() && arr[stack.peek()] <= value) {
                    stack.pop();
                }
                left[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            int value = arr[i];
            if (value != 0) {
                while (!stack.isEmpty() && arr[stack.peek()] >= value) {
                    stack.pop();
                }
                right[i] = stack.isEmpty() ? n-1 : stack.peek();
                stack.push(i);
            }
        }

        System.out.println(new Gson().toJson(left) + " :: " + new Gson().toJson(right));

        for (int i = 0; i < n; i++) {
            int l = left[i];
            int r = right[i];

            maxArea = Math.max((r - l - 1) * arr[i], maxArea);
        }


        return maxArea;
    }

    public static void main(String[] args) {
        int[][] arr = {{0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0}};
//        System.out.println(getMaxAreaOfRectangle(arr));

        int[] arr1 = {3, 4, 0, 0};
        System.out.println(getMaxAreaOfHistogram(arr1));

    }
}
