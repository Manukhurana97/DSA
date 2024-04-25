package com.example.dsa.NewCode.DP.Square8;

import java.util.Stack;

public class MaxAreaOfRectangle {
    for(
    int i = 0;i<m;i++)
    {
        // Update the heights array for the current row
        for (int j = 0; j < n; j++) {
            if (matrix[i][j] == '1') {
                heights[j] += 1;
            } else {
                heights[j] = 0; // Reset height if the current cell is '0'
            }
        }
        // Calculate the largest rectangle area for the current row
        maxArea = Math.max(maxArea, largestRectangleArea(heights));
    }

    private int maxRectangle(int[] matrix) {

        int[] left = new int[matrix.length];
        int[] right = new int[matrix.length];
        Stack<Integer> stack = new Stack<>();
        stack.add(0);

        for (int i = 1; i < matrix.length; i++) {
            int value = matrix[i];

            while (!stack.isEmpty() && value < matrix[stack.peek()]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.add(i);
        }

        stack.clear();

        stack.add(matrix.length - 1);
        for (int i = matrix.length - 1; i >= 0; i--) {
            int value = matrix[i];

            while (!stack.isEmpty() && value < matrix[stack.peek()]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? matrix.length - 1 : stack.peek();
            stack.add(i);
        }

        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            max = Math.max(max, right[i] - left[i]);
        }

        return max;
    }
}
