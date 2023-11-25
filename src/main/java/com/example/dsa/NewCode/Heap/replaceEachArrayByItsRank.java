package com.example.dsa.NewCode.Heap;

import java.util.*;

public class replaceEachArrayByItsRank {

    public static int[] getRanks(int[] arr) {
        int[] result = new int[arr.length];
        int n = arr.length;

        for(int i=0;i<n;i++){
            Set<Integer> set = new HashSet<>();
            for (int k : arr)
                if (arr[i] > k)
                    set.add(k);

            result[i] = set.size()+1;
        }

        return result;
    }

    public static int[] getRanks1(int[] arr) {
        List<Integer> set = new ArrayList<>();

        for (int i : arr) set.add(i);

        Collections.sort(set);

        for (int i = 0; i < arr.length; i++) arr[i] = set.indexOf(arr[i])+1;

        return arr;
    }

    public static int[] getRanks2(int[] arr) {
        int[] result = new int[arr.length];
        return result;
    }



    public static void main(String[] args) {
        int arr[] = {20, 15, 26, 2, 98, 6};
        System.out.println(Arrays.toString(getRanks(arr)));
        System.out.println(Arrays.toString(getRanks1(arr)));
    }
}
