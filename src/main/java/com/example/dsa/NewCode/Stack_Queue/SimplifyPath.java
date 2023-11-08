package com.example.dsa.NewCode.Stack_Queue;

import java.util.Stack;

public class SimplifyPath {

    public String simplifyPath(String path) {
        String curr = "";
        Stack<String> stack = new Stack<>();


        path += "/";
        for (char ch : path.toCharArray()) {
            if (ch == '/') {
                if (curr.equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else if (!curr.equals("") && !curr.equals(".")) {
                    stack.push(curr);
                }
                curr = "";

            } else {
                curr += (ch);
            }
        }

        if (stack.isEmpty()) return "/";

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, "/" + stack.pop());
        }

        return result.toString();
    }

}
