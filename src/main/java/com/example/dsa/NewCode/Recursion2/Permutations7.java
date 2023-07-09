package com.example.dsa.NewCode.Recursion2;

import java.util.ArrayList;
import java.util.List;

public class Permutations7 {

    private void swap(int[] arr, int to, int from) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }

    private void printAllPermutations(int[] arr, int i, int n) {

        if (i == n) {
            for (int z : arr)
                System.out.print(z + " ");
            System.out.println();
            return;
        }

        for (int j = i; j <= n; j++) {
            swap(arr, i, j);
            printAllPermutations(arr, i + 1, n);
            swap(arr, j, i);
        }
    }

    private void printAllPermutationsWithSpace(List<Integer> lst, boolean[] flag, int[] arr) {
        if (arr.length == lst.size()) {
            System.out.println(lst);
            return;
        }

        for (int j = 0; j < arr.length; j++) {
            if (!flag[j]) {
                flag[j] = true;
                lst.add(arr[j]);
                printAllPermutationsWithSpace(lst, flag, arr);
                flag[j] = false;
                lst.remove(lst.size() - 1);
            }
        }
    }

    private void printAllPermutations(int[] arr) {
//        this.printAllPermutations(arr, 0, arr.length - 1);

        this.printAllPermutationsWithSpace(new ArrayList<>(), new boolean[arr.length], arr);
    }


    public static void main(String[] args) {
        Permutations7 permutations7 = new Permutations7();
        int[] arr = {1, 2, 3};
        permutations7.printAllPermutations(arr);


    }
}
