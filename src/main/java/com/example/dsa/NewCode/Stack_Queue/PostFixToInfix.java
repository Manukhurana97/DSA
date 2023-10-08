package com.example.dsa.NewCode.Stack_Queue;

import java.util.Stack;

/**
 * if not a Symbol Put the element in stack.
 * else pop the 2 element and create a string b+symbol+a;
 * */
public class PostFixToInfix {
    private static boolean isSymbol(char ch) {
        return (ch == '+' || ch == '-' || ch == '*' || ch == '/');
    }

    public static String calculate(String s) {
        Stack<String> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (isSymbol(ch)) {
                if (stack.size() < 2) continue;

                var a = stack.pop();
                var b = stack.pop();

                stack.push(b + ch + a);

            } else {
                stack.push(String.valueOf(ch));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(calculate("AB-C+"));
    }
}
