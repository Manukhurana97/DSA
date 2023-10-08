package com.example.dsa.NewCode.Stack_Queue;

import java.util.Stack;

public class InfixToPrefix {

    private static int getPriority(char ch) {
        switch (ch) {
            case '^':
                return 1;
            case '/':
            case '*':
                return 2;
            case '+':
            case '-':
                return 3;
            case '(':
            case ')':
                return 4;
            default:
                return 5;
        }
    }

    public static String calculate(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            int currentCharPriority = getPriority(ch);

            switch (currentCharPriority) {
                case 1, 2, 3 -> {
                    while (!stack.isEmpty() && getPriority(stack.peek()) <= currentCharPriority) {
                        result.append(stack.pop());
                    }

                    stack.push(ch);
                }
                case 4 -> {
                    if (ch == '(') {
                        while (!stack.isEmpty() && stack.peek() != ')') result.append(stack.pop());
                        if (!stack.isEmpty() && stack.peek() == ')') stack.pop();
                    } else {
                        stack.push(ch);
                    }
                }
                case 5 -> result.append(ch);
            }

        }

        while (!stack.isEmpty()) result.append(stack.pop());

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(calculate("x+y*z/w+u"));
        System.out.println(calculate("(p+q)*(c-d)"));
        System.out.println(calculate("k+L-M*N+(O^P)*W/U/V*T+Q"));
    }
}
