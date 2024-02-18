package com.example.dsa.NewCode.Graph;

import java.util.*;

// it can we applied on dag : dircted acyclic graph  
// if there us node from u->v, the u always ahead of v
// 1. perform the dfs on all the element, and keep the visited pointer
// 2. get all the neighbour of current element and mark the as visited and perform the dfs
// 3. once the dfs is completed perform add the (last elemnt to result)
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
        // List<List<Integer>> list = new ArrayList<>();
        // list.add(Arrays.asList());
        // list.add(Arrays.asList());
        // list.add(Arrays.asList(3));
        // list.add(Arrays.asList(1));
        // list.add(Arrays.asList(0, 1));
        // list.add(Arrays.asList(0, 2));

        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1, 2)); // Edge from 0 to 1 and 2
        list.add(Arrays.asList(2, 3)); // Edge from 1 to 2 and 3
        list.add(Arrays.asList(3)); // Edge from 2 to 3
        list.add(Arrays.asList());
        System.out.println(topoSort(list));
        ;
    }

}
