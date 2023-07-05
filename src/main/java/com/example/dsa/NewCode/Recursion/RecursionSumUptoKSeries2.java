package com.example.dsa.NewCode.Recursion;

import java.util.LinkedList;
import java.util.List;

public class RecursionSumUptoKSeries2 {

    /**
     * 1 2 1
     * f(1)    f(2,1)
     * f(1,2)   f(1,1) f(2)  f(1)
     * f(1,2,1) f(1,2)
     */

    private void sumOfElementUpToK(List<Integer> lst, int[] arr, int i, int n, int sum, int total) {

        if (i == n) {
            if (sum == total) System.out.println(lst);
            return;
        }
        if (sum == total) {
            System.out.println(lst);
            return;
        }

        /* picking element */
        var e = arr[i];
        sum += e;
        lst.add(e);
        sumOfElementUpToK(lst, arr, i + 1, n, sum, total);

        /* Not picking the element */
        sum -= e;
        lst.remove(lst.size() - 1);
        sumOfElementUpToK(lst, arr, i + 1, n, sum, total);

    }
    private void sumOfElementUpToK(int[] arr, int total) {

        this.sumOfElementUpToK(new LinkedList<>(), arr, 0, arr.length, 0, total);
    }


    /**
     * return the number of pairs
     */
    private int sumOfElementUpToKV1(int[] arr, int i, int n, int sum, int total) {

        if (i == n) {
            if (sum == total)
                return 1;
            return 0;
        }
        if (sum == total) return 1;


        /* picking element */
        var e = arr[i];
        sum += e;
        var left = sumOfElementUpToKV1(arr, i + 1, n, sum, total);

        /* Not picking the element */
        sum -= e;
        var right = sumOfElementUpToKV1(arr, i + 1, n, sum, total);

        return (left + right);
    }
    private void sumOfElementUpToKV1(int[] arr, int total) {

        var c = this.sumOfElementUpToKV1(arr, 0, arr.length, 0, total);
        System.out.println("count " + c);
    }


    /**
     * variation: if we want to stop at first output only
     * -> using base case contition :: it will return the first out and the exists
     */

    private boolean sumOfElementUpToKV2(List<Integer> lst, int[] arr, int i, int n, int sum, int total) {

        if (i == n) {
            if (sum == total) {
                System.out.println(lst);
                return true;
            }
            return false;
        }
        if (sum == total) {
            System.out.println(lst);
            return true;
        }

        /* picking element */
        var e = arr[i];
        sum += e;
        lst.add(e);
        if (sumOfElementUpToKV2(lst, arr, i + 1, n, sum, total)) return true;

        /* Not picking the element */
        sum -= e;
        lst.remove(lst.size() - 1);
        if (sumOfElementUpToKV2(lst, arr, i + 1, n, sum, total)) return true;

        return false;
    }
    private void sumOfElementUpToKV2(int[] arr, int total) {

        this.sumOfElementUpToKV2(new LinkedList<>(), arr, 0, arr.length, 0, total);
    }


    public static void main(String[] args) {
        RecursionSumUptoKSeries2 kSeries = new RecursionSumUptoKSeries2();
        int[] arr = {1, 2, 1};
        kSeries.sumOfElementUpToK(arr, 2);
        kSeries.sumOfElementUpToKV1(arr, 2);
        kSeries.sumOfElementUpToKV2(arr, 2);
    }
}
