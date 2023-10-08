package com.example.dsa.NewCode.Stack_Queue;

import java.util.Stack;

public class NearestSmallerElementRight {

    private static int[] getSmallestElement(int[] arr) {

        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            int value = arr[i];

            while (!stack.isEmpty() && stack.peek() > value) stack.pop();
            arr[i] = (stack.isEmpty()) ? -1 : stack.peek();
            stack.push(value);
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        arr = getSmallestElement(arr);
        for (int i : arr) System.out.print(i + " ");
    }
}

// 4, 5, 2, 10, 8
// 2, 2, -1, 8, -1