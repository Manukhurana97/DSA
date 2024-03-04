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

        if (target == "0000")
            return 0;

        Set<String> visited = new HashSet<>(Arrays.asList(deadends));

        if (visited.contains("0000"))
            return -1;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node("0000", 0));

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

    private List<String> childrens(String curr) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            char c = curr.charAt(i);
            String up = curr.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + curr.substring(i + 1);
            String down = curr.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + curr.substring(i + 1);

            res.add(up);
            res.add(down);
        }

        return res;
    }

}
