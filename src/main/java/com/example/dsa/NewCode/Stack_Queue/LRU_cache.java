package com.example.dsa.NewCode.Stack_Queue;

import java.util.HashMap;
import java.util.Map;

public class LRU_cache {

    protected int capacity;

    protected Map<Integer, Node> map;

    protected Node head;
    protected Node tail;

    private class Node {
        int value;
        Node prev;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    LRU_cache() {
        this(4);
    }

    LRU_cache(int _capacity) {
        this.capacity = _capacity;
        head = new Node(0);
        tail = new Node(0);
        map = new HashMap<>();
    }

    /**
     * Push the value the cache
     */
    public void addCache(int value) {

        Node newNode = new Node(value);

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
    public int displayCache(int value) {
        if (!map.containsKey(value)) return -1;
        Node existingNode = this.getNode(value);

        Node newNode = new Node(value);
        this.insertNode(newNode);

        return existingNode.value;
    }

    /**
     * Insert new Node in List
     */
    protected void insertNode(Node newNode) {
        if (isCacheFull()) this.removeLastNode();

        newNode.next = head.next;
        newNode.prev = head;
        head.next.prev = newNode;
        head.next = newNode;
    }

    protected void removeLastNode() {
        if (!this.isCacheEmpty())
            this.removeNode(tail.prev);
    }

    /**
     * delete the existing node
     */
    protected void removeNode(Node existing) {
        existing.prev.next = existing.next;
        existing.next.prev = existing.prev;

        existing.next = existing.prev = null;
    }

    /**
     * get the node by value
     */
    protected Node getNode(int value) {
        Node existingNode = map.get(value);
        this.removeNode(existingNode);

        return existingNode;
    }

    protected boolean isCacheFull() {
        return map.size() == this.capacity;
    }

    protected boolean isCacheEmpty() {
        return (head.next == tail);
    }

    public void displayCache() {
        Node temp = head.next;
        while (temp != tail) {
            System.out.println(temp.value + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        LRU_cache cache = new LRU_cache();
        cache.addCache(1);
        cache.addCache(2);
        cache.addCache(3);
        System.out.println(cache.map);
        cache.displayCache();
        cache.addCache(4);
        cache.addCache(5);
        System.out.println(cache.map);
        cache.displayCache();
        cache.displayCache(3);
        System.out.println(cache.map);
        cache.displayCache();
    }

}
