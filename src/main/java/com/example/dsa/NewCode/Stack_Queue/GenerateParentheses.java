package com.example.dsa.NewCode.Stack_Queue;

import java.util.*;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        int open = 0;
        int close = 0;
        List<String> result = new ArrayList<>();
        generategenerateParenthesis(0, n, open, close, new StringBuilder(), result);
        return result;
    }

    public void generategenerateParenthesis(int i, int n, int open, int close, StringBuilder str, List<String> list) {

        if (i == 2 * n) {
            list.add(str.toString());
            return;
        }

        if (open <= n) {
            str.append("(");
            generategenerateParenthesis(i + 1, n, open + 1, close, str, list);
            str.deleteCharAt(str.length() - 1);

        }

        if (close <= open) {
            str.append(")");
            generategenerateParenthesis(i + 1, n, open, close + 1, str, list);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
