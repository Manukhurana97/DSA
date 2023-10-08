package com.example.dsa.NewCode.Stack_Queue;

import java.util.Stack;

/**
 * 1. reverse a string;
 * 2.  push the element in stack if its a character (a-z)
 * 3. pop 2 element from stack and place operator in last : a b +
 * 4. place the new form string (a b +) in stack
 * 5. return stack.pop()
 */
public class PrefixToPostfix {

    private static boolean isSymbol(char ch) {
        return (ch == '+' || ch == '-' || ch == '*' || ch == '/');
    }

    public static String calculate(String s) {
        Stack<String> stack = new Stack<>();

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (isSymbol(ch)) {
                if (stack.size() < 2) continue;
                var a = stack.pop();
                var b = stack.pop();

                stack.push(a + b + ch);
            } else {
                stack.push(String.valueOf(ch));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
//        System.out.println(calculate("+-*AB/CDE"));
        System.out.println(calculate("+-ABC"));
    }
}
