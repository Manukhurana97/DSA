package com.example.dsa.NewCode.Stack_Queue;

import java.util.Stack;

public class RemoveAllAdjasentDuplicate {
//    public String removeDuplicates(String s, int k) {
//        int temp = 0;
//        Stack<Character> stack = new Stack<>();
//
//        for (char ch : s.toCharArray()) {
//
//            if (!stack.isEmpty() && stack.peek() == ch) {
//                temp = 1;
//
//                while (!stack.isEmpty() && stack.peek() == ch) {
//                    temp++;
//                    stack.pop();
//                }
//
//                if (k != temp) while (temp-- != 0) stack.push(ch);
//
//            } else stack.push(ch);
//        }
//
//        String result = "";
//        while (!stack.isEmpty()) result = stack.pop() + result;
//
//        return result;
//}

    public String removeDuplicates(String s, int k) {
        int temp = 0;
        Stack<Character> stack = new Stack<>();
        Stack<Integer> count = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (!stack.isEmpty()) {
                if (stack.peek() == ch) {
                    count.push(count.pop() + 1);
                } else {
                    stack.push(ch);
                    count.push(1);
                }

                if (count.peek() == k) {
                    stack.pop();
                    count.pop();
                }
            } else {
                stack.push(ch);
                count.push(1);
            }

        }

        String result = "";
        while (!stack.isEmpty() && !count.isEmpty()) {
            var value = stack.pop();
            var c = count.pop();
            for (int i = 0; i < c; i++)
                result = value + result;
        }

        return result;
    }


    public static void main(String[] args) {

    }

}