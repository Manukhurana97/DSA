package OldCode.Arrays;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/***
 * To find the max sum of a sub-array
 */
public class KadanesAlgo {

    public static int KadaneAlgo(int[] arr) {

        int max = Integer.MIN_VALUE, localMax = 0;
        for (int j : arr) {
//            max = Math.max(max, (localMax+j));
//            localMax = Math.max(localMax, max);
            max = Math.max(max, (localMax += j));
            localMax = Math.max(localMax, 0); // localmax will always greater then or equals to 0
            // localmax us used to check the last sum value , if sum is greater than 0 it will continue else it will
            // make last sum as 0.

        }
        return max;
    }

    public static ArrayList<Integer> duplicates(int arr[], int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i]))
                map.put(arr[i], map.get(i) + 1);
            else
                map.put(arr[i], 1);

        }
        ArrayList<Integer> result = new ArrayList<>();
        for(Map.Entry<Integer, Integer> res : map.entrySet())
            if(res.getValue()>1) result.add(res.getKey());

        System.out.println();
         Collections.sort(result);;
         return result;
    }


    public static void main(String[] args) {
        int[] arr = {-1, -2, -3, -4};
        System.out.println(KadaneAlgo(arr));
//
//        int arr[] = {1,2,3,4,2};
//        duplicates(arr, arr.length);
    }
}
