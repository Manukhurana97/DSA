package com.example.dsa.NewCode.Arrays3;

import java.util.Arrays;

public class Arrays2 {

    public static int[] twoSum(int[] arr, int k) {
        int n = arr.length;
//        for (int i = 0; i < n - 1; i++) {
//            int f = arr[i];
//            for (int j = i + 1; j < n; j++) {
//                if (f + arr[j] == k) {
//                    return new int[]{i, j};
//                }
//            }
//        }


//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            if (map.containsKey(k - arr[i])) {
//                return new int[]{map.get(k - arr[i]), i};
//            } else {
//                map.put(arr[i], i);
//            }
//        }


        Arrays.sort(arr);
        int i = 0, j = n - 1;
        while (i < j) {
            int sum = (arr[i] + arr[j]);
            if (sum == k) return new int[]{1, j};
            else if (sum > k) j--;
            else i++;

        }


        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] arr = {2, 6, 8, 5, 11, 12};
       var a =  twoSum(arr, 14);
       for(int i: a)
           System.out.println(i);
    }
}
