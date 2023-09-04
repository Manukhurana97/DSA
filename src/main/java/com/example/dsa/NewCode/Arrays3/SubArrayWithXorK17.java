package com.example.dsa.NewCode.Arrays3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubArrayWithXorK17 {

    /**
     * O(n)
     * */
    public static List<List<Integer>> getList(int[] arr, int target) {

        List<List<Integer>> result = new ArrayList<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int xor = arr[i];

            if (arr[i] == target) {
                result.add(List.of(target));
            }

            for (int j = i + 1; j < n; j++) {
                xor ^= arr[j];

                if (xor == target) {
                    ArrayList<Integer> lst = new ArrayList<>();

                    for (int z = i; z <= j; z++) {
                        lst.add(arr[z]);
                    }
                    result.add(lst);

                }
            }
        }
        return result;

    }

    public static List<List<Integer>> getList1(int[] arr, int target) {

        List<List<Integer>> result = new ArrayList<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            List<Integer> elementList = new ArrayList<>();
            elementList.add(arr[i]);

            int xor = arr[i];
            if (xor == target) {
                result.add(elementList);
                continue;
            }

            for (int j = i + 1; j < n; j++) {
                elementList.add(arr[j]);
                xor ^= arr[j];

                if (xor == target) {
                    result.add(new ArrayList<>(elementList));
                }
            }

        }
        return result;

    }

    public static int getList2(int[] arr, int target) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int xor = 0;
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];

            if (map.containsKey((xor ^ target))) {
                count += map.get((xor ^ target));
            }

            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }

        return count;
    }


    public static void main(String[] args) {
//        int[] arr = {4, 2, 2, 6, 4};
//        int target = 6;
        int[] arr = {4, 3, 1, 2, 4};
        int target = 2;

        System.out.println(getList(arr, target));
        System.out.println(getList1(arr, target));
        System.out.println(getList2(arr, target));


    }
}
