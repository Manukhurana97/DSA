package com.example.dsa.NewCode.Graph;

import java.util.*;

// it can we applied on dag : dircted acyclic graph  
// if there us node from u->v, the u always ahead of v
public class TopologicalSort {

    private static List<Integer> topoSort(List<List<Integer>> list) {
        boolean[] visit = new boolean[list.size()];
        List<Integer> stack = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (!visit[i]) {
                dfs(i, list, visit, stack);
            }
        }

        Collections.reverse(stack);
        return stack;
    }

    private static void dfs(int current, List<List<Integer>> list, boolean[] visit, List<Integer> stack) {
        visit[current] = true;

        for (var neighbour : list.get(current)) {
            if (!visit[neighbour]) {
                dfs(neighbour, list, visit, stack);

            }
        }
        stack.add(current);
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList());
        list.add(Arrays.asList());
        list.add(Arrays.asList(3));
        list.add(Arrays.asList(1));
        list.add(Arrays.asList(0, 1));
        list.add(Arrays.asList(0, 2));
        System.out.println(topoSort(list));
        ;
    }

}
