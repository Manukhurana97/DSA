package com.example.dsa.NewCode.Stack_Queue;

import java.util.*;
import java.util.stream.Collectors;

public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < speed.length; i++) {
            map.put(position[i], speed[i]);
        }

        map.entrySet().stream().sorted((e1, e2) -> e1.getKey() - e2.getKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (l1, l2) -> l1, LinkedHashMap::new));

        Stack<Float> stack = new Stack<>();

        map.forEach((key, value) -> {
            float time = (target - key) / value;
            if (!stack.isEmpty() && stack.peek() < time) {
                stack.push(time);
            }
        });
        return stack.size();
    }
}