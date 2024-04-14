package com.example.dsa.NewCode.DP.Stocks5;

public class BuyAndSellStockWithTransactionFee {

    public int maxProfit(int[] prices, int fee) {
        // return maxProfitRecurssion(0, 1, prices, fee);

        // int[][] dp = new int[prices.length + 1][2];
        // return maxProfitMemoization(0, 1, prices, fee, dp);

        // return maxProfitTabulation(prices, fee);

        // return maxProfitSpaceOptimization(prices, fee);

        return maxProfitSpaceOptimization1(prices, fee);

    }

    private int maxProfitRecurssion(int index, int isBuy, int[] prices, int fee) {
        if (index == prices.length)
            return 0;

        if (isBuy == 1) {
            int buy = -prices[index] + maxProfitRecurssion(index + 1, 0, prices, fee);
            int notBuy = maxProfitRecurssion(index + 1, 1, prices, fee);
            return Math.max(buy, notBuy);
        } else {
            int sell = prices[index] - fee + maxProfitRecurssion(index + 1, 1, prices, fee);
            int notSell = maxProfitRecurssion(index + 1, 0, prices, fee);
            return Math.max(sell, notSell);
        }
    }

    private int maxProfitMemoization(int index, int isBuy, int[] prices, int fee, int[][] dp) {
        if (index == prices.length)
            return 0;

        if (isBuy == 1) {
            int buy = -prices[index] + maxProfitMemoization(index + 1, 0, prices, fee, dp);
            int notBuy = maxProfitMemoization(index + 1, 1, prices, fee, dp);
            dp[index][isBuy] = Math.max(buy, notBuy);
            return Math.max(buy, notBuy);
        } else {
            int sell = prices[index] - fee + maxProfitMemoization(index + 1, 1, prices, fee, dp);
            int notSell = maxProfitMemoization(index + 1, 0, prices, fee, dp);
            dp[index][isBuy] = Math.max(sell, notSell);
            return Math.max(sell, notSell);
        }
    }

    private int maxProfitTabulation(int prices[], int fee) {
        int[][] dp = new int[prices.length + 1][2];

        for (int index = prices.length - 1; index >= 0; index--) {
            for (int isBuy = 0; isBuy < 2; isBuy++) {
                if (isBuy == 1) {
                    int buy = -prices[index] + dp[index + 1][0];
                    int notBuy = dp[index + 1][1];
                    dp[index][isBuy] = Math.max(buy, notBuy);
                } else {
                    int sell = prices[index] - fee + dp[index + 1][1];
                    int notSell = dp[index + 1][0];
                    dp[index][isBuy] = Math.max(sell, notSell);
                }
            }
        }

        return dp[0][1];
    }

    private int maxProfitSpaceOptimization(int prices[], int fee) {
        int[] ahead = new int[2];
        int[] curr = new int[2];

        for (int index = prices.length - 1; index >= 0; index--) {
            for (int isBuy = 0; isBuy < 2; isBuy++) {
                if (isBuy == 1) {
                    int buy = -prices[index] + ahead[0];
                    int notBuy = ahead[1];
                    curr[isBuy] = Math.max(buy, notBuy);
                } else {
                    int sell = prices[index] - fee + ahead[1];
                    int notSell = ahead[0];
                    curr[isBuy] = Math.max(sell, notSell);
                }
            }
            ahead = curr;
        }

        return ahead[1];
    }

    private int maxProfitSpaceOptimization1(int prices[], int fee) {
        int[] ahead = new int[2];

        for (int index = prices.length - 1; index >= 0; index--) {
            for (int isBuy = 0; isBuy < 2; isBuy++) {
                if (isBuy == 1) {
                    int buy = -prices[index] + ahead[0];
                    int notBuy = ahead[1];
                    ahead[isBuy] = Math.max(buy, notBuy);
                } else {
                    int sell = prices[index] - fee + ahead[1];
                    int notSell = ahead[0];
                    ahead[isBuy] = Math.max(sell, notSell);
                }
            }
        }

        return ahead[1];
    }

}
