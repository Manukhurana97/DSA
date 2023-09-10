package com.example.dsa.NewCode.LinkedList;

import java.util.Collection;

public class MyLinkedList<T> {

    Node head;
    Node tail;


    MyLinkedList() {
        head = tail = null;
    }


    public void add(T val) {
        if (val != null)
            this.addValue(val);
        return;
    }

    public void addAll(T[] list) {
        if (list.length > 0) {
            this.addAllValue(list);
        }
    }

    public void addAll(Collection<T> list) {
        if (!list.isEmpty()) {
            this.addAllValue(list);
        }
    }


    public void addValue(T val) {

        Node node = new Node(val);

        if (isEmpty()) {
            head = tail = node;
            return;
        }

        node.prev = tail;
        tail.next = node;
        tail = node;
        return;
    }

    private void addAllValue(T[] list) {
        for (T i : list) {
            this.add(i);
        }
    }

    private void addAllValue(Collection<T> list) {
        for (var i : list) {
            this.add(i);
        }
    }

    public Node getTop() {
        return (head == null) ? null : head;
    }

    private boolean isEmpty() {
        return (head == null);
    }
}
