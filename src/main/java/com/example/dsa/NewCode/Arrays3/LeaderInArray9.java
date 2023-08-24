package com.example.dsa.NewCode.Arrays3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeaderInArray9 {

    private static int[] findLeader(int[] arr) {

        int k = 0;
        int n = arr.length;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            boolean isLeader = true;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] < arr[j]) {
                    isLeader = false;
                    break;
                }
            }
            if (isLeader) result.add(arr[i]);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    private static int[] findLeader1(int[] arr) {

        int n = arr.length;
        int leaderTilNow = arr[n - 1];

        List<Integer> result = new LinkedList<>();
        result.add(leaderTilNow);

        for (int i = n - 1; i > 0; i--) {
            if (leaderTilNow < arr[i]) {
                result.add(0, arr[i]);
                leaderTilNow = arr[i]; // new leader
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }


    public static void main(String[] args) {
        int[] arr = {7, 22, 15, 3, 0, 6};
        var result = findLeader(arr);
        for (int i : result) System.out.print(i + " ");
        System.out.println();

        result = findLeader1(arr);
        for (int i : result) System.out.print(i + " ");
        System.out.println();
    }
}
