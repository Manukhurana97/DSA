package com.example.dsa.NewCode.GreedyApproach;

import java.util.*;

public class jobSequencingProblem {

    static class Node {
        int jobId;
        int deadline;
        int profit;

        public Node(int jobId, int deadline, int profit) {
            this.jobId = jobId;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static int getMaxProfit(List<Node> arr) {

        arr.sort(Comparator.comparingInt((Node n2) -> n2.profit).reversed());

        int maxDeadLine = 0;
        for (var i : arr) {
            maxDeadLine = Math.max(maxDeadLine, i.deadline);
        }

        int[] result = new int[maxDeadLine];
        int profit = 0;

        for (var i : arr) {
            for (int j = i.deadline - 1; j >= 0; j--) {
                if (result[j] == 0) {
                    profit += i.profit;
                    result[j] = i.jobId;
                    break;
                }
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        List<Node> lst = new ArrayList<>();
        lst.add(new Node(1, 4, 20));
        lst.add(new Node(2, 5, 60));
        lst.add(new Node(3, 6, 70));
        lst.add(new Node(4, 6, 65));
        lst.add(new Node(5, 4, 25));
        lst.add(new Node(6, 2, 80));
        lst.add(new Node(7, 2, 10));
        lst.add(new Node(8, 2, 22));
        System.out.println(getMaxProfit(lst));
    }
}
