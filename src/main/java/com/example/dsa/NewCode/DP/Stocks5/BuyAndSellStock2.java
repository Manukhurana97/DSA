package com.example.dsa.NewCode.DP.Stocks5;

public class BuyAndSellStock2 {

    private static int maxProfit(int[] prices) {
        // return maxProfitRecurssion(0, prices, true);

        int[][] dp = new int[prices.length + 1][2];
        // return maxProfitMemoization(0, prices, true, dp);

        return maxProfitTabulation(prices, dp);
    }

    private static int maxProfitRecurssion(int index, int[] price, boolean buy) {

        if (index == price.length)
            return 0;

        if (buy) {
            // buy or not buy
            return Math.max(-price[index] + maxProfitRecurssion(index + 1, price, !buy),
                    maxProfitRecurssion(index + 1, price, buy));
        } else {
            // sell or not sell
            return Math.max(price[index] + maxProfitRecurssion(index + 1, price, !buy),
                    maxProfitRecurssion(index + 1, price, buy));
        }
    }

    private static int maxProfitMemoization(int index, int[] price, boolean buy, int[][] dp) {

        if (index == price.length)
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
            int isSell = Math.max(price[index] + maxProfitMemoization(index + 1, price, !buy, dp),
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
                    dp[index][buy] = Math.max(price[index] + dp[index + 1][1], dp[index + 1][0]);
                }
            }
        }

        return dp[0][1];
    }

    private static int maxProfitSpaceOptimization(int[] price) {

        int[] ahread = new int[2];
        int[] curr = new int[2];

        for (int index = price.length - 1; index >= 0; index--) {
            for (int buy = 0; buy < 2; buy++) {
                if (buy == 1) {
                    curr[buy] = Math.max(-price[index] + ahread[0], ahread[1]);
                } else {
                    curr[buy] = Math.max(price[index] + ahread[1], ahread[0]);
                }
            }
            ahread = curr;
            curr = new int[2];

        }

        return ahread[1];
    }

    private static int maxProfitSpaceOptimizationAhead(int[] price) {

        int ahreadNotBuy = 0, ahreadBuy = 0, currBuy = 0, currNotBuy = 0;

        for (int index = price.length - 1; index >= 0; index--) {

            currBuy = Math.max(-price[index] + ahreadNotBuy, ahreadBuy);
            currNotBuy = Math.max(price[index] + ahreadBuy, ahreadNotBuy);
        }
        ahreadBuy = currBuy;
        ahreadNotBuy = currNotBuy;

        return ahreadBuy;
    }

}
