package com.example.dsa.NewCode.LinkedList;

import java.util.Arrays;

public class FindMiddle {

    public static int getMiddle(Node<Integer> node) {
        Node fast = node;
        Node slow = node;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return (int) slow.getVal();
    }

    public static void main(String[] args) {

        MyLinkedList<Integer> lst = new MyLinkedList<>();
       lst.addAll(Arrays.asList(1,2,3,4,5,31,4,5,6,7,8));

        var a = getMiddle(lst.getTop());
        System.out.println(a);

    }

}
