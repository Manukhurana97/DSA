package com.example.dsa.NewCode.Arrays3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence10 {


    /**
     * O(nlogn)+O(n)
     */
    public static int longestConsecutive(int[] arr) {
        if (arr.length == 0) return 0;
        Arrays.sort(arr);

        int count = 1;
        int largestSequence = 0;
        int smallestElement = arr[0];


        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == smallestElement + 1) {
                count++;
            } else if (arr[i] == smallestElement) {
            } else {
                largestSequence = Math.max(largestSequence, count);
                count = 1;
            }
            smallestElement = arr[i];
        }

        // Check the final count after the loop ends
        largestSequence = Math.max(largestSequence, count);

        return largestSequence;
    }


    /**
     * O(n)+O(n)
     * O(n)
     */
    public static int longestConsecutive1(int[] arr) {

        if (arr.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        int largestSequence = 1;
        int n = arr.length;

        for (int i : arr) set.add(i);

        for (int i : set) {
            if (!set.contains(i - 1)) {
                int element = i;
                int count = 1;

                while (set.contains(element + 1)) {
                    count += 1;
                    element += 1;
                }

                largestSequence = Math.max(count, largestSequence);
            }
        }

        return largestSequence;
    }


    public static void main(String[] args) {
//        int[] arr = {100, 4, 4, 101, 102, 103, 7, 8, 9, 10, 71, 64, 18, 19, 11, 20, 12};
//        int[] arr = {100,4,200,1,3,2};
        int[] arr = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};

        var longestConsecutiveSequence = longestConsecutive(arr);
        System.out.println("Length of longest consecutive subsequence: " + longestConsecutiveSequence);

    }
}
