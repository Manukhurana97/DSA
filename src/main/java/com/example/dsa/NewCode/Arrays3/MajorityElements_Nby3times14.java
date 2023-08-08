package com.example.dsa.NewCode.Arrays3;

import java.util.ArrayList;
import java.util.List;

public class MajorityElements_Nby3times14 {

    public static List<Integer> countElement(int[] arr) {
        int count1 = 0, count2 = 0;
        int element1 = 0, element2 = 0;

        for (int i : arr) {
            if (element1 == i) {count1 += 1;
            } else if (element2 == i) {count2++;
            } else if (count1 == 0) {
                element1 = i;
                count1 = 1;
            } else if (count2 == 0) {
                element2 = i;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int i : arr) {
            if (i == element1) {
                count1++;
            }
            if (i == element2) {
                count2++;
            }
        }

        int n = arr.length;
        List<Integer> result = new ArrayList<>();
        if (count1 > n / 3) {
            result.add(element1);
        }
        if (count2 > n / 3 && element2 != element1) {
            result.add(element2);
        }

        return result;

    }


    public static void main(String[] args) {
//        int[] arr = {2, 1, 1, 3, 1, 4, 5, 6};
        int[] arr = {0, 0, 0};
        var a = countElement(arr);
        System.out.println(a);

    }
}
