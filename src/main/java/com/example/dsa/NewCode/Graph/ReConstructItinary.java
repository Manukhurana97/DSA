package com.example.dsa.NewCode.Graph;

import java.util.*;

public class ReConstructItinary {

    public List<String> findItinerary(List<List<String>> tickets) {

        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (var ticket : tickets)
            map.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));

        List<String> result = new LinkedList<>();
        dfs("JFK", result, map);

        return result;
    }

    private void dfs(String ticket, List<String> result, Map<String, PriorityQueue<String>> map) {
        PriorityQueue<String> destinations = map.get(ticket);

        while (destinations != null && !destinations.isEmpty()) {
            dfs(destinations.poll(), result, map);
        }
        result.add(0, ticket);
    }

    public static void main(String[] args) {
        List<List<String>> input = new ArrayList<>();
        input.add(Arrays.asList("MUC", "LHR"));
        input.add(Arrays.asList("JFK", "MUC"));
        input.add(Arrays.asList("SFO", "SJC"));
        input.add(Arrays.asList("LHR", "SFO"));

        ReConstructItinary reConstructItinary = new ReConstructItinary();
        var a = reConstructItinary.findItinerary(input);
        System.out.println(a);
    }

}
