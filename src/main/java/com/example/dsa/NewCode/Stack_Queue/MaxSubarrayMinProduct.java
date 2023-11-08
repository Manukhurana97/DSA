package com.example.dsa.NewCode.Stack_Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class MaxSubarrayMinProduct {
    public int maxSumMinProduct(int[] arr) {
        int n = arr.length;
        int[] prefixSum = new int[n + 1];

        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> rightStack = new Stack<>();

        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        }

        for (int i = 0; i < n; i++) {
            int val = arr[i];

            while (!leftStack.isEmpty() && arr[leftStack.peek()] <= val) {
                leftStack.pop();
            }

            left[i] = (!leftStack.isEmpty()) ? -1 : leftStack.peek();
            leftStack.push(i);
        }

        for (int i = n; i >= 0; i--) {
            int val = arr[i];

            while (!rightStack.isEmpty() && arr[rightStack.peek()] <= val) {
                rightStack.pop();
            }

            right[i] = !rightStack.isEmpty() ? n : rightStack.peek();
            rightStack.push(i);
        }


        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, (arr[right[i]] - arr[left[i] + 1] * arr[i]));
        }

        return max;

    }
}