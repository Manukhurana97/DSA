package com.example.dsa.NewCode.Stack_Queue;

import java.util.Stack;

/**
 * 1. insert char
 * 2. if element of same priority already exist in top: pop the existing one and add the new one
 * 3. if element with lower priority exist : pop till element with higher priority is not found.
 * 4. if ) pop will ( not found
 *
 * */
public class InfixToPostFix {

    private static int getPriority(char ch) {
        switch (ch) {
            case '^': return 1;
            case '/':
            case '*': return 2;
            case '+':
            case '-': return 3;
            case '(':
            case ')': return 4;
            default: return 5;
        }
    }

    public static String calculate(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (var ch : s.toCharArray()) {
            int currentCharPriority = getPriority(ch);

            switch (currentCharPriority) {
                case 1, 2, 3 -> {
                    while (!stack.isEmpty() && getPriority(stack.peek()) <= currentCharPriority)
                        result.append(stack.pop());
                    if (!stack.isEmpty() && getPriority(stack.peek()) == currentCharPriority)
                        result.append(stack.pop());
                    stack.push(ch);
                }
                case 4 -> {
                    if (ch == ')') {
                        while (!stack.isEmpty() && stack.peek() != '(') result.append(stack.pop());
                        if (stack.peek() == '(') stack.pop();
                    } else {
                        stack.push(ch);
                    }
                }
                case 5 -> {
                    result.append(ch);
                }
            }
        }

        while (!stack.isEmpty()) result.append(stack.pop());

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(("abcd^e-fgh*+^*+i-".equals(calculate("a+b*(c^d-e)^(f+g*h)-i"))));
        System.out.println(("pq+mn-*".equals(calculate("(p+q)*(m-n)"))));
    }
}
