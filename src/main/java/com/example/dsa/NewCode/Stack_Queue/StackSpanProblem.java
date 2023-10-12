package com.example.dsa.NewCode.Stack_Queue;

import java.util.Stack;

public class StackSpanProblem {

    public static void main(String[] args) {
        int[] arr = {100, 80, 60, 70, 60, 75, 85};
        arr = getProfit(arr);
        for (int i : arr) System.out.print(i + " ");
    }

    public static int[] getProfit(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];

            while (!stack.isEmpty() && arr[stack.peek()] < value) {
                stack.pop();
            }

            result[i] = (stack.isEmpty()) ? 1 : i - stack.peek();
            stack.push(i);
        }

        return result;
    }
}

// 100, 80, 60, 70, 60, 75, 85
