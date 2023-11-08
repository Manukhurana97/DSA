//package com.example.dsa.NewCode.Stack_Queue;
//
//import java.util.Stack;
//
//public class RemoveKElement {
//    public String removeKdigits(String num, int k) {
//
//
//        Stack<Integer> stack = new Stack<>();
//
//        for (char ch : num.toCharArray()) {
//            int i = Integer.parseInt(String.valueOf(ch));
//
//            while (!stack.isEmpty() && stack.peek() > i && k > 0) {
//                k--;
//                stack.pop();
//            }
//            stack.push(i);
//        }
//
//        StringBuilder result = new StringBuilder();
//        while (!stack.isEmpty()) {
//            result.insert(0, stack.pop());
//        }
//
//        while (!result.isEmpty() && result.charAt(0) == '0') {
//            result.deleteCharAt(i);
//            i++;
//        }
//
//        return result.toString();
//    }
//}