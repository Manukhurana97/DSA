package com.example.dsa.NewCode.DP.Stocks5;

public class BuyAndSellStock3 {

    private static int maxProfit(int[] price, int times) {
        // return maxProfitRecursion(0, price, times, 1);

        // int[][][] dp = new int[price.length][2][3];
        // return maxProfitMemoization(0, price, times, 1, dp);

        // return maxProfitTabulation(price, 2, dp);

        return maxProfitSpaceOptimization(price, 2);
    }

    // time: O(2^n), Space: O(N*2*3);
    private static int maxProfitRecursion(int index, int[] price, int times, int buy) {

        if (times == 0 || index == price.length)
            return 0;

        if (buy == 1) {
            int buyStock = -price[index] + maxProfitRecursion(index + 1, price, times, 0);
            int noBuyStock = maxProfitRecursion(index + 1, price, times, 1);
            return Math.max(buyStock, noBuyStock);
        } else {
            int SellStock = price[index] + maxProfitRecursion(index + 1, price, times - 1, 1);
            int notSellStock = maxProfitRecursion(index + 1, price, times, 0);
            return Math.max(SellStock, notSellStock);
        }
    }

    // time: O(N);, Space: 2*O(N*2*3);
    private static int maxProfitMemoization(int index, int[] price, int times, int buy, int[][][] dp) {

        if (times == 0 || index == price.length)
            return 0;

        if (dp[index][buy][times] != 0)
            return dp[index][buy][times];

        if (buy == 1) {
            int buyStock = -price[index] + maxProfitMemoization(index + 1, price, times, 0, dp);
            int noBuyStock = maxProfitMemoization(index + 1, price, times, 1, dp);
            var buying = Math.max(buyStock, noBuyStock);
            dp[index][buy][times] = buying;
            return buying;
        } else {
            int SellStock = price[index] + maxProfitMemoization(index + 1, price, times - 1, 1, dp);
            int notSellStock = maxProfitMemoization(index + 1, price, times, 0, dp);
            int selling = Math.max(SellStock, notSellStock);
            dp[index][buy][times] = selling;
            return selling;
        }
    }

    // time: O(N*2*3), Space: O(N*2*3);
    private static int maxProfitTabulation(int[] price, int times, int[][][] dp) {

        for (int index = price.length - 1; index >= 0; index--) {
            for (int buy = 0; buy < 2; buy++) {
                for (int cap = 1; cap <= times; cap++) {
                    if (buy == 1)
                        dp[index][buy][cap] = Math.max(-price[index] + dp[index + 1][0][cap], dp[index + 1][1][cap]);
                    else {
                        dp[index][buy][cap] = Math.max(price[index] + dp[index + 1][1][cap - 1], dp[index + 1][0][cap]);
                    }
                }

            }
        }
        return dp[0][1][times];
    }

    // time: O(N*2*3);, Space: O(2*3) = O(1);
    private static int maxProfitSpaceOptimization(int[] price, int times) {

        int[][] prev = new int[2][times + 1];
        int[][] curr = new int[2][times + 1];

        for (int index = price.length - 1; index >= 0; index--) {
            for (int buy = 0; buy < 2; buy++) {
                for (int cap = 1; cap <= times; cap++) {
                    if (buy == 1)
                        curr[buy][cap] = Math.max(-price[index] + prev[0][cap], prev[1][cap]);
                    else {
                        curr[buy][cap] = Math.max(price[index] + prev[1][cap - 1], prev[0][cap]);
                    }
                }

            }
            prev = curr;
            curr = new int[2][times + 1];
        }
        return prev[1][times];
    }
}
