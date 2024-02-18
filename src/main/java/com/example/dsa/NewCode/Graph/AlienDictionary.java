package com.example.dsa.NewCode.Graph;

import java.util.*;

/* 
    compare input, and find the different character with each string (from i to n)
    once's difference element is found, break the comparing loop, and create a graph from char[i]->char[i+1]
    also calculate in inbound notes
    perform topo sort : 
    1. calculate inbound of all the nodes
    2. get all the element with 0 inbound
    3. remove the element and connction with neighbours and store the new inbound with 0
    
    */
public class AlienDictionary {

    private static String findOrder(String[] dictionary, int N, int k) {
        List<List<Integer>> input = new ArrayList<>();
        int[] inbound = new int[k];

        if (N == 1) {
            return dictionary[0];
        }

        for (int i = 0; i < k; i++) {
            input.add(new ArrayList<>());
        }

        // creating a adjancy list from input
        for (int i = 0; i < N - 1; i++) { // for each string
            var s1 = dictionary[i]; // i
            var s2 = dictionary[i + 1]; // i+1
            int min = Math.min(s1.length(), s2.length());
            for (int j = 0; j < min; j++) { // get differnt character
                if (s1.charAt(j) != s2.charAt(j)) { // if different elemnt found
                    input.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a'); // create a node of adjanct list
                    inbound[s2.charAt(j) - 'a']++; // sum inbound degree of destination
                    break;
                }
            }
        }

        // perform standarf topo sort
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (inbound[i] == 0) {
                queue.add(i);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            var current = queue.poll();
            result.append((char) ('a' + current)); // since we store the element in number convert back to string

            for (var neighbour : input.get(current)) {
                inbound[neighbour]--;
                if (inbound[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String[] dic = { "baa", "abcd", "abca", "cab", "cad" };
        System.out.println(findOrder(dic, 5, 4));
    }

}
