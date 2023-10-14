package com.example.dsa.NewCode.Stack_Queue;

/*in:  1 2 3 4 5*/
/*out: 5 4 3 2 1*/
/*out: 1 2 3 4 5*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ImplementStackAndQueue {

    private static void implementStack(int[] arr) {

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> helperQueue = new LinkedList<>();

        for (int i : arr) {
            while (!queue.isEmpty()) helperQueue.add(queue.remove());
            queue.add(i);
            while (!helperQueue.isEmpty()) queue.add(helperQueue.remove());
        }

        System.out.println(queue);
    }
    private static void implementQueue(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> helperStack = new Stack<>();

        for (int i : arr) {
            while (!stack.isEmpty()) helperStack.push(stack.pop());
            stack.push(i);
            while (!helperStack.isEmpty()) stack.push(helperStack.pop());

        }

        System.out.println(stack);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
//        implementStack(arr);
        implementQueue(arr);

    }
}
