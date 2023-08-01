package com.example.dsa.NewCode.Recursion2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class CombinationSum1 {


    private void combinationSum(List<List<Integer>> resp, List<Integer> lst, int[] arr, int i, int n, int sum, int target) {

        if (i == arr.length) {
            if (sum == target) resp.add(new LinkedList<>(lst));
            return;
        }


        if(sum<=target) {
            var e = arr[i];
            sum += e;
            lst.add(e);
            combinationSum(resp, lst, arr, i, n, sum, target);
            sum -= e;
            lst.remove(lst.size() - 1);
        }


        combinationSum(resp, lst, arr, i + 1, n, sum, target);


    }

    private void combinationSum(List<List<Integer>> resp, List<Integer> lst, int[] arr, int i, int n, int target) {


        if (i == n) {
            if (target == 0)
                resp.add(new ArrayList<>(lst));
            return;
        }


        if (arr[i] <= target) {
            lst.add(arr[i]);
            combinationSum(resp, lst, arr, i, n, target - arr[i]);
            lst.remove(lst.size() - 1);
        }
        combinationSum(resp, lst, arr, i + 1, n, target);

    }


    private List<List<Integer>> combinationSum(int[] arr, int target) {
        LinkedList<List<Integer>> list_list = new LinkedList<List<Integer>>();
//        combinationSum(list_list, new LinkedList<>(), arr, 0, arr.length, 0, target);
        combinationSum(list_list, new LinkedList<>(), arr, 0, arr.length,  target);
        return list_list;
    }

    public static void main(String[] args) {
        CombinationSum1 combinationSum1 = new CombinationSum1();
        int[] arr = {2, 2, 3, 4, 6, 7};

        List<List<Integer>> response = combinationSum1.combinationSum(arr, 7);
        for (var i : response)
            System.out.println(i);
    }
}
