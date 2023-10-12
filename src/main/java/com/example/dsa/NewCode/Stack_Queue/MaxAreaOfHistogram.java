package com.example.dsa.NewCode.Stack_Queue;

import com.google.gson.Gson;

import java.util.Stack;

public class MaxAreaOfHistogram {

    public static int getMaxArea(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int leftValue = arr[i];

            while (!stack.isEmpty() && arr[stack.peek()] > leftValue) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);

        }
        stack.clear();
        for (int i = arr.length - 1; i >= 0; i--) {
            int rightValue = arr[i];
            while (!stack.isEmpty() && arr[stack.peek()] > rightValue) {
                stack.pop();
            }
            right[i] = (stack.isEmpty()) ? arr.length : stack.peek();
            stack.push(i);
        }


        int maxHist = 0;
        for (int i = 0; i < arr.length; i++) {
            int l = left[i];
            int r = right[i];

            maxHist = Math.max((r - l - 1) * arr[i], maxHist);

        }
        return maxHist;
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 5, 4, 5, 1, 6};
        System.out.println(getMaxArea(arr));
    }
}
