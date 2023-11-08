package com.example.dsa.NewCode.SlidingWIndow.StaticK;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstNegativeElementInWindow {


    private static List<Integer> getFirstNegatives(int[] arr, int k) {
        int i = 0, j = 0, n = arr.length;

        List<Integer> lst = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        while (j < n) {
            if (arr[j] < 0) lst.add(j);

            if (j - i < k - 1) {
                j++;
                continue;
            }

            if (!lst.isEmpty() && lst.get(0) < i) lst.remove(0);
            result.add((!lst.isEmpty() ? arr[lst.get(0)] : 0));

            i++;
            j++;
        }

        return result;
    }



    public static void main(String[] args) {
        int k = 3;
        int[] arr = {12, -1, -7, 8, -15, 30, 13, 28};
        System.out.println(getFirstNegatives(arr, k));
    }
}
