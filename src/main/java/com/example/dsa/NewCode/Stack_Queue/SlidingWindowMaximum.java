package com.example.dsa.NewCode.Stack_Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

    public static void solve(int[] arr, int k) {
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            if(deque.size()==k)deque.removeFirst();

            while(!deque.isEmpty() && deque.peek()<value) deque.removeLast();
            deque.addLast(value);
            if(i>=k-1)
            System.out.print(deque.getFirst()+" ");

        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        solve(arr, 3);
    }
}
