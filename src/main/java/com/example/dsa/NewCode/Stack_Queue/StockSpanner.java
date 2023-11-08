package com.example.dsa.NewCode.Stack_Queue;

import java.util.Stack;

public class StockSpanner {

    int index;
    Stack<Node> stack;

    class Node {
        int price;
        int index;

        Node(int price, int index) {
            this.price = price;
            this.index = index;
        }
    }

    public StockSpanner() {
        index = 0;
        stack = new Stack<>();
    }

    public int next(int price) {
        index++;
        System.out.println(stack);
        while (!stack.isEmpty() && stack.peek().price < price) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            stack.push(new Node(price, index));
            return 1;
        } else {
            var prevNode = stack.peek();
            stack.push(new Node(price, index));
            return index - prevNode.index;
        }
    }

    public static void main(String[] args) {

    }
}