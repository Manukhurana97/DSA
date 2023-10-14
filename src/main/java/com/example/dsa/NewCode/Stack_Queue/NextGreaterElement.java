package com.example.dsa.NewCode.Stack_Queue;

import java.util.Stack;

public class NextGreaterElement {

    public static int[] implement(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            int value = arr[i];

            while (!stack.isEmpty() && stack.peek() < value) stack.pop();

            arr[i] = (stack.isEmpty()) ? -1 : stack.peek();
            stack.push(value);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {3, 10, 4, 2, 1, 6, 1, 7, 2, 9};
        arr = implement(arr);
        for (int i : arr)
            System.out.print(i + " ");
    }
}
