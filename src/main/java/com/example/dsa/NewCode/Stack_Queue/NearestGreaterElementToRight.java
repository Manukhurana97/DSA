package com.example.dsa.NewCode.Stack_Queue;

import java.util.Stack;

public class NearestGreaterElementToRight {

    public static void main(String[] args) {
        int[] arr = {1,3,2,4};
        arr = getGreaterElement(arr);

        for(int i: arr) System.out.print(i+" ");
    }

    public static int[] getGreaterElement(int[] arr) {
        Stack<Integer> stack = new Stack();

        for (int i = arr.length - 1; i >=0; i--) {
            int value = arr[i];

            while (!stack.isEmpty() && stack.peek() < value) {
                stack.pop();
            }

            arr[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(value);
        }


        return arr;
    }
}
