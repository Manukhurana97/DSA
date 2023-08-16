package com.example.dsa.NewCode.Arrays3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuadSum16 {

    public static List<List<Integer>> quad(int[] arr, int target) {

        List<List<Integer>> lst = new ArrayList<>();
        int n = arr.length;

        Arrays.sort(arr);

        for (int i = 0; i < n-3; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < n-2; j++) {
                if (j != i + 1 && arr[j] == arr[j - 1]) {
                    continue;
                }

                int k = j + 1;
                int z = n - 1;

                while (k < z) {
                    long sum = (long) arr[i] + arr[j] + arr[k] + arr[z];
                    if (sum == target) {
                        lst.add(Arrays.asList(arr[i], arr[j], arr[k], arr[z]));
                        while (k < z && arr[k] == arr[k + 1]) k += 1;
                        while (k < z && arr[z] == arr[z - 1]) z -= 1;
                        k += 1;
                        z -= 1;
                    } else if (sum < target) {
                        k++;
                    } else {
                        z--;
                    }
                }
            }
        }
        return lst;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, -1, 0, -2, 2};
        var result = quad(arr, 0);
        for (var res : result) {
            System.out.println(res);
        }
    }
}
