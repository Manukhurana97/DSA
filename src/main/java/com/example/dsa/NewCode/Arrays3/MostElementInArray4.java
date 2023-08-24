package com.example.dsa.NewCode.Arrays3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MostElementInArray4 {

    /**
     * Time: O(n^2)
     * Space: O(1)
     */
    public static int mostElement1(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i + 1; j < n; j++) {
                count += (arr[j] == arr[i]) ? 1 : 0;
            }

            if (count > (n / 2)) return arr[i];
        }
        return -1;
    }


    /**
     * Time: O(nlogn)+O(n)
     * Space: O(1)
     */
    public static int mostElement2(int[] arr) {
        Arrays.sort(arr);

        int count = 0;
        int n = arr.length;
        int temp = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] == temp) {
                count += 1;
            } else {
                if (count > (n / 2)) return temp;
                count = 1;
                temp = arr[i];
            }
        }

        return -1;
    }


    /**
     * Time: O(n)+O(n)
     * Space : O(n)
     */
    public static int mostElement3(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) map.put(arr[i], (map.getOrDefault(arr[i], 0) + 1));
        for (Map.Entry<Integer, Integer> k_v : map.entrySet()) if (k_v.getValue() > n / 2) return k_v.getKey();

        return -1;
    }


    /**
     * Time: O(n)
     * Space : O(1)
     */
    public static int mooseVotingAlgo(int[] arr) {
        int el = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (count == 0) {
                count = 1;
                el = arr[i];
            } else if (arr[i] == el) {
                count += 1;
            } else {
                count -= 1;
            }
        }

        count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == el) count += 1;
        }
        if (count > arr.length / 2) return el;


        return -1;
    }


    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 3, 1, 2, 2, 2, 3, 3, 2, 2, 2};
        System.out.println(mostElement1(arr));
        System.out.println(mostElement2(arr));
        System.out.println(mostElement3(arr));
        System.out.println(mooseVotingAlgo(arr));
    }
}
