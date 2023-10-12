package com.example.dsa.NewCode.Stack_Queue;

import java.util.Stack;

public class MinElement {

    static Stack<Integer> stack = new Stack<>();
    static Stack<Integer> aux = new Stack<>();
    static int min = Integer.MAX_VALUE;

//    public static void push(int value) {
//        if (stack.isEmpty()) {
//            aux.push(value);
//            min = value;
//        } else if (min > value) {
//            min = value;
//            aux.push(min);
//        }
//
//        stack.push(value);
//    }
//
//    public static void pop() {
//        if (!stack.isEmpty())
//            min = Objects.equals(aux.peek(), stack.pop()) ? aux.pop() : min;
//
//    }
//    public static int getMinElement() {
//        return (!aux.isEmpty()) ? aux.peek() : -1;
//    }

    public static void push(int value) {
        if (stack.isEmpty()) {
            stack.push(value);
            min = value;
        } else if (value < min) {
            stack.push(2 * value - min);
            min = value;
        } else {
            stack.push(value);
        }
    }

    public static int pop() {
        if (stack.isEmpty()) return -1;
        int top = stack.pop();
        if (top < min) {
            int newMin = min;
            min = 2 * min - top;
            return newMin;
        }
        return top;
    }

    public static int getMinElement() {
        if (stack.isEmpty()) return -1;
        if (stack.peek() < min) return min;
            return stack.peek();
    }

    public static void main(String[] args) {
        int[] arr = {16, 15, 29, 19, 18};
        push(16);
        push(15);
        System.out.println("min: "+(15 == getMinElement()));
        System.out.println("pop: "+(15 == pop()));
        System.out.println("min: "+(16 == getMinElement()));
        push(29);
        push(19);
        push(18);
        System.out.println("min: "+(16 == getMinElement())+" "+getMinElement());
        System.out.println("pop: "+(18 == pop()));
        System.out.println("min: "+(16 == getMinElement()));
        System.out.println("pop: "+(19 == pop()));
        System.out.println("pop: "+(29 == pop()));
        System.out.println("pop: "+(16 == pop()));
        System.out.println("min"+(-1 == getMinElement()));


    }
}
