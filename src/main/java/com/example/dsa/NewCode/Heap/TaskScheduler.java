package com.example.dsa.NewCode.Heap;

import java.util.*;

public class TaskScheduler {

        class Node {
            int count;
            int idleTime;

            Node(int count, int idleTime) {
                this.count = count;
                this.idleTime = idleTime;
            }
        }

    public int leastInterval(char[] tasks, int n) {

        if (n == 0) return tasks.length;

        int time = 0;
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        Deque<Node> coolDownPeriod = new LinkedList<>();


        for (int i : tasks) map.put(i, map.getOrDefault(i, 0) + 1);
        for (Map.Entry<Integer, Integer> k_v : map.entrySet()) queue.add(k_v.getValue());

        while (!queue.isEmpty() || !coolDownPeriod.isEmpty()) {
            time += 1;
            if (!queue.isEmpty()) {
                int count = queue.remove() - 1;
                if (count > 0)
                    coolDownPeriod.add(new Node(count, time + n));
            }

            if (!coolDownPeriod.isEmpty() && coolDownPeriod.getFirst().count == time) {
                queue.add(coolDownPeriod.remove().count);
            }
        }

        return time;
    }




    public static void main(String[] args) {

    }
}
