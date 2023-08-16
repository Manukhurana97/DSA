package com.example.dsa.NewCode.Arrays3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingInterval18 {

    /*(1,3), (2,4), (2,6), (8,9), (9,11), (15,18), 16,17)*/
    public static int[][] mergeInterval(int[][] intervals) {

        int n = intervals.length;
        List<int[]> arr = new ArrayList<>();

        Arrays.sort(intervals, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[0] - o2[1]);


        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            /*(1,3), (2,4), (2,6), (8,9), (9,11), (15,18), 16,17)*/

            int j = 0;
            for (j = i + 1; j < n; j++) {
                if (intervals[j][0] <= end) {
                    end = Math.max(end, intervals[j][1]);
                } else {
                    break;
                }
            }
            i = j;
            arr.add(new int[]{start, end});
        }


        int[][] result = new int[arr.size()][2];
        for (int i = 0; i < arr.size(); i++) {
            result[i] = arr.get(i);
        }
        return result;
    }

    public static int[][] mergeInterval1(int[][] intervals) {

        int n = intervals.length;
        List<int[]> arr = new ArrayList<>();

        Arrays.sort(intervals, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[0] - o2[1]);


        for (int i = 0; i < n; i++) {

            /*(1,3), (2,4), (2,6), (8,9), (9,11), (15,18), 16,17)*/

            if (arr.isEmpty() || intervals[i][0] > arr.get(arr.size() - 1)[1]) {
                arr.add(new int[]{intervals[i][0], intervals[i][1]});
            } else {
                var a = arr.get(arr.size() - 1);
                a[1] = Math.max(arr.get(arr.size() - 1)[1], intervals[i][1]);
                arr.set(arr.size() - 1, a);
            }
        }


        int[][] result = new int[arr.size()][2];
        for (int i = 0; i < arr.size(); i++) {
            result[i] = arr.get(i);
        }
        return result;
    }

    public static void main(String[] args) {

        int[][] arr = {{1, 3}, {2, 6}, {8, 9}, {9, 11}, {8, 10}, {2, 4}, {15, 18}, {16, 17}};
        var data = mergeInterval1(arr);
        for (var i : data) {
            System.out.println(i[0] + " " + i[1]);
        }
    }
}
