package com.example.dsa.NewCode.Arrays3;

import java.util.*;

public class CountSubArraySumEqualsToK13 {

    public static Set<List<Integer>> countSumValue(int[] arr, int k) {

        int sum = 0;
        int n = arr.length;
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == k) {
                    List<Integer> lst = new ArrayList<>();
                    for (int z = i; z <= j; z++) {
                        lst.add(arr[z]);
                    }
                    set.add(lst);
                }
            }
        }
        return set;
    }

    public static int countSumLen(int[] arr, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        int count = 0;
        int presum = 0;
        map.put(0, 1);

        for (int i = 0; i < arr.length; i++) {
            presum += arr[i];

            if (map.containsKey(presum - k)) {
                count += map.get(presum - k);
            }
            map.put(presum, map.getOrDefault(presum, 0) + 1);
        }
        return count;
    }
    public static int countSumLen1(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int count = 0;
        int presum = 0;
        int n = arr.length;

        map.put(0, 1);

        for (int i = 0; i < n; i++) {

            presum += arr[i];

            if (map.containsKey(presum - k)) {
                count += map.get(presum - k);
            }

            map.put(presum, map.getOrDefault(presum, 0) + 1);

        }
        return count;
    }

    public static int countSumLen2(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int count = 0;
        int presum = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {

            presum += arr[i];

            count += ((presum ^ k) == 0) ? 1 : 0;
            count += map.getOrDefault(presum - k, 0);

            map.put(presum, map.getOrDefault(presum, 0) + 1);
        }
        return count;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -3, 1, 1, 1, 4, 2, -3};
//          var result = countSumValue(arr, 3);
//        var result1 = countSumLen(arr, 3);
        var result2 = countSumLen1(arr, 3);
//        var result3 = countSumLen2(arr, 3);
        System.out.println(result2);


//        int[] arr1 = {1};
//        var result3 = countSumLen1(arr1, 0);
//        System.out.println(result3);

    }
}
