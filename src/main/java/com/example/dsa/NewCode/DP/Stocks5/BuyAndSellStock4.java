package com.example.dsa.NewCode.DP.Stocks5;

public class BuyAndSellStock4 {

    private int maxProfit(int k, int[] prices) {
        return maxProfitRecurssion(0, 0, k, prices);
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

}
