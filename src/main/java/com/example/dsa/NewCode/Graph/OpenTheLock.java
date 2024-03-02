package com.example.dsa.NewCode.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class OpenTheLock {
    class Node {
        String pattern;
        int turn;

        Node(String pattern, int turn) {
            this.pattern = pattern;
            this.turn = turn;
        }
    }

    public int openLock(String[] deadends, String target) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node("0000", 0));

        Set<String> visited = new HashSet<>(Arrays.asList(deadends));

        while (!queue.isEmpty()) {
            var current = queue.poll();
            if (current.pattern.equals(target))
                return current.turn;

            for (var child : childrens(current.pattern)) {
                if (!visited.contains(child)) {
                    visited.add(child);
                    queue.add(new Node(child, current.turn + 1));
                }
            }
        }
        return -1;
    }

    private List<String> childrens(String current) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            char[] lock = current.toCharArray();

            var j = Integer.parseInt(lock[i] + "");
            lock[i] = (char) ((char) j + 1);
            res.add(String.valueOf(lock));

            lock[i] = (char) ((char) j + -2);
            res.add(String.valueOf(lock));

        }

        return res;
    }
}
