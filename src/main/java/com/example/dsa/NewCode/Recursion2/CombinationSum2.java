package com.example.dsa.NewCode.Recursion2;

import java.util.*;

public class CombinationSum2 {


    private void getPairs1(HashSet<List<Integer>> set, List<Integer> lst, int[] arr, int i, int n, int sum, int target) {

        if (i == n) {
            if (sum == target) {
                set.add(new ArrayList<>(lst));
            }
            return;
        }

        int e = arr[i];
        sum += e;
        lst.add(e);
        getPairs1(set, lst, arr, i + 1, n, sum, target);

        sum -= e;
        lst.remove(lst.size() - 1);
        getPairs1(set, lst, arr, i + 1, n, sum, target);

    }


    private void getPairs2(HashSet<List<Integer>> set, List<Integer> lst, int[] arr, int i, int target) {

        if (target < 0) return;

        if (target == 0) {
            set.add(new ArrayList<>(lst));
            return;
        }

        for (int z = i; z < arr.length; z++) {
            if (z < i && arr[i] == arr[i - 1]) continue; // if same as
            int e = arr[z];
            lst.add(e);
            getPairs2(set, lst, arr, z + 1, target - e);
            lst.remove(lst.size() - 1);
        }


    }


    private List<List<Integer>> getPairs2(int[] arr, int target) {
        HashSet<List<Integer>> set = new HashSet<>();
        Arrays.sort(arr);
        getPairs1(set, new ArrayList<>(), arr, 0, arr.length - 1, 0, target);
        getPairs2(set, new ArrayList<>(), arr, 0, target);

        return new LinkedList<>(set);
    }

    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();

        int arr[] = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> lst_lst = combinationSum2.getPairs2(arr, 8);
        for (var i : lst_lst)
            System.out.println(i);
    }


}
