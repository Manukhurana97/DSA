package com.example.dsa.NewCode.DP.Stocks5;

public class BuyAndSellStock4 {

    private int maxProfit(int k, int[] prices) {
        // return maxProfitRecurssion(0, 0, k, prices);

        int[][] dp = new int[prices.length + 1][2 * k + 1];
        // return maxProfitMemoization(0, 0, k, prices, dp);

        // return maxProfitTabulation(k, prices, dp);

        // return maxProfitSpaceOptimization(k, prices);

        return maxProfitSpaceOptimizationAhead(k, prices);
    }

    private int maxProfitRecurssion(int index, int transactionNo, int k, int[] prices) {

        if (index == prices.length || transactionNo == 2 * k)
            return 0;

        if (transactionNo % 2 == 0) {
            int buy = -prices[index] + maxProfitRecurssion(index + 1, transactionNo + 1, k, prices);
            int notBuy = maxProfitRecurssion(index + 1, transactionNo, k, prices);
            return Math.max(buy, notBuy);
        } else {
            int sell = prices[index] + maxProfitRecurssion(index + 1, transactionNo + 1, k, prices);
            int notSell = maxProfitRecurssion(index + 1, transactionNo, k, prices);
            return Math.max(sell, notSell);
        }
    }

    private int maxProfitMemoization(int index, int transactionNo, int k, int[] prices, int[][] dp) {

        if (index == prices.length || transactionNo == 2 * k)
            return 0;

        if (dp[index][transactionNo] != 0)
            return dp[index][transactionNo];

        if (transactionNo % 2 == 0) {
            int buy = -prices[index] + maxProfitMemoization(index + 1, transactionNo + 1, k, prices, dp);
            int notBuy = maxProfitMemoization(index + 1, transactionNo, k, prices, dp);
            dp[index][transactionNo] = Math.max(buy, notBuy);
            return Math.max(buy, notBuy);
        } else {
            int sell = prices[index] + maxProfitMemoization(index + 1, transactionNo + 1, k, prices, dp);
            int notSell = maxProfitMemoization(index + 1, transactionNo, k, prices, dp);
            dp[index][transactionNo] = Math.max(sell, notSell);
            return Math.max(sell, notSell);
        }
    }

    private int maxProfitTabulation(int k, int[] prices, int[][] dp) {

        for (int index = prices.length - 1; index >= 0; index--) {
            for (int transactionNo = 2 * k - 1; transactionNo >= 0; transactionNo--) {
                if (transactionNo % 2 == 0) {
                    int buy = -prices[index] + dp[index + 1][transactionNo + 1];
                    int notBuy = dp[index + 1][transactionNo];
                    dp[index][transactionNo] = Math.max(buy, notBuy);
                } else {
                    int sell = prices[index] + dp[index + 1][transactionNo + 1];
                    int notSell = dp[index + 1][transactionNo];
                    dp[index][transactionNo] = Math.max(sell, notSell);
                }
            }
        }

        return dp[0][0];
    }

    private int maxProfitSpaceOptimization(int k, int[] prices) {

        int[] ahead = new int[2 * k + 1];
        int[] curr = new int[2 * k + 1];

        for (int index = prices.length - 1; index >= 0; index--) {
            for (int transactionNo = 2 * k - 1; transactionNo >= 0; transactionNo--) {
                if (transactionNo % 2 == 0) {
                    curr[transactionNo] = Math.max(-prices[index] + ahead[transactionNo + 1], ahead[transactionNo]);
                } else {
                    curr[transactionNo] = Math.max(prices[index] + ahead[transactionNo + 1], ahead[transactionNo]);
                }
            }
            ahead = curr;
            curr = new int[2 * k + 1];
        }

        return ahead[0];
    }

    private int maxProfitSpaceOptimizationAhead(int k, int[] prices) {

        int[] ahead = new int[2 * k + 1];

        for (int index = prices.length - 1; index >= 0; index--) {
            for (int transactionNo = 2 * k - 1; transactionNo >= 0; transactionNo--) {
                if (transactionNo % 2 == 0) {
                    ahead[transactionNo] = Math.max(-prices[index] + ahead[transactionNo + 1], ahead[transactionNo]);
                } else {
                    ahead[transactionNo] = Math.max(prices[index] + ahead[transactionNo + 1], ahead[transactionNo]);
                }
            }
        }

        return ahead[0];
    }
}
