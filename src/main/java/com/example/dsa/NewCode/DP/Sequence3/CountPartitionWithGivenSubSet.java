package com.example.dsa.NewCode.DP.Sequence3;

public class CountPartitionWithGivenSubSet {

    // recurison
    public static int findSubSetsRecursion(int n, int target, int[] arr) {

        if (n < 0) {
            if (target == 0 && arr[0] == 0)
                return 2;
            return (target == 0 || arr[0] == 0) ? 1 : 0;
        }

        int take = arr[n] > target ? 0 : findSubSetsRecursion(n - 1, target - arr[n], arr);
        int notTake = findSubSetsRecursion(n - 1, target, arr);
        return (take + notTake) % 1000000007;
    }

    // recurison + memoization
    public static int findSubSetsMemoization(int n, int target, int[] arr, int[][] dp) {

        if (n < 0) {
            if (target == 0 && arr[0] == 0)
                return 2;
            return (target == 0 || arr[0] == 0) ? 1 : 0;
        }

        if (dp[n][target] != 0)
            return dp[n][target];

        int take = arr[n] > target ? 0 : findSubSetsMemoization(n - 1, target - arr[n], arr, dp);
        int notTake = findSubSetsMemoization(n - 1, target, arr, dp);

        dp[n][target] = (take + notTake) % 1000000007;

        return (take + notTake) % 1000000007;

    }

    // tabulation
    public static int findSubSetsTabulation(int n, int target, int[] arr, int[][] dp) {

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= target; j++) {

                if (i == 0 && j == 0)
                    dp[i][j] = 1;
                else if (i == 0)
                    dp[i][j] = 0;
                else {

                    int take = arr[i - 1] > j ? 0 : dp[i - 1][j - arr[i - 1]];
                    int notTake = dp[i - 1][j];

                    dp[i][j] = (take + notTake) % 1000000007;
                }
            }
        }

        return dp[n][target];
    }

    // count += (s1 - s2 == d) ? 1 : 0;
    public static int countPartitions(int n, int d, int[] arr) {
        // (s1 - s2 == d) -> total - s2 - s2 = d -> total - d = 2s2
        // since all number are positive total-d should also be positive

        int totalSum = 0;
        for (int i : arr)
            totalSum += i;

        if (totalSum - d < 0 || (totalSum - d) % 2 != 0)
            return 0;

        // return findSubSetsRecursion(n - 1, (totalSum - d) / 2, arr);

        int[][] dp = new int[n + 1][(totalSum - d) / 2 + 1];
        // return findSubSetsMemoization(n - 1, (totalSum - d) / 2, arr, dp);

        return findSubSetsTabulation(n - 1, (totalSum - d) / 2, arr, dp);
    }

    public static void main(String[] args) {
        int[] arr = { 5, 2, 6, 4 };
        var result = countPartitions(arr.length, 3, arr);
        System.out.println("count " + result);

        int[] arr1 = { 1, 1, 1, 1 };
        var result1 = countPartitions(arr.length, 0, arr);
        System.out.println("count " + result1);
    }

}
