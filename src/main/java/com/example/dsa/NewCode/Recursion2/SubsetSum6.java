package com.example.dsa.NewCode.Recursion2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetSum6 {

//    private void generateAllSubsetsSum(List<Integer> lst, int[] arr, int i, int sum) {
//
//        if (i == arr.length) {
//            lst.add(sum);
//            return;
//        }
//
//        int e = arr[i];
//        sum += e;
//        generateAllSubsetsSum(lst, arr, i + 1, sum);
//
//        sum -= e;
//        generateAllSubsetsSum(lst, arr, i + 1, sum);
//    }
//
//    private List<Integer> subsetSum(int[] arr, int n) {
//        List<Integer> listOfSums = new ArrayList<>();
//
//        generateAllSubsetsSum(listOfSums, arr, 0, 0);
//
//        Collections.sort(listOfSums);
//        return listOfSums;
//    }


    private void generateAllSubsetsSum(List<Integer> lst, int[] arr, int i, int sum) {

        if(i==arr.length){
            lst.add(sum);
            return;
        }

        generateAllSubsetsSum(lst, arr, i+1, sum+arr[i]);
        generateAllSubsetsSum(lst, arr, i+1, sum);

    }
    private List<Integer> subsetSum(int[] arr, int n) {
        List<Integer> listOfSums = new ArrayList<>();

        generateAllSubsetsSum(listOfSums, arr, 0, 0);

        Collections.sort(listOfSums);
        return listOfSums;
    }



    public static void main(String[] args) {
        SubsetSum6 subsetSum6 = new SubsetSum6();
//        int[] arr = {2, 3};
        int[] arr = {5, 2, 1, 9};
        var data = subsetSum6.subsetSum(arr, arr.length);

        for (int i : data)
            System.out.print(i + " ");
    }
}
