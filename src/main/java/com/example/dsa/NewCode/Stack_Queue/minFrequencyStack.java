package com.example.dsa.NewCode.Stack_Queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class minFrequencyStack {

    Map<Integer, Node> map;
    Map<Integer, List<Node>> frequency;

    class Node {
        int data;
        int freq;

        Node(int data) {
            this.data = data;
            this.freq = 1;
        }
    }

    public minFrequencyStack() {
        map = new HashMap<>();
        frequency = new HashMap<>();
    }

    public void push(int val) {


        if (map.containsKey(val)) {
            Node node = map.get(val);
            node.freq += 1;
            map.put(val, node);
            increaseFrequency(node.freq, node);
        } else {
            Node newNode = new Node(val);
            map.put(val, newNode);
            frequency.computeIfAbsent(1, k -> new LinkedList<>()).add(newNode);
        }
    }



    public void increaseFrequency(int freq, Node node) {
        List<Node> nodes = frequency.get(freq);
        node.freq += 1;
        frequency.computeIfAbsent(node.freq, k -> new LinkedList<>()).add(node);

    }

    public void decreaseFrequency(int val, Node node) {
    }

}