package com.example.dsa.NewCode.Graph;

import java.util.*;

public class DFS2 {

    private static List<Integer> triverse(List<List<Integer>> input, int v) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(v - 1);
        visited.add(v - 1);

        helper(input, v, result, visited, stack);

        return result;
    }

    private static void helper(List<List<Integer>> input, int v, List<Integer> result, Set<Integer> visited,
            Stack<Integer> stack) {

        while (!stack.isEmpty()) {
            var n = stack.pop();
            result.add(n + 1);

            var list = input.get(n);
            for (var node : list) {
                if (!visited.contains(node - 1)) {
                    stack.add(node - 1);
                    visited.add(node - 1);
                    helper(input, node - 1, result, visited, stack);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(2, 6));
        input.add(Arrays.asList(1, 3, 4));
        input.add(Arrays.asList(2));
        input.add(Arrays.asList(2, 5));
        input.add(Arrays.asList(4, 8));
        input.add(Arrays.asList(1, 7, 9));
        input.add(Arrays.asList(6, 8));
        input.add(Arrays.asList(7));
        input.add(Arrays.asList(6));

        System.out.println(triverse(input, 1));
    }

}
