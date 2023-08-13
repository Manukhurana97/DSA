package com.example.dsa.NewCode.Arrays3;

import java.util.*;

public class Triplet15 {

    public static Set<List<Integer>> getTriplet(int[] arr) {
        Set<List<Integer>> result = new HashSet<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        List<Integer> targetSum = Arrays.asList(arr[i], arr[j], arr[k]);
                        Collections.sort(targetSum);

                        result.add(targetSum);
                    }
                }
            }
        }
        return result;
    }

    public static Set<List<Integer>> getTriplet1(int[] arr) {
        Set<List<Integer>> result = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int targetSum = arr[i] + arr[j];
                if (map.containsKey((targetSum * -1))) {
                    List<Integer> triplet = Arrays.asList(arr[i], arr[j], (targetSum * -1));
                    Collections.sort(triplet);

                    result.add(triplet);

                }
            }
            map.put(arr[i], 0);
        }

        return result;
    }


    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        Set<List<Integer>> result = getTriplet1(arr);
        for (var i : result) {
            System.out.println(i);
        }

    }
}
