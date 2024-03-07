package com.example.dsa.NewCode.DP;

import java.util.Map;

public class NinjaTraining {
    public static int ninjaTraining(int n, int points[][]) {

        return ninjaTraining(n, 3, points);
    }

    public static int ninjaTraining(int n, int last, int points[][]) {
        if (n == 0) {
            int maxi = 0;
            for (int i = 0; i < n; i++) {
                if (i != last) {
                    maxi = Math.max(maxi, points[n][i]);
                }
            }
            return maxi;
        }

        int maxPoints = 0;
        for (int i = 0; i < n; i++) {
            if (i != last) {
                int currentMax = Math.max(points[n][i], ninjaTraining(n - 1, i, points));
                maxPoints = Math.max(maxPoints, currentMax);
            }
        }

        return maxPoints;
    }

    // memoization : botton to top
    public static int ninjaTrainingMemoization(int n, int last, int points[][], int[][] map) {
        if (n == 0) {
            int maxi = 0;
            for (int i = 0; i < n; i++) {
                if (i != last) {
                    maxi = Math.max(maxi, points[n][i]);
                }
            }
            return maxi;
        }

        if (map[n][last] != 0)
            return map[n][last];

        int maxPoints = 0;
        for (int i = 0; i < n; i++) {
            if (i != last) {
                int currentMax = Math.max(points[n][i], ninjaTrainingMemoization(n - 1, i, points, map));
                maxPoints = Math.max(maxPoints, currentMax);
            }
        }

        map[n][last] = maxPoints;
        return maxPoints;
    }

    // tabulation : top to bottom
    public static int ninjaTrainingTabulation(int n, int points[][], int[][] map) {

        // on first day
        map[0][0] = Math.max(points[0][1], points[0][2]);
        map[0][1] = Math.max(points[0][0], points[0][2]);
        map[0][2] = Math.max(points[0][0], points[0][1]);
        map[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        // from second day
        for (int days = 1; days < n; days++) {
            for (int last = 0; last < 4; last++) { // to iterate over all posibility of last week
                for (int tasks = 0; tasks < 3; tasks++) { // to iterate over all possibility of current week
                    if (last != tasks) {
                        int point = points[days][tasks] + map[days - 1][tasks];
                        map[days][tasks] = Math.max(map[days][tasks], point);
                    }
                }
            }
        }

        return map[n - 1][3];
    }

    public static int ninjaTrainingSpaceOptimization(int n, int points[][], int[] prev) {
        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        int[] temp = new int[4];

        for (int days = 1; days < n; days++) {
            for (int index = 0; index < n; index++) {
                temp[index] = prev[index];
            }

            for (int last = 0; last < 4; last++) {
                for (int tasks = 0; tasks < 3; tasks++) {
                    if (last != tasks) {
                        int point = points[days][tasks] + prev[tasks];
                        temp[tasks] = Math.max(prev[tasks], point);
                    }
                }
            }
            for (int index = 0; index < n; index++) {
                prev[index] = temp[index];
            }
        }
        return prev[3];
    }
}
