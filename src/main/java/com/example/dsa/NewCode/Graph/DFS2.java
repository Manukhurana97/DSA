package com.example.dsa.NewCode.Graph;

import java.util.*;

public class DFS2 {

    private static List<Integer> triverse(List<List<Integer>> input, int v) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(v - 1);
        visited.add(v - 1);

        dfs(input, v, result, visited, stack);

        return result;
    }

    private static void dfs(List<List<Integer>> input, int v, List<Integer> result, Set<Integer> visited,
            Stack<Integer> stack) {

        while (!stack.isEmpty()) {
            var vertex = stack.pop();
            result.add(vertex + 1);

            for (var neighbour : input.get(vertex)) {
                if (!visited.contains(neighbour - 1)) {
                    stack.add(neighbour - 1);
                    visited.add(neighbour - 1);
                    dfs(input, neighbour - 1, result, visited, stack);
                }
            }
        }
    }

    /******************************************************************************************************************************************/

    private static List<Integer> triverse1(List<List<Integer>> input, int v) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        dfs1(input, v - 1, result, visited);

        return result;
    }

    private static void dfs1(List<List<Integer>> input, int n, List<Integer> result, Set<Integer> visited) {

        visited.add(n);
        result.add(n + 1);

        for (var node : input.get(n)) {
            if (!visited.contains(node - 1)) {
                dfs1(input, node - 1, result, visited);
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

        System.out.println("a " + triverse(input, 1));
        System.out.println("b " + triverse1(input, 1));
    }

}
