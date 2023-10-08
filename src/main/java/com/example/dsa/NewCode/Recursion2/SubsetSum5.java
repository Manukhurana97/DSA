package com.example.dsa.NewCode.Recursion2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSum5 {

    private void findSubset(int ind, int[] arr, ArrayList<Integer> lst, List<List<Integer>> listList) {

            if(ind == arr.length){
                return;
            }

        for (int i = ind; i < arr.length; i++) {
            if (i != ind && arr[i] == arr[i - 1]) continue;

            lst.add(arr[i]);
            listList.add(new ArrayList<>(lst));
            findSubset(i+1, arr, lst, listList);
            lst.remove(lst.size() - 1);
        }
    }

    private void subsetWithoutDuplicate(int[] arr) {
        Arrays.sort(arr);

        List<List<Integer>> listList = new ArrayList<>();
        findSubset(0, arr, new ArrayList<>(), listList);

        System.out.println(listList.size());
        for(var i: listList){
            System.out.println(i);
        }
    }


    public static void main(String[] args) {
        SubsetSum5 subsetSum5 = new SubsetSum5();

//        int[] arr = {1,2,2,2,3,3};
        int[] arr = {3,1,2,4};
        subsetSum5.subsetWithoutDuplicate(arr);
    }


}

