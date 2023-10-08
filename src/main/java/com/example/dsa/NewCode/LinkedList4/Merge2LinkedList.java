package com.example.dsa.NewCode.LinkedList;

import java.util.Arrays;

public class Merge2LinkedList {

    public static Node<Integer> reverse(Node<Integer> head) {
        if (head == null) return null;

        Node<Integer> tempHead = head;
        if (head.next != null) {
            tempHead = reverse(head.next);

            head.next.next = head;
            head.next = null;
        }
        return tempHead;
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> lst = new MyLinkedList<>();
        lst.addAll(Arrays.asList(1, 2, 3, 4, 5));

        var a = reverse(lst.getTop());
        while (a != null) {
            System.out.println(a);
        }
    }

}

