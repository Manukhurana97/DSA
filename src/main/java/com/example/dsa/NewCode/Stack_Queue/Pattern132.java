package com.example.dsa.NewCode.Stack_Queue;

import java.util.Stack;

public class Pattern132 {

    class Node {
        int current;
        int prevMin;

        Node(int data, int prevMin) {
            this.current = data;
            this.prevMin = prevMin;
        }
    }

    public boolean find132pattern(int[] nums) {

        Stack<Node> stack = new Stack<>();
        int n = nums.length;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int val = nums[i];

            while (!stack.isEmpty() && stack.peek().current < val) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                var node = stack.peek();
                if (node.current > val && node.prevMin < val) return true;
            }


            stack.push(new Node(val, min));
            min = Math.min(min, val);
        }

        return false;

    }


}