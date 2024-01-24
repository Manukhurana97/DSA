package com.example.dsa.NewCode.Graph;

import java.util.*;

public class DetechGraphIsCyclic {

    private static boolean isGraphCyclic(int v, List<List<Integer>> list) {

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Integer> parent = new HashMap<>(); // current node, who is the parent

        for (int i = 0; i < v; i++) { // for all the nodes, (if the graph ic brock into multiple component)
            if (!visited.contains(i)) { // if not visited
                if (detectCycleBFS(i, queue, visited, parent, list)) // has cycle , return true
                    return true;
            }
        }
        return false;
    }

    private static boolean detectCycleBFS(int i, Queue<Integer> queue, Set<Integer> visited,
            Map<Integer, Integer> parent, List<List<Integer>> list) {
        queue.add(i); // add to the queue
        parent.put(i, null);

        while (!queue.isEmpty()) {
            int current = queue.poll(); // get current elemnt from queue
            visited.add(current); // mark as visited

            for (int neighbour : list.get(current)) { // get all the neighbours of current
                if (!visited.contains(neighbour)) { // if not visited , the add to the queue and get the parents
                    queue.add(neighbour);
                    parent.put(neighbour, current);
                } else if (parent.get(neighbour) != current) // if already visited, the check if parent is same
                                                             // as current ot not
                    return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(2, 6));
        input.add(Arrays.asList(3, 1));
        input.add(Arrays.asList(2, 4));
        input.add(Arrays.asList(3, 5));
        input.add(Arrays.asList(4, 6));
        input.add(Arrays.asList(1, 5, 7));
        input.add(Arrays.asList(6));

        System.out.println(isGraphCyclic(1, input));
    }

}
