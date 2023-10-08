package com.example.dsa.NewCode.Stack_Queue;

import java.util.Stack;


/**
 * 1. reverse a string
 * 2. push the element in stack if its a character (a-z)
 * 3. pop 2 element from stack and place operator in b/w : a + b
 * 4. place the new form string (a + b) in stack
 * 5. return  stack.pop() ;
 *
 * */
public class PrefixToInfix {

    private static boolean isSymbol(Character ch) {
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

                String result = "(" + a + ch + b + ")";
                stack.push(result);

            } else {
                stack.push(String.valueOf(ch));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(calculate("+-*AB/CDE"));
        System.out.println("(A*B)-(C/D)+E".equals(calculate("+-*AB/CDE")));
    }
}
