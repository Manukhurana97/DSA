package com.example.dsa.NewCode.LinkedList;

public class MyHashSet {

    Node head;
    Node tail;

        class Node{

            int val;
            Node prev;
            Node next;

            Node(){}
            Node(int val) {
                this.val = val;
                this.next = null;
            }
            Node(int val, Node next) {
                this.val = val;
                this.next = next;
            }

            Node(int val, Node prev, Node next) {
                this.val = val;
                this.next = next;
                this.prev = prev;
            }
        }

    public MyHashSet() {

    }

    public void add(int key) {
        if (contains(key)) return;

        Node node = new Node(key);
        if (head == null) {
            head = tail = node;
            return;
        }

        tail.next = node;
        node.prev = tail;
        tail = tail.next;


        return;

    }

    public void remove(int key) {
        if (head == null) return;

        Node temp = containsKeyByNode(key);
        System.out.println("remove"+ key);

        if(temp==null) return;

        if (temp.prev == null && temp.next == null) {
            System.out.println("1");
            head = tail = null;
            return;
        }
        if (temp.prev == null) {
            System.out.println("2");
            head = head.next;
            head.prev = null;
            return;
        }
        if (temp.next == null) {
            System.out.println(3+"::"+temp.val);
            tail = tail.prev;
            tail.next = null;
            return;
        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;

    }

    public boolean contains(int key) {
        if (head == null) return false;
        return containsKeyByNode(key) != null;
    }

    private Node containsKeyByNode(int key) {
        Node tempHead = head;
        Node tempTail = tail;

        while (tempHead != null && tempTail != null && tempHead != tempTail) {
            if (tempHead.val == key) return tempHead;
            if (tempTail.val == key) return tempTail;

            tempHead = tempHead.next;
            tempTail = tempTail.prev;
        }

        if (tempHead!=null && tempHead.val == key) return tempHead ;
        if (tempTail!=null && tempTail.val == key) return tempTail ;
        return null;
    }





}

