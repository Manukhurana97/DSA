package com.example.dsa.NewCode.SlidingWIndow.DynamicK;

import java.util.HashMap;
import java.util.Map;

/*
    1.pick maximum number of tops.
    2 can pick 2 type of element at once.
   */
public class PickToys {

    public static int maxToys(String[] arr, int k) {

        int i = 0, j = 0, n = arr.length, maxToys = 0;
        Map<String, Integer> map = new HashMap<>();

        while (j < n) {
            String val = arr[j];
            map.put(val, map.getOrDefault(val, 0) + 1);

            while (map.size() > k) {
                String popElement = arr[i];
                if (map.get(popElement) < 1) {
                    map.put(popElement, map.get(popElement) - 1);
                } else {
                    map.remove(popElement);
                }
                i++;
            }

            maxToys = Math.max(maxToys, j-i+1);
            j++;
        }

        return maxToys;
    }

    /*
    * a:1 :: m=1, s=1
    * a:1,b:1 :: m=2, s=2
    * a:2,b:1, :: m=3, s=3
    * a:2,b:1,c:1 -> a:1, c:1 :: m=3, s=2
    * a:1, c:2 :: m=3, s=3
    * a:2, c:2 :: m=4, s=4
    * a:2, c:2 -> a:1, b1  :: m=4, s=2
    * */
    public static void main(String[] args) {
        String[] arr = {"a", "b", "a", "c", "c", "a", "b"};
        System.out.println(maxToys(arr, 2));
    }
}
