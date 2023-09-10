package com.example.dsa.NewCode.LinkedList;

public class Node<T> {

    T val;
    Node next;
    Node prev;

    Node() {
    }

    Node(T val) {
        this.val = val;
    }

    Node(T val, Node next) {
        this.val = val;
        this.next = next;
    }


    Node(T val, Node next, Node prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }

    public T getVal(){
        return this.val;
    }

}
