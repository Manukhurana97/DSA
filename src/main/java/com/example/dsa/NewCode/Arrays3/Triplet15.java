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


    /*-4,-1,-1,0,1,1*/
    public static List<List<Integer>> getTriplet2(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        int n = arr.length;

        Arrays.sort(arr);


        for (int i = 0; i < n - 1; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum == 0) {
                    result.add(Arrays.asList(arr[i], arr[j], arr[k]));

                    /*while (j < k && arr[j] == arr[j + 1]) {
                        j++;
                    }
                    while (j < k && arr[k] == arr[k - 1]) {
                        k--;
                    }*/

                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return result;

    }


    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        var result = getTriplet2(arr);
        for (var i : result) {
            System.out.println(i);
        }

    }
}
