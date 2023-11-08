package com.example.dsa.NewCode.Stack_Queue;

import java.util.*;

public class LFU_cache {

    int capacity;
    int minFrequency;
    Map<Integer, Node> cache = new HashMap<>();
    Map<Integer, List<Node>> frequencyList = new HashMap<>();


    public LFU_cache() {
        this(3);
    }

    public LFU_cache(int capacity) {
        this.capacity = capacity;
        this.minFrequency = 0;
        this.cache = new HashMap<>();
        this.frequencyList = new HashMap<>();
    }

    public int get(int key) {
        if (cache.isEmpty()) return -1;

        Node node = cache.get(key);
        updateFrequency(key, node);

        return node.value;
    }

    public void push(int key, int value) {
        if (capacity == 0) return;

        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            updateFrequency(key, node);
        } else {
            if (capacity == cache.size()) {
                evict();
            }
            Node node = new Node(key, value);
            cache.put(key, node);
            frequencyList.computeIfAbsent(1, k -> new LinkedList<>()).add(node);
            minFrequency = 1;
        }
    }

    private void updateFrequency(int key, Node node) {
        int freq = node.frequency;
        List<Node> nodes = frequencyList.get(freq);
        nodes.remove(nodes);

        if (nodes.isEmpty() && freq == minFrequency)
            minFrequency += 1;
        node.frequency += 1;

        frequencyList.computeIfAbsent(node.frequency, k -> new LinkedList<>()).add(node);
    }

    private void evict() {
        List<Node> nodes = frequencyList.get(minFrequency);
        if (!nodes.isEmpty()) {
            Node nodeToRemove = nodes.iterator().next(); /* get last element;*/

            cache.remove(nodeToRemove.key);
            nodes.remove(nodeToRemove);
        }
    }

    private class Node {
        int key;
        int value;
        int frequency;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1;
        }
    }

}
