package com.example.dsa.NewCode.Stack_Queue;

import java.util.Stack;

public class NearestSmallerElementToLeft {

    private static int[] getSmallestElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];

            while (!stack.isEmpty() && stack.peek() > value) stack.pop();

            arr[i] = stack.isEmpty() ? -1 : stack.peek();

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

//4, 5, 2, 10, 8
//-1,4, -1, 2, 2