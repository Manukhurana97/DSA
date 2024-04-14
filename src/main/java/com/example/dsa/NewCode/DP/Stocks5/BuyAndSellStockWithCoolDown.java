package com.example.dsa.NewCode.DP.Stocks5;

public class BuyAndSellStockWithCoolDown {

    public int maxProfit(int[] prices) {
        // return maxProfitRecurssion(0, prices, true);

        int[][] dp = new int[prices.length + 2][2];
        // return maxProfitMemoization(0, prices, true, dp);

        // return maxProfitTabulation(prices, dp);
        return maxProfitSpaceOptimization(prices, dp);
    }

    private static int maxProfitRecurssion(int index, int[] price, boolean buy) {

        if (index >= price.length)
            return 0;

        if (buy) {
            // buy or not buy
            return Math.max(-price[index] + maxProfitRecurssion(index + 1, price, !buy),
                    maxProfitRecurssion(index + 1, price, buy));
        } else {
            // sell or not sell
            return Math.max(price[index] + maxProfitRecurssion(index + 2, price, !buy),
                    maxProfitRecurssion(index + 1, price, buy));
        }
    }

    private static int maxProfitMemoization(int index, int[] price, boolean buy, int[][] dp) {

        if (index >= price.length)
            return 0;

        if (dp[index][(buy) ? 1 : 0] != 0)
            return dp[index][(buy) ? 1 : 0];

        if (buy) {
            // buy or not buy
            int isBuy = Math.max(-price[index] + maxProfitMemoization(index + 1, price, !buy, dp),
                    maxProfitMemoization(index + 1, price, buy, dp));
            dp[index][(buy) ? 1 : 0] = isBuy;
            return isBuy;
        } else {
            // sell or not sell
            int isSell = Math.max(price[index] + maxProfitMemoization(index + 2, price, !buy, dp),
                    maxProfitMemoization(index + 1, price, buy, dp));
            dp[index][(buy) ? 1 : 0] = isSell;
            return isSell;
        }
    }

    private static int maxProfitTabulation(int[] price, int[][] dp) {

        for (int index = price.length - 1; index >= 0; index--) {
            for (int buy = 0; buy < 2; buy++) {
                if (buy == 1) {
                    dp[index][buy] = Math.max(-price[index] + dp[index + 1][0], dp[index + 1][1]);
                } else {
                    dp[index][buy] = Math.max(price[index] + dp[index + 2][1], dp[index + 1][0]);
                }
            }
        }

        return dp[0][1];
    }

    private static int maxProfitSpaceOptimization(int[] price) {

        int[] ahead1 = new int[2];
        int[] ahead2 = new int[2];
        int[] curr = new int[2];

        for (int index = price.length - 1; index >= 0; index--) {
            curr[1] = Math.max(-price[index] + ahead1[0], ahead1[1]);
            curr[0] = Math.max(price[index] + ahead2[1], ahead1[0]);

            ahead2 = ahead1.clone();
            ahead1 = curr.clone();
        }
        return ahead1[1];
    }

}
