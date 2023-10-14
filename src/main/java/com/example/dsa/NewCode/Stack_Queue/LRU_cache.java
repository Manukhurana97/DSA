package com.example.dsa.NewCode.Stack_Queue;

import java.util.HashMap;
import java.util.Map;

public class LRU_cache {

    int size = 5;
    Map<Integer, Node> map = new HashMap<>();

    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);

    /**
     * Push the value the cache
     */
    public void addCache(int value) {

        Node newNode = new Node(map.size() + 1, value);

        if (map.isEmpty()) {
            head.next = newNode;
            tail.prev = newNode;
            newNode.prev = head;
            newNode.next = tail;
        } else {
            if (map.containsKey(value)) this.getNode(value);
            this.insertNode(newNode);
        }
        map.put(value, newNode);

    }

    /**
     * get the value of exist, and update the cache position to top
     */
    private int getCache(int value) {
        if (!map.containsKey(value)) return -1;
        Node existingNode = this.getNode(value);

        Node newNode = new Node(existingNode.index, value);
        this.insertNode(newNode);

        return existingNode.data;
    }

    /**
     * Insert new Node in List
     */
    public void insertNode(Node newNode) {
        if(isCacheFull()){}

        newNode.next = head.next;
        newNode.prev = head;
        head.next.prev = newNode;
        head.next = newNode;
    }


    /**
     * delete the existing node
     */
    private void removeNode(Node existing) {
        existing.prev.next = existing.next;
        existing.next.prev = existing.prev;

        existing.next = existing.prev = null;
    }

    /**
     * get the node by value
     * */
    private Node getNode(int value) {
        Node existingNode = map.get(value);
        this.removeNode(existingNode);

        return existingNode;
    }


    public boolean isCacheFull(){
        return map.size()==this.size;
    }

    private class Node {
        int index;
        int data;
        Node prev;
        Node next;

        public Node(int index, int data) {
            this.index = index;
            this.data = data;
        }
    }


}
