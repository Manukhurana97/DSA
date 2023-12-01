package com.example.dsa.NewCode.GreedyApproach;

import java.util.Stack;

public class ValidParanthesisString {

    public static boolean checkValidString(String s) {

        int star = 0;
        Stack<Character> stack = new Stack<>();

        for (var ch : s.toCharArray()) {
            if (ch == '(') stack.push(ch);
            else if (ch == '*') star++;
            else {
                if (!stack.isEmpty()) {
                    if (stack.peek() == '(') stack.pop();
                } else if (star > 0) {
                    star--;
                } else {
                    return false;
                }
            }
        }


        while(!stack.isEmpty() && star>0){
            stack.pop();
            star--;
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
//        System.out.println(checkValidString("((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()"));
        System.out.println(checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));
    }
}
