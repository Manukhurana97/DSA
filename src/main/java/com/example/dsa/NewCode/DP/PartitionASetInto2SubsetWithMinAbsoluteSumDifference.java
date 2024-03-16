package com.example.dsa.NewCode.DP;

//  Partition A Set Into Two Subsets With Minimum Absolute Sum Difference
public class PartitionASetInto2SubsetWithMinAbsoluteSumDifference {

    public int minimumDifference(int[] nums) {
        int n = nums.length;
        long totalSum = 0;

        for (int i : nums)
            totalSum += i;

        int[] min = { Integer.MAX_VALUE };
        // minimumGenerateAllSubsetsRecursion(0, 0, 0, totalSum, min, nums);

        long[][] dp = new long[nums.length][nums.length / 2 + 1];
        minimumGenerateAllSubsetsMemoization(0, 0, 0, totalSum, min, nums, dp);
        return min[0];

    }

    private void minimumGenerateAllSubsetsRecursion(int n, int count, long sum, long totalSum, int[] min, int[] nums) {
        if (count == nums.length / 2) {
            var absDiff = Math.abs(totalSum - sum);
            min[0] = (int) Math.min(min[0], Math.abs(sum - absDiff));
            return;
        }
        if (n == nums.length) {
            return;
        }

        minimumGenerateAllSubsetsRecursion(n + 1, count + 1, sum + nums[n], totalSum, min, nums);
        minimumGenerateAllSubsetsRecursion(n + 1, count, sum, totalSum, min, nums);
    }

    // recursion + memoization
    private void minimumGenerateAllSubsetsMemoization(int n, int count, long sum, long totalSum, int[] min, int[] nums,
            long[][] dp) {
        if (count == nums.length / 2) {
            min[0] = (int) Math.min(min[0], Math.abs(sum - Math.abs(totalSum - sum)));
            return;
        }
        if (n == nums.length)
            return;

        if (dp[n][count] != 0)
            sum = dp[n][count];

        minimumGenerateAllSubsetsMemoization(n + 1, count + 1, sum + nums[n], totalSum, min, nums, dp);
        minimumGenerateAllSubsetsMemoization(n + 1, count, sum, totalSum, min, nums, dp);

        dp[n][count] = sum;
    }

}
