package com.example.dsa.NewCode.Graph;

import java.util.*;

// find all the nodes that are pointing to the end nodes / not pointing to the safe note
public class EvantualSafeState {
    private static List<Integer> evantualSafeState(List<List<Integer>> grid) {

        int[] visited = new int[grid.size()];
        int[] pathVisited = new int[grid.size()];
        int[] check = new int[grid.size()];

        for (int i = 0; i < grid.size(); i++) {
            if (visited[i] == 0) {
                dfs(i, grid, visited, pathVisited, check);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < grid.size(); i++)
            if (check[i] == 1)
                result.add(i);
        return result;
    }

    // detecting cycle in dfs
    private static boolean dfs(int i, List<List<Integer>> grid, int[] visited, int[] pathVisited, int[] check) {

        visited[i] = 1;
        pathVisited[i] = 1;
        check[i] = 0;

        for (var neighbour : grid.get(i)) {
            if (visited[neighbour] == 0) {
                if (dfs(neighbour, grid, visited, pathVisited, check))
                    return true;
            } else if (pathVisited[neighbour] == 1) {
                return true;
            }
        }

        check[i] = 1;// if element is not a check ot not pointing to a cycle we make it as 1
        pathVisited[i] = 0; // Reset pathVisited after exploration.
        return false;
    }

    // solution 2 using topo sort
    private static List<Integer> evantualSafeStateTopoSort(List<List<Integer>> grid) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < grid.size(); i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[grid.size()];
        // reverse the nodes and increment the indegree of all the element
        for (int i = 0; i < grid.size(); i++) {
            for (var neighbours : grid.get(i)) {
                adj.get(neighbours).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        // calculate the element whose indegree is 0
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        // remove the element from graph whose indegree is 0 and remove the neighbour
        // connection also
        while (!queue.isEmpty()) {
            var currentPoint = queue.poll();
            result.add(0, currentPoint);

            // get all the neighbours of current node
            for (var neighbours : adj.get(currentPoint)) {
                indegree[neighbours]--;
                // if any element whose indegree is 0 after removing connetion , the add the the
                // queue
                if (indegree[neighbours] == 0) {
                    queue.add(neighbours);
                }
            }
        }

        return result;

    }

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(5);
        adj.get(4).add(6);
        adj.get(5).add(6);
        adj.get(6).add(7);
        adj.get(8).add(1);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);
        adj.get(11).add(9);

        var result = evantualSafeStateTopoSort(adj);
        System.out.println(result);

    }
}
