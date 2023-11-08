package com.example.dsa.NewCode.Stack_Queue;

import java.util.Stack;

public class ReversePolishNotion {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (var token : tokens) {
            System.out.println(token+" "+stack);
            if (token.length()>1|| Character.isDigit(token.charAt(0))) {
                stack.push(Integer.parseInt(token));
            } else {
                int b = stack.pop();
                int a = stack.pop();

                if (token.equals("+")) {
                    stack.push(a + b);
                } else if (token.equals("-")) {
                    stack.push(a - b);
                } else if (token.equals("*")) {
                    stack.push(a * b);
                } else if (token.equals("/")) {
                    stack.push(a / b);
                }
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        ReversePolishNotion reversePolishNotion = new ReversePolishNotion();
        String[] str = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        var a = reversePolishNotion.evalRPN(str);
        System.out.println(a);
    }
}

