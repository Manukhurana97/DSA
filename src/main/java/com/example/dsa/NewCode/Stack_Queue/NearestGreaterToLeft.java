package com.example.dsa.NewCode.Stack_Queue;

import java.util.Stack;

public class NearestGreaterToLeft {

    private static int[] getGreaterElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            while (!stack.isEmpty() && stack.peek() < value) {
                stack.pop();
            }
            arr[i] = (stack.isEmpty()) ? -1 : stack.peek();
            stack.push(value);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4};

        arr = getGreaterElement(arr);
        for (int i : arr) System.out.print(i + " ");

    }
}

/*
 * in: 1,3,2,4
 * out: -1,-1,3,-1
 * */